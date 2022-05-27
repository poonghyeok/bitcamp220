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
				<td colspan = 2 align = "center"> <input type = "button" value = "로그인" onclick="checkLoginData();">
				<input type = "button" value = "회원가입" onclick="location.href='/miniPJ/member/writeForm.do'">
			 </td>
			</tr>
			
		</table>
	</form>
	<script>
		function checkLoginData(){
			document.getElementById("idDiv").innerText = "";
			document.getElementById("pwdDiv").innerText = "";
			
			if(document.getElementById("id").value === ""){
				document.getElementById("idDiv").innerText = "아이디를 입력해주세요 ";
			}else if(document.getElementById("pwd").value === ""){
				document.getElementById("pwdDiv").innerText = "비밀번호 입력해주세요 ";
			}else{
				document.loginForm.submit();
			}
			
		}
	</script>