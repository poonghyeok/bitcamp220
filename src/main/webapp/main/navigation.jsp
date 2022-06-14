<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var = "loginStatus" value = "${empty sessionScope.sessionName}" />

<c:if test="${empty sessionScope.sessionId}">
	<jsp:include page = "../member/loginForm.jsp"></jsp:include>
</c:if>
	   		
<c:if test="${not empty sessionScope.sessionId}">
	<h3>
 		${sessionScope.sessionName}(${sessionScope.sessionId})님 반갑습니다
		<input type="button" value = "로그아웃" id="logoutButton">
		<input type="button" value = "정보수정" id="memberUpdateButton" onclick="memberUpdateButton();">
		
	</h3> 
</c:if>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src = "http://localhost:8080/miniPJ/script/memberLoginForm.js"></script>
	   		

<%-- loginStatus : ${requestScope.loginStatus == 'login'}

<c:set var = "loginStatusTest" value = "${requestScope.loginStatus == 'login'}" />

<c:if test = "${not loginStatusTest}">
		<jsp:include page="../member/loginForm.jsp"></jsp:include>
</c:if>

<c:if test = "${loginStatusTest}">
	<c:if test = "${requestScope.name != null}">
		<jsp:include page="../member/loginOk.jsp"></jsp:include>
	</c:if>
	
	<c:if test = "${requestScope.name == null}">
		<jsp:include page="../member/loginForm.jsp"></jsp:include>
	</c:if>
</c:if>
	 		
<c:if test="${requestScope.loginFailMsg != null}">
	<jsp:include page = "../member/loginFail.jsp"></jsp:include>
</c:if> 
 --%>

<%-- <c:if test="${requestScope.name != null}">
	<jsp:include page = "../member/loginOk.jsp"></jsp:include>
</c:if>

<c:if test="${requestScope.name == null}">
	<jsp:include page = "../member/loginForm.jsp"></jsp:include>
</c:if> 
--%>


