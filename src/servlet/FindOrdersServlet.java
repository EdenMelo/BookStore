package servlet;

import pojo.Order;
import pojo.OrderItem;
import pojo.Product;
import pojo.User;
import service.CartService;
import service.OrderService;
import service.impl.CartServiceImpl;
import service.impl.OrderServiceImpl;
import utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

// @WebServlet("/findOrdersServlet")
public class FindOrdersServlet extends BaseServlet{

    private OrderService orderService = new OrderServiceImpl();

    /**
     * 后台：查询所有订单信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findAllOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> list = orderService.findAllOrder();

        //测试成功
        list.forEach(System.out::println);

        req.setAttribute("orderList", list);

        //请求转发
        req.getRequestDispatcher("WebContent/admin/products/orderList.jsp").forward(req,resp);
    }

    /**
     * 后台：根据条件来查询订单信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findOrdersByCondition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("------------进来了条件查询订单findOrdersByCondition-------------");
        String orderId = req.getParameter("orderId");
        String receiverName = req.getParameter("name");
        System.out.println("orderId:" + orderId + "\n receiverName:" + receiverName);

        //判断orderId和receiverName都为空就查询所有订单
        if(("".equals(orderId) ||orderId == null) && ("".equals(receiverName) || receiverName == null)){
            //查询所有订单
            System.out.println("查询所有订单");
            findAllOrders(req,resp);
            return;
        }

        System.out.println("条件查询订单");
        List<Order> list = orderService.findOrderByCondition(orderId, receiverName);
        req.setAttribute("orderList",list);

        //请求转发
        req.getRequestDispatcher("WebContent/admin/products/orderList.jsp").forward(req,resp);
    }


    /**
     * 后台：根据当前订单查看订单详细信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findAllOrderItems(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("id");

        //根据订单id获取订单项，看当前订单中买了什么商品
        List<OrderItem> itemList = orderService.findOrderItemByOrderId(orderId);

        //一个订单商品项OrderItem对应一个商品Product
        //所以还需要设置OrderItem对应的Product属性
        for(OrderItem orderItem : itemList){
            String productId = orderItem.getProductId();
            Product product = orderService.findProductById(productId);
            //P是设置当前订单项中的商品信息Product，一个订单商品项对应一个商品
            orderItem.setP(product);
        };

        //保存订单商品项用于JSP页面展示
        req.setAttribute("itemList",itemList);

        req.getRequestDispatcher("WebContent/admin/products/orderView.jsp").forward(req,resp);
    }


    /**
     * 后台：删除订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("------------进来了删除订单deleteOrder-------------");
        String orderId = req.getParameter("orderId");
        String userId = req.getParameter("userId");

        System.out.println("orderId:" + orderId);
        System.out.println("userId:" + userId);

        //既要删除order订单，又要删除orderItem订单项
        orderService.deleteOrderById(orderId,userId);
        orderService.deleteOrderItemByOrderId(orderId);


        //更新当前用户的订单信息，进行参数初始化，即重新查询当前用户的订单信息
        //再重新放入全局域中用于“个人账户”的订单显示
        CartService cartService = new CartServiceImpl();
        User loginUser = (User) req.getServletContext().getAttribute("loginUser");
        List<Order> list = cartService.findOrderByUserId(loginUser.getId().toString());
        req.getServletContext().setAttribute("orderListByUserId", list);


        //继续查询全部订单信息即可
        findAllOrders(req, resp);
    }


    /**
     * 前台：根据当前订单查看订单详细信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findAllOrderItemsByAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("id");

        //根据订单id获取订单项，看当前订单中买了什么商品
        List<OrderItem> itemList = orderService.findOrderItemByOrderId(orderId);

        //一个订单商品项OrderItem对应一个商品Product
        //所以还需要设置OrderItem对应的Product属性
        for(OrderItem orderItem : itemList){
            String productId = orderItem.getProductId();
            Product product = orderService.findProductById(productId);
            //P是设置当前订单项中的商品信息Product，一个订单商品项对应一个商品
            orderItem.setP(product);
        };

        //保存订单商品项用于JSP页面展示
        req.setAttribute("itemList",itemList);

        req.getRequestDispatcher("WebContent/client/AccountOrderView.jsp").forward(req,resp);
    }

}
