package service.impl;

import dao.DownloadDao;
import dao.impl.DownloadDaoImpl;
import pojo.Sales;
import service.DownloadService;
import utils.JdbcUtils;

import java.util.List;

public class DownloadServiceImpl implements DownloadService {
    DownloadDao downloadDao = new DownloadDaoImpl();
    @Override
    public List<Sales> downloadSales(String year, String month) {
        List<Sales> sales = downloadDao.downloadSales(year, month);
        JdbcUtils.commitAndClose();
        return sales;
    }
}
