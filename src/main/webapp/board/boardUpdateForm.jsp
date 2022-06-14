<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정하기</title>
</head>

<style>
	.alertMsg{
		background-color : yellow;
		color : red;
		font-size : 10px;
		width : 150px;
	}
	
	table {
	    width: 100%;
	    border:none;
	 }
  	th, td {
	    padding: 10px;
	    border-left: none !important;
	    border-bottom: 1px solid #96D4D4;
	    border-top: 1px solid #96D4D4;
	}
	
</style>

 	
<body>
	
	<form name = "boardForm" id = "boardForm">
		<input type="text" name="seq" id = "seq" value="${param.seq}"> 	
		
		<input type="text" name="pg" id ="pg" value="${param.pg}"> 	
		<table>
			<tr>
				<td>제목</td>
				<td>
					<input type = "text" name = "subject" id = "subject" value = "">
					<div class = "alertMsg" id = "subjectDiv"></div>
				</td>
				
			</tr> 

			<tr>
				<td> 내용 </td>
				<td>
					<textarea name = "content" id = "content" rows="10" cols="50"></textarea>
					<div class = "alertMsg" id = "contentDiv"></div>
				</td>
			</tr>
			
			<tr>
				<td colspan = "2" align = "center"> 
					<input type = "button" value = "수정하기" id = "boardUpdateButton">
					<!-- 유효성 검사 추가하고 싶다면 추가 -->
					<input type = "button" id = "resetButton" value = "다시작성">
				</td>
			</tr>
		</table>
		
	</form>
	
	<!-- <input type = "button" value = "목록" onclick="location.href='/miniPJ/board/boardList.do?pg=1'">
	 -->
	 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	 <script src="http://localhost:8080/miniPJ/script/boardUpdateForm.js"></script>
 	<script>
	 
	
	 
	</script>

</body>
</html>