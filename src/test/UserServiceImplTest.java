package test;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import org.junit.Test;
import pojo.User;
import pojo.UserAddress;
import pojo.UserIcon;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.JdbcUtils;

public class UserServiceImplTest {
    UserService usersevice = new UserServiceImpl();

    @Test
    public void registUser() {
        usersevice.registUser(new User(null,"UserServiceTest","123456","male","13","1","1"));
        //同样需要手动提交事务
        JdbcUtils.commitAndClose();
    }

    @Test
    public void login() {
        User login = usersevice.login(new User(null, "UserServiceTest", "123456", "male", "13", "1", "1"));
        if(login!=null){
            System.out.println("登录成功！");
        }else{
            System.out.println("用户不存在！");
        }
    }

    @Test
    public void existsUsername() {
        boolean userServiceTest = usersevice.existsUsername("UserServiceTest");
        if(userServiceTest){
            System.out.println("用户名存在！");
        }else{
            System.out.println("用户名可用！");
        }
    }

    @Test
    public void modifyAddressById() {
        System.out.println(usersevice.modifyAddressById(3, "动漫星城"));
    }

    @Test
    public void modifyUserById() {
        User user = new User(4,"Rider1","123456","female","asdad@q.com","ssss.gridMan",null);
        usersevice.modifyUserById(user);
    }

    @Test
    public void queryAddressById(){
        UserAddress userAddress = usersevice.queryAddressById(4);
        System.out.println(userAddress);
    }

    @Test
    public void updateUserIconById(){
        UserIcon userIcon = new UserIcon("3","/images/user/user_icon_4.jpg");
        int i = usersevice.modifyUserIconById(userIcon);
        System.out.println(i);
        JdbcUtils.commitAndClose();
    }

    @Test
    public void findUserIconById(){
        UserIcon userIcon = usersevice.findUserIconById("3");
        System.out.println(userIcon);
    }


}
