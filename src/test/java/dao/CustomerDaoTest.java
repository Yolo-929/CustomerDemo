package dao;

import model.Customer;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class CustomerDaoTest {
    @Test
    public void add() {

        //为了测试的方便，直接使用构造函数了！
        Customer customer = new Customer("1", "zhongfucheng", "男", new Date(), "1234", "aa@sina.com", "打代码", "高贵的用户", "我是个好人");


        CustomerDao customerDao = new CustomerDao();
        customerDao.addCustomer(customer);
    }

}