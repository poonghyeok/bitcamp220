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
	 <form name="boardDetailForm" id="boardDetailForm">
	 	<input type="text" name="seq" id="seq" value="${requestScope.seq}">
	 	<input type="text" name="pg" id ="pg" value="${requestScope.pg}">
	 	<input type="text" name="sessionId" id="sessionId" value="${sessionScope.sessionId}">
		 <table>
			<tr> 
				<td><h2 id = "subject"></h2></td> 
			</tr>
		
			<tr>
				<td>
					<div class = "pageInfo">
					
						<span class = "seqInfo">글번호 : <span id = "seqVal"></span> </span>  
						<span class = "authorInfo"> 작성자 :  <span id = "authorVal"></span></span> 
						<span class = "hitInfo">조회수 :  <span id = "hitVal"></span></span> 
						 
						<!-- 개별식별을 class로 하는 건 별로 좋지 않겠죠 --> 
			 		</div>
			 	</td>
			</tr>
			 		
			<tr>
			 	<td>
				 	<pre id="contentPre"></pre>
				</td>
			</tr>
		</table>
		
			<div class = "pageControl">
				<span class = "toList"><input type = "button" value = "목록" onclick="mode(4)">
					<input type="button" value="답글" onclick="mode(3)")>
				</span>
				
				<span class = "updel" >
					<input type = "button" value = "수정" id="boardUpdateButton">
					<input type = "button" value = "삭제" id="boardDeleteButton"> 	
					
				</span>
						
			</div>
	</form>
</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="http://localhost:8080/miniPJ/script/boardDetail.js"></script>
</body>
</html>