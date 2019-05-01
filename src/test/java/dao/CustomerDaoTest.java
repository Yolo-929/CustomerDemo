package dao;

import model.Customer;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class CustomerDaoTest {

    @Test
    public void add() {

        //为了测试的方便，直接使用构造函数了！
        Customer customer = new Customer("2", "loyo", "男", new Date(), "1234", "aa@sina.com", "打代码", "SVIP", "我是个程序员");


        CustomerDao customerDao = new CustomerDao();
        customerDao.addCustomer(customer);
    }

    @Test
    public void find() {
        CustomerDao customerDao = new CustomerDao();
        List<Customer> customers = customerDao.getAll();

        for (Customer customer : customers) {
            System.out.println(customer.getName());
        }
    }

    @Test
    public void update(){
            CustomerDao customerDao = new CustomerDao();

            //我们已经知道了某id，通过id获取得到用户信息（Customer）
            String id = "2";
            Customer customer = customerDao.find(id);

            //修改用户信息
            customer.setName("改名卡");
            customerDao.update(customer);
    }

    @Test
    public void delete() {

        CustomerDao customerDao = new CustomerDao();

        //我们已经知道了某id，通过id删除数据库中的记录
        String id = "1";

        customerDao.delete(id);
    }
}