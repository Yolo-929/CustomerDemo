package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Utils2DB {

    private static ComboPooledDataSource comboPooledDataSource = null;

    static {
        //它会自动寻找配置文件，节点为mysql的数据库（默认就是Mysql）
        comboPooledDataSource = new ComboPooledDataSource();
    }


    public static DataSource getDataSource() {
        return comboPooledDataSource ;
    }

    public static Connection connection() {
        try {
            return comboPooledDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("数据库初始化失败了！");
        }
    }
}
