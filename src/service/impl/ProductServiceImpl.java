package service.impl;

import dao.OrderDao;
import dao.ProductDao;

import dao.impl.OrderDaoImpl;
import dao.impl.ProductDaoImpl;
import pojo.OrderItem;
import pojo.Page;
import pojo.Product;
import service.ProductService;
import utils.JdbcUtils;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao = new ProductDaoImpl();
    private OrderDao orderDao = new OrderDaoImpl();


    @Override
    public List<Product> queryAllProduct() {

        List<Product> products = productDao.queryAllProduct();
        //提交事务
        JdbcUtils.commitAndClose();
        return products;
    }

    @Override
    public List<Product> queryByCondition(String id, String name, String category, double minPrice, double maxPrice) {
        //应该在Service层进行条件查询，处理业务逻辑

        //定义args集合放入符合条件的属性
        List<Object> args = new ArrayList<>();

        //三个sql属性作为占位符，在sql语句中要么是id = id这种，要么是传入值的占位符id = ?这种
        String sqlId = ("id".equals(id) ? "id" : "?");
        String sqlName = ("name".equals(name) ? "name" : "?");
        String sqlCategory = ("category".equals(category) ? "category" : "?");

        //将不为默认值的属性放入args集合中作为条件查询
        //即id = 114514这种，这种才是具体需要查询的值，否则就是默认值id = id这种原样查询
        if (!"id".equals(id)) {
            args.add(id);
        }
        if (!"name".equals(name)) {
            args.add(name);
        }
        if (!"category".equals(category)) {
            args.add(category);
        }
        args.add(minPrice);
        args.add(maxPrice);

        //传入三个占位符和查询条件args集合
        //提交事务
        JdbcUtils.commitAndClose();
        return productDao.queryByCondition(sqlId, sqlName, sqlCategory, minPrice, maxPrice, args);
    }


    
    @Override
    public int addProduct(Product product) {
        int add = productDao.addProduct(product);
        if(add==1){
            //提交事务
            JdbcUtils.commitAndClose();
            return add;
        }else{
            //回滚事务
            JdbcUtils.rollbackAndClose();
            return 0;
        }

    }

    @Override
    //根据商品ID修改商品信息
    public int updateProductById(String id, String name, double price, int pnum, String category, String description, String imgurl){
        int update = productDao.updateProductById(id, name, price, pnum, category, description, imgurl);
        if(update==1){
            //提交事务
            JdbcUtils.commitAndClose();
            return update;
        }else{
            //回滚事务
            JdbcUtils.rollbackAndClose();
            return 0;
        }
    }


    @Override
    public int deleteProductById(String id) {
        int delete = productDao.deleteProduct(id);
        if(delete==1){
            //提交事务
            JdbcUtils.commitAndClose();
            return delete;
        }else{
            //回滚事务
            JdbcUtils.rollbackAndClose();
            return 0;
        }
    }

    @Override
    public List<Product> findByCategory(String category) {
        List<Product> list = productDao.queryByCategory(category);
        JdbcUtils.commitAndClose();
        return list;
    }

    @Override
    public Page<Product> page(int pageNo, int pageSize) {
        Page<Product> page = new Page<>();

        //设置每页显示的数量
        page.setPageSize(pageSize);

        // 求总记录数,需要调用ProductDao层，即需要SQL语句来查询
        // 即select count(*) from products;
        Integer pageTotalCount = productDao.queryForPageTotalCount();

        //当前分页对象page设置总记录数
        page.setPageTotalCount(pageTotalCount);

        //求总页码,总页码=总记录数/每页显示数量
        int pageTotal = pageTotalCount / pageSize;
        //向上取整，多出来的记录单独成为一页
        if(pageTotalCount % pageSize > 0){
            ++pageTotal;
        }

        // 设置总页码
        page.setPageTotal(pageTotal);

        // 设置当前页码
        page.setPageNo(pageNo);

        // 求当前页数据的开始索引,用于设定每一页显示哪4个，同样需要SQL语句
        //同样的begin开始下标的位置公式为：当前页数-1 * 4
        //即第一位就从下标为0的第1个开始，第二页就从下标为4的第5个开始
        int begin = (page.getPageNo() - 1) * pageSize;

        // 即SQL的 select * from products limit begin,pageSize
        //即下标为begin的元素开始，显示pageSize个数据
        List<Product> items = productDao.queryForPageItems(begin,pageSize);

        // 设置当前页数据,因为一页显示不止一个数据，所以定义成List集合
        //items就为当前页面所需要显示的商品
        page.setItems(items);

        return page;
    }

    @Override
    public Product queryProductById(String id) {
        Product product = productDao.queryProductById(id);
        JdbcUtils.commitAndClose();
        return product;
    }

    @Override
    public int batchAddProductNum(String orderId) {
        //1 通过orderId查询订单下面的所有商品
        List<OrderItem> items = orderDao.findOrderItemByOrderId(orderId);

        //2 遍历items，拿到每个商品的id和购买数量
        int i = 0;
        for (OrderItem item : items) {
            //3 通过商品id和购买数量修改对应的库存数量
            i = productDao.updateProductNum(item.getProductId(), item.getBuynum());
        }
        JdbcUtils.commitAndClose();
        return i;
    }
}
