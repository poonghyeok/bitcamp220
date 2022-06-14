<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답글쓰기</title>
</head>

<style>

	.alertMsg{
		background-color : yellow;
		color : red;
		font-size : 10px;
		width : 150px;
	}
	
</style>

 	
<body>
	<form name = "boardReplyForm" id = "boardReplyForm">
		<input type="text" name="pseq" id="pseq" value="${requestScope.pseq}">
		<input type="text" name="pg" id="pg" value="${requestScope.pg}">

		<table border = "1" cellspacing = "3" cellpadding ="5">

			<tr>
				<td>답글 제목</td>
				<td>
				<div class = "alertMsg" id = "subjectDiv"></div>
				<input type = "text" name = "subject" id = "subject" placeholder = "제목을 입력하세요 "></td>
				
			</tr>

			<tr>
				<td> 답글 내용 </td>
				<td>
				<div class = "alertMsg" id = "contentDiv"></div>
				<textarea name = "content" id = "content" rows="10" cols="50" placeholder = "내용을 입력하세요 "></textarea></td>
			</tr>
			
			<tr>
				<td colspan = "2" align = "center"> 
					<input type = "button" value = "답글쓰기" id = "boardReplyButton">
					<!-- 유효성 검사 추가하고 싶다면 추가 -->
					<input type = "reset" value = "다시작성">
				</td>
			</tr>
			
		</table>
	</form>
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="/miniPJ/script/boardReplyForm.js"></script>
	
		
		
</body>
</html>