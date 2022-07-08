package servlet;

import pojo.Sales;
import service.DownloadService;
import service.impl.DownloadServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/downloadServlet")
public class DownloadServlet extends BaseServlet{

    DownloadService downloadService = new DownloadServiceImpl();

    /**
     * 根据年份和月份下载销售表单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void downloadFile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String year = req.getParameter("year");
        String month = req.getParameter("month");

        System.out.println("year:" + year + " month:" + month);

        List<Sales> sales = downloadService.downloadSales(year, month);

        String fileName = year + "年" + month + "月销售榜单.csv";
        resp.setHeader("Content-Disposition", "attachement;filename="+new String(fileName.getBytes("GBK"),"iso8859-1"));
        resp.setCharacterEncoding("utf8");

        resp.setContentType(this.getServletContext().getMimeType(fileName) + ";charset=gbk");
        PrintWriter out = resp.getWriter();
        out.println("商品名称,销售数量");

        for (int i = 0; i < sales.size(); i++) {
            Sales arr = sales.get(i);
            out.println(arr.getName() + "," + arr.getBuynum());
        }
        out.flush();
        out.close();
    }
}
