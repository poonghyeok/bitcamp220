/**
 * 
 */
function checkLogin(){
	document.getElementById("nameDiv").innerText = "";
	document.getElementById("pwdDiv").innerText = "";
	
	if(document.getElementById("name").value === ""){
		document.getElementById("nameDiv").innerText = "이름이 없다 이름이...";
	}else if(document.getElementById("pwd").value !== document.getElementById("pwd2").value){
		document.getElementById("pwdDiv").innerText = "비밀번호 다르다";
	}else{
		document.writeForm.submit();
	}
}

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

	
