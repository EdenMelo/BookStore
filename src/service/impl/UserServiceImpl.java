package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.Order;
import pojo.User;
import pojo.UserAddress;
import pojo.UserIcon;
import service.UserService;
import utils.JdbcUtils;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
        JdbcUtils.commitAndClose();
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryUserByUsername(username) == null) {
           // 等于null,说明没查到，没查到表示可用
           return false;
        }
        return true;
    }

    @Override
    public int modifyAddressById(Integer id, String address) {
        int i = userDao.updateAddressById(id, address);
        if (i != 1) {
            JdbcUtils.rollbackAndClose();
        }
        JdbcUtils.commitAndClose();
        return i;
    }

    @Override
    public int modifyUserById(User user) {
        int i = userDao.updateUserById(user);
        if (i != 1) {
            JdbcUtils.rollbackAndClose();
        }
        JdbcUtils.commitAndClose();
        return i;
    }

    @Override
    public UserAddress queryAddressById(Integer id) {
        UserAddress userAddress = userDao.queryAddressById(id);
        JdbcUtils.commitAndClose();
        return userAddress;
    }

    @Override
    public List<Order> findOrderByUserId(String userId) {
        List<Order> list = userDao.findOrderByUserId(userId);
        JdbcUtils.commitAndClose();
        return list;
    }

    @Override
    public int modifyUserIconById(UserIcon userIcon) {
        int i = userDao.updateUserIconById(userIcon);
        JdbcUtils.commitAndClose();
        return i;
    }

    @Override
    public UserIcon findUserIconById(String userId) {
        UserIcon userIcon = userDao.queryUserIconById(userId);
        JdbcUtils.commitAndClose();
        return userIcon;
    }
}
