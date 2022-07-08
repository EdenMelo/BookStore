package test;

import org.junit.Test;
import pojo.Collections;
import pojo.Page;
import pojo.Product;
import service.CollectionService;
import service.impl.CollectionServiceImpl;

import java.util.List;

public class CollectionServiceTest {

    CollectionService collectionService = new CollectionServiceImpl();

    @Test
    public void findAllUserCollections(){
        List<Collections> allUserCollections = collectionService.findAllUserCollections("3");
        allUserCollections.forEach(System.out::println);
    }

    @Test
    public void page(){
        Page<Product> page = collectionService.page(1, 4,"3");
        List<Product> items = page.getItems();
        items.forEach(System.out::println);
        System.out.println("------------------");
        System.out.println("总页数：" + page.getPageTotal());
        System.out.println("总记录数：" + page.getPageTotalCount());
        System.out.println("当前页：" + page.getPageNo());
        System.out.println("当前页显示数量：" + page.getPageSize());
    }

    @Test
    public void deleteCollectionById(){
        int deleteCollectionById = collectionService.deleteCollectionById("3", "7379565b-b585-4d24-82a7-a84021b58a24");
        System.out.println(deleteCollectionById);
    }

    @Test
    public void addCollection(){
        Collections collection = new Collections("7379565b-b585-4d24-82a7-a84021b58a24","3");
        int i = collectionService.addCollection(collection);
        System.out.println(i);
    }

    @Test
    public void isCollection(){
        Collections collection = new Collections("709f46ea-ca60-498a-aec4-cdb42965a466","3");
        boolean isCollection = collectionService.isCollection(collection);
        System.out.println(isCollection);
    }

}
