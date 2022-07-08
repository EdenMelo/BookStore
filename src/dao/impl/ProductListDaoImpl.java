package dao.impl;

import dao.ProductListDao;
import pojo.Product;

import java.util.List;

public class ProductListDaoImpl extends BaseDao implements ProductListDao {
    @Override
    public List<Product> queryBookByName(String name) {
        //根据书名查询书籍
        // String sql = "select `name`,`price`,`pnum` from products where name like '%"+name+"%' ";
        String sql = "select * from products where name like '%"+name+"%' ";
        return queryForList(Product.class,sql);
    }
}
