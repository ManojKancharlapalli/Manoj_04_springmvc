<%@page import="com.jfsfeb.springmvc.dto.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% EmployeeBean bean=(EmployeeBean) request.getAttribute("empInfo");
    String errMsg=(String) request.getAttribute("errMsg");
    %>
    <jsp:include page="header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="./searchEmp" method="get">
Employee Id: <input type="number" name="id"><br>
<input type="submit">

</form>
<%if(bean !=null ){ %>
<h3 style="color: green;">Employee REcord Found for<%=bean.getId() %></h3>
Employee Name:<%=bean.getName()%>
employee Mobile :<%=bean.getMobilenumber() %>
Employee EmailId: <%=bean.getEmailId() %>
<% }%>
<%if(errMsg!=null && !errMsg.isEmpty()){ %>
<h2 style="color: red;"><%=errMsg %></h2>
<%} %>
</body>
</html>