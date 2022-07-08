package dao;

import pojo.Product;

import java.util.List;

public interface ProductDao {
    /**查询全部商品*/
    List<Product> queryAllProduct();

    /**根据多个条件查询商品*/
    List<Product> queryByCondition(String id, String name, String category, double minPrice, double maxPrice,List<Object> args);

    /**根据商品id查询图书信息*/
    Product queryProductById(String id);

     /**添加商品*/
    int addProduct(Product product);

     /**删除商品*/
    int deleteProduct(String id);

     /**根据商品ID修改商品信息*/
    int updateProductById(String id, String name, double price, int pnum, String category, String description, String imgurl);

    /**根据图书类型查询对应的图书*/
    List<Product> queryByCategory(String category);

    /**查询总记录数*/
    Integer queryForPageTotalCount();

    /**分页查询*/
    List<Product> queryForPageItems(int begin, int pageSize);

    /**根据图书id和数量对应修改（增加）当前图书的库存数量*/
    int updateProductNum(String productId, int buyNum);
}
