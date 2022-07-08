package service.impl;

import dao.SaleDao;
import dao.impl.SaleDaoImpl;
import pojo.ProductSales;
import service.SaleService;
import utils.JdbcUtils;

import java.util.List;

public class SaleServiceImpl implements SaleService {

    SaleDao saleDao = new SaleDaoImpl();

    @Override
    public List<ProductSales> findAllProductSales(Integer queryNum) {
        List<ProductSales> list = saleDao.queryAllProductSales(queryNum);
        JdbcUtils.commitAndClose();
        return list;
    }

    @Override
    public int addProductSalesById(String productId, int productSale) {
        int i = saleDao.updateProductSalesById(productId, productSale);
        if(i!=1){
            JdbcUtils.rollbackAndClose();
        }else{
            JdbcUtils.commitAndClose();
        }
        return i;
    }
}

