package view;

import model.Customer;
import service.BusinessService;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddCustomerController extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //将表单的数据弄到Bean对象中
        Customer customer = WebUtils.request2Bean(request, Customer.class);

        customer.setId(WebUtils.makeId());

        try {
            //调用BusinessService层的方法，添加客户
            BusinessService businessService = new BusinessService();
            businessService.addCustomer(customer);

            //如果执行到这里，说明成功了，如果被catch了，说明失败了。
            request.setAttribute("message", "添加成功！");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "添加失败");
        }
        request.getRequestDispatcher("/message.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
