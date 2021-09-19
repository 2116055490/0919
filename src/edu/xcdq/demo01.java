package edu.xcdq;

import com.mysql.jdbc.Driver;

import java.sql.*;

public class demo01 {
    public static void main(String[] args) throws SQLException {
        // 1 注册驱动
        DriverManager.registerDriver(new Driver());
        // 2 获取链接
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test01", "root", "905274");
        // 3 创建传输状态
        Statement statement = connection.createStatement();
        // 4 准备sql并执行
        ResultSet resultSet = statement.executeQuery("select * from book");
        // 5 得到结果
        while(resultSet.next()){
            System.out.println(resultSet.getInt(1)+resultSet.getString(2)+
                    resultSet.getString(3)+resultSet.getDouble(4));
        }
        // 6 关闭资源
        resultSet.close();
        statement.close();
        connection.close();

    }
}
