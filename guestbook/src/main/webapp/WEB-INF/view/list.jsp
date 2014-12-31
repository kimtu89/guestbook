<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.spring.web.vo.page" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-2.1.3.min.js"></script>
<title>글목록</title>
</head>
<body>
<h1>글목록</h1>
<form action='write'>
<input type='submit' value='글쓰기'>
</form><br><br>
<c:forEach var="page" items="${pages}"> 
<table>
<tr><td>NO.${page.index}</td>
<td>이메일 : ${page.email}</td></tr>
<tr><td>생성시간 : ${page.writetime} </td></tr>
<tr><td>수정시간 : ${page.modifytime} </td></tr>
<tr><td>본문 : ${page.content}</td></tr>
</table>
<form action='modify' method='post'>
<input type='hidden' name='no' value='${page.index}'>
<input type='submit' value='수정'>
</form>
<br><br>
</c:forEach>
</body>
</html>