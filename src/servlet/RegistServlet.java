package servlet;

import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("pw");
        String email = req.getParameter("email");
        String gender = req.getParameter("sex");
        String telephone = req.getParameter("telephone");
        String introduce = req.getParameter("introduce");

        //注册失败的时候设置回显信息
        req.setAttribute("username", username);
        req.setAttribute("email", email);


        //调用Service保存到数据库，并手动提交事务,id自增不需要传入
        userService.registUser(new User(null, username,password,gender,email,telephone,introduce));
        JdbcUtils.commitAndClose();

        //跳转到注册成功页面
        req.getRequestDispatcher("/WebContent/client/registersuccess.jsp").forward(req, resp);

    }
}
