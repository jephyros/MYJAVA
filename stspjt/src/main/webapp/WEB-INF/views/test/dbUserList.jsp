
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" isELIgnored="false"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>�׽�Ʈ</title>
</head>
<body>
	 USER����Ʈ 
	
	
	<h2>����ڸ���Ʈ</h2>
<table width ="70%" border ="1" cellpadding="0" cellspacing="0" >
	<tr align ="center" bgcolor="yellow">
		<td>ID</td>
		<td>�̸�</td>
		<td>Ư�̻���</td>		
		<td>����������ID</td>
		<td>������������</td>
		
		
	</tr>
<c:forEach var="m" items="${userList}">
	<tr align ="center">
		<td>${m.user_id}</td>
		<td>${m.user_name}</td>		
		<td>${m.remark}</td>
		<td>${m.lst_modify_id}</td>
		<td>${m.lst_modify_dt}</td>
		
				
		
		
	</tr>
</c:forEach>

</table>
<br><br><br>
<a href="${pageContext.request.contextPath}/test/adduserForm.do"> ��� </a>
</center>
</body>
</html>