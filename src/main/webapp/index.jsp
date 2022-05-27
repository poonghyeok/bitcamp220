<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link rel = "stylesheet" type = "text/css" href = "/miniPJ/css/cssIndex.css">
<title>Insert title here</title>
</head>
<body>
<div id="header">
	<h1> <a href = "http://localhost:8080/miniPJ"><img src ="http://localhost:8080/miniPJ/img/jeju.jpg" width = "150px"></a>
	 MVC 를 이용한 미니 프로젝트 </h1>
	<p>
	<jsp:include page="./main/menu.jsp"></jsp:include>
</div>

<div id="container">
	   <div id="nav">
	   		<jsp:include page = "./main/navigation.jsp"></jsp:include>
	   		<c:if test="${not empty navDisplay}">
	   			<jsp:include page = "${navDisplay}"></jsp:include>
	   		</c:if>
	   	</div>
	   	
		<div id="section">	
			<c:if test="${empty display}">
				<c:if test = "${not empty requireLoginMsg}">
					<div id = "requireLoginMsg" style = "display :inline-block; color :  red; background: yellow;">
						${requireLoginMsg}
					</div>
					<input type = "button" value = "로그인하기" onclick = "loginFormFocus();">
				</c:if>
				<c:if test = "${empty requireLoginMsg}">
					<h3>방문을 환영합니다</h3>
					<img alt="welcomeIMG" src="http://localhost:8080/miniPJ/img/spongebob.png">
				</c:if>
			</c:if>
			
			<c:if test="${not empty display}">
				<jsp:include page = "${display}"></jsp:include>
			</c:if>
			
		</div>
</div>

<div id="footer">
   <p>footer area</p>
</div>

<script type="text/javascript">
	function loginFormFocus(){
		document.getElementById("id").focus();
	}
</script>

</body>
</html>