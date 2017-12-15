<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- jstl 코어 태그 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<a href="${pageContext.request.contextPath}/test/jqGridtest.do">그리드조회</a>
<c:choose>
    <c:when test="${sessionScope.userId == null}">
        <a href="${pageContext.request.contextPath}/test/login.do">로그인</a>
    </c:when>
    <c:otherwise>
        ${sessionScope.userName}님이 로그인중입니다.
        <a href="${pageContext.request.contextPath}/test/logout.do">로그아웃</a>
    </c:otherwise>
</c:choose>
    
<hr>
