package dao;

import pojo.Order;
import pojo.Product;

import java.util.List;

public interface CartDao {
    /**根据图书id查询图书信息*/
    Product findProductById(String id);

    /**根据图书id删除图书信息*/
    int deleteProductById(String id);

    /**新增一条订单信息*/
    int insertOrder(Order order);

    /**新增一条订单商品信息*/
    int insertOrderItem(String orderId, String productId, int buyNum);

    /**根据用户id查询对应的多条订单信息*/
    List<Order> findOrderByUserId(String userId);

    /**根据图书id和数量对应修改当前图书的库存数量*/
    int updateProductNum(String productId, int buyNum);

    /**根据订单id修改订单支付状态*/
    int updateOrderStatus(String orderId);
}

