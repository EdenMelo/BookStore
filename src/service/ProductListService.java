package service;

import pojo.Product;

import java.util.List;

public interface ProductListService {
    //根据书名查询书籍
    public List<Product> queryBookByName(String name);
}
