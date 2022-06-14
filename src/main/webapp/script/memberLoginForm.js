/**
 * 
 */
function memberUpdateButton(){
	location.href='http://localhost:8080/miniPJ/member/memberUpdateForm.do';	
}

$('#logoutButton').click(function(){
	if(confirm('정말로 로그아웃?')){
		location.href = 'http://localhost:8080/miniPJ/member/logout.do'
	}
})

/*$('#memberUpdateButton').click(function(){
	
	$.ajax({
		url: 'http://localhost:8080/miniPJ/member/memberUpdateForm.do',
		type: 'post',
		dataType: 'html',
		success : function(result){
			$('#section').html(result);
		},
		error : function(error){
			console.log(error);
		} 
	})
})

*/
	
$('#loginButton').click(function(){
	$('#idDiv').empty();
	$('#pwdDiv').empty();
	$('#loginResultDiv').empty();
	
	if($('#id').val() === ''){
		$('#idDiv').html('아이디를 입력하세요!');
		$('#idDiv').css({'color':'magenta',
		'font-size':'8pt',
		'font-weight':'bold',
		'background':'yellow'
		});
		
	}else if($('#pwd').val() === ''){
		$('#pwdDiv').html('비밀번호를 입력하세요!');
		$('#pwdDiv').css({'color':'magenta',
		'font-size':'8pt',
		'font-weight':'bold',
		'background':'yellow'
		});
	}else{
		$.ajax({
			url: 'http://localhost:8080/miniPJ/member/login.do',
			type: 'post',
			/* data: 'id=' + $('#idWrite').val(), */
			data : {id:$('#id').val(),
					pwd:$('#pwd').val()},
			dataType: 'text' /*'html'*//* 서버로부터 받는 데이터 형식 */,
			success : function(result){
				result = result.trim().substring(1,100);/* 공백제거를 위하여 */
				console.log('result : ' + result);
				
				if(result.includes('sessionAccess')){
					alert('로그인에 성공했습니다.');
					location.href="/miniPJ";
				}else{
					$('#loginResultDiv').html('로그인에 실패하였습니다.');
				}
			},
			error : function(error){
				console.log(error);
			} 
		});
	}
})
			