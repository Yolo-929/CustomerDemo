package view;

import model.Page;
import service.BusinessService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LookCustomerServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取用户想要看的页数，如果是第一次，那肯定为null
        String currentPageCount = req.getParameter("currentPageCount");

        String servletName = this.getServletName();

        //调用BusinessService的方法，获取得到所有客户信息
        BusinessService businessService = new BusinessService();

        //把Servlet的url也传递进去
        Page page = businessService.getPageData(currentPageCount, req.getContextPath() + "/" + servletName);

        //把客户信息带过去给jsp页面
        req.setAttribute("page", page);

        //跳转到显示客户界面信息的jsp
        req.getRequestDispatcher("/lookCustomer.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
