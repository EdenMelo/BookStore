package test;

import org.junit.Test;
import pojo.Order;
import pojo.Product;
import service.CartService;
import service.impl.CartServiceImpl;
import utils.JdbcUtils;

import java.util.*;

public class CartServiceTest {
    CartService cartService = new CartServiceImpl();

    @Test
    public void testFindProductById() {
        Product product = cartService.findProductById("79bbe618-d2f8-4081-b35a-62ebbe938b64");
        System.out.println(product);
    }

    @Test
    public void testFindBatchProductBySet() {
        Set<String> set = new HashSet<>();
        set.add("79bbe618-d2f8-4081-b35a-62ebbe938b64");
        set.add("709f46ea-ca60-498a-aec4-cdb42965a466");

        List<Product> list = cartService.findBatchProductBySet(set);
        list.forEach(System.out::println);
    }

    @Test
    public void testDeleteProductById() {
        int i = cartService.deleteProductById("6666");
        System.out.println(i);
    }

    @Test
    public void testAddOrder() {
        int i = cartService.addOrder(new Order("11", 10, "地址", "收件人", "电话", 1, new Date(), "5", null));
        System.out.println(i);
    }

    @Test
    public void testAddBatchOrderItem() {
        Map<String,Integer> cartProductMap = new HashMap<>();
        cartProductMap.put("测试1",1);
        cartProductMap.put("测试2",2);
        int i = cartService.addBatchOrderItem("11", cartProductMap);
        System.out.println(i);
    }

    @Test
    public void testFindOrderByUserId(){
        List<Order> list = cartService.findOrderByUserId("3");
        list.forEach(System.out::println);
        System.out.println("4");
    }

    @Test
    public void testUpdateBatchProductNum(){
        Map<String,Integer> map = new HashMap<>();
        map.put("d8b3bd89-53b6-431a-8e67-d38fcff1a3d8",1);
        map.put("84c842da-16b6-4e87-953e-859a1ca62bab",2);
        int i = cartService.updateBatchProductNum(map);
        System.out.println(i);
    }

    @Test
    public void testUpdateOrderStatus(){
        int i = cartService.updateOrderStatus("c1f5d4ca-3857-45c9-a4a5-4202be309cd1");
        System.out.println(i);
        JdbcUtils.commitAndClose();
    }


}
