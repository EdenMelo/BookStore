package test;

import org.junit.Test;
import pojo.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;
import utils.JdbcUtils;

import java.util.List;

public class ProductServiceTest {

    private ProductService productService = new ProductServiceImpl();

    @Test
    public void testQueryAllProduct() {
        List<Product> products = productService.queryAllProduct();
        for(Product product : products) {
            System.out.println(product);
        }
    }

    @Test
    public void testQueryProductByCondition() {

        List<Product> products = productService.queryByCondition("id", "name", "计算机", 0, 50);
        for(Product product : products) {
            System.out.println(product);
        }
    }

    //添加商品
    @Test
    public void testAddProduct() {
        Product product = new Product(null,"香蕉",20.0,"计算机",222,"none","none");
        int add = productService.addProduct(product);
        //手动提交事务
        JdbcUtils.commitAndClose();
        System.out.println(add);
    }

    //修改商品
    @Test
    public void testUpdateProduct() {
        int update = productService.updateProductById("0cdd18c9-cd40-4289-954f-b71d92048a70","菠萝",15.0,114,"生活百科","none","none");
        //手动提交事务
        JdbcUtils.commitAndClose();
        System.out.println(update);
    }

    //删除商品
    @Test
    public void testDeleteProduct() {
        int delete = productService.deleteProductById("eb9ffb38-a7b4-48a6-be94-fb208e6ed2bb");
        //手动提交事务
        JdbcUtils.commitAndClose();
        System.out.println(delete);
    }

    @Test
    public void testFindByCategory() {
        List<Product> list = productService.findByCategory("计算机");
        for(Product product : list) {
            System.out.println(product);
        }
    }

    @Test
    public void testQueryProductById() {
        Product product = productService.queryProductById("33eb296c-44a7-465d-a2de-164a3ee2f0a4");
        System.out.println(product);
    }

    @Test
    public void batchAddProductNum(){
        int i = productService.batchAddProductNum("41b9bf6f-ee9c-4f70-a70f-bb6aeeba47d6");
        System.out.println(i);
    }


}
