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

	<form name = "boardReplyForm">
		<input type="hidden" name="pseq" value="${requestScope.pseq}">
		<input type="hidden" name="pg" value="${requestScope.pg}">

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
					<input type = "button" value = "답글쓰기" onclick = "replyButton()">
					<!-- 유효성 검사 추가하고 싶다면 추가 -->
					<input type = "reset" value = "다시작성">
				</td>
			</tr>
			
		</table>
	</form>
	
	<script>
		function submitPost(actionPath){
			document.boardReplyForm.method = "post";
			document.boardReplyForm.action = actionPath;
			document.boardReplyForm.submit(); 
		}
	
		function check(actionPath){
			const subjectEle = document.getElementById('subject');
			const contentEle = document.getElementById('content');
			const subjectDiv = document.getElementById('subjectDiv');
			const contentDiv = document.getElementById('contentDiv');

			subjectDiv.innerText = "";
			contentDiv.innerText = "";
			
			if(subjectEle.value === ""){
				subjectDiv.innerText = "제목을 입력해야합니다.";
			}else{
				if(contentEle.value === ""){
					contentDiv.innerText = "내용을 입력해야합니다.";
				}else{
					submitPost(actionPath);  	
				}
			}
		}

		function replyButton(){
			let actionPath = "http://localhost:8080/miniPJ/board/boardReply.do";
			check(actionPath);
		}
	
	</script>

</body>
</html>