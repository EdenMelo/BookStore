package dao.impl;

import dao.CollectionDao;
import pojo.Collections;
import pojo.Product;

import java.util.List;

public class CollectionDaoImpl extends BaseDao implements CollectionDao {
    @Override
    public List<Collections> queryAllUserCollections(String userId) {
        String sql = "select * from collection where userId=?";
        return queryForList(Collections.class, sql, userId);
    }


    @Override
    public Integer queryForPageTotalCountById(String userId) {
        String sql = "select count(*) from collection where userId=?";
        Number count = (Number) queryForSingleValue(sql,userId);
        //返回的是Number类型，但需要使用intValue方法转成Integer/int类型
        return count.intValue();
    }

    // @Override
    // public List<Collections> queryForPageItems(int begin, int pageSize) {
    //     String sql = "select * from collection limit ?,?";
    //     return queryForList(Collections.class, sql, begin, pageSize);
    // }

    @Override
    public List<Collections> queryForPageItems(int begin, int pageSize, String userId) {
        //需要用userId来限制，需要多表联查
        String sql = "select user_collections.* " +
                "from (SELECT * from collection WHERE userId = ?) user_collections " +
                "limit ?,?";
        return queryForList(Collections.class, sql, userId, begin, pageSize);
    }

    @Override
    public int deleteCollectionById(String userId, String productId) {
        String sql = "delete from collection where userId=? and productId=?";
        return update(sql, userId, productId);
    }

    @Override
    public int addCollection(Collections collection) {
        String sql = "insert into collection values(?,?)";
        return update(sql, collection.getProductId(),collection.getUserId());
    }

    @Override
    public Collections isCollection(Collections collection) {
        String sql = "select * from collection where userId=? and productId=?";
        return queryForOne(Collections.class, sql, collection.getUserId(), collection.getProductId());
    }
}

