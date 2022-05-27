<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var = "loginStatus" value = "${empty sessionScope.sessionName}" />

<c:if test = "${empty sessionScope.sessionName}">
	<jsp:include page="../member/loginForm.jsp"></jsp:include>
</c:if>
	
<c:if test = "${not empty sessionScope.sessionName}">
	<jsp:include page="../member/loginOk.jsp"></jsp:include>
</c:if>


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


