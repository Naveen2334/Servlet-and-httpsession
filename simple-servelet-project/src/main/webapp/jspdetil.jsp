<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%for(int i = 0;i<=10;i++){ %>
<h1>the no is<%= i %></h1>
<%}%>
<h4>year = <%=LocalDate.now().getYear() %></h4>
<h4>year = <%=LocalDate.now().getDayOfWeek() %></h4>
<h4>year = <%=LocalDate.now().getMonth()%></h4>


</body>
</html>