package com.why.mybatis;

import domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author 王皓宇
 * @version V1.0
 * @title : Executor
 * @Package : com.why.mybatis
 * @Description:
 * @date 2022/3/17 14:36
 **/
public class Executor {
    /**
     * 具体执行SQL的方法
     *
     * @param <T>
     * @return
     */
    public <T> T query(String sql, Object parameter) {
        Connection conn = null;
        Statement stmt = null;
        User user = new User();
        try {
            // 注册 JDBC 驱动
            // Class.forName("com.mysql.cj.jdbc.Driver");
            // 打开连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatisdb?characterEncoding=utf-8&serverTimezone=UTC", "root", "123456");
            // 执行查询
            stmt = conn.createStatement();
            // todo 改成 ps

            ResultSet rs = stmt.executeQuery(String.format(sql, parameter));

            // todo 自动转换

            // 获取结果集
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String userName = rs.getString("user_name");
                String realName = rs.getString("real_name");
                String password = rs.getString("password");
                Integer did = rs.getInt("d_id");
                user.setId(id);
                user.setUserName(userName);
                user.setRealName(realName);
                user.setPassword(password);
                user.setDId(did);
            }
            rs.close();
            stmt.close();
            conn.close();
            return (T) user;
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return null;
    }
}
