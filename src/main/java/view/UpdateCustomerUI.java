package view;

import model.Customer;
import service.BusinessService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateCustomerUI extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        BusinessService businessService = new BusinessService();

        //通过id获取得到用户的详细信息
        Customer customer = businessService.findCustomer(id);

        request.setAttribute("customer", customer);
        //跳转到显示用户详细信息的jsp页面上
        request.getRequestDispatcher("/customerInformation.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
