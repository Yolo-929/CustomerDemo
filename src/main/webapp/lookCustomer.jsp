<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/2 0002
  Time: 下午 9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:if test="${empty(page.list)}">
    对不起，还没有任何客户的信息！
</c:if>

<c:if test="${!empty(page.list)}">
    <table border="1px">
        <tr>
            <td>用户名：</td>
            <td>性别：</td>
            <td>生日：</td>
            <td>电话号码：</td>
            <td>邮箱：</td>
            <td>爱好</td>
            <td>类型：</td>
            <td>描述：</td>
        </tr>

        <c:forEach items="${page.list}" var="customer">
            <tr>
                <td>${customer.name}</td>
                <td>${customer.gender}</td>
                <td>${customer.birthday}</td>
                <td>${customer.cellphone}</td>
                <td>${customer.email}</td>
                <td>${customer.preference}</td>
                <td>${customer.type}</td>
                <td>${customer.description}</td>
            </tr>
        </c:forEach>
    </table>

    <jsp:include page="/page.jsp"/>

</c:if>

</body>
</html>
