package servlet;

import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import pojo.Order;
import pojo.OrderItem;
import pojo.Product;
import pojo.User;
import service.CartService;
import service.SaleService;
import service.impl.CartServiceImpl;
import service.impl.SaleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;


@WebServlet("/cartServlet")
public class CartServlet extends BaseServlet {
    /**
     * 表示当前登录的用户，用来判断用户是否已经切换
     */
    static String currentUsername;

    /**
     * 全局购物车哈希表，处理从商品列表中添加的图书id，key存放图书id,value存放书本数量，用于购物车结账
     */
    Map<String, Integer> bookMap = new HashMap<>();

    /**
     * 全局变量计算总价
     */
    Double sum = 0.0;

    /**
     * 全局保存当前登录的用户名
     */
    String username;


    /**
     * 全局保存当前购物车中的图书信息和图书购买数量
     */
    Map<Product, Integer> productCartMap = new HashMap<>();


    /**
     * 调用productServlet中查询全部图书信息
     */
    ProductServlet productServlet = new ProductServlet();
    CartService cartService = new CartServiceImpl();
    SaleService saleService = new SaleServiceImpl();


    /**
     * 图书点击"购买"，将图书添加到购物车中
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void testFindUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取当前登录的用户名
        username = (String) req.getServletContext().getAttribute("username");
        String id = req.getParameter("id");

        //从当前页数中添加图书，获取全局保存的页数，再回传到ProductServlet中的page分页方法中用于页面回显
        //作用是点击当前第N页的商品购买，依旧保持当前第N页这个页面
        if(req.getServletContext().getAttribute("pageNo")!=null){
            String pageNo = req.getServletContext().getAttribute("pageNo").toString();
            System.out.println("pageNo:" + pageNo);
            req.getSession().setAttribute("cartPageNo", pageNo);
        }

        if(req.getServletContext().getAttribute("collectionPageNo")!=null){
            String collectionPageNo = req.getServletContext().getAttribute("collectionPageNo").toString();
            System.out.println("collectionPageNo:" + collectionPageNo);
            req.getSession().setAttribute("collectionPageNo", collectionPageNo);
        }




        //如果当前页面用户未登录，那么就默认从首页中展示所有商品，并且方法退出
        if (username == null) {
            System.out.println("用户未登录");
            productServlet.queryProductByIndex(req, resp);
            return;
        }

        //如果是第一次登录，那么就将当前登录的用户名存入到全局变量中
        if ("".equals(currentUsername) || currentUsername == null) {
            currentUsername = username;
        } else if (!currentUsername.equals(username)) {
            //判断当前登录的用户名是否与全局变量中的用户名相同
            //如果不同，代表上一个用户已经退出账号，当前是新用户
            //那么就将上一个用户名保存的购物车信息和购物车商品总价清空，并将当前用户名更换为新用户的名字
            System.out.println("用户名不对了！,清空！");
            currentUsername = username;
            bookMap = new HashMap<>();
            productCartMap = new HashMap<>();
            sum = 0.0;
        }

        //否则能走到这里，说明当前用户已经登录，可以正常添加图书到购物车中
        //key存放图书id，value存放图书数量
        bookMap.put(id, bookMap.getOrDefault(id, 0) + 1);

        System.out.println("当前用户名：" + currentUsername);
        System.out.println("全局用户名：" + username);
        for (Map.Entry<String, Integer> entry : bookMap.entrySet()) {
            System.out.println("bookMap图书id:" + entry.getKey() + " 购买数量:" + entry.getValue());
        }
        System.out.println("----------------------------------------------------");

        System.out.println("flag = " + req.getParameter("flag"));


        if("cart".equals(req.getParameter("flag"))){
            //从购物车进来的保持当前商品目录不需要变动，默认展示全部商品
            productServlet.page(req, resp);
        }else if("collection".equals(req.getParameter("flag"))){
            //否则就是从我的收藏里面进来的
            CollectionServlet collectionServlet = new CollectionServlet();
            collectionServlet.queryUserCollection(req, resp);
        }

    }


    /**
     * 点击“去结账”，购物车结账界面
     * @param req  请求
     * @param resp 响应
     * @throws ServletException
     * @throws IOException
     */
    protected void cartCheckout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进来了购物车结账cartCheckout----------------------------------------------------");
        username = (String) req.getServletContext().getAttribute("username");

        //如果当前切换用户登录之后直接点击购物车结账，没有进行图书添加，那么也在这作判断
        //也将上一个用户的信息给清空，并且置标记flag为1代表当前购物车应该为空
        if (currentUsername != null && !currentUsername.equals(username)) {
            System.out.println("用户名不对了！,清空！");
            currentUsername = username;
            bookMap = new HashMap<>();
            productCartMap = new HashMap<>();
            sum = 0.0;
            //标记flag作用于Cart.jsp中用于“提交订单”按钮的判断
            req.getSession().setAttribute("flag", 1);
        }

        //直接提取当前购物车哈希表中的数据，获得全部图书id
        Set<String> bookIdSet = bookMap.keySet();
        bookIdSet.forEach(System.out::println);

        //返回一个Map集合来整合数据，key为书籍详细信息、value为购买数量
        Map<Product, Integer> productMap = new HashMap<>();

        //调用方法，通过购物车中的全部图书id批量查询对应的图书信息作为List<Product>返回
        List<Product> products = cartService.findBatchProductBySet(bookIdSet);


        //totalPrices用来计算当前购物车中全部商品的价格
        Double totalPrices = 0.0;
        for (Product product : products) {
            //再单独计算当前图书总额，取出每一个图书的单价和购买数量进行累加
            totalPrices += (product.getPrice() * bookMap.get(product.getId()));
            productMap.put(product, bookMap.get(product.getId()));
        }


        //这里防止购物车中删除了全部商品但总价还没有发生变化的情况
        if (bookMap.isEmpty()) {
            System.out.println("购物车没有变化或购物车为空！");
            // req.setAttribute("productMap", productCartMap);
            req.setAttribute("productMap", productMap);
            req.setAttribute("sum", sum);
            req.getSession().setAttribute("flag",1);
            req.getRequestDispatcher("WebContent/client/Cart.jsp").forward(req, resp);
            return;
        }else{
            req.getSession().setAttribute("flag",null);
        }

        //将当前购物车中的总价赋给全局变量sum
        sum = totalPrices;

        //将当前购物车中的产品全部放入productCartMap,并设置request域的键值对用于给JSP页面获取
        productCartMap.putAll(productMap);
        req.setAttribute("products", products);
        req.setAttribute("productMap", productMap);
        req.setAttribute("sum", totalPrices);

        req.getRequestDispatcher("WebContent/client/Cart.jsp").forward(req, resp);
    }


    /**
     * 删除购物车中的图书
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteCartItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进来了删除购物车中的图书deleteCartItem-------------------------------------------");

        //只需要删除Map集合中的元素即可，不需要连接数据库
        String productId = req.getParameter("id");
        bookMap.remove(productId);
        //根据被删除的图书id找到对应的价格，从图书总和中删除
        Product curProduct = cartService.findProductById(productId);
        sum -= curProduct.getPrice();


        //重新获取购物车中的图书id
        Set<String> bookIdSet = bookMap.keySet();

        //根据这些图书id批量查询图书信息作为List<Product>返回
        List<Product> products = cartService.findBatchProductBySet(bookIdSet);

        //再定义一个Map集合来存储购物车中的图书信息，key存放Product实体类对象，value存放购买数量
        Map<Product, Integer> productMap = new HashMap<>();
        for (Product product : products) {
            productMap.put(product, bookMap.get(product.getId()));
        }

        //将当前购物车中的产品全部放入productCartMap
        productCartMap.putAll(productMap);

        //设置标记，判断删除商品之后购物车是否为空
        if (productMap.isEmpty()) {
            //如果购物车中的商品全部删除完了，设置标记为1代表购物车商品空，不能提交
            req.getSession().setAttribute("flag", 1);
        } else {
            //否则购物车中还有商品，可以正常提交
            req.getSession().setAttribute("flag", null);
        }

        req.setAttribute("productMap", productMap);
        req.setAttribute("sum", sum);
        req.getRequestDispatcher("WebContent/client/Cart.jsp").forward(req, resp);
    }


    /**
     * 单纯转发到支付界面
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void payView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进来了支付界面payView-------------------------------------------");
        req.getRequestDispatcher("WebContent/client/Pay.jsp").forward(req, resp);
    }

    /**
     * 模拟支付
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void simulationPay(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进来了模拟支付simulationPay-------------------------------------------");

        System.out.println("orderId：" + req.getParameter("orderId"));
        System.out.println("pay：" + req.getParameter("pay"));

        //如果已支付就修改订单状态，否则直接返回
        if("1".equals(req.getParameter("pay"))){
            System.out.println("已支付");
            //修改订单状态为已支付“1”
            cartService.updateOrderStatus(req.getParameter("orderId"));

            /**增加该商品的销量*/
            //1、根据订单id查询订单下购买的多个商品id
            OrderDao orderDao = new OrderDaoImpl();
            List<OrderItem> list = orderDao.findOrderItemByOrderId(req.getParameter("orderId"));

            //2、找出当前订单下所有商品信息之后，逐个取出对应的商品id和商品数量进行修改
            for (OrderItem orderItem : list) {
                Order order = orderItem.getOrder();
                String productId = orderItem.getProductId();
                int buyNum = orderItem.getBuynum();

                //3、根据商品id和对应的购买数量修改商品的销量
                int i = saleService.addProductSalesById(productId, buyNum);
            }

            //4、更新当前用户的支付状态
            User loginUser = (User) req.getServletContext().getAttribute("loginUser");
            List<Order> orderList = cartService.findOrderByUserId(loginUser.getId().toString());
            req.getServletContext().setAttribute("orderListByUserId", orderList);

        }
        req.getRequestDispatcher("WebContent/client/PaySuccess.jsp").forward(req, resp);
    }


    /**
     * 购物车提交,生成订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void submitCartItems(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进来了购物车提交submitCartItems------------------------------------------");

        //防止用户未登录就直接点进购物车结算界面提交订单
        if (currentUsername == null || !currentUsername.equals(username)) {
            System.out.println("用户未登录或已经切换了用户,购物车结账失败");
            req.getRequestDispatcher("WebContent/client/index.jsp").forward(req, resp);
        }

        for (Map.Entry<String, Integer> entry : bookMap.entrySet()) {
            System.out.println("bookMap图书id:" + entry.getKey() + " 购买数量:" + entry.getValue());
        }

        for (Map.Entry<Product, Integer> entry : productCartMap.entrySet()) {
            System.out.println("productCartMap图书id:" + entry.getKey().getId() + " 购买数量:" + entry.getValue());
        }

        //判断如果购物车为空就不能提交
        if (bookMap.isEmpty() || productCartMap.isEmpty()) {
            //购物车为空的情况下标志为1
            System.out.println("购物车为空，不能提交");
            req.setAttribute("sum", sum);
            req.getSession().setAttribute("flag", 1);
            req.getRequestDispatcher("WebContent/client/Cart.jsp").forward(req, resp);
            return;
        } else {
            req.getSession().setAttribute("flag", null);
        }


        /**否则能到下面的代码代表可以正常的提交生成订单*/
        //生成UUID作为订单号id
        String orderId = UUID.randomUUID().toString();
        System.out.println("生成的订单号为：" + orderId);

        //获取总价sum
        Double orderMoney = sum;
        System.out.println("订单总价为：" + orderMoney);

        //获取当前登录用户的数据，返回实体类User
        User loginUser = (User) req.getServletContext().getAttribute("loginUser");

        //获取用户填写的地址、用户名、手机号
        String receiverName = req.getParameter("receiverName");
        String receiverAddress = req.getParameter("receiverAddress");
        String receiverPhone = req.getParameter("receiverPhone");

        System.out.println("收货人姓名：" + receiverName);
        System.out.println("收货人地址：" + receiverAddress);
        System.out.println("收货人手机号：" + receiverPhone);


        //获取用户id
        Integer userId = loginUser.getId();
        System.out.println("当前用户的id为：" + userId);

        //保存封装为Order对象,并保存到数据库中，默认是未支付状态
        Order order = new Order(orderId, orderMoney, receiverAddress, receiverName, receiverPhone, 0, new Date(), userId.toString(), loginUser);
        cartService.addOrder(order);


        /**再分别对当前订单号生成多个商品购买信息*/
        for (Map.Entry<String, Integer> entry : bookMap.entrySet()) {
            System.out.println("图书id:" + entry.getKey() + " 购买数量:" + entry.getValue());
        }
        //bookMap中保存着当前购物车的图书id和购买数量，遍历bookMap，生成多个商品购买信息
        cartService.addBatchOrderItem(orderId, bookMap);

        //提交订单之后对应的商品库存数量也需要修改，买了一本书对应的库存就要减1
        cartService.updateBatchProductNum(bookMap);

        //购买完成之后，清空购物车和总价，并设置标记为1代表购物车商品空，不能提交
        bookMap.clear();
        productCartMap.clear();
        req.getSession().setAttribute("flag", 1);
        sum = 0.0;

        //将当前用户的订单信息保存保存到整个应用域中，因为一个账户可以买多个订单，所以需要用List
        List<Order> list = cartService.findOrderByUserId(loginUser.getId().toString());
        req.getServletContext().setAttribute("orderListByUserId", list);

        
        //跳转回一个新页面，显示订单号
        req.setAttribute("orderId", orderId);
        req.getRequestDispatcher("WebContent/client/createOrder.jsp").forward(req, resp);
    }

}

