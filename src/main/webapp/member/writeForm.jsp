<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>


<style>
	#writeForm {
		padding : 10px;
		padding-left : 100px; 
		width : 800px;
	}
	
	#writeForm h3{
		padding-left : 150px; 
	}
	
	#writeForm table{
		border: 1px solid black;
		border-collapse: collapse;
		width : 400px;
		cellpadding : 5;
	}
	#writeForm th, td {
	  border: 1px solid black;
	  border-collapse: collapse;
	}
	#writeForm .attribute{
		text-align : center;
	}
</style>

<body>
	<form name = "writeForm" id = "writeForm" action="/miniPJ/member/write.do" method = "post">
	<h3>회원가입</h3>
		<table>
			<tr>
				<td class = "attribute">이름</td>
				<td><input type = "text" name = "nameWrite" id = "nameWrite" placeholder = "이름">
					<div id = "nameDivWrite" style = "color : red; background: yellow;"></div>
				</td>
			
			</tr>
			
			<tr>
				<td class = "attribute">아이디</td>
				<td><input type = "text" name = "idWrite" id = "idWrite" placeholder = "아이디">
					<input type = "button" value = "중복확인" onclick = "checkWriteDuplicate();">
					<div id = "idDivWrite" style = "color : red; background: yellow;"></div>
				</td>
			</tr>
			
			<tr>	
				<td class = "attribute">비밀번호</td>
				<td><input type = "password" name = "pwdWrite" id = "pwdWrite" placeholder = "비밀번호"></td>
			</tr>
			 	
			<tr>
				<td class = "attribute">비밀번호재확인</td>
				<td><input type = "password" name = "pwd2Write" id = "pwd2Write" placeholder = "비밀번호 재입력">
				<div id = "pwdDivWrite" style = "color : red; background: yellow;"></div>
			</tr>
			
			<tr>
				<td class = "attribute">성별</td>
				<td>
					 <div>
						<input type="radio" id="maleRadio" name="gender" value="male"
						checked>
						<label for="maleRadio">남자</label>
						<input type="radio" id="femaleRadio" name="gender" value="female">
						<label for="femaleRadio">여자</label>
					</div>
				</td>
			</tr>
			
			<tr>
				<td class = "attribute">이메일</td>
				<td>
					<input type = "text" name = "email1">
					@
					<input type = "email" list = "email2" name = "email2" placeholder = "직접입력">
					<datalist id = "email2">
						<option value = "gmail.com">
						<option value = "daum.net">
						<option value = "naver.com">
					</datalist>
				</td>
			</tr>
			
			<tr>
				<td class = "attribute">핸드폰</td>
				<td>
					<input type="text" id="tel1" name="tel1" placeholder = "010" style = "width : 50px">-
					<input type="text" id="tel2" name="tel2" placeholder = "1234" style = "width : 200px">-
					<input type="text" id="tel3" name="tel3" placeholder = "5678" style = "width : 200px">	
				</td>
			</tr>
			
			<tr>
				<td class = "attribute">주소</td>
				<td>
				<input type = "text" name = "zipcode" id = "zipcode" placeholder = "우편 번호" readonly>
				<input type = "button" value = "주소검색" onclick = "sample6_execDaumPostcode();">
				<input type = "text" name = "address1" id = "address1" placeholder = "기본 주소" readonly>
				<input type = "text" name = "address2" id = "address2" placeholder = "상세주소 입력 ">
				</td>
			</tr>
			
			<tr>
				<td colspan = 2 align = "center">
					<input type = "button" value = "회원가입" onclick = "checkWrite();">	
					<input type = "reset" value = "다시작성" >
					<div id = "checkDivWrite" style = "color: red; background: yellow;"></div>
				</td>
			</tr>
			
		</table>
	</form>
	
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
	function sample6_execDaumPostcode() {
	    new daum.Postcode({
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	
	            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	            var addr = ''; // 주소 변수
	
	            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                addr = data.roadAddress;
	            } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                addr = data.jibunAddress;
	            }
	
	   
	
	            // 우편번호와 주소 정보를 해당 필드에 넣는다.
	            document.getElementById('zipcode').value = data.zonecode;
	            document.getElementById("address1").value = addr;
	            // 커서를 상세주소 필드로 이동한다.
	            document.getElementById("address2").focus();
	        }
	    }).open();
	}
	
	</script>
	
	<script>
		var checkDuplicate = {
			buttonClick : false,
			checkedId : ""
		};
	
		/* function isFullName(){
			document.getElementById("nameDivWrite").innerText = "";
			nameDivInner = document.getElementById("nameDivWrite").innerText;
			nameVal = document.writeForm.nameWrite.value;
			
		}
		
		function iFullPwd(){
			document.getElementById("pwdDivWrite").innerText = "";
            pwdDivInner = document.getElementById("pwdDivWrite").innerText;  
			pwdVal = document.writeForm.pwdWrite.value;                      
			pwd2Val = document.writeForm.pwd2Write.value;                    
		} */
	
		function checkWrite(){
			document.getElementById("nameDivWrite").innerText = "";
			document.getElementById("pwdDivWrite").innerText = "";
			document.getElementById("checkDivWrite").innerText = "";
			document.getElementById("idDivWrite").innerText = "";
			
			var nameDivInner = document.getElementById("nameDivWrite").innerText;
			var nameVal = document.writeForm.nameWrite.value;
			
			var idDivInner = document.getElementById("idDivWrite").innerText;
			var idVal = document.writeForm.idWrite.value;		
			
			var pwdDivInner = document.getElementById("pwdDivWrite").innerText;
			var pwdVal = document.writeForm.pwdWrite.value;
			var pwd2Val = document.writeForm.pwd2Write.value;
			
			var checkDivInner = document.getElementById("checkDivWrite").innerText;
			
				if(nameVal === ""){
					document.getElementById("nameDivWrite").innerText = "이름을 입력해주세요 !";
				}else if(idVal === ""){
					document.getElementById("idDivWrite").innerText = "id를 입력해주세요!";
				}else if(pwdVal === ""){
					document.getElementById("pwdDivWrite").innerText = "비밀번호를 입력해주세요 !";
				}else{
					if(pwdVal !== pwd2Val){
						document.getElementById("pwdDivWrite").innerText = "비밀번호가 다릅니다!";
				 	}else{
				 		if(checkDuplicate.buttonClick === false){
				 			document.getElementById("checkDivWrite").innerText ="중복확인을 완료하세요!"
						}else{
							if(idVal !== checkDuplicate.checkedId){
								document.getElementById("checkDivWrite").innerText = "중복확인이 완료된 아이디를 사용하셔야합니다!";
							}else{
								document.writeForm.submit();
							}
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

		function checkWriteDuplicate(){
			const deliveredId = document.writeForm.idWrite.value;
			if(deliveredId === ""){
				document.getElementById("idDivWrite").innerText = "id를 입력해주세요!";
			}else{
				document.getElementById("idDivWrite").innerText = "";
				window.open("http://localhost:8080/miniPJ/member/checkDuplicate.do?id=" + deliveredId,"duplicate","width=150 heigth=80 left = 200 top = 200");
			}

		}

	
	</script>
	
</body>
</html>