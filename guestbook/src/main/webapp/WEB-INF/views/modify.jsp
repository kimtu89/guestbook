<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.mycompany.myapp.page" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<% page P = (page)request.getAttribute("result"); %>
<form action='modify_done' method='post'>
email : <input type='text' name='email' value='<%=P.getEmail() %>'><br>
pw : <input type='password' name='pw'><br>
content : <input type='text' name='content' value='<%=P.getContent() %>' style='height:100px'><br>
<input type='submit' value='쓰기'>
</body>
</html>