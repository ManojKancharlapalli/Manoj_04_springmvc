<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% String msg=(String) request.getAttribute("msg");
    String errMsg=(String) request.getAttribute("errMsg"); %>
    <jsp:include page="header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="./addEmp" method="post">
   Employee Id:<input type="number" name="id">
	Employee Name:<input type="text" name="name">
	Employee Age:<input type="text" name="age">
	Employee Email:<input type="text" name="emailId">
	Employee Mobile Number:<input type="text" name="mobilenumber">
	Employee Password:<input type="text" name="password">
	<input type="submit" name="Submit">
</form>
<%if(msg !=null ){ %>
<h3 style="color: green;">Employee added for<%=msg%></h3>

<% }%>
<%if(errMsg!=null && !errMsg.isEmpty()){ %>
<h2 style="color: red;"><%=errMsg %></h2>
<%} %>
</body>
</html>