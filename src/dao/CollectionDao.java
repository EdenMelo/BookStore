package dao;


import pojo.Collections;
import pojo.Product;

import java.util.List;

public interface CollectionDao {

    /**根据用户id查询所有收藏的商品信息*/
    List<Collections> queryAllUserCollections(String userId);

    /**根据用户id查询总记录数*/
    Integer queryForPageTotalCountById(String userId);

    /**分页查询*/
    List<Collections> queryForPageItems(int begin, int pageSize,String userId);

    /**取消收藏*/
    int deleteCollectionById(String userId, String productId);

    /**添加收藏*/
    int addCollection(Collections collection);

    /**查询是否存在当前收藏*/
    Collections isCollection(Collections collection);
}
