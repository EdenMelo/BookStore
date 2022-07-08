package utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    private static DruidDataSource dataSource;
    //设定ThreadLocal对象进行连接的封装
    private static ThreadLocal<Connection> conns = new InheritableThreadLocal<>();

    static {
        try {
            Properties properties = new Properties();
            // 读取jdbc.properties属性配置文件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            // 从流中加载数据
            properties.load(inputStream);
            // 创建数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取数据库连接池中的连接
     * @return 如果返回null,说明获取连接失败<br/>有值就是获取连接成功
     */
    public static Connection getConnection(){

        //获取ThreadLocal保存的连接对象，调用get方法
        Connection conn = conns.get();

        //如果获取的为空，那么就进行创建
        if(conn==null){
            try {
                //获取数据库连接对象
                conn = dataSource.getConnection();

                //将当前数据库连接对象放到ThreadLocal对象当中，保证线程安全和设定唯一的关联对象
                conns.set(conn);

                //设置手动提交事务
                conn.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }



    /**
     * 提交事务，并关闭连接
     */
    public static void commitAndClose(){
        Connection conn = conns.get();
        //如果不等于null，说明之前使用过连接，直接进行操作即可
        if (conn != null) {
            try {
                //提交事务
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    //关闭连接
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //最后一定要执行remove操作， 否则就会出错。（因为 Tomcat 服务器底层使用了线程池技术）
        conns.remove();
    }

    
    /**
     * 回滚事务，并关闭连接
     */
    public static void rollbackAndClose(){
        Connection conn = conns.get();

        //如果不等于null，说明之前使用过连接，直接进行操作即可
        if (conn != null) {
            try {
                //回滚事务
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    //关闭连接
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //最后一定要执行remove操作， 否则就会出错。（因为 Tomcat 服务器底层使用了线程池技术）
        conns.remove();
    }


    /**
     * 关闭连接，放回数据库连接池
     * @param conn
     */
    public static void close(Connection conn){
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}