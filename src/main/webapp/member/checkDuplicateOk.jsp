<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3> ${requestScope.usableId} 는 사용가능한 닉네임입니다.</h3>

<input type = "button" value = "사용하기" onclick = "checkDuplicateClose('${requestScope.usableId}');">
<!-- 왜 ' 을 찍어야하는가? usableId는 어짜피 string이라서 그냥 넘기면 안되나? -->
<script type="text/javascript">
	function checkDuplicateClose(usableId){
		window.opener.document.writeForm.idWrite.value = usableId;
		window.opener.document.getElementById("idDivWrite").innerText = "";
		window.close();
		window.opener.document.writeForm.pwdWrite.focus();
		window.opener.checkDuplicate.checkedId = '${requestScope.usableId}';
		window.opener.checkDuplicate.buttonClick = true;
	}
</script>

</body>
</html> --%>
nonexist