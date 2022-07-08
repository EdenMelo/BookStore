package servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import pojo.Order;
import pojo.User;
import pojo.UserAddress;
import pojo.UserIcon;
import service.OrderService;
import service.ProductService;
import service.UserService;
import service.impl.OrderServiceImpl;
import service.impl.ProductServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UserServlet extends BaseServlet{
    private UserService userService = new UserServiceImpl();
    private OrderService orderService = new OrderServiceImpl();
    private ProductService productService = new ProductServiceImpl();

    /**
     * 前台：登录方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 调用 userService.login()登录处理业务，判断用户名和密码是否正确
        User loginUser = userService.login(new User(null, username, password, null,null,null,null));
        System.out.println(loginUser);



        // 如果等于null,说明登录失败!
        if (loginUser == null) {
            // 把错误信息，和回显的表单项信息，保存到Request域中用于页面输出
            req.setAttribute("msg","账号密码错误！");
            req.setAttribute("username", username);
            // 跳回登录页面
            req.getRequestDispatcher("WebContent/client/loginfail.jsp").forward(req, resp);
        } else {
            //登录成功，保存登录的用户信息到session域
            req.getSession().setAttribute("username", username);
            req.getSession().setAttribute("loginUser",loginUser);


            /**登陆成功后为查看“我的账户”保存数据用于点击查询*/
            //查询当前用户的地址
            UserAddress userAddress = userService.queryAddressById(loginUser.getId());

            //查询当前用户的订单信息
            List<Order> orderList = userService.findOrderByUserId(loginUser.getId().toString());

            //登录成功，保存登录的用户信息和地址到application域
            req.getServletContext().setAttribute("username", username);
            req.getServletContext().setAttribute("loginUser", loginUser);
            req.getServletContext().setAttribute("userAddress", userAddress.getAddress());
            req.getServletContext().setAttribute("orderListByUserId", orderList);

            //保存当前用户的头像信息到application域
            UserIcon icon = userService.findUserIconById(loginUser.getId().toString());
            req.getServletContext().setAttribute("userIcon",icon);

            //重定向
            resp.sendRedirect("WebContent/client/loginsuccess.jsp");
        }
    }

    /**
     * 前台：用户退出/注销方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、销毁Session中用户登录的信息（或者销毁 Session）
        //因为登录的用户名是保存在session域中的
        req.getSession().invalidate();

        //2、销毁application域中的用户登录的信息（用户名、用户信息、用户地址）
        req.getServletContext().setAttribute("username", null);
        req.getServletContext().setAttribute("loginUser", null);
        req.getServletContext().setAttribute("userAddress", null);

        //3、销毁当前用户的订单信息
        req.getServletContext().setAttribute("orderListByUserId", null);

        //4、销毁当前用户的头像信息
        req.getServletContext().setAttribute("userIcon",null);

        //5、重定向到首页,这里重定向到工程路径，即首页
        resp.sendRedirect(req.getContextPath());
    }


    /**
     * 前台：点击“我的账户”
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void personalInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入personalInfo方法-----------------");
        //重新查询个人信息和订单信息保存到全局域中

        //查询当前用户的个人信息
        User loginUser = (User) req.getServletContext().getAttribute("loginUser");

        //查询用户当前订单信息
        List<Order> orderList = userService.findOrderByUserId(loginUser.getId().toString());

        //重新保存到全局域中
        req.getServletContext().setAttribute("loginUser", loginUser);
        req.getServletContext().setAttribute("orderListByUserId", orderList);

        //转到“我的账户”
        req.getRequestDispatcher("WebContent/client/myAccount.jsp").forward(req, resp);

    }

    /**
     * 前台：“我的账户”里面的修改用户的个人信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void modifyPersonalInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进来了修改个人信息modifyPersonalInfo");
        String userId = req.getParameter("userId");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");


        User user = new User(Integer.parseInt(userId), username, password, gender,email,phone,null);

        //修改用户user，并同时修改地址userAddress
        userService.modifyUserById(user);
        userService.modifyAddressById(Integer.parseInt(userId), address);

        //将更新之后的用户信息重新保存到application域中
        req.getServletContext().setAttribute("username", username);
        req.getServletContext().setAttribute("loginUser", user);
        req.getServletContext().setAttribute("userAddress", address);


        //重定向到首页,这里重定向到工程路径，即首页
        resp.sendRedirect(req.getContextPath());
    }


    /**
     * 前台：“我的账户”里点击上传头像（可以看作是修改头像）
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void uploadUserIcon(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入uploadUserIcon方法（上传头像）-----------------");

        //1、设置字符集为uft-8防止编码出错
        req.setCharacterEncoding("utf-8");

        //2、调用静态方法isMultipartContent判断上传的数据是否多段数据（只有是多段的数据， 才是文件上传的）
        // if(ServletFileUpload.isMultipartContent(req)){
        if(true){
            System.out.println("是多段数据，是文件上传的");
            //3、创建FileItemFactory对象，用于传入ServletFileUpload类进行文件解析
            FileItemFactory fileItemFactory = new DiskFileItemFactory();

            //4、创建ServletFileUpload对象，传入FileItemFactory对象进行文件的解析
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);

            try {
                //5、调用ServletFileUpload对象的parseRequest方法，传入请求对象req来对文件进行解析
                //返回的是一个List<FileItem>集合，每一个FileItem就是获取的一个数据
                List<FileItem> list = servletFileUpload.parseRequest(req);

                //6、对集合进行遍历，取出每一个上传的文件或者表单项
                for(FileItem fileItem:list){

                    //7、调用isFormField判断是否为表单项，为true即表单项，false即为上传的文件
                    if(fileItem.isFormField()){
                        //表单项的属性值用getString获取，传入UTF-8字符编码防止中文乱码
                        System.out.println("获取表单项属性值："+fileItem.getString("UTF-8"));
                    }
                    else{
                        //else即为false,上传的为文件
                        //文件名使用getName来获取
                        //文件的name属性值使用getFieldName获取，与表单项不同
                        System.out.println("获取文件属性名："+fileItem.getName());
                        System.out.println("文件的name 属性值："+fileItem.getFieldName());

                        //8、创建File对象，指定上传的文件要保存在硬盘的哪里，并用fileItem.getName()给定文件名
                        File file = new File("D:\\JavaWeb\\BookStore\\web\\WebContent\\client\\userIconImg\\"
                                +fileItem.getName());

                        //9、调用FileItem的write方法将文件写入到指定目录
                        fileItem.write(file);

                        /**10、修改用户头像*/
                        //获取application域中的user对象
                        User user = (User) req.getServletContext().getAttribute("loginUser");
                        //获取用户的id
                        int userId = user.getId();
                        //设置并获取当前用户修改之后的头像路径
                        String userIconUrl =  ("WebContent/client/userIconImg/"+fileItem.getName());
                        System.out.println("用户头像路径："+userIconUrl);
                        //封装成UserIcon对象
                        UserIcon userIcon = new UserIcon(String.valueOf(userId),userIconUrl);
                        //调用service层的方法修改用户头像
                        userService.modifyUserIconById(userIcon);
                        //UserIcon对象保存到全局域中
                        req.getServletContext().setAttribute("userIcon",userIcon);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        req.getRequestDispatcher("/").forward(req, resp);
    }


    /**
     * 前台：用户取消未支付订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void cancelOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入cancelOrder方法-----------------");

        String orderId = req.getParameter("orderId");
        User loginUser = (User)req.getServletContext().getAttribute("loginUser");
        String userId = loginUser.getId().toString();

        System.out.println("orderId:" + orderId);
        System.out.println("userId:" + userId);

        //既要删除order订单，又要删除orderItem订单项
        orderService.deleteOrderById(orderId,userId);
        orderService.deleteOrderItemByOrderId(orderId);

        //同时还需要重新将书本库存量加回去
        productService.batchAddProductNum(orderId);

        //删除完成后重新查询一次个人账户信息
        personalInfo(req, resp);
    }






}
