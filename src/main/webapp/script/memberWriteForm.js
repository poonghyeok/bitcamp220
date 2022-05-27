/**
 * 
 */
let checkDuplicate = {
	buttonClick = false,
	checkedId = ""
};
 
function checkWrite(){
		document.getElementById("nameDivWrite").innerText = "";
		document.getElementById("pwdDivWrite").innerText = "";
		document.getElementById("checkDivWrite").innerText = "";
		
		if(document.getElementById("nameWrite").value === ""){
			document.getElementById("nameDivWrite").innerText = "이름이 없다 이름이...";
		}else if(document.getElementById("pwdWrite").value !== document.getElementById("pwd2Write").value){
			document.getElementById("pwdDivWrite").innerText = "비밀번호 다르다";
		}else {
			if(checkDuplicate.buttonClick === false){
				document.getElementById("checkDivWrite").innerText="중복확인을 완료하세요!"
			}else{
				if(document.writeForm.id.value !== checkDuplicate.checkedId){
					document.getElementById("checkDivWrite").innerText = "중복확인이 완료된 아이디를 사용하셔야합니다!";
				}else{
					document.writeForm.submit();
				}
			}
		}
}

function checkLogData(){
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

function checkDuplicate(){
	const deliveredId = document.writeForm.idWrite.value;
	if(deliveredId === ""){
		document.getElementById("idDivWrite").innerText = "id를 입력해주세요!";
	}else{
		document.getElementById("idDivWrite").innerText = "";
		window.open("/miniPJ/member/checkDuplicate.do?id=" + deliveredId,"duplicate","width=150 heigth=80 left = 200 top = 200");
	}

}
