<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>

<%
//쿠키
Cookie[] cookieArr = request.getCookies();

if(cookieArr != null){
	for(int i = 0; i < cookieArr.length; i++){
		String cookieName = cookieArr[i].getName();
		String cookieValue = cookieArr[i].getValue();
		
		System.out.println("쿠키명 : " + cookieName);
		System.out.println("쿠키값 : " + cookieValue);
	}
}

%>
 --%>
<%-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome~</title>
</head>
<body>

<h3>${sessionScope.memName } 님 로그인! </h3>

<h3> 
${sessionScope.sessionId}(${sessionScope.sessionName}) 님 반갑습니다!
</h3>
<input type = "button" value = "로그아웃" onclick = "location.href='/miniPJ/member/logout.do'">
<input type = "button" value = "회원정보수정" onclick = "toUpdateForm();">
<script type="text/javascript">	
	function toUpdateForm(){
		location.href = "/miniPJ/member/memberUpdateForm.do?id=${sessionScope.sessionId}"
	}
</script>
</body>
</html> --%>
success