<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.List" %>
    <%@ page import = "com.app.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All users </title>
</head>
<body>
<table>
	<% List<User> userList = (List)session.getAttribute("user");%>
	<%
	 for(User user : userList){
		%>
		<tr> 
		<td><% out.println(user.getUser_id());%> </td>
		<td><% out.println(user.getUser_name());%> </td>
		<td><% out.println(user.getEmail());%> </td>
		<td><% out.println(user.getPhone_number());%> </td>
		</tr>
		<%} %>
		</table>

</body>
</html>