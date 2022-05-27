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
	
</style>

 	
<body>
	<h3>수정하고자하는 페이지 : ${requestScope.updateSeq}</h3>
	<form name = "boardForm">
		<%-- <input type="hidden" name="" value="${requestScope.updateSeq}"> --%>	

		<input type = "hidden" name = "oldSeq" value = "${requestScope.updateSeq}">
			<table border = "1" cellspacing = "3" cellpadding ="5">
			<tr>
				<td>제목</td>
				<td>
				<div class = "alertMsg" id = "subjectDiv"></div>
				<input type = "text" name = "subject" id = "subject" value = "${requestScope.oldBoard.getSubject()}"></td>
				
			</tr>

			<tr>
				<td> 내용 </td>
				<td>
				<div class = "alertMsg" id = "contentDiv"></div>
				<textarea name = "content" id = "content" rows="10" cols="50">${requestScope.oldBoard.getContent()}</textarea>
				</td>
			</tr>
			
			<tr>
				<td colspan = "2" align = "center"> 
					<input type = "button" value = "수정하기" onclick = "check();">
					<!-- 유효성 검사 추가하고 싶다면 추가 -->
					<input type = "reset" value = "다시작성">
				</td>
			</tr>
			
		</table>
	</form>
	
	<!-- <input type = "button" value = "목록" onclick="location.href='/miniPJ/board/boardList.do?pg=1'">
	 -->
	<script>
		function check(){
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
					document.boardForm.method = "post";
					document.boardForm.action = "http://localhost:8080/miniPJ/board/boardUpdate.do";
					document.boardForm.submit();  	
				}
						
			}
		}
		
		/* window.onload = function insertOld(){
			document.boardForm.subject.value = '${requestScope.oldBoard.getSubject()}';
			document.getElementById("content").innerHTML = '${requestScope.oldBoard.getContent()}';
		} */
		
	
	</script>

</body>
</html>