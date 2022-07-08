package test;

import dao.ProductListDao;
import dao.impl.ProductListDaoImpl;
import org.junit.Test;
import pojo.Product;

import java.util.List;

public class ProductListDaoTest {
    ProductListDao productListDao = new ProductListDaoImpl();

    @Test
    public void testGetProductList() {
        List<Product> products = productListDao.queryBookByName("计算机");
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
