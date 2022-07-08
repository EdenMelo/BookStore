package service.impl;

import dao.CollectionDao;
import dao.ProductDao;
import dao.impl.CollectionDaoImpl;
import dao.impl.ProductDaoImpl;
import pojo.Collections;
import pojo.Page;
import pojo.Product;
import service.CollectionService;
import utils.JdbcUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionServiceImpl implements CollectionService {

    CollectionDao collectionDao = new CollectionDaoImpl();

    @Override
    public List<Collections> findAllUserCollections(String userId) {
        List<Collections> list = collectionDao.queryAllUserCollections(userId);
        JdbcUtils.commitAndClose();
        return list;
    }

    @Override
    public Page<Product> page(int pageNo, int pageSize,String userId) {
        Page<Product> page = new Page<>();

        //设置每页显示的数量
        page.setPageSize(pageSize);

        // 求总记录数,需要调用ProductDao层，即需要SQL语句来查询
        // 即select count(*) from collection;
        Integer pageTotalCount = collectionDao.queryForPageTotalCountById(userId);

        System.out.println("CollectionService--pageTotalCount = " + pageTotalCount);

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

        System.out.println("Service---pageNo=" + pageNo);

        // 设置当前页码
        page.setPageNo(pageNo);

        // 求当前页数据的开始索引,用于设定每一页显示哪4个，同样需要SQL语句
        //同样的begin开始下标的位置公式为：当前页数-1 * 4
        //即第一位就从下标为0的第1个开始，第二页就从下标为4的第5个开始
        int begin = (page.getPageNo() - 1) * pageSize;

        // 即SQL的 select * from products limit begin,pageSize
        //即下标为begin的元素开始，显示pageSize个数据
        List<Collections> list = collectionDao.queryForPageItems(begin,pageSize,userId);


        //取出每个收藏对应的商品id，查询商品信息
        ProductDao productDao = new ProductDaoImpl();
        List<Product> items = new ArrayList<>();
        for(Collections collection : list){
            Product product = productDao.queryProductById(collection.getProductId());
            items.add(product);
        }


        // 设置当前页数据,因为一页显示不止一个数据，所以定义成List集合
        //items就为当前页面所需要显示的商品
        page.setItems(items);

        JdbcUtils.commitAndClose();

        return page;
    }

    @Override
    public int deleteCollectionById(String userId, String productId) {
        int i = collectionDao.deleteCollectionById(userId, productId);
        JdbcUtils.commitAndClose();
        return i;
    }

    @Override
    public int addCollection(Collections collection) {
        int i = collectionDao.addCollection(collection);
        JdbcUtils.commitAndClose();
        return i;
    }

    @Override
    public boolean isCollection(Collections collection) {
        Collections collection1 = collectionDao.isCollection(collection);
        if(collection1 != null){
            return true;
        }
        return false;
    }
}

