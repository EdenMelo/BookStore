package dao;

import pojo.Order;
import pojo.OrderItem;
import pojo.Product;

import java.util.List;

public interface OrderDao {
    /**查找所有订单*/
    List<Order> findAllOrder();

    /**根据条件查询订单信息*/
    List<Order> findOrderByCondition(String orderId,String receiverName);

    /**根据订单编号查询订单商品*/
    List<OrderItem> findOrderItemByOrderId(String orderId);

    /**根据id查找订单信息*/
    Order findOrderById(String id);

    /**根据产品id查询产品信息*/
    Product findProductById(String productId);

    /**根据订单id和用户id删除订单*/
    int deleteOrderById(String orderId, String userId);

    /**根据订单id删除订单项*/
    int deleteOrderItemByOrderId(String orderId);
}
