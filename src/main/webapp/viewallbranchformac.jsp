<%@page import="com.ty.dto.Branch"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border="3px solid red">

<thead>
<tr>
<th>ID</th>
<th>BRANCH NAME</th>
<th>APPLICANTS</th>

</tr>
<% List<Branch>  branchs=(List<Branch>)request.getAttribute("allbranchformac");%>
<tr>
<% for(Branch branch:branchs){ %>
<td><%=branch.getId()%> </td>
 <td><%=branch.getBranchName() %></td>
<td><a href="getbyid?id=<%=branch.getId()%> ">View</a></td><br>
</tr>

<%} %>
</table>

</body>
</html>