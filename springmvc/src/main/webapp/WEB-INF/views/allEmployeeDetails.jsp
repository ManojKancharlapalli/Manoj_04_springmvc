<%@page import="com.jfsfeb.springmvc.dto.EmployeeBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	EmployeeBean bean = (EmployeeBean) request.getAttribute("msg");
	String errMsg = (String) request.getAttribute("errMsg");
%>
<jsp:include page="header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<a href="./allEmp">Getall employee details</a>

</body>
</html>
<%
	if (bean != null) {
%>
<%=bean.getName()%>
<%
	}
%>