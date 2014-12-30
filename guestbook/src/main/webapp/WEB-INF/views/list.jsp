<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mycompany.myapp.page" %>
<%@ page import="java.util.ArrayList" %>
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
<%
ArrayList<page> pages = (ArrayList<page>)request.getAttribute("pages");
for(page P : pages){
%>
<table>
<tr><td>NO.<%=P.getIndex() %></td>
<td>이메일 : <%=P.getEmail() %></td></tr>
<tr><td>생성시간 : <%=P.getCreatedDate() %> <%=P.getCreatedTime() %></td></tr>
<tr><td>수정시간 : <%=P.getModifiedDate() %> <%=P.getModifiedTime() %></td></tr>
<tr><td>본문 : <%=P.getContent() %></td></tr>
</table>
<form action='modify' method='post'>
<input type='hidden' name='no' value='<%=P.getIndex() %>'>
<input type='submit' value='수정'>
</form>
<br><br>
<%}%>
</body>
</html>