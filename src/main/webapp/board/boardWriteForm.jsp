<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
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

	<form name = "boardForm" id= "boardForm">

		<table border = "1" cellspacing = "3" cellpadding ="5">

			<tr>
				<td>제목</td>
				<td>
				<div class = "alertMsg" id = "subjectDiv"></div>
				<input type = "text" name = "subject" id = "subject" placeholder = "제목을 입력하세요 "></td>
			</tr>

			<tr>
				<td> 내용 </td>
				<td>
				<div class = "alertMsg" id = "contentDiv"></div>
				<textarea name = "content" id = "content" rows="10" cols="50" placeholder = "내용을 입력하세요 "></textarea></td>
			</tr>
			
			<tr>
				<td colspan = "2" align = "center"> 
					<input type = "button" value = "글쓰기" id="boardWriteButton">
					<input type = "reset" value = "다시작성">
				</td>
			</tr>
			
		</table>
	</form>
	
	<input type = "button" value = "목록" id="boardListButton">
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src = "http://localhost:8080/miniPJ/script/boardWrite.js"></script>
	<script>
		$(function(){
			if(${sessionId == null}){
				$('div#section').html('로그인 필요한 기능');
			}
		})
	</script>
</body>
</html>