package dao.impl;

import dao.CartDao;
import pojo.Order;
import pojo.Product;

import java.util.List;

public class CartDaoImpl extends BaseDao implements CartDao {
    @Override
    public Product findProductById(String id) {
        String sql = "select * from products where id = ?";
        return queryForOne(Product.class,sql,id);
    }

    @Override
    public int deleteProductById(String id) {
        String sql = "delete from products where id = ?";
        return update(sql,id);
    }

    @Override
    public int insertOrder(Order order) {
        String sql = "insert into " +
                "orders " +
                "values(?,?,?,?,?,?,?,?)";
        return update(sql,order.getId(),order.getMoney(),order.getReceiverAddress(),order.getReceiverName(),order.getReceiverPhone(),order.getPaystate(),order.getOrdertime(),order.getUserId());
    }

    @Override
    public int insertOrderItem(String orderId, String productId, int buyNum) {
        String sql = "insert into orderitem values(?,?,?)";
        return update(sql,orderId,productId,buyNum);
    }

    @Override
    public List<Order> findOrderByUserId(String userId) {
        String sql = "select * from orders where user_id = ?";
        return queryForList(Order.class,sql,userId);
    }

    @Override
    public int updateProductNum(String productId, int buyNum) {
        String sql = "update products set pnum = pnum - ? where id = ?";
        return update(sql,buyNum,productId);
    }

    @Override
    public int updateOrderStatus(String orderId) {
        String sql = "update orders set paystate = 1 where id = ?";
        return update(sql, orderId);
    }
}
