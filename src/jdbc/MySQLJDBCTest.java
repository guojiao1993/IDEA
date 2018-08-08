package jdbc;

import java.sql.*;

public class MySQLJDBCTest {
    public static void main(String[] args) {
        insert();
        select();
        delete();
        select();
        update();
        select();
    }

    public static void insert() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // 通过 ?useUnicode=true&characterEncoding=utf8 设置字符编码，以将中文正确地插入到MySQL中
            String url = "jdbc:mysql://139.199.129.174:3306/hrm_db?useUnicode=true&characterEncoding=utf8";
            String user = "root";
            String pass = "root";
            connection = DriverManager.getConnection(url, user, pass);
            preparedStatement = connection.prepareStatement("insert into user_inf(loginname, PASSWORD, STATUS, createdate, username)" +
                    " values('Alan', 'Alan', 3, ?, ?)");
            preparedStatement.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
            preparedStatement.setString(2, "艾伦");
            int result = preparedStatement.executeUpdate();
            System.out.println("插入" + result + "条数据");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL数据库驱动加载失败！");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("MySQL数据库开启连接失败！");
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("MySQL数据库关闭连接失败！");
                e.printStackTrace();
            }
        }
    }

    public static void delete() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://139.199.129.174:3306/hrm_db?useUnicode=true&characterEncoding=utf8";
            String user = "root";
            String pass = "root";
            connection = DriverManager.getConnection(url, user, pass);
            preparedStatement = connection.prepareStatement("delete from user_inf where username = ?");
            preparedStatement.setString(1, "艾伦");
            int result = preparedStatement.executeUpdate();
            System.out.println("删除" + result + "条数据");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL数据库驱动加载失败！");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("MySQL数据库开启连接失败！");
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("MySQL数据库关闭连接失败！");
                e.printStackTrace();
            }
        }
    }

    public static void update() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://139.199.129.174:3306/hrm_db?useUnicode=true&characterEncoding=utf8";
            String user = "root";
            String pass = "root";
            connection = DriverManager.getConnection(url, user, pass);
            preparedStatement = connection.prepareStatement("update user_inf set createdate = ? where id = 2");
            preparedStatement.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
            int result = preparedStatement.executeUpdate();
            System.out.println("更新" + result + "条数据");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL数据库驱动加载失败！");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("MySQL数据库开启连接失败！");
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("MySQL数据库关闭连接失败！");
                e.printStackTrace();
            }
        }
    }

    public static void select() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://139.199.129.174:3306/hrm_db?useUnicode=true&characterEncoding=utf8";
            String user = "root";
            String pass = "root";
            connection = DriverManager.getConnection(url, user, pass);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from user_inf");
            while (resultSet.next()) {
                System.out.print(resultSet.getString("id") + "\t");
                System.out.print(resultSet.getString("loginname") + "\t");
                System.out.print(resultSet.getString("password") + "\t");
                System.out.print(resultSet.getString("status") + "\t");
                System.out.print(resultSet.getString("createdate") + "\t");
                System.out.print(resultSet.getString("username") + "\t");
                System.out.println();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL数据库驱动加载失败！");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("MySQL数据库开启连接失败！");
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("MySQL数据库关闭连接失败！");
                e.printStackTrace();
            }
        }
    }

}
