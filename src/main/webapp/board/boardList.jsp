<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록 조회</title>
	<link rel="stylesheet" href="/miniPJ/board/css/cssBoardList.css">
</head>

<body>
<!-- 여기서 request 객체에ArrayList가 들어있고 list에는 BoardDTO가 담겨있다. -->
<h3>글목록</h3>
<input type="hidden" id="forTrigger">
<div id = "boardListTbl">
	<form name = "boardDetailValueForm">
	<input id = "sessionId" type="text" value="${sessionScope.sessionId}">
	<input id = "pg" type="text" value="${requestScope.pg}">
	<table id = "boardListTable">
		<tr id="titleRow">
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>	
			<!-- 작성자를 닉네임 (아이디 형태로 표시해보자) -->
			<th>작성일</th>
			<th>조회수</th>
			<!-- <th>글관리</th> -->
		</tr>
				
			<%-- <c:forEach var = "row" items = "${requestScope.elements}">
				<tr>
					<td class = "subcol">${row.getSeq()}</td>
					
					<td class = "maincol" style="text-align: left;">
				 		<a class = "subjectA"> <!--onclick="isLogined(${row.getSeq()},${param.pg});" -->
							<span id = "debuging" style = " border: 1px solid red; ">글의 seq : ${row.getSeq()}</span>
			  				
								<input type="hidden" name = "pg" value ="${requestScope.pg}">
								<input type="hidden" name = "detailSeq" value ="${row.getSeq()}">
							
							<c:forEach var="i" begin="1" end="${row.getLev()}" step="1">
								&emsp; 
							</c:forEach>
							<c:if test="${row.getLev() > 0}">
							<img alt="replyGIF" src="/miniPJ/img/replyArrow.gif">
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
			</c:forEach>  --%>
	</table>
	<!-- 제이쿼리로 동적처리를 활용해 밀어넣겠다.  -->
		<div class = "pageControl">
			<span class = "toWriteForm"> 
				<input type = "button" value = "글작성" id="listBoardWriteButton">
			</span>
			
			<span>
				<div id = "pageNumList"><%-- ${requestScope.boardPaging.getPagingHTML()} --%></div>
			</span>
		</div> <!-- div : pageControl  -->
		</form>
	</div> <!-- boardListTbl -->
	<!-- function to search  -->
	<p/>
	
	<!-- boardSearch -->
	<form name="searchForm" id = "searchForm">
		<select name="searchOption" id="searchOption">
			<option value="author">작성자id</option>
			<option value="subject" selected>제목</option>
		</select>
		<input type="text" name="searchCondition" id = "searchCondition">
		<input type="button" id="listSearchButton" value = "검색">
		<div id="searchAlert"></div>
	</form>
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="http://localhost:8080/miniPJ/script/boardList.js"></script>
	<script type="text/javascript">
	</script>

</body>
</html>