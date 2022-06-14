<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<style>
		#loginForm table{
			border : 3px solid black;
		}
	</style>
	
	<form name  ="loginForm" id = "loginForm" action = "/miniPJ/member/login.do" method = "post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type = "text" name = "id" id = "id" placeholder = "아이디">
				<div id = "idDiv" style = "color : red;"></div>
				</td>
				
			</tr> 
			
			<tr>
				<td>비밀번호</td>
				<td><input	 type = "password" name = "pwd" id = "pwd" placeholder = "비밀번호">
				<div id = "pwdDiv" style = "color : red;"></div>
				</td>
			
			</tr>
			
			<tr>
				<td colspan = 2 align = "center"> <input type = "button" value = "로그인" id="loginButton">
				<input type = "button" value = "회원가입" onclick="location.href='/miniPJ/member/writeForm.do'">
			 	<div id = "loginResultDiv"></div>
			 </td>
			</tr>
			
		</table>
	</form>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src = "http://localhost:8080/miniPJ/script/memberLoginForm.js"></script>
		