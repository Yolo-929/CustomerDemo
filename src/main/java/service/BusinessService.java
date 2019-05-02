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
    public Page getPageData(String currentPageCount) {

        Page page = new Page();

        //获取数据库中有多少条记录，并封装到Page对象中
        Long totalRecord = customerDao.getTotalRecord();
        page.setTotalRecord(totalRecord);

        //算出总页数，并封装到Page对象中
        int totalPagecount = (int) (totalRecord % page.getLinesize() == 0 ? totalRecord / page.getLinesize() : totalRecord / page.getLinesize() + 1);
        page.setTotalPageCount(totalPagecount);

        int start ;
        int end = page.getLinesize();

        //现在又分两种情况了，如果传递进来的参数是null的，那么说明外界是第一次查询的
        if (currentPageCount == null) {

            //第一次查询，就应该设置当前页数是第一页
            page.setCurrentPageCount(1);

            start = (int) ((page.getCurrentPageCount() - 1) * page.getLinesize());

            List<Customer> customers = customerDao.getPageData(start, end);

            page.setList(customers);
        } else {

            //如果不是第一次，就把外界传递进来的页数封装到Page对象中
            page.setCurrentPageCount(Long.parseLong(currentPageCount));

            start = (int) ((page.getCurrentPageCount() - 1) * page.getLinesize());

            List<Customer> customers = customerDao.getPageData(start, end);

            page.setList(customers);

        }
        return page;

    }
}