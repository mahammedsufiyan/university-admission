<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>  Register Here</h1>
<form action="applicantRegistation">
<fieldset>
<legend>Applicant registration form</legend>

BRANCH ID<input type="number" name="BranchId" readonly="readonly" value="<%=request.getParameter("id")%>"><br><br>
NAME:<input type="text" name="name"><br><br>
EMAIL:<input type="text" name="email"><br><br>
PHONE:<input type="text" name="phone"><br><br>
AGE:<input type="number" name="age" ><br><br>
PUC:<input type="text" name="puc"><br><br>
GENDER:<input type="radio" name="gender" value="male" id="gender">Male
        <input type="radio" name="gender" value="female" id="gender">Female 



<input type="submit" value="submit">
</fieldset>
</form>



</body>
</html>