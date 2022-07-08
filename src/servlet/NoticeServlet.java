package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import pojo.Notice;
import service.NoticeService;
import service.impl.NoticeServiceImpl;

@WebServlet("/noticeServlet")
public class NoticeServlet extends BaseServlet {

    private NoticeService noticeService = new NoticeServiceImpl();

    /**
     * 后台：查询所有公告信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showAllNotice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Notice> list = noticeService.findAllNotice();
        req.setAttribute("noticeList", list);
        req.getRequestDispatcher("WebContent/admin/notice/noticeList.jsp").forward(req, resp);
    }


    /**
     * 后台：添加公告信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addNotice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进来了添加公告addNotice");

        String title = req.getParameter("title");
        String[] descriptions = req.getParameterValues("description");

        Notice notice = new Notice(null, title, descriptions[1], new Date());
        noticeService.addNotice(notice);

        //重定向防止重复提交
        resp.sendRedirect("WebContent/admin/notice/addNotice.jsp");
    }


    /**
     * 后台：修改公告信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateNotice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进来了修改公告updateNotice");

        //获取输入的公告标题和内容
        String title = req.getParameter("title");
        String[] descriptions = req.getParameterValues("description");

        //获取公告id，判断是否为空
        String strId = req.getParameter("id");
        strId = strId.trim();
        int id = ("".equals(strId) || strId == null) ? -1 : Integer.parseInt(strId);

        //根据公告id更新公告信息
        Notice notice = new Notice(id, title, descriptions[1], new Date());
        noticeService.updateNotice(notice);

        //重定向防止重复提交
        resp.sendRedirect("WebContent/admin/notice/editNotice.jsp");
    }


    /**
     * 后台：删除公告信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteNotice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进来了删除公告deleteNotice");
        String id = req.getParameter("id").trim();
        System.out.println("id:" + id);

        noticeService.deleteNotice(Integer.parseInt(id));

        //删除完公告再重新查询全部公告即可
        showAllNotice(req, resp);

    }

    /**
     * 前台：查询最新的五条公告信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void queryNewNotice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进来了查询最新的五条公告信息queryNewNotice------------------------------");
        List<Notice> list = noticeService.findNewNotice();
        req.getServletContext().setAttribute("noticeList", list);

        list.forEach(System.out::println);

        //顺便查询出本周所有热卖的所有商品
        ProductServlet productServlet = new ProductServlet();
        productServlet.hotProduct(req, resp);

    }


    /**
     * 前台：查看公告详情
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void viewNotice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进来了查看公告详情viewNotice------------------------------");
        String id = req.getParameter("id");
        System.out.println("公告id:" + id);

        Notice notice = noticeService.findNoticeById(Integer.parseInt(id));
        req.setAttribute("notice", notice);
        req.getRequestDispatcher("WebContent/client/NoticeView.jsp").forward(req, resp);
    }


}
