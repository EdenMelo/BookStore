package dao;


import pojo.Order;
import pojo.User;
import pojo.UserAddress;
import pojo.UserIcon;

import java.util.List;

public interface UserDao {

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 如果返回null,说明没有这个用户。反之亦然
     */
    User queryUserByUsername(String username);

    /**
     * 根据 用户名和密码查询用户信息
     * @param username
     * @param password
     * @return 如果返回null,说明用户名或密码错误,反之亦然
     */
    User queryUserByUsernameAndPassword(String username, String password);

    /**
     * 保存用户信息，用于注册
     * @param user
     * @return 返回-1表示操作失败，其他是sql语句影响的行数
     */
    int saveUser(User user);

    /**
     * 根据用户id查询用户信息
     * @param id
     * @return
     */
    User queryUserById(Integer id);

    /**
     * 根据用户id修改地址信息
     * @param id 用户id
     * @param address 用户地址
     * @return
     */
    int updateAddressById(Integer id, String address);

    /**
     * 根据用户id修改用户信息
     * @param user
     * @return
     */
    int updateUserById(User user);

    /**
     * 根据用户id查询用户地址
     * @param id
     * @return
     */
    UserAddress queryAddressById(Integer id);


    /**
     * 根据用户id查询对应的多条订单信息
     */
    List<Order> findOrderByUserId(String userId);

    /**
     * 修改用户头像
     */
    int updateUserIconById(UserIcon userIcon);

    /**
     * 根据用户id查询用户头像
     */
    UserIcon queryUserIconById(String userId);

}
