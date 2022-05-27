<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<body>
<h3>답글 작성 결과 = ${requestScope.boardRepliedNum}</h3>

<c:if test= "${requestScope.boardRepliedNum > 0}">
	<h3>답글 작성을 완료했습니다.</h3>
	<input type="button" value="목록" onclick="location.href='/miniPJ/board/boardList.do?pg=${pg}'">
</c:if>

</body>
</html>

