<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사용자등록</title>
</head>
<body>
	<form action ="addUser.do" method="post">
	아이디 : <input type ="text" name="user_id"/> <br>
	이름 : <input type ="text" name="user_name"/> <br>
	비고 : <input type ="text" name="remark"/>	<br>
	    
	<input type="submit" value="등록">
	
	</form>

</body>
</html>