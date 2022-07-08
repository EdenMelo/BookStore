package test;

import org.junit.Test;
import pojo.Sales;
import service.DownloadService;
import service.impl.DownloadServiceImpl;

import java.util.List;

public class DownloadServiceTest {
    DownloadService downloadService = new DownloadServiceImpl();
    @Test
    public void downloadServiceTest() {
        List<Sales> sales = downloadService.downloadSales("2022", "1");
        for (Sales sale : sales) {
            System.out.println(sale);
        }
    }
}
