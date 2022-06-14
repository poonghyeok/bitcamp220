/**
 * 
 */
$('#menuWriteButton').click(function(){
	location.href = 'http://localhost:8080/miniPJ/board/boardWriteForm.do';
	/*$.ajax({
		url: 'http://localhost:8080/miniPJ/board/boardWriteForm.do',
		type: 'post',
		dataType : 'html',
		success : function(result){
			$('div#section').html(result);	
		}
		,
		error : function(error){
			console.log(error);
		} 
	});
	*/
})
	
$('#boardWriteButton').click(function(){
	$('#subjectDiv').empty();
	$('#contentDiv').empty();
	
	if($('#subject').val() === ''){
		$('#subjectDiv').html('제목 입력하세요! 제이쿼리!');
		
	}else if($('#content').val() === ''){
		$('#contentDiv').html('내용을 입력하세요! 제이쿼리!');
		
	}else{
		$.ajax({
			url: 'http://localhost:8080/miniPJ/board/boardWrite.do',
			type: 'post',
			data : $('#boardForm').serialize(),
			success : function(){
				console.log('boardFomr 시리얼 ::: ' + $('#boardForm').serialize);
				alert('글 작성을 완료했습니다..!');
				location.href = '/miniPJ';
			}
			,
			error : function(error){
				console.log(error);
			} 
		});
	}
});


$('#boardListButton').click(function(){
	location.href = 'http://localhost:8080/miniPJ/board/boardList.do?pg=1';
/*	$.ajax({
		l
		url: 'http://localhost:8080/miniPJ/board/boardList.do?pg=1',
		type: 'post',
		dataType : 'html',
		success : function(result){
			$('div#section').html(result);
		}
		,
		error : function(error){
			console.log(error);
		} 
	});
*/	
})

	
 