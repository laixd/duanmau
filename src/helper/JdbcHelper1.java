/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class JdbcHelper1 {

    private static String url = "jdbc:sqlserver://localhost:1433;databaseName=Polypro_laintpd02389";
    private static String user = "sa";
    private static String pass = "songlong";

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static PreparedStatement preparedStatement(String sql, Object... args) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement pre = null;
        if (sql.trim().startsWith("{")) {
            pre = con.prepareCall(sql);
        } else {
            pre = con.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            pre.setObject(i + 1, args[i]);
        }
        return pre;
    }
//
    public static ResultSet executeUpdate(String sql, Object... args) {
        try {
            PreparedStatement pre = preparedStatement(sql, args);
            try {
                pre.executeUpdate();
            } finally {
                pre.getConnection().close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
//    public static void executeUpdate(String sql, Object... args) {
//        try {
//            PreparedStatement prestm = preparedStatement(sql, args);
//            try {
//                prestm.executeUpdate();
//            } finally {
//                prestm.getConnection().close();
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public static ResultSet executeQuery(String sql, Object... args) {
        try {
            PreparedStatement stmt = preparedStatement(sql, args);
            return stmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
