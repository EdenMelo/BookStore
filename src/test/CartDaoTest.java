package test;

import dao.CartDao;
import dao.impl.CartDaoImpl;
import org.junit.Test;
import pojo.Order;
import pojo.Product;
import utils.JdbcUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CartDaoTest {

    CartDao cartDao = new CartDaoImpl();

    @Test
    public void testFindProductById() {
        Product product = cartDao.findProductById("5d026325-3d6c-402a-ac35-c8ea15385ad5");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));

        System.out.println(product);
    }

    @Test
    public void testDeleteProductById() {
        System.out.println(cartDao.deleteProductById("66666"));
        JdbcUtils.commitAndClose();
    }

    @Test
    public void testAddProduct(){
        int i = cartDao.insertOrder(new Order("11", 10, "地址", "收件人", "电话", 1, new Date(), "5", null));
        System.out.println(i);
        JdbcUtils.commitAndClose();
    }

    @Test
    public void testInsertOrderItem(){
        int i = cartDao.insertOrderItem("订单id", "商品id", 1);
        System.out.println(i);
        JdbcUtils.commitAndClose();
    }

    @Test
    public void testFindOrderByUserId(){
        List<Order> list = cartDao.findOrderByUserId("3");
        list.forEach(System.out::println);
    }

    @Test
    public void testUpdateProductNum(){
        int i = cartDao.updateProductNum("d8b3bd89-53b6-431a-8e67-d38fcff1a3d8", 2);
        System.out.println(i);
        JdbcUtils.commitAndClose();
    }

    @Test
    public void testUpdateOrderStatus(){
        int i = cartDao.updateOrderStatus("4c2eeb61-d917-4ad3-acf9-781e74094738");
        System.out.println(i);
        JdbcUtils.commitAndClose();
    }
}
