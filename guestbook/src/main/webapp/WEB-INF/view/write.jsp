<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>글쓰기</title>
</head>
<body>
<h1>글쓰기</h1>
<form name='write_form' action='write_done' method='post'>
email : <input type='text' name='email' onBlur="check_mail(email.value)"><br>
pw : <input type='password' name='pw'><br>
content : <input type='text' name='content' style='height:100px'><br>
<input type='submit' onClick="check_mail(email.value)" value='쓰기'>
</form>
</body>
</html>