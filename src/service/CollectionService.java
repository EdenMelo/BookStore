package service;

import pojo.Collections;
import pojo.Page;
import pojo.Product;

import java.util.List;

public interface CollectionService {

    /**分页显示当前用户的收藏数据*/
    Page<Product> page(int pageNo, int pageSize,String userId);

    /**根据用户id查询所有收藏的商品信息*/
    List<Collections> findAllUserCollections(String userId);

    /**取消收藏*/
    int deleteCollectionById(String userId, String productId);

    /**添加收藏*/
    int addCollection(Collections collection);

    /**判断是否重复收藏同一个商品*/
    boolean isCollection(Collections collection);

}
