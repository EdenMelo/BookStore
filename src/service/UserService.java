package service;


import pojo.Order;
import pojo.User;
import pojo.UserAddress;
import pojo.UserIcon;

import java.util.List;

public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    void registUser(User user);

    /**
     * 登录
     * @param user
     * @return 如果返回null，说明登录失败，返回有值，是登录成功
     */
    User login(User user);

    /**
     * 检查 用户名是否可用
     * @param username
     * @return 返回true表示用户名已存在，返回false表示用户名可用
     */
    boolean existsUsername(String username);

    /**
     * 根据用户id更新地址信息
     * @param id 用户id
     * @param address 用户地址
     * @return
     */
    int modifyAddressById(Integer id, String address);

    /**
     * 根据用户id更新用户信息
     * @param user
     * @return
     */
    int modifyUserById(User user);

    /**
     * 根据用户id查询用户地址
     * @param id
     * @return
     */
    UserAddress queryAddressById(Integer id);

    /**
     * 根据用户id查询对应的多条订单信息
     * @param userId
     * @return
     */
    List<Order> findOrderByUserId(String userId);

    /**
     * 根据用户id修改对应的头像
     * @param userIcon
     * @return
     */
    int modifyUserIconById(UserIcon userIcon);

    /**
     * 根据用户id查询用户头像
     */
    UserIcon findUserIconById(String userId);
}
