package dao.impl;

import dao.UserDao;
import pojo.Order;
import pojo.User;
import pojo.UserAddress;
import pojo.UserIcon;

import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {
    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return
     */
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select `id`,`username`,`password`,`gender`,`email`,`telephone`,`introduce` from user where username = ?";
        return queryForOne(User.class, sql, username);
    }

    /**
     * 根据用户名和密码查询用户信息
     * @param username
     * @param password
     * @return
     */
    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`password`,`gender`,`email`,`telephone`,`introduce` from user where username = ? and password = ?";
        return queryForOne(User.class, sql, username,password);
    }

    /**
     * 保存用户信息放到数据库中
     * @param user
     * @return
     */
    @Override
    public int saveUser(User user) {
        String sql = "insert into user(`username`,`password`,`gender`,`email`,`telephone`,`introduce`) values(?,?,?,?,?,?);";
        return update(sql, user.getUsername(),user.getPassword(),user.getGender(),user.getEmail(),user.getTelephone(),user.getIntroduce());
    }

    /**
     * 根据用户id查询用户信息
     * @param id
     * @return
     */
    @Override
    public User queryUserById(Integer id) {
        String sql = "select * from user where id = ?";
        return queryForOne(User.class,sql,id);
    }

    /**
     * 根据用户id更新地址信息
     * @param id 用户id
     * @param address 用户地址
     * @return
     */
    @Override
    public int updateAddressById(Integer id, String address) {
        String sql = "update useraddress set address = ? where user_id = ?";
        return update(sql, address,id);
    }

    @Override
    public int updateUserById(User user) {
        String sql = "update user set username = ?,password = ?,gender = ?,email = ?,telephone = ? where id = ?";
        return update(sql, user.getUsername(),user.getPassword(),user.getGender(),user.getEmail(),user.getTelephone(),user.getId());
    }

    @Override
    public UserAddress queryAddressById(Integer id) {
        String sql = "select user_id userId,address from useraddress where user_id = ?";
        return queryForOne(UserAddress.class, sql, id);
    }

    @Override
    public List<Order> findOrderByUserId(String userId) {
        String sql = "select * from orders where user_id = ?";
        return queryForList(Order.class,sql,userId);
    }

    @Override
    public int updateUserIconById(UserIcon userIcon) {
        String sql = "update usericon set userIconUrl = ? where userId = ?";
        return update(sql,userIcon.getUserIconUrl(),userIcon.getUserId());
    }

    @Override
    public UserIcon queryUserIconById(String userId) {
        String sql = "select * from usericon where userId = ?";
        return queryForOne(UserIcon.class,sql,userId);
    }

}
