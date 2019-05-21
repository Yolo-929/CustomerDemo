package view;

import model.Customer;
import service.BusinessService;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateCustomer extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //将数据封装到Bean中
        Customer customer = WebUtils.request2Bean(request, Customer.class);

        //将id封装到Customer对象中！！！不要忘了id！！！在表单中获取到的数据是没有id的！！！！！记得！！！！
        customer.setId(request.getParameter("id"));

        //调用Service层的方法，实现修改
        BusinessService businessService = new BusinessService();
        businessService.updateCustomer(customer);

        //修改成功就跳回查看客户界面
        request.getRequestDispatcher("/lookCustomer").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
