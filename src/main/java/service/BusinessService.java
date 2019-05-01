package service;

import dao.CustomerDao;
import model.Customer;

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
}