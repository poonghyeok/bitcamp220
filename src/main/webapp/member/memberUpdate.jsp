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
<c:if test = "${requestScope.updatedLine == 1}">
	<h3>회원님의 정보를 수정하였습니다.</h3>
</c:if>

<c:if test = "${requestScope.updatedLine != 1}">
	<h3>수정에 실패했습니다. 관리자에게 문의해주세요. </h3>
</c:if>

</body>
</html>