/**
 * 
 */

$('#idWrite').focusout(function(){
				if($('#idWrite').val() === ''){
					$('#idDivWrite').html('먼저 아이디를 입력하세요!');
					$('#idDivWrite').css('color','magenta');
					$('#idDivWrite').css('font-size','8pt');
					$('#idDivWrite').css('font-weight','bold');
				}else{
					$.ajax({
						url: 'http://localhost:8080/miniPJ/member/checkDuplicate.do',
						type: 'post',
						/* data: 'id=' + $('#idWrite').val(), */
						data : {id:$('#idWrite').val()},
						dataType: 'text'/* 서버로부터 받는 데이터 형식 */,
						
						success : function(result){
							result = result.trim();/* 공백제거를 위하여 */
							
							if(result == 'exist'){
								$('#idDivWrite').html('사용불가능..');
							}else if (result == 'nonexist'){
								$('#idDivWrite').html('사용가능..');
								$('#checkedId').val($('#idWrite').val());		
							}
						},
						error : function(error){
							console.log(error);
						} 
					});
				}
			})
			
$('#writeButton').click(function(){
	$('#nameDivWrite').empty();
	$('#pwdDivWrite').empty();
	
	if($('#nameWrite').val() === ''){
		$('#nameDivWrite').html('이름을 입력해주세요');
	}else if($('#pwdWrite').val() === '' || $('#pwd2Write').val() === ''){
		$('#pwdDivWrite').html('비밀번호를 모두 입력해주세요');
	}else if($('#pwdWrite').val() !== $('#pwd2Write').val()){
		$('#pwdDivWrite').html('동일한 비밀번호를 입력해주세요');
	}else{
		$.ajax({
			url: 'http://localhost:8080/miniPJ/member/write.do',
			type: 'post',
			/* data: 'id=' + $('#idWrite').val(), */
			data : {
				nameWrite : $('#nameWrite').val(),
				idWrite : $('#idWrite').val(),
				pwdWrite : $('#pwdWrite').val(),
				gender : $('input[type="radio"]:checked').val(),
				email1 : $('#email1').val(),
				email2 : $('#email2').val(),
				tel1 : $('#tel1').val(),
				tel2 : $('#tel2').val(),
				tel3 : $('#tel3').val(),
				zipcode : $('#zipcode').val(),
				address1 : $('#address1').val(),
				address2 : $('#address2').val(),
			}
			,/* 여기다가 SUCCESS 사용해서 회원가입 되자마자 로그인되게 할 수 있으려나*/
			error : function(error){
				console.log(error);
			}
			,
			complete : function(){
				alert('회원가입을 완료했습니다!');
				location.href="/miniPJ";
			}				
		});
	}
})

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
	
	
