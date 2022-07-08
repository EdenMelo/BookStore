package test;

import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import org.junit.Test;
import pojo.Order;
import pojo.OrderItem;
import pojo.Product;
import utils.JdbcUtils;

import java.util.List;

public class OrderDaoTest {

    private OrderDao orderDao = new OrderDaoImpl();

    @Test
    public void testFindAllOrder(){
        List<Order> list = orderDao.findAllOrder();
        list.forEach(System.out::println);
    }

    @Test
    public void testFindOrderByCondition(){
        // List<Order> list = orderDao.findOrderByCondition("'0c0796f2-0124-4a13-a891-5efbb63b04f9'", "'hanyongmeng'");
        List<Order> list = orderDao.findOrderByCondition("id", "receiverName");
        // List<Order> list = orderDao.findOrderByCondition("id", "'hanyongmeng'");
        list.forEach(System.out::println);
    }

    @Test
    public void testFindOrderItemByOrderId(){
        List<OrderItem> list = orderDao.findOrderItemByOrderId("0c0796f2-0124-4a13-a891-5efbb63b04f9");
        list.forEach(System.out::println);
    }

    @Test
    public void testFindOrderById(){
        Order order = orderDao.findOrderById("0c0796f2-0124-4a13-a891-5efbb63b04f9");
        System.out.println(order);
    }

    @Test
    public void testFindProductById(){
        Product product = orderDao.findProductById("5d026325-3d6c-402a-ac35-c8ea15385ad5");
        System.out.println(product);
    }

    @Test
    public void testDeleteOrderById(){
        int i = orderDao.deleteOrderById("5ca52408-03f5-4950-98a1-a8cc9191c2ae", "3");
        System.out.println(i);
        JdbcUtils.commitAndClose();
    }

    @Test
    public void testDeleteOrderItemByOrderId(){
        int i = orderDao.deleteOrderItemByOrderId("0c0796f2-0124-4a13-a891-5efbb63b04f9");
        System.out.println(i);
        JdbcUtils.commitAndClose();
    }




}
