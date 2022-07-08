package servlet;

import pojo.Product;
import service.ProductListService;
import service.ProductService;
import service.impl.ProductListServiceImpl;
import service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MenuSearchServlet extends BaseServlet{

    private ProductListService productListService = new ProductListServiceImpl();

    /**
     * 前台：根据书名搜索书籍
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("bookName");

        List<Product> products = productListService.queryBookByName(name);

        //获取查询到的书籍名字：成功
        System.out.println(name);
        //遍历查询到的书籍：成功
        for (Product product : products) {
            System.out.println(product);
        }

        //保存到request域中
        req.setAttribute("products", products);

        //转发到查询书籍页面
        req.getRequestDispatcher("WebContent/client/ProductList2.jsp").forward(req,resp);

    }
}
