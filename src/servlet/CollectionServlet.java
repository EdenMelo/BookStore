package servlet;

import pojo.Collections;
import pojo.Page;
import pojo.Product;
import pojo.User;
import service.CollectionService;
import service.ProductService;
import service.impl.CollectionServiceImpl;
import service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/collectionServlet")
public class CollectionServlet extends BaseServlet {

    ProductService productService = new ProductServiceImpl();
    CollectionService collectionService = new CollectionServiceImpl();

    /**
     * 查询用户收藏的所有商品（包括分页）
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void queryUserCollection(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("处理分页数据page-----------------------------");
        //1 获取请求的参数pageNo,默认为第一页
        int pageNo = 1;

        System.out.println("地址栏的页数" + req.getParameter("collectionPageNo"));

        //否则获取请求的参数pageNo，获取当前页码
        if(req.getParameter("collectionPageNo") != null){
            pageNo = Integer.parseInt(req.getParameter("collectionPageNo"));
        }else if(req.getSession().getAttribute("collectionPageNo")!= null){
            //点击“购买”按钮后继续保持当前收藏的分页页面
            pageNo = Integer.parseInt(req.getSession().getAttribute("collectionPageNo").toString());
        }

        if(req.getParameter("index")!=null){
            //从首页栏过来的默认都是第一页
            pageNo = 1;
        }

        System.out.println("pageNo:"+pageNo);

        //pageSize默认设置为常量4，一页就显示4个数据
        int pageSize = 4;

        //获取当前用户id
        User user = (User) req.getServletContext().getAttribute("loginUser");
        String userId = user.getId().toString();

        //2 调用productService.page( pageNo,pageSize) : 获得Page对象
        //即当前page对象中存放着当前页码，总页数，总记录数，当前页的数据
        Page<Product> page = collectionService.page(pageNo,pageSize,userId);

        //3 保存Page对象到Request域中，保存当前页码pageNo在全局域中，方便CartServlet中的添加购物车方法获取
        req.setAttribute("collectionPage",page);
        req.getServletContext().setAttribute("collectionPageNo",pageNo);

        //4 请求转发到ProductList.jsp页面，让分页之后的页面显示当前页码的商品数据
        req.getRequestDispatcher("WebContent/client/MyCollection.jsp").forward(req,resp);
    }


    /**
     * 取消收藏
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void cancelCollection(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("取消收藏cancelCollection-----------------------------");
        //1 获取请求的参数productId
        String productId = req.getParameter("id");

        //2 获取当前登录用户id
        User loginUser = (User)req.getServletContext().getAttribute("loginUser");
        String userId = loginUser.getId().toString();

        System.out.println("productId:"+productId);
        System.out.println("userId:"+userId);
        System.out.println("pageNo:"+req.getParameter("pageNo"));


        //3 调用collectionService.deleteCollectionById(userId,productId)：取消收藏
        int i = collectionService.deleteCollectionById(userId, productId);
        System.out.println("取消收藏的结果："+i);

        //获取当前页码并传过去
        req.getSession().setAttribute("collectionPageNo",req.getParameter("pageNo"));
        System.out.println("==============================");

        //取消收藏继续保留在当前页
        queryUserCollection(req,resp);
    }


    /**
     * 添加收藏
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addCollection(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("添加收藏addCollection-----------------------------");

        //1 获取请求的参数productId
        String productId = req.getParameter("id");

        //2 获取当前登录用户id
        User loginUser = (User)req.getServletContext().getAttribute("loginUser");
        String userId = loginUser.getId().toString();

        //3 创建Collections对象，并设置属性
        Collections collection = new Collections(productId,userId);

        //4 调用collectionService.addCollection(userId,productId)：添加收藏
        //判断是否已经收藏,要为没收藏的状态才添加
        if(collectionService.isCollection(collection)){
            System.out.println("已经收藏");
            //返回给jsp页面作警告提示
            req.setAttribute("collectionMsg","已经收藏过了！");
        }else{
            collectionService.addCollection(collection);
        }

        //继续保持商品页码的页码显示
        ProductServlet productServlet = new ProductServlet();
        req.setAttribute("pageNo",req.getParameter("pageNo"));
        productServlet.page(req,resp);
    }

}




