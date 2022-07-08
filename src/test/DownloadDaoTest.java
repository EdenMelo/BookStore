package test;

import dao.DownloadDao;
import dao.impl.DownloadDaoImpl;
import org.junit.Test;
import pojo.Sales;

import java.util.List;

public class DownloadDaoTest {
    DownloadDao downloadDao = new DownloadDaoImpl();
    @Test
    public void downloadSalesTest() {
        List<Sales> sales = downloadDao.downloadSales("2022", "1");
        sales.stream().forEach(System.out::println);
    }
}
