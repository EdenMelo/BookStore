package test;

import dao.SaleDao;
import dao.impl.SaleDaoImpl;
import org.junit.Test;
import pojo.ProductSales;
import pojo.Sales;
import utils.JdbcUtils;

import java.util.List;

public class SaleDaoTest {

    SaleDao saleDao = new SaleDaoImpl();

    @Test
    public void testQueryAllProductSales(){
        List<ProductSales> sales = saleDao.queryAllProductSales(5);
        sales.forEach(System.out::println);
    }

    @Test
    public void updateProductSalesById(){
        int i = saleDao.updateProductSalesById
                ("40196dab-07a3-4aba-abb6-504d7a6dd41c", 1);
        JdbcUtils.commitAndClose();
        System.out.println(i);
    }
}
