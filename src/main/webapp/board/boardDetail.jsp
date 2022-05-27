<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="./css/cssBoardDetail.css" type="text/css">
</head>
<body>
<div id = "boardListTbl">
<h3>글 상세보기</h3>
	 <form name="boardDetailForm">
	 	<input type="hidden" name="seq" value="${requestScope.rqPage.getSeq()}">
	 	<input type="hidden" name="updatePg" value="${requestScope.previousPage}">
	 	
		 <table>
			<tr>
				<td><h2>${requestScope.rqPage.getSubject()}</h2></td> 
			</tr>
		
			<tr>
				<td>
					<div class = "pageInfo">
						<span class = "seqInfo">글번호 : ${requestScope.rqPage.getSeq()}</span> 
						<span class = "authorInfo">작성자 :${requestScope.rqPage.getName()}(${requestScope.rqPage.getId()}) </span> 
						<span class = "hitInfo">조회수 : ${requestScope.rqPage.getHit()}</span> 
			 		</div>
			 	</td>
			</tr>
			 		
			<tr>
			 	<td>
				 	<pre>${requestScope.rqPage.getContent()}</pre>
				</td>
			</tr>
		</table>
		
			<div class = "pageControl">
				<span class = "toList"><input type = "button" value = "목록" onclick="mode(4)">
					<input type="button" value="답글" onclick="mode(3)")>
				</span>
				<c:if test = "${requestScope.rqPage.getId() == sessionScope.sessionId}">
					<span class = "updel" >
						<input type = "button" value = "수정" onclick="mode(1)">
						<input type = "button" value = "삭제" onclick="mode(2)"> 	
						
					</span>
				</c:if>
				<c:if test = "${requestScope.rqPage.getId() != sessionScope.sessionId}">
					<span style = "float:right;"> 본인의 글만 수정삭제가 가능합니다. </span> 
				</c:if>		
			</div>
	</form>
</div>
	<script type="text/javascript">
	
		/* post방식으로 넘겨주기 */
		function boardDetailSubmit(actionPath){
			document.boardDetailForm.method = "post";
			document.boardDetailForm.action = actionPath;
			document.boardDetailForm.submit();
		}
		
		function mode(num){
			if(num ==1){
				let actionPath = "/miniPJ/board/boardUpdateForm.do";
				boardDetailSubmit(actionPath);
				
				/* document.boardDetailForm.method = "post";
				document.boardDetailForm.action = "/miniPJ/board/boardUpdateForm.do";
				document.boardDetailForm.submit(); */
			}else if(num ==2 ){
				if(confirm("정말로 삭제하시겠습니까?")){
					let actionPath = "/miniPJ/board/boardDelteForm.do";
					boardDetailSubmit(actionPath);
					
/* 					document.boardDetailForm.method = "post";
					document.boardDetailForm.action = "/miniPJ/board/boardDelteForm.do";
					document.boardDetailForm.submit();
 */				}
			}else if(num == 3){
				let actionPath = "/miniPJ/board/boardReplyForm.do";
				boardDetailSubmit(actionPath);
				
				/* document.boardDetailForm.method = "post";
				document.boardDetailForm.action = "/miniPJ/board/boardReplyForm.do";
				document.boardDetailForm.submit();
			 */}else if(num == 4){
				let actionPath = "/miniPJ/board/boardList.do?pg=${requestScope.previousPage}";
				boardDetailSubmit(actionPath);
				
				/* document.boardDetailForm.method = "post";
				document.boardDetailForm.action = "/miniPJ/board/boardList.do";
				document.boardDetailForm.submit();
			 */}else{
				alert('javascript something wrong..!');
			}
		}
		
		
	</script>
	

</body>
</html>