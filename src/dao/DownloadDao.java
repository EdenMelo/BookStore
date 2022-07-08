package dao;

import pojo.Sales;

import java.util.List;

public interface DownloadDao {
    /**
     * 根据年份和月份查询销售数量
     * @param year
     * @param month
     */
    public List<Sales> downloadSales(String year, String month);
}
