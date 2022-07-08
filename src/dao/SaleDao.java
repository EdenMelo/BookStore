package dao;

import pojo.ProductSales;
import pojo.Sales;
import java.util.*;

public interface SaleDao {
    /**查询所有商品的销量（按照销量限制查询个数）*/
    List<ProductSales> queryAllProductSales(Integer queryNum);

    /**修改商品的销量(已支付的才增加)*/
    int updateProductSalesById(String productId, int productSale);

}
