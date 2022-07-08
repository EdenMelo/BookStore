package service;

import pojo.Page;
import pojo.Product;

import java.util.List;

public interface ProductService {
    //查询全部商品
    public List<Product> queryAllProduct();

    //根据多个条件查询商品
    public List<Product> queryByCondition(String id, String name, String category, double minPrice, double maxPrice);

    /**根据商品id查询图书信息*/
    Product queryProductById(String id);

    //添加商品
    public int addProduct(Product product);

    //根据商品ID删除商品
    public int deleteProductById(String id);

    //根据商品ID修改商品信息
    public int updateProductById(String id, String name, double price, int pnum, String category, String description, String imgurl);

    /**根据图书类型查询对应的图书*/
    List<Product> findByCategory(String category);

    /**设置当前分页的图书数据*/
    Page<Product> page(int pageNo, int pageSize);

    /**根据订单id批量增加图书的库存数量*/
    int batchAddProductNum(String orderId);
}
