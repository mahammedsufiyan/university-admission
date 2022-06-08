<%@page import="com.ty.dto.Applicant"%>
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
	<h1>FILTERED APPLICANTS DETAILS</h1>
	
	<h4>Here is your details....!!</h4>
<table border="2px solid black">

<thead>
<tr>
<th>ID</th>
<th>NAME</th>
<th>EMAIL</th>
<th>PHONE</th>
<th>AGE</th>
<th>GENDER</th>
<th>PUC</th>
</tr>
	
	<% List<Applicant>applicants  = (List<Applicant>)request.getAttribute("filterapplicants");%>
	<% for(Applicant applicant:applicants){ %>
	<tr>
		<td><%=applicant.getId()%> </td>
 		<td><%=applicant.getName() %></td>	
 		<td><%=applicant.getEmail() %></td>	
 		<td><%=applicant.getPhone() %></td>	
 		<td><%=applicant.getAge()%></td>	
 		<td><%=applicant.getGender()%></td>	
 		<td><%=applicant.getPuc()%></td>	
	</tr>
	<%} %>

</thead>
</table>
</body>
</html>