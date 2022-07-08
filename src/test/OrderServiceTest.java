package test;

import org.junit.Test;
import pojo.Order;
import service.OrderService;
import service.impl.OrderServiceImpl;
import utils.JdbcUtils;

import java.util.List;

public class OrderServiceTest {

    private OrderService orderService = new OrderServiceImpl();

    @Test
    public void testOrderService01(){
        orderService.findAllOrder().forEach(System.out::println);
    }

    @Test
    public void testFindOrderItemByOrderId(){
        orderService.findOrderItemByOrderId("0c0796f2-0124-4a13-a891-5efbb63b04f9").forEach(System.out::println);
    }

    @Test
    public void testFindProductById(){
        System.out.println(orderService.findProductById("72c52302-cd1e-4a22-8ac8-dc300a915be5"));
    }

    @Test
    public void testDeleteOrderById(){
        int i = orderService.deleteOrderById("f4f89ebd-6321-4d90-849e-da0b31aaba7a", "3");
        System.out.println(i);
        JdbcUtils.commitAndClose();
    }

    @Test
    public void testDeleteOrderItemByOrderId(){
        int i = orderService.deleteOrderItemByOrderId("5ca52408-03f5-4950-98a1-a8cc9191c2ae");
        System.out.println(i);
        JdbcUtils.commitAndClose();
    }

    @Test
    public void testFindOrderByCondition(){
        // List<Order> list = orderService.findOrderByCondition("0c0796f2-0124-4a13-a891-5efbb63b04f9", "hanyongmeng");
        // List<Order> list = orderService.findOrderByCondition("0c0796f2-0124-4a13-a891-5efbb63b04f9", null);
        // List<Order> list = orderService.findOrderByCondition(null, "hanyongmeng");
        List<Order> list = orderService.findOrderByCondition(null, null);
        list.forEach(System.out::println);
    }

}
