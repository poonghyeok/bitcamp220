/**
 * 
 */
$(function(){
    $.ajax({
		type : 'post',
		url : 'http://localhost:8080/miniPJ/board/getBoardDetail.do',
		data : {seq : $('#seq').val(),
				pg : $('#pg').val()},
		dataType : 'json',
		success : function(data){
			//여기서 json으로 넘어왔다. 
			$('#subject').html(data.subject);
			$('span#seqVal').html(data.seq);
			$('span#authorVal').html(data.id);
			$('span#hitVal').html(data.hit);
			$('#contentPre').html(data.content);
			
		},
		error : function(err){
		
			console.log(err);
		}
	})
}) 

function boardDetailSubmit(actionPath){
	document.boardDetailForm.method = "post";
	document.boardDetailForm.action = actionPath;
	document.boardDetailForm.submit();
}

//jquery로 삭제기능 구현하기 
$('#boardUpdateButton').click(function(){
	let sessionId = $('#sessionId').val();
	let authorId = $('#authorVal').text();
	
	if(sessionId !== authorId){
		alert('본인의 글만 수정 또는 삭제가 가능합니다.');
		return false;
	}else{
		let actionPath = "/miniPJ/board/boardUpdateForm.do";
		boardDetailSubmit(actionPath);
	}
})

$('#boardDeleteButton').click(function(){
	let sessionId = $('#sessionId').val();
	let authorId = $('#authorVal').text();
			
	if(sessionId !== authorId){
		alert('본인의 글만 수정 또는 삭제가 가능합니다.');
		return false;
	}else{
		if(confirm("정말로 삭제하시겠습니까?")){
			$.ajax({
				type : 'post',
				url : '/miniPJ/board/boardDelete.do',
				data : $('#boardDetailForm').serialize(),
				success : function(){
					alert('글을 삭제했습니다.');
					location.href = '/miniPJ/board/boardList.do?pg=1';
				},
				error : function(err){
					console.log(err);
				}
			})
		}
	}
})
		
function mode(num){
	if(num == 3){
		let actionPath = "/miniPJ/board/boardReplyForm.do";
		boardDetailSubmit(actionPath);
		
	}else if(num == 4){
		let actionPath = "/miniPJ/board/boardList.do?pg="+$('#pg').val();
		boardDetailSubmit(actionPath);
		
		/* document.boardDetailForm.method = "post";
		document.boardDetailForm.action = "/miniPJ/board/boardList.do";
		document.boardDetailForm.submit();
	 	*/
	}
}
		

 