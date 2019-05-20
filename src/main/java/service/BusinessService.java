package service;

import dao.CustomerDao;
import model.Customer;
import model.Page;

import java.util.List;

public class BusinessService {

    CustomerDao customerDao = new CustomerDao();

    public List<Customer> getAll() {

        return customerDao.getAll();
    }

    public void addCustomer(Customer customer) {

        customerDao.addCustomer(customer);
    }

    public void deleteCustomer(String id) {
        customerDao.delete(id);
    }

    public void updateCustomer(Customer customer) {
        customerDao.update(customer);
    }

    public Customer findCustomer(String id) {
        return customerDao.find(id);
    }

    //既然Page对象代表是分页数据，那么返回Page对象即可！
    //web层应该传入想要看哪一页数据的参数！
    public Page getPageData(String currentPageCount,String url) {

        //获取得到总记录数
        Long totalPageCount = customerDao.getTotalRecord();

        //现在又分两种情况了，如果传递进来的参数是null的，那么说明外界是第一次查询的
        if (currentPageCount == null) {

            //如果是第一次，那么就将用户想看的页数设置为1
            Page page = new Page(1, totalPageCount);

            List<Customer> customers = customerDao.getPageData(page.getStartIndex(), page.getLinesize());

            page.setUrl(url);
            page.setList(customers);
            return page;

        } else {

            //如果不是第一次，就将获取得到的页数传递进去
            Page page = new Page(Integer.parseInt(currentPageCount), totalPageCount);

            List<Customer> customers = customerDao.getPageData(page.getStartIndex(), page.getLinesize());

            page.setUrl(url);
            page.setList(customers);
            return page;
        }
    }
}