package dao.impl;

import dao.OrderDao;
import pojo.Order;
import pojo.OrderItem;
import pojo.Product;

import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public List<Order> findAllOrder() {
        String sql = "select `id`,`money`,`receiverAddress`,`receiverName`,`receiverPhone`,`paystate`," +
                "`ordertime`,`user_id` AS `userId`"+
                " from orders order by orders.user_id";
        return queryForList(Order.class,sql);
    }

    @Override
    public List<Order> findOrderByCondition(String orderId,String receiverName) {
        String sql = "select `id`,`money`,`receiverAddress`,`receiverName`,`receiverPhone`,`paystate`," +
                "`ordertime`,`user_id` AS `userId`"+
                " from orders where id = "+orderId+" and receiverName = "+receiverName;
        return queryForList(Order.class,sql);
    }

    @Override
    public List<OrderItem> findOrderItemByOrderId(String orderId) {
        String sql = "select " +
                "product_id as productId, " +
                "buynum " +
                "from orderitem " +
                "where order_id = ?";
        return queryForList(OrderItem.class,sql,orderId);
    }

    @Override
    public Order findOrderById(String id) {
        String sql = "select * from orders where id= ? ";
        return queryForOne(Order.class,sql,id);
    }

    @Override
    public Product findProductById(String productId) {
        String sql = "select * from products where id= ? ";
        return queryForOne(Product.class,sql,productId);
    }

    @Override
    public int deleteOrderById(String orderId, String userId) {
        String sql = "delete from orders where id = ? and user_id = ?";
        return update(sql,orderId,userId);
    }

    @Override
    public int deleteOrderItemByOrderId(String orderId) {
        String sql = "delete from orderitem where order_id = ?";
        return update(sql,orderId);
    }
}
