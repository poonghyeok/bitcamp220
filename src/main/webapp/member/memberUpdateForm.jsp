<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form name = "memberUpdateForm" id = "memberUpdateForm" action="/miniPJ/member/memberUpdate.do" method = "post">
	<h3>회원정보수정</h3>
		<table>
			<tr>
				<td class = "attribute">이름</td>
				<td><input type = "text" name = "nameWrite" id = "nameWrite" >
					<div id = "nameDivWrite" style = " color : red;"></div>
				</td>
			
			</tr>
			
			<tr>
				<td class = "attribute">아이디</td>
				<td><input type = "text" name = "idWrite" id = "idWrite" readonly="readonly">
					<input type = "button" value = "중복확인" onclick = "checkDuplicate();" readonly="readonly" >
					<div id = "idDivWrite" style="color: red;"></div>
				</td>
			</tr>
			
			<tr>	
				<td class = "attribute">비밀번호</td>
				<td><input type = "password" name = "pwdWrite" id = "pwdWrite" placeholder = "수정할 비밀번호"></td>
			</tr>
			 	
			<tr>
				<td class = "attribute">비밀번호재확인</td>
				<td><input type = "password" name = "pwd2Write" id = "pwd2Write" placeholder = "수정할 비밀번호 재입력">
				<div id = "pwdDivWrite" style = " color : red;"></div>
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
					<input type = "button" value = "회원정보수정" id = "checkValOrSubmit">
					<input type = "button" value = "다시작성" onclick = "updateFormReload();">
				</td>
			</tr>
			
		</table>
	</form>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src = "http://localhost:8080/miniPJ/script/memberUpdateForm.js"></script>
	<script type="text/javascript">
	/*한명의 data만 받아오고 싶다. 여기서 json이 활용되나. 한명검색할 때 id는 그냥 session에 있는 값 사용하면 되니깐 굳이 뭐 넘겨줄 필요없다.*/
	$(function(){
		
		$.ajax({
			type : 'post',
			url : '/miniPJ/member/getMember.do',
			dataType : 'json',
			success : function(member){
				console.log(member);
				$('input[name="nameWrite"]').val(member.name);
				$('input[name="idWrite"]').val(member.id);
				$('input[name="gender"][value="'+member.name+'"]').prop('checked', true);
				$('input[name="email1"]').val(member.email1);
				$('input[name="email2"]').val(member.email2);
				$('input[name="tel1"]').val(member.tel1);
				$('input[name="tel2"]').val(member.tel2);
				$('input[name="tel3"]').val(member.tel3);
				$('input[name="zipcode"]').val(member.zipcode);
				$('input[name="address1"]').val(member.address1);
				$('input[name="address2"]').val(member.address2);
			},
			error : function(err){
				console.log(err);
			}
		})
	})
	
	$('#checkValOrSubmit').click(function(){
		$('#nameDivWrite').empty();
		$('#pwdDivWrite').empty();
		
		if($('#nameWrite').val() === ''){
			$('#nameDivWrite').html('이름을 입력하세요 제이쿼리!');
		}else if($('#pwdWrite').val() === ''){
			$('#pwdDivWrite').html('변경할 비밀번호를 입력해주세요 제이쿼리!');
		}else if($('#pwdWrite').val() !== $('#pwd2Write').val()){
			$('#pwdDivWrite').html('동일한 비밀번호를 입력해주세요 제이쿼리!');
		}else{
			/* $('#memberUpdateForm').submit(); */
			$.ajax({
				type: 'post',
				url : '/miniPJ/member/memberUpdate.do',
				data : $('#memberUpdateForm').serialize(),
				/* serialize만 해주고 넘겨도 &로 구분되어서 넘어가기 때문에 서블릿에서 다 받아먹을 수 있다. get방식으로 보냈을 때 &로 구분되어서 딜리버 되는 것처럼 */
				success:function(){
					console.log($('#memberUpdateForm').serialize());
					alert('회원정보를 수정하였습니다..');
					location.href = '/miniPJ';
				},
				error : function(err){
					console.log(err);
				}
			});
		}
	})
				
	</script>
	
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
	
	<script type="text/javascript">
		
		
		/* function checkValOrSubmit(){
			document.getElementById("nameDivWrite").innerText = "";
			document.getElementById("pwdDivWrite").innerText = "";
			
			if(document.getElementById("nameWrite").value === ""){
				document.getElementById("nameDivWrite").innerText = "이름을 입력해주세요!";
			}else if(document.getElementById("pwdWrite").value === ""){
				document.getElementById("pwdDivWrite").innerText = "변경할 비밀번호를 입력해주세요!";
			}else if(document.getElementById("pwdWrite").value !== document.getElementById("pwd2Write").value){
				document.getElementById("pwdDivWrite").innerText = "비밀번호가 서로 달라요!";
			}else{
				document.memberUpdateForm.submit();
			}
		} */
		
	    /* function loadExistingData(){
			document.memberUpdateForm.nameWrite.value = '${requestScope.userData.getName()}'
			document.memberUpdateForm.idWrite.value = '${requestScope.userData.getId()}'
		
			if('${requestScope.userData.getGender()}' === 'male'){
				document.getElementById('maleRadio').checked = true;
				document.getElementById('femaleRadio').checked = false;
			}else{
				document.getElementById('maleRadio').checked = false;
				document.getElementById('femaleRadio').checked = true;
			}
			
			document.memberUpdateForm.email1.value = '${requestScope.userData.getEmail1()}'
			document.memberUpdateForm.email2.value = '${requestScope.userData.getEmail2()}'
							
			document.memberUpdateForm.tel1.value = '${requestScope.userData.getTel1()}'
			document.memberUpdateForm.tel2.value = '${requestScope.userData.getTel2()}'
			document.memberUpdateForm.tel3.value = '${requestScope.userData.getTel3()}'
			
			document.memberUpdateForm.zipcode.value = '${requestScope.userData.getZipcode()}'
			document.memberUpdateForm.address1.value = '${requestScope.userData.getAddress1()}'
			document.memberUpdateForm.address2.value = '${requestScope.userData.getAddress2()}'
		} */
	    
	    function updateFormReload(){
	    	window.location.reload();	
	    }
	    
	    /* window.onload = loadExistingData; */
	    
	</script>
	
</body>
</html>