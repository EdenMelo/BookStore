package dao.impl;


import dao.ProductDao;
import pojo.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductDaoImpl extends BaseDao implements ProductDao {

    @Override
    public List<Product> queryAllProduct() {
        // String sql = "select `id`,`name`,`price`,`category`,`pnum`,`imgurl`,`description` from products";
        String sql = "select * from products";
        return queryForList(Product.class,sql);
    }

    @Override
    public List<Product> queryByCondition(String sqlId, String sqlName, String sqlCategory, double minPrice, double maxPrice,List<Object> args) {

        //传进来的sqlId要么id = id ，要么是有具体值的占位符“?”，即id = ?形式，然后args集合的元素为占位符"?"需要的具体值
        String sql = "SELECT * FROM `products` WHERE `id` = "+sqlId+" and `name` = "+sqlName+" and `category` = "+sqlCategory+" and `price` BETWEEN ? AND ?";
        // String sql = "SELECT * FROM `products` WHERE `id` = id  and `name` = ? and `category` = ? and `price` BETWEEN ? AND ?";

        //将args集合转换成Object数组
        return queryForList(Product.class,sql,args.toArray());
    }


    @Override
    public int addProduct(Product product) {
        //添加商品不需要从Product里获取id，因为id是自动生成的UUID.randomUUID().toString()
        String sql = "insert into products(`id`,`name`,`price`,`category`,`pnum`,`imgurl`,`description`) values(?,?,?,?,?,?,?)";
        return update(sql,UUID.randomUUID().toString(),product.getName(),product.getPrice(),product.getCategory(),product.getPnum(),product.getImgurl(),product.getDescription());
    }


    @Override
    public int updateProductById(String id, String name, double price, int pnum, String category, String description, String imgurl) {
        String sql = "update products set `name` = ?,`price` = ?,`pnum` = ?,`category` = ?,`description` = ?,`imgurl` = ? where `id` = ?";
        return update(sql,name,price,pnum,category,description,imgurl,id);
    }

    @Override
    public int deleteProduct(String id) {
        String sql = "delete from products where `id` = ?";
        return update(sql,id);
    }

    @Override
    public List<Product> queryByCategory(String category) {
        String sql = "select * from products where `category` = ?";
        return queryForList(Product.class, sql, category);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from products";
        Number count = (Number) queryForSingleValue(sql);
        //返回的是Number类型，但需要使用intValue方法转成Integer/int类型
        return count.intValue();
    }

    @Override
    public List<Product> queryForPageItems(int begin, int pageSize) {
        String sql = "select * from products limit ?,?";
        return queryForList(Product.class, sql, begin, pageSize);
    }

    @Override
    public Product queryProductById(String id) {
        String sql = "select * from products where `id` = ?";
        return queryForOne(Product.class, sql, id);
    }

    @Override
    public int updateProductNum(String productId, int buyNum) {
        String sql = "update products set pnum = pnum + ? where id = ?";
        return update(sql,buyNum,productId);
    }
}
