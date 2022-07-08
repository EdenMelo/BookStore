package test;

import org.junit.Test;
import pojo.Product;
import service.ProductListService;
import service.impl.ProductListServiceImpl;

import java.util.List;

public class ProductListServiceTest {
    private ProductListService productListService = new ProductListServiceImpl();

    @Test
    public void testGetProductList() {
        List<Product> products = productListService.queryBookByName("计算机");
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
