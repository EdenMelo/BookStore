package dao.impl;

import dao.DownloadDao;
import pojo.Sales;

import java.util.List;

public class DownloadDaoImpl extends BaseDao implements DownloadDao {
    @Override
    public List<Sales> downloadSales(String year, String month) {
        String sql = "SELECT products.name,SUM(orderitem.buynum) buynum "
                + "FROM orders,products,orderItem "
                + "WHERE orders.id=orderItem.order_id "
                + "AND products.id=orderItem.product_id AND orders.paystate=1 "
                + "AND year(ordertime)= "+year+" and month(ordertime)="+month+" "
                + "GROUP BY products.name ORDER BY buynum DESC";
        return queryForList(Sales.class,sql);
    }
}
