package test;

import org.junit.Test;
import pojo.ProductSales;
import service.SaleService;
import service.impl.SaleServiceImpl;
import utils.JdbcUtils;

import java.util.Date;
import java.util.List;

public class SaleServiceTest {
    SaleService saleService = new SaleServiceImpl();

    @Test
    public void findAllProductSales(){
        List<ProductSales> list = saleService.findAllProductSales(5);
        list.forEach(System.out::println);
        System.out.println("==========================================================");
        Date date = new Date();
        System.out.println("当前时间："+date);

        //上一周的时间
        long time = date.getTime() - 7 * 24 * 60 * 60 * 1000;
        System.out.println("上一周时间："+new Date(time));
    }

    @Test
    public void addProductSalesById(){
        int i = saleService.addProductSalesById
                ("4dcb9742-3e07-4e84-97bd-96ac5e7f1f1d", 1);
        JdbcUtils.commitAndClose();
        System.out.println(i);
    }
}
