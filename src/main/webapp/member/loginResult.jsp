<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test = "${not empty sessionScope.sessionId}">
	<h3>로그인에 성공했습니다.</h3>
</c:if>

<c:if test = "${empty sessionScope.sessionId}">
	<h3>로그인에 실패했습니다.</h3>
	<input type = "button" value = "다시로그인" onclick="history.go(-1)">
</c:if>

</body>
</html> --%>

<c:if test = "${not empty sessionScope.sessionId}">
success
</c:if>

<c:if test = "${empty sessionScope.sessionId}">
fail
</c:if>