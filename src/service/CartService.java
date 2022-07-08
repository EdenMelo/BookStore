package service;

import pojo.Order;
import pojo.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface CartService {
    /**根据图书id查询图书信息*/
    Product findProductById(String id);

    /**传入Map集合，批量查询图书信息，返回List集合*/
    List<Product> findBatchProductBySet(Set<String> bookIdSet);

    /**根据图书id删除购物车中的商品*/
    int deleteProductById(String id);

    /**新增一条订单信息*/
    int addOrder(Order order);

    /**批量新增订单商品信息*/
    int addBatchOrderItem(String orderId, Map<String,Integer> cartProductMap);

    /**根据用户id查询对应的多条订单信息*/
    List<Order> findOrderByUserId(String userId);

    /**根据图书id批量修改图书库存数量*/
    int updateBatchProductNum(Map<String,Integer> cartProductMap);

    int updateOrderStatus(String orderId);
}
