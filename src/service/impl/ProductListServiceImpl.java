package service.impl;

import dao.ProductListDao;
import dao.impl.ProductListDaoImpl;
import pojo.Product;
import service.ProductListService;
import utils.JdbcUtils;

import java.util.List;

public class ProductListServiceImpl implements ProductListService {

    private ProductListDao productListDao = new ProductListDaoImpl();

    @Override
    public List<Product> queryBookByName(String name) {
        List<Product> products = productListDao.queryBookByName(name);
        //提交事务
        JdbcUtils.commitAndClose();
        return products;
    }
}
