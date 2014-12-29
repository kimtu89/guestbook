<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mycompany.myapp.page" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
ArrayList<page> pages = (ArrayList<page>)request.getAttribute("pages");
for(page P : pages){
%>
<form action='modify_done' method='post'>
<input type='hidden' name='no' value='<%=P.getIndex() %>'>
email : <input type='text' name='email' value='<%=P.getEmail() %>'><br>
pw : <input type='password' name='pw'><br>
content : <input type='text' name='content' value='<%=P.getContent() %>' style='height:100px'><br>
<input type='submit' value='쓰기'>
</form>
<%} %>
</body>
</html>