package test;

import dao.CollectionDao;
import dao.ProductDao;
import dao.impl.CollectionDaoImpl;
import dao.impl.ProductDaoImpl;
import org.junit.Test;
import pojo.Collections;
import pojo.Product;
import utils.JdbcUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionDaoTest {

    CollectionDao collectionDao = new CollectionDaoImpl();

    @Test
    public void queryAllUserCollections(){
        List<Collections> list = collectionDao.queryAllUserCollections("4");
        list.forEach(System.out::println);
    }

    @Test
    public void queryForPageTotalCount(){
        Integer count = collectionDao.queryForPageTotalCountById("3");
        System.out.println(count);
    }

    @Test
    public void queryForPageItems(){
        List<Collections> list = collectionDao.queryForPageItems(4, 4,"3");
        ProductDao productDao = new ProductDaoImpl();
        List<Product> items = new ArrayList<>();
        for(Collections collection : list){
            Product product = productDao.queryProductById(collection.getProductId());
            items.add(product);
        }

        System.out.println("------------------");
        items.forEach(System.out::println);
    }

    @Test
    public void deleteCollectionById(){
        int i = collectionDao.deleteCollectionById("3", "60ed6ec4-29d0-4ff2-b2e7-83d32832dc6a");
        System.out.println(i);
        JdbcUtils.commitAndClose();
    }

    @Test
    public void addCollection(){
        Collections collection = new Collections("7379565b-b585-4d24-82a7-a84021b58a24","3");
        int i = collectionDao.addCollection(collection);
        System.out.println(i);
        JdbcUtils.commitAndClose();
    }

    @Test
    public void isCollection(){
        Collections collection = new Collections("33eb296c-44a7-465d-a2de-164a3ee2f0a4","3");
        Collections collections = collectionDao.isCollection(collection);
        System.out.println(collections);
    }


}
