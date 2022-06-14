/**
 * 
 */

/*window.onload = function insertOld(){
	document.boardForm.subject.value = '${requestScope.oldBoard.getSubject()}';
	document.getElementById("content").innerHTML = '${requestScope.oldBoard.getContent()}';
}
*/
	
/*function check(){
	const subjectEle = document.getElementById('subject');
	const contentEle = document.getElementById('content');
	const subjectDiv = document.getElementById('subjectDiv');
	const contentDiv = document.getElementById('contentDiv');

	subjectDiv.innerText = "";
	contentDiv.innerText = "";
	
	if(subjectEle.value === ""){
		subjectDiv.innerText = "제목을 입력해야합니다.";
	}else{
		if(contentEle.value === ""){
			contentDiv.innerText = "내용을 입력해야합니다.";
		}else{
			document.boardForm.method = "post";
			document.boardForm.action = "http://localhost:8080/miniPJ/board/boardUpdate.do";
			document.boardForm.submit();  	
		}
	}
}*/
$(function(){
	console.log('ajax data seq :' + $('#seq').val() + ' pg : ' + $('#pg').val());
	$.ajax({
		type : 'post',
		url : '/miniPJ/board/getBoardUpdateForm.do',
		data : {seq : $('#seq').val(),
				pg : $('#pg').val()
				},
		dataType : 'json',
		success : function(data){
			$('#subject').val(data.subject);
			$('#content').val(data.content);
		},
		error : function(err){
			console.log(err);
		}
	})
})

$('#resetButton').click(function(){
	if(confirm('수정한 내용이 초기화 됩니다. 정말 다시 작성하시겠습니까? ')){
		$.ajax({
		type : 'post',
		url : '/miniPJ/board/getBoardUpdateForm.do',
		data : {seq : $('#seq').val(),
				pg : $('#pg').val()
				},
		dataType : 'json',
		success : function(data){
			$('#subject').val(data.subject);
			$('#content').val(data.content);
		},
		error : function(err){
			console.log(err);
		}
	})
	}
})

$('#boardUpdateButton').click(function(){
	$('#subjectDiv').empty();
	$('#contentDiv').empty();
	
	var subjectEle = $('#subject').val();
	var contentEle = $('#content').val();
	
	if(subjectEle == ''){
		$('#subjectDiv').html('제목입력 제이쿼리!');
	}else if(contentEle == ''){
		$('#contentDiv').html('내용입력 제이쿼리!');
	}else{
		$.ajax({
			type : 'post',
			url : 'http://localhost:8080/miniPJ/board/boardUpdate.do',
			data : $('#boardForm').serialize(),
			dataType : 'json',
			success : function(page){
				console.log($('#boardForm').serialize());
				alert('글 수정이 완료되었습니다.');
				location.href='http://localhost:8080/miniPJ/board/boardDetail.do?pg='+page.pg+'&seq='+page.seq;			
			},
			eror : function(err){
				console.log(err);
			}
		})
	}
		
})
		