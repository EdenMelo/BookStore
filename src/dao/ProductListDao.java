package dao;

import pojo.Product;

import java.util.List;

public interface ProductListDao {
    //根据书名查询书本信息
    public List<Product> queryBookByName(String name);
}
