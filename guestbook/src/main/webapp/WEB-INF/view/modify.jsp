<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.spring.web.vo.page" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-2.1.3.min.js"></script>
<script>
function check_mail(value){
	if (value.search(/(\S+)@(\S+)\.(\S+)/) == -1 ) {
		   alert("E-mail 주소가 부정확합니다.");   
	}
}
</script>
<title>글수정</title>
</head>
<body>
<form action='modify_done' method='post'>
<input type='hidden' name='no' value='${page.index}'>
email : <input type='text' name='email' value='${page.email}' onBlur="check_mail(email.value)"><br>
pw : <input type='password' name='pw'><br>
content : <input type='text' name='content' value='${page.content}' style='height:100px'><br>
<input type='submit' onClick="check_mail(email.value)" value='쓰기'>
</form>
</body>
</html>