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
	<c:if test="${requestScope.boardUpdatedNum == 1}">
		<h3>글 수정이 완료 되었습니다.</h3>
		<input type = "button" value = "목록" onclick="location.href='/miniPJ/board/boardList.do?pg=1'">
	</c:if>
	
	<c:if test="${requestScope.boardUpdatedNum != 1}">
		<h3>글 수정에 실패했습니다...</h3>
	</c:if>
	
</body>
</html>
 --%>
 ${requestScope.updateJson}