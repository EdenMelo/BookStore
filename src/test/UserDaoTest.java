package test;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import org.junit.Test;
import pojo.User;
import pojo.UserAddress;
import pojo.UserIcon;
import utils.JdbcUtils;

import javax.swing.*;

public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername(){
        if ( userDao.queryUserByUsernameAndPassword("Test1","123456") == null) {
            System.out.println("用户名或密码错误，登录失败");
        } else {
            System.out.println("查询成功");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword(){
        User user = userDao.queryUserByUsernameAndPassword("Test1", "123456");
        System.out.println(user);
    }

    @Test
    public void saveUser(){
        //userDao.saveUser(new User(null, "Test2", "123456", "girl", "111@em.com", "137", "None"));
        User user = new User(null, "Test2", "123456", "girl", "111@em.com", "137", "None");
        int i = userDao.saveUser(user);
        System.out.println(i);
        //完成后要手动提交事务
        JdbcUtils.commitAndClose();
    }

    @Test
    public void testQueryUserById(){
        User user = userDao.queryUserById(3);
        System.out.println(user);
    }

    @Test
    public void testUpdateAddressById(){
        int i = userDao.updateAddressById(3, "北京");
        System.out.println(i);
        JdbcUtils.commitAndClose();
    }

    @Test
    public void testUpdateUserById(){
        User user = new User(4,"Rider1","123456","female","asdad@q.com","sss",null);
        System.out.println(userDao.updateUserById(user));
        JdbcUtils.commitAndClose();
    }

    @Test
    public void testQueryAddressById(){
        UserAddress userAddress = userDao.queryAddressById(3);
        System.out.println(userAddress);
    }

    @Test
    public void updateUserIconById(){
        UserIcon userIcon = new UserIcon("3","/images/user/user_icon_3.jpg");
        int i = userDao.updateUserIconById(userIcon);
        System.out.println(i);
        JdbcUtils.commitAndClose();
    }

    @Test
    public void queryUserIconById(){
        UserIcon userIcon = userDao.queryUserIconById("3");
        System.out.println(userIcon);
    }

}
