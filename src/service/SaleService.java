package service;

import pojo.ProductSales;

import java.util.List;

public interface SaleService {
    /**查询所有商品的销量（按照销量限制查询个数）*/
    List<ProductSales> findAllProductSales(Integer queryNum);

    /**修改商品的销量(已支付的才增加)*/
    int addProductSalesById(String productId, int productSale);
}
