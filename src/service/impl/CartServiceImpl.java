package service.impl;

import dao.CartDao;
import dao.impl.CartDaoImpl;
import pojo.Order;
import pojo.Product;
import service.CartService;
import utils.JdbcUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CartServiceImpl implements CartService {
    CartDao cartDao = new CartDaoImpl();

    @Override
    public Product findProductById(String id) {
        Product product = cartDao.findProductById(id);
        JdbcUtils.commitAndClose();
        return product;
    }

    @Override
    public List<Product> findBatchProductBySet(Set<String> bookIdSet) {
        List<Product> productList = new ArrayList<>();

        for (String bookId : bookIdSet) {
            Product product = cartDao.findProductById(bookId);
            productList.add(product);
        }
        JdbcUtils.commitAndClose();
        return productList;
    }

    @Override
    public int deleteProductById(String id) {
        int i = cartDao.deleteProductById(id);
        JdbcUtils.commitAndClose();
        return i;
    }

    @Override
    public int addOrder(Order order) {
        int i = cartDao.insertOrder(order);
        JdbcUtils.commitAndClose();
        return i;
    }

    @Override
    public int addBatchOrderItem(String orderId, Map<String, Integer> cartProductMap) {
        int i = 0;
        for(Map.Entry<String, Integer> entry : cartProductMap.entrySet()) {
            i = cartDao.insertOrderItem(orderId, entry.getKey(), entry.getValue());
        }
        JdbcUtils.commitAndClose();
        return i;
    }

    @Override
    public List<Order> findOrderByUserId(String userId) {
        List<Order> list = cartDao.findOrderByUserId(userId);
        JdbcUtils.commitAndClose();
        return list;
    }

    @Override
    public int updateBatchProductNum(Map<String, Integer> cartProductMap) {
        int i = 0;
        for(Map.Entry<String, Integer> entry : cartProductMap.entrySet()) {
            i = cartDao.updateProductNum(entry.getKey(), entry.getValue());
        }
        JdbcUtils.commitAndClose();
        return i;
    }

    @Override
    public int updateOrderStatus(String orderId) {
        int i = cartDao.updateOrderStatus(orderId);
        JdbcUtils.commitAndClose();
        return i;
    }
}
