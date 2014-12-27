<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mycompany.myapp.page" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글목록</title>
</head>
<body>
<h1>글목록</h1>
<%
ArrayList<page> pages = (ArrayList<page>)request.getAttribute("pages");
for(page P : pages){
%>
NO.<%=P.getIndex() %>
이메일 : <%=P.getEmail() %><br>
본문 : <%=P.getContent() %>
생성시간 : <%=P.getCreatedDate() %><br>
수정시간 : <%=P.getModifiedDate() %><br><br>
<%}%>
</body>
</html>