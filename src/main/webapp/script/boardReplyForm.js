/**
 * 
 */
 
$(function(){
	
});


$('#boardReplyButton').click(function(){
	var subjectEle = $('#subject').val();
	var contentEle = $('#content').val();
	
	$('#subjectDiv').empty();
	$('#contentDiv').empty();
	
	if(subjectEle === ''){
		$('#subjectDiv').html('제목을 입력해주세요 제이쿼리!');
	}else if(contentEle === ''){
		$('#contentDiv').html('내용을 입력해주세요 제이쿼리!');
	}else{
		$.ajax({
			type : 'post',
			url : 'http://localhost:8080/miniPJ/board/boardReply.do',
			data : $('#boardReplyForm').serialize(),
			dataType : 'json', /*dataType이란걸 제대로 입력하지 않아서 디폴트인 text로 데이터가 들어왔다. */
			success : function(data){
				location.href='http://localhost:8080/miniPJ/board/boardDetail.do?pg='+data.pg+'&seq='+data.seq;
			},
			error : function(err){
				console.log(err);
			}
		})
	}
});

/*function submitPost(actionPath){
	document.boardReplyForm.method = "post";
	document.boardReplyForm.action = actionPath;
	document.boardReplyForm.submit(); 
}
	
function check(actionPath){
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
			submitPost(actionPath);  	
		}
	}
}

function replyButton(){
	let actionPath = "http://localhost:8080/miniPJ/board/boardReply.do";
	check(actionPath);
}*/