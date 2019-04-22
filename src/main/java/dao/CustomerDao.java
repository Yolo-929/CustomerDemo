package dao;

import model.Customer;
import org.apache.commons.dbutils.QueryRunner;
import utils.Utils2DB;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerDao {
    public void addCustomer(Customer customer)  {

        QueryRunner queryRunner = new QueryRunner(Utils2DB.getDataSource());


        String sql = "INSERT INTO customer (id,name, gender, birthday, cellphone, preference, type, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";


        //得到用户传递进来的数据
        String id = customer.getId();
        String name = customer.getName();
        String gender = customer.getGender();
        String cellphone = customer.getCellphone();
        String email = customer.getEamil();
        String preference = customer.getPreference();
        String type = customer.getType();
        String description = customer.getDescription();

        //对于日期，要转换一下
        Date date = customer.getBirthday();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String birthday = simpleDateFormat.format(date);

        try {
            //向数据库插入数据
            queryRunner.update(sql, new Object[]{id,name,gender,birthday,cellphone,email,preference,type,description});

            //插入记录成功！
        } catch (SQLException e) {

            //如果出现了异常，就抛出Dao异常吧（自定义的异常）
            e.printStackTrace();

           // throw new DaoException("添加用户出错了！");
        }
    }
}
