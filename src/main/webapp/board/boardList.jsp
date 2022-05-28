<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록 조회</title>
	<link rel="stylesheet" href="./css/cssBoardList.css" type="text/css">
</head>

<body>
<!-- 여기서 request 객체에ArrayList가 들어있고 list에는 BoardDTO가 담겨있다. -->
<h3>글목록</h3>

<c:set var = "columSize" value = "13" />
<div id = "boardListTbl">
	<%-- <div id = "debuging" style = "border: 1px solid red;">글의 seq : ${row }</div> --%>
	<form name = "boardDetailValueForm">
		<input type="hidden" id="seq" name="seq" value="">
		<input type="hidden" id="pg" name="pg" value="">
	<table>
		<tr>
			<%-- <c:forEach var = "columnName" items = "${requestScope.columnNames}">
				<th>${columnName}</th>
			</c:forEach>
			 --%>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>	
			<!-- 작성자를 닉네임 (아이디 형태로 표시해보자) -->
			<th>작성일</th>
			<th>조회수</th>
			<!-- <th>글관리</th> -->
		</tr>
			<c:forEach var = "row" items = "${requestScope.elements}">
				<tr>
					<td class = "subcol">${row.getSeq()}</td>
					<%-- <td class = "subcol">${row.getId()}</td>
					 --%>
					<%-- <td class = "subcol">${row.getEmail()}</td>
					 --%>
					<td class = "maincol" style="text-align: left;">
						
							<a id = "subjectA"  onclick="isLogined(${row.getSeq()},${param.pg});"> <!-- -->
								<span id = "debuging" style = "border: 1px solid red;">글의 seq : ${row.getSeq()}</span>
								<%-- <input type="hidden" name = "pg" value ="${requestScope.pg}">
								<input type="hidden" name = "detailSeq" value ="${row.getSeq()}">
								 --%><%-- href = "/miniPJ/board/boardDetail.do?pg=${param.pg}&seq=${row.getSeq()}" --%>
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
					<%-- <td class = "maincol">${row.getContent()}</td>
					 --%>
					<%-- <td class = "subcol">${row.getLev()}</td>
					<td class = "subcol">${row.getStep()}</td>
					<td class = "subcol">${row.getPseq()}</td>
					<td class = "subcol">${row.getReply()}</td>
					 --%>
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
				<c:forEach var = "pageNum" begin = "1" end = "${requestScope.totalPageNum}" step = "1">
					<%-- pageNum : ${pageNum} || param.pg = ${param.pg} || pageNum == param.pg ${pageNum == param.pg}
					 --%>
					 <c:if test = "${pageNum == param.pg}" >
						<a id = "listLink" href = "/miniPJ/board/boardList.do?pg=${pageNum}" style = "color : red"> 
							[ ${pageNum} ]
						</a>
					</c:if>
					<c:if test="${pageNum != param.pg}" >
						<a id = "listLink" href = "/miniPJ/board/boardList.do?pg=${pageNum}" > 
							[ ${pageNum} ]
						</a>
					</c:if>
				</c:forEach>
			</span>
		</div> <!-- div : pageControl  -->
		</form>
	</div> <!-- boardListTbl -->
	
	<script type="text/javascript">
		  
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

	</script>
</body>
</html>