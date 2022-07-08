package servlet;

import pojo.Page;
import pojo.Product;
import pojo.ProductSales;
import service.ProductService;
import service.SaleService;
import service.impl.ProductServiceImpl;
import service.impl.SaleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductServlet extends BaseServlet{

    private ProductService productService = new ProductServiceImpl();
    private SaleService saleService = new SaleServiceImpl();

    
    /**
     * 后台：查询全部商品
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void queryProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先设定一个默认查询全部商品的,返回的是一个List集合
        List<Product> products = productService.queryAllProduct();

        //销毁原本session域中的products
        // req.getSession().removeAttribute("products");
        req.getSession().invalidate();

        //再重新保存商品信息products保存到session域中
        req.getSession().setAttribute("products", products);



        // req.getRequestDispatcher("WebContent/admin/products/list.jsp").forward(req,resp);
    }



    /**
     * 后台：根据多个条件查询商品
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void queryProductForCondition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取查询条件
        String id = "".equals(req.getParameter("id"))?"id":req.getParameter("id");
        String name = "".equals(req.getParameter("name"))?"name":req.getParameter("name");
        String category = "".equals(req.getParameter("category")) ? "category" : req.getParameter("category");
        String minprice = req.getParameter("minprice");
        String maxprice = req.getParameter("maxprice");

        //两个价格区间
        double minPrice = Double.parseDouble("".equals(minprice)?"0":req.getParameter("minprice"));
        //设定默认最大值为9999999999
        double maxPrice = Double.parseDouble("".equals(maxprice)?"99999999":req.getParameter("maxprice"));

        //如果五个条件都为自身（即都为空）,则查询全部商品
        if("id".equals(id) && "name".equals(name) && "category".equals(category) && "".equals(minprice) && "".equals(maxprice)){
            System.out.println("查询全部商品");
            queryProduct(req,resp);
            //直接重定向+返回
            req.getRequestDispatcher("WebContent/admin/products/list.jsp").forward(req,resp);
            // resp.sendRedirect("WebContent/admin/products/list.jsp");
            return;
        }

        //调用service层的方法
        List<Product> products = productService.queryByCondition(id,name,category,minPrice,maxPrice);

        //销毁原本session域中的products
        // req.getSession().removeAttribute("products");
        req.getSession().invalidate();

        //再重新保存商品信息products保存到session域中
        req.getSession().setAttribute("products", products);

        //重定向回商品列表
        req.getRequestDispatcher("WebContent/admin/products/list.jsp").forward(req,resp);


    }


    /**
     * 后台：添加商品
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        int pnum = Integer.parseInt(req.getParameter("pnum"));
        String category = req.getParameter("category");
        String description = req.getParameter("description");
        String imgurl = req.getParameter("imgurl");

        // Product product = new Product(null,name,price,category,pnum,"null",description);
        Product product = new Product(null,name,price,category,pnum,imgurl,description);

        //调用service层的方法
        productService.addProduct(product);

        //重定向回商品列表
        req.getRequestDispatcher("WebContent/admin/products/add.jsp").forward(req,resp);
    }


    /**
     * 后台：修改商品信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        int pnum = Integer.parseInt(req.getParameter("pnum"));
        String category = req.getParameter("category");
        String description = req.getParameter("description");

        String imgurl = req.getParameter("imgurl");
        String[] description2s = req.getParameterValues("description");
        for(String description2:description2s){
            System.out.println("description2："+description2);
        }

        String lastUpdateDescription = description2s[description2s.length-1];
        System.out.println(lastUpdateDescription);


        //调用service层的方法
        // productService.updateProductById(id,name,price,pnum,category,imgurl,description);
        productService.updateProductById(id,name,price,pnum,category,lastUpdateDescription,imgurl);

        //重定向回商品列表
        req.getRequestDispatcher("WebContent/admin/products/list.jsp").forward(req,resp);
    }


    /**
     * 后台：删除商品
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        //调用service层的方法
        productService.deleteProductById(id);

        //重定向回商品列表
        req.getRequestDispatcher("WebContent/admin/products/list.jsp").forward(req,resp);
    }


    /**
     * 前台：从首页中展示所有商品
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
        protected void queryProductByIndex(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //展示所有商品
            queryProduct(req,resp);

            List<Product> products = productService.queryAllProduct();
            req.setAttribute("products",products);

            //要展示的是当前分页的数据，因为当前默认就是第一页所以不需要设置
            page(req,resp);
            // req.getRequestDispatcher("WebContent/client/ProductList.jsp").forward(req,resp);
    }

    /**
     * 前台：从菜单中不同书籍分类中展示对应书籍/商品
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void queryProductByMenu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("查询不同类型的书籍queryProductByMenu-----------------------------");
        String name = req.getParameter("name");
        System.out.println("name:" + name);
        List<Product> list = productService.findByCategory(name);
        req.setAttribute("products",list);

        Page<Product> page = new Page<>();
        page.setItems(list);
        req.setAttribute("page",page);

        req.getRequestDispatcher("WebContent/client/ProductList.jsp").forward(req,resp);
    }


    /**
     * 前台：处理分页数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("处理分页数据page-----------------------------");
        //1 获取请求的参数pageNo,默认为第一页
        int pageNo = 1;

        //否则获取请求的参数pageNo，获取当前页码
        if (req.getParameter("pageNo") != null) {
            pageNo = Integer.parseInt(req.getParameter("pageNo"));
        } else if (req.getAttribute("pageNo") != null) {
            pageNo = Integer.parseInt(req.getAttribute("pageNo").toString());
        } else if (req.getSession().getAttribute("cartPageNo") != null) {
            //从当前页数中添加图书，获取全局保存的页数，再回传到ProductServlet中的page分页方法中用于页面回显
            //因为如果点击了不同页的商品添加，需要继续保持在当前页码的页面
            pageNo = Integer.parseInt(req.getSession().getAttribute("cartPageNo").toString());
        }

        //pageSize默认设置为常量4，一页就显示4个数据
        int pageSize = 4;

        //2 调用productService.page( pageNo,pageSize) : 获得Page对象
        //即当前page对象中存放着当前页码，总页数，总记录数，当前页的数据
        Page<Product> page = productService.page(pageNo, pageSize);

        List<Product> items = page.getItems();

        //3 保存Page对象到Request域中，保存当前页码pageNo在全局域中，方便CartServlet中的添加购物车方法获取
        req.setAttribute("page", page);
        req.getServletContext().setAttribute("pageNo", pageNo);

        //3.5 如果是从“添加收藏”里过来的，还需要判断是否已经收藏
        if(req.getAttribute("collectionMsg")!=null){
            System.out.println("收藏提示信息："+req.getAttribute("collectionMsg"));
            req.getSession().setAttribute("collectionMsg","已收藏");
        }else{
            req.getSession().setAttribute("collectionMsg",null);
        }

        //4 请求转发到ProductList.jsp页面，让分页之后的页面显示当前页码的商品数据
        req.getRequestDispatcher("WebContent/client/ProductList.jsp").forward(req, resp);
    }


    /**
     * 前台：查看图书详情信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void bookDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("查看图书详情信息bookDetails-----------------------------");

        //判断是从哪里进来的当前页面
        String flag = req.getParameter("flag");
        System.out.println("flag:" + flag);

        //判断完成之后传回BookDetails继续作判断显示不同的返回按钮
        req.setAttribute("flag",flag);

        int pageNo = 1;
        if(req.getServletContext().getAttribute("pageNo")!= null){
            pageNo = (int)req.getServletContext().getAttribute("pageNo");
        }else if(req.getServletContext().getAttribute("collectionPageNo")!= null){
            pageNo = (int)req.getServletContext().getAttribute("collectionPageNo");
        }

        String id = req.getParameter("id");
        System.out.println("id:" + id);

        Product product = productService.queryProductById(id);
        req.setAttribute("productDetails",product);


        req.getRequestDispatcher("WebContent/client/BookDetails.jsp").forward(req,resp);
    }


    /**
     * 前台：展示本周热卖
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void hotProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("展示本周热卖hotProduct-----------------------------");

        //默认展示5个热卖商品
        List<ProductSales> list = saleService.findAllProductSales(5);
        req.getServletContext().setAttribute("hotProductList",list);

        req.getRequestDispatcher("WebContent/client/index.jsp").forward(req,resp);
    }

}
