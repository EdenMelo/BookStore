package dao.impl;

import dao.SaleDao;
import pojo.ProductSales;
import pojo.Sales;

import java.util.List;

public class SaleDaoImpl extends BaseDao implements SaleDao {
    @Override
    public List<ProductSales> queryAllProductSales(Integer queryNum) {
        //本周销量排行榜，latestSaleDate
        // String sql = "select * from sale order by productSale desc limit ?";
        String sql = "SELECT * " +
                    "FROM sale " +
                    "WHERE DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= DATE(latestSaleDate)" +
                    "order by productSale desc " +
                    "limit ? ";
        return queryForList(ProductSales.class,sql,queryNum);
    }

    @Override
    public int updateProductSalesById(String productId, int productSale) {
        String sql = "update sale set productSale=productSale+? where productId=?";
        return update(sql, productSale, productId);
    }
}
