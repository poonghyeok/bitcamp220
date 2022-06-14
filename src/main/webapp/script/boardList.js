/**
 *	왜 window onload 안먹힐까 내가 뭘 놓치고 있는걸까. window.onload는 왜 ㅇ 
 let reqSearchOption = '${requestScope.searchOption}';
	let reqSearchCondition = '${requestScope.searchCondition}';
	console.log('searchDefault'+ reqSearchOption + reqSearchCondition);
 */
 
 /* 페이지 넘기기 구현 이게 최선? */
 $(document).on('click', 'span.listPage', function(){
	alert('span tag clicked!!');
	let clickedVal = $(this).text().trim();
	let curPage = parseInt($('span#currentPaging').text());
	let nextPage;
			
	console.log("click a tag : " + clickedVal); 
	
		if(clickedVal.includes('다음') || clickedVal.includes('이전')){
			if(clickedVal.includes('다음')){
				nextPage = curPage + 1;
			}else if(clickedVal.includes('이전')){
				nextPage = curPage - 1;
			}
		}else{
			nextPage = clickedVal;
		}
	console.log("next page : " + nextPage);
	$('#pg').val(nextPage);
	$('#forTrigger').trigger('custom');
});

$(document).on('click', 'span.searchListPage', function(){
	alert('search List span tag clicked!!');
	let searchCondition = $('#searchCondition').val();
	let searchOption = $('#searchOption').val();
	let clickedVal = $(this).text().trim();
	let curPage = parseInt($('span#currentPaging').text());
	let nextPage;		
	console.log("click a tag : " + clickedVal); 
	
		if(clickedVal.includes('다음') || clickedVal.includes('이전')){
			if(clickedVal.includes('다음')){
				nextPage = curPage + 1;
			}else if(clickedVal.includes('이전')){
				nextPage = curPage - 1;
			}
		}else{
			nextPage = clickedVal;
		}
		$('#pg').val(nextPage);
		$('#listSearchButton').trigger('click');
		$('#pg').val(1);
		
	}
);

/*custom 트리거 만들기 */
$('#forTrigger').on('custom', function(triggerError, triggerData){
	console.log('list custom trigger start!!');
	$.ajax({
		type : 'post',
		url : '/miniPJ/board/getBoardList.do',
		data: {
			'pg': $('#pg').val()
		},
		dataType : 'json',
		success: function(result){
				$('#boardListTable tr').not($('#titleRow')).empty();
				$.each(result.list, function(index, items){
					var levSpace = '';
					var subjectRow = $('<td/>');
					var iconReply = $('<img/>', {
						src : '/miniPJ/img/replyArrow.gif',
						alt : 'replyArrowGif'
					});
					
					for(var i = 0; i < items.lev; i++){
						subjectRow.append('&emsp;');
					}
					if(items.lev > 0 ){
						subjectRow.append(iconReply);
					}
					subjectRow.append($('<a>', {
									href : 'http://localhost:8080/miniPJ/board/boardDetail.do?pg='+$('#pg').val()+'&seq='+items.seq,
									id : 'subjectA_'+items.seq,
									class : 'subjectA',
									text : 'lev : ' + items.lev + items.subject
								}));
				
					$('<tr/>').append($('<td/>', {
									align : 'center',
									text : items.seq
								})
							).append(
								subjectRow
							).append($('<td/>', {
									align : 'center',
									text : items.id
								})
							).append($('<td/>', {
									align : 'center',
									text : items.logtime
								})
							).append($('<td/>', {
									align : 'center',
									text : items.hit
								})
						).appendTo($('#boardListTable'));
				// 로그인 여부 확인방법 1 
				});

				// 로그인 여부 확인방법 2
				$('#boardListTable').on('click', '#subjectA', function(){
					alert();
				
					if(result.sessionId == null){
						alert('먼저로그인! 에이잭스!');
					}else{
						var seq = $(this).parent().prev().text();
						location.href = '/miniPJ/board/boardView.do?seq='+seq+'&pg='+$('#pg').val();
					}
				})

				$('#pageNumList').html(result.pagingHTML)
				console.log('pageNumList :: ' + $('#pageNumList').html());
				},
		error : function(err){
			console.log(err);
		}
	})
})

/* list 목록 나타내기 */
$(function(){
	$('#pg').val(1);
	$('#forTrigger').trigger('custom');
	
})

$('#listBoardWriteButton').click(function(){
	alert('menuWriteButton clicked!');
	location.href='http://localhost:8080/miniPJ/board/boardWriteForm.do';
})

/*글 제목 클릭시, 글 상세보기 */
$(document).on('click', 'a.subjectA', function(){
	alert('a.subjectA clicked..!');
	
	if(!$('#sessionId').val()){
		alert('글을 조회하려면 먼저 로그인을 해주세요!');		
		return false;
	}else{
		location.href='http://localhost:8080/miniPJ/board/boardDetail.do?pg='+$('input[name="pg"]').val()+'&seq='+$('input[name="detailSeq"]').val();
	}
});

/*list search button click event */ 
$('#listSearchButton').click(function(){
	alert('listSearchButton clicked..!');
	let searchCondition = $('#searchCondition').val();
	let searchOption = $('#searchOption option:selected').val();
	if(searchCondition === ''){
		$('#searchAlert').html('검색어를 입력해주세요!');
		$('#searchAlert').css({'color':'red', 'background-color':'yellow'});
	}else{
		$.ajax({
			url: '/miniPJ/board/jQueryBoardSearch.do',
			type : 'post',
			data : { searchOption : searchOption,
				searchCondition : searchCondition,
				pg : $('#pg').val()
			},
			dataType : 'json',
			success: function(result){
				$('#boardListTable tr').not($('#titleRow')).empty();
				$.each(result.list, function(index, items){
					var levSpace = '';
					var subjectRow = $('<td/>');
					var iconReply = $('<img/>', {
						src : '/miniPJ/img/replyArrow.gif',
						alt : 'replyArrowGif'
					});
					
					for(var i = 0; i < items.lev; i++){
						subjectRow.append('&emsp;');
					}
					if(items.lev > 0 ){
						subjectRow.append(iconReply);
					}
					subjectRow.append($('<a>', {
									href : 'http://localhost:8080/miniPJ/board/boardDetail.do?pg='+$('#pg').val()+'&seq='+items.seq,
									id : 'subjectA_'+items.seq,
									class : 'subjectA',
									text : 'lev : ' + items.lev + items.subject
								}));
					
					$('<tr/>').append($('<td/>', {
								align : 'center',
								text : items.seq
							}))
							.append(subjectRow
							).append($('<td/>', {
								text : items.id
							}))
							.append($('<td/>', {
								text : items.logtime
							}))
							.append($('<td/>', {
								text : items.hit
							})).appendTo($('#boardListTable'));
				});
				
				$('#pageNumList').html(result.pagingHTML)
				
			},
			error : function(err){
				console.log(err);
			}
		})
	}
});

