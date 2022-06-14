<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:if test="${requestScope.boardWrittenNum == 1}">
<h3>글작성을 완료했습니다.</h3>
<input type="button" value="글목록" onclick="location.href='/miniPJ/board/boardList.do?pg=1'">
</c:if>

<c:if test="${requestScope.boardWrittenNum != 1}">
<h3>글작성에 실패했습니다.</h3>
</c:if>

<script type="text/javascript">
	/* window.onload = function(){
		if(${requestScope.boardWrittenNum == 1}){
			location.href='/miniPJ/board/boardList.do?pg=1';
		}else{
			alert('글 작성에 실패했습니다.');
		}
		
	}
	 */
</script>

