<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 검색</title>
	<link rel="stylesheet" href="./css/cssBoardList.css" type="text/css">
</head>

<body>
<!-- 여기서 request 객체에ArrayList가 들어있고 list에는 BoardDTO가 담겨있다. -->
<h3>검색된 목록</h3>
<h3>test로 뽑아보기 : ${requestScope.searchList.get(0).getSubject()}</h3>
<div id = "boardListTbl">
	<form name = "boardDetailValueForm">
		<input type="hidden" id="seq" name="seq" value="">
		<input type="hidden" id="pg" name="pg" value="">
	<table>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>		
			<th>작성일</th>
			<th>조회수</th>
		</tr>
				
			<c:forEach var = "row" items = "${requestScope.searchList}">
				<tr>
					<td class = "subcol">${row.getSeq()}</td>
					<td class = "maincol" style="text-align: left;">
				 		<a id = "subjectA"  onclick="isLogined(${row.getSeq()},${param.pg});"> <!-- -->
							<span id = "debuging" style = "border: 1px solid red;">글의 seq : ${row.getSeq()}</span>
							<input type="hidden" name = "pg" value ="${requestScope.pg}">
							<input type="hidden" name = "detailSeq" value ="${row.getSeq()}">
							<c:forEach var="i" begin="1" end="${row.getLev()}" step="1">
								&emsp; 
							</c:forEach>
							<c:if test="${row.getLev() > 0}">
							<img alt="replyGIF" src="../img/replyArrow.gif">
							</c:if>
							${row.getSubject()}
						</a>
					</td>
			
					<td class = "subcol">
						${row.getName()}(${row.getId()})
					</td>
					<td class = "subcol">${row.getLogtime()}</td>
					<td class = "subcol">${row.getHit()}</td>
				</tr>
			</c:forEach> 
	</table>
	
		<div class = "pageControl">
			<span class = "toWriteForm"> 
				<input type = "button" value = "글작성" onclick="location.href='/miniPJ/board/boardWriteForm.do'">
			</span>
			
			<span class = "pageNumList">
				<div>${requestScope.boardPaging.getPagingHTML()}</div>
			</span>
		</div> <!-- div : pageControl  -->
		
		</form>
	</div> <!-- boardListTbl -->
	<!-- function to search  -->
	<p/>
	
	<form name="searchForm">
		<select name="searchOption" id = "searchOption">
			<option value="author">작성자id</option>
			<option value="subject" selected>제목</option>
		</select>
		<input type="text" name="searchCondition" id = "searchCondition">
		<input type="button" onclick="searchList();" value = "검색">
	</form>
	
	<script type="text/javascript">
		function searchList(){
			let searchCondtion = (document.searchForm.searchCondition.value !== '');
			console.log("searchList 조건 출력 : " + (document.searchForm.searchCondition.value !== ''));
			if(searchCondtion){
				document.searchForm.method = "post";
				document.searchForm.action = "/miniPJ/board/boardSearch.do?pg=1";
				document.searchForm.submit();
			}else{
				alert('검색할 내용을 제대로 입력해주세요!');
				document.searchForm.searchCondition.focus();
			}
			
		}	  
		function isLogined(seq,pg){
			if(${empty sessionScope.sessionId}){
				alert('글을 조회하려면 로그인이 필요합니다. 먼저 로그인을 해주세요.');
			}else{
				document.boardDetailValueForm.method = "post";
				document.boardDetailValueForm.action = "/miniPJ/board/boardDetail.do";
				document.getElementById("seq").value = seq;
				document.getElementById("pg").value = pg;
				/* 	@@@href = "/miniPJ/board/boardDetail.do?pg=${param.pg}&seq=${row.geatSeq()}" */
				document.boardDetailValueForm.submit();
			}
		}
		/* window.onload = isLogined(${sessionScope.sessionId}); */

		function boardPaging(pg2){
			document.searchForm.method = "post";
			document.searchForm.action = "/miniPJ/board/boardSearch.do?pg="+pg2;
			document.searchForm.submit();
		
		}
		
		window.onload = function searchDefault(){
			
			let reqSearchOption = '${requestScope.searchOption}';
			let reqSearchCondition = '${requestScope.searchCondition}';
			console.log(reqSearchOption, reqSearchCondition);
			
			var temp = reqSearchOption;
			var mySelect = document.getElementById('searchOption');

			for(var i, j = 0; i = mySelect.options[j]; j++) {
			    if(i.value == temp) {
			        mySelect.selectedIndex = j;
			        break;
			    }
			}
			document.getElementById('searchCondition').value = reqSearchCondition;
		}
		
	</script>

</body>
</html>