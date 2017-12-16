
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>보드리스트</title>
</head>
<body>
	 <h1>DAO인터페이스와 getMapper(xx.class)를 <br>이용해 myBatis의 XML쿼리와연계하여조회 리스트</h1><br>
	 left outer join 사용하여 수겅된 DTO를 활용
<table width ="70%" border ="0" cellpadding="0" cellspacing="0" >
	<tr bgcolor="white">
	<td>
		 <div id="search" style="text-align: right;">
		  <form id="searchForm" action="/board/boardlistExt.do" method="get" >
		   		    
		    제목: <input type="text" name="title" size="15" maxlength="30" /> 
		    작성자: <input type="text" name="name" size="7" maxlength="30" />
		    <input type="button" value="검색" />
		    
		  </form>
		 </div>
	 </td>
	 </tr>
</table>	
 <br>	
<table width ="70%" border ="1" cellpadding="0" cellspacing="0" >
	<tr align ="center" bgcolor="yellow">
		<td>NUM</td>
		<td>제목</td>
		<td>내용</td>		
		<td>입력ID</td>
		<td>입력자이름</td>
		<td>최종수정일자</td>
		
		
	</tr>
<c:forEach var="m" items="${boardlistExt}">
	<tr align ="center">
		<td>${m.num}</td>
		<td>${m.title}</td>		
		<td>${m.content}</td>
		<td>${m.lst_modify_id}</td>
		<td>${m.user_name}</td>
		<td>${m.lst_modify_dt}</td>
		
		
	</tr>
</c:forEach>

</table>
<br>



<br><br>

</body>
</html>