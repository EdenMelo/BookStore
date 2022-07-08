package test;

import dao.OrderDao;
import dao.SaleDao;
import dao.impl.OrderDaoImpl;
import dao.impl.SaleDaoImpl;
import org.junit.Test;
import pojo.Order;
import pojo.OrderItem;
import pojo.Product;
import service.OrderService;
import service.SaleService;
import service.impl.OrderServiceImpl;
import service.impl.SaleServiceImpl;

import java.util.LinkedList;
import java.util.List;

public class ServletTest {
    OrderService orderService = new OrderServiceImpl();

    @Test
    public void test() {
        //根据订单id获取订单项
        String orderId = "0c0796f2-0124-4a13-a891-5efbb63b04f9";
        List<OrderItem> itemList = orderService.findOrderItemByOrderId(orderId);
        Order order = new Order();

        //一个订单可能买了多本书
        List<Product> productList = new LinkedList<>();
        for (OrderItem orderItem : itemList) {
            String productId = orderItem.getProductId();
            Product product = orderService.findProductById(productId);
            orderItem.setP(product);
            productList.add(product);
        }
        ;

        itemList.forEach(System.out::println);

        productList.stream().forEach(System.out::println);
    }

    @Test
    public void test02() {
        /**增加该商品的销量*/
        //1、根据订单id查询订单下购买的多个商品id
        OrderDao orderDao = new OrderDaoImpl();
        List<OrderItem> list = orderDao.findOrderItemByOrderId("305a7870-3820-4079-b6f9-5d2b63cbcd2a");

        //2、找出当前订单下所有商品信息之后，逐个取出对应的商品id和商品数量进行修改
        for (OrderItem orderItem : list) {
            Order order = orderItem.getOrder();
            String productId = orderItem.getProductId();
            int buyNum = orderItem.getBuynum();

            //3、根据商品id和对应的购买数量修改商品的销量
            SaleService saleService = new SaleServiceImpl();
            int i = saleService.addProductSalesById(productId, buyNum);
            System.out.print(i+",");
        }

    }
}
