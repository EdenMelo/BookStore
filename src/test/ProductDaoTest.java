package test;

import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import org.junit.Test;
import pojo.Product;
import utils.JdbcUtils;

import java.util.ArrayList;
import java.util.List;

public class ProductDaoTest {

    private ProductDao productDao = new ProductDaoImpl();

    @Test
    public void testGetProduct() {
        List<Product> products = productDao.queryAllProduct();
        for(Product product: products) {
            System.out.println(product);
        }
    }

    @Test
    public void testGetProductById() {
        List<Object> args = new ArrayList<>();
        args.add("计算机");
        args.add(0);
        args.add(50);

        List<Product> products = productDao.queryByCondition("id", "name", "?", 0, 50,args);
        for(Product product: products) {
            System.out.println(product);
        }
    }

    @Test
    public void testAddProduct() {
        Product product = new Product(null,"苹果",10.0,"计算机",1,"none","none");
        int add = productDao.addProduct(product);
        //手动提交事务
        JdbcUtils.commitAndClose();
        System.out.println(add);
    }

    @Test
    public void testUpdateProduct() {
        int update = productDao.updateProductById("0cdd18c9-cd40-4289-954f-b71d92048a70","橙",15.0,114,"生活百科","none","none");
        //手动提交事务
        JdbcUtils.commitAndClose();
        System.out.println(update);
    }

    @Test
    public void testDeleteProduct() {
        int delete = productDao.deleteProduct("0cdd18c9-cd40-4289-954f-b71d92048a70");
        //手动提交事务
        JdbcUtils.commitAndClose();
        System.out.println(delete);
    }

    @Test
    public void testQueryByCategory() {
        List<Product> list = productDao.queryByCategory("生活百科");
        list.forEach(System.out::println);
    }

    @Test
    public void testQueryForPageTotalCount() {
        Integer integer = productDao.queryForPageTotalCount();
        System.out.println(integer);
    }

    @Test
    public void testQueryForPageItems() {
        List<Product> list = productDao.queryForPageItems(0, 5);
        list.forEach(System.out::println);
    }

    @Test
    public void testQueryProductById() {
        Product product = productDao.queryProductById("33eb296c-44a7-465d-a2de-164a3ee2f0a4");
        System.out.println(product);
    }

}
