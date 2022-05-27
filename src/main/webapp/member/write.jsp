<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test = "${requestScope.su == 1}">회원가입을 축하합니다.</c:if>
<c:if test = "${requestScope.su != 1}">회원가입이 정상적으로 이루어지지 않았습니다. 다시 작성하세요. </c:if>
</body>
</html>