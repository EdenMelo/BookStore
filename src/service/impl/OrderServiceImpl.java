package service.impl;

import dao.OrderDao;
import dao.UserDao;
import dao.impl.OrderDaoImpl;
import dao.impl.UserDaoImpl;
import org.junit.Test;
import pojo.Order;
import pojo.OrderItem;
import pojo.Product;
import service.OrderService;
import utils.JdbcUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = new OrderDaoImpl();

    private UserDao userDao = new UserDaoImpl();


    /**
     * 查找所有订单信息
     * @return 订单集合
     */
    @Override
    public List<Order> findAllOrder() {
        List<Order> list = orderDao.findAllOrder();
        //一个订单可能有多个商品，所以订单实体类Order下还需要设置一个List<OrderItem>属性
        List<OrderItem> orderItemList = new LinkedList<>();

        for (Order order : list) {
            //根据用户id查找用户信息，设置User对象
            int userId = Integer.parseInt(order.getUserId());
            // order.setUserId(order.getUserId());
            //表示当前订单的用户
            order.setUser(userDao.queryUserById(userId));

            //一个订单可能有多个商品，根据订单id查找全部的订单商品项
            orderItemList = orderDao.findOrderItemByOrderId(order.getId());
            //再设置当前订单下的订单商品项
            order.setOrderItems(orderItemList);
        }

        JdbcUtils.commitAndClose();
        return list;
    }

    /**
     * 根据条件查找订单
     * @param orderId
     * @param receiverName
     * @return
     */
    @Override
    public List<Order> findOrderByCondition(String orderId, String receiverName) {
        if("".equals(orderId) || orderId == null){
            orderId = "id";
        }else{
            orderId = "'" + orderId + "'";
        }

        if("".equals(receiverName) || receiverName == null){
            receiverName = "receiverName";
        }else{
            receiverName = "'" + receiverName + "'";
        }
        System.out.println("service：" + orderId +"--------"+ receiverName);


        List<Order> list = orderDao.findOrderByCondition(orderId, receiverName);
        //一个订单可能有多个商品，所以订单实体类Order下还需要设置一个List<OrderItem>属性
        List<OrderItem> orderItemList = new LinkedList<>();

        for (Order order : list) {
            //根据用户id查找用户信息，设置User对象
            int userId = Integer.parseInt(order.getUserId());
            //表示当前订单的用户
            order.setUser(userDao.queryUserById(userId));

            //一个订单可能有多个商品，根据订单id查找全部的订单商品项
            orderItemList = orderDao.findOrderItemByOrderId(order.getId());
            //再设置当前订单下的订单商品项
            order.setOrderItems(orderItemList);
        }

        JdbcUtils.commitAndClose();
        return list;
    }

    /**
     * 根据订单id指定订单项详细信息
     * @param orderId 订单id
     * @return 订单项集合
     */
    @Override
    public List<OrderItem> findOrderItemByOrderId(String orderId) {
        List<OrderItem> list = orderDao.findOrderItemByOrderId(orderId);
        JdbcUtils.commitAndClose();
        return list;
    }

    /**
     * 根据商品id查找商品信息
     * @param productId 商品id
     * @return  商品对象
     */
    @Override
    public Product findProductById(String productId) {
        Product product = orderDao.findProductById(productId);
        JdbcUtils.commitAndClose();
        return product;
    }


    /**
     * 根据订单id和用户id删除订单
     * @param orderId 订单id
     * @param userId 用户id
     * @return
     */
    @Override
    public int deleteOrderById(String orderId, String userId) {
        int i = orderDao.deleteOrderById(orderId, userId);
        JdbcUtils.commitAndClose();
        return i;
    }

    /**
     * 根据订单id删除订单项
     * @param orderId
     * @return
     */
    @Override
    public int deleteOrderItemByOrderId(String orderId) {
        int i = orderDao.deleteOrderItemByOrderId(orderId);
        JdbcUtils.commitAndClose();
        return i;
    }

    @Override
    public Order findOrderByUserId(String userId) {
        return null;
    }
}
