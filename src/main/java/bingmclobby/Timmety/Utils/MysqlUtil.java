package bingmclobby.Timmety.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlUtil {

    private static Connection conn = null;
    private static String host;
    private static int port;
    private static String db;
    private static String user;
    private static String password;

    public static void init(String host, int port, String db, String user, String password) {
        MysqlUtil.host = host;
        MysqlUtil.port = port;
        MysqlUtil.db = db;
        MysqlUtil.user = user;
        MysqlUtil.password = password;
    }

    public static Connection i() {
        if (host == null) {
            return null;
        }
        try {
            if (conn == null) {
                conn = DriverManager.getConnection(
                        String.format("jdbc:mysql://%s:%d/%s", host, port, db),user,password);
            }
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
