<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
	.mainNavigation{
		background-color: #483D88;
		list-style: none;
		color : #FFFF00;
		font : italic;
	}
	
	.mainNavigation li{
		display : inline-block;
		justify-content: space-between;
	}
	
	.mainNavigation li a {
		color : #ffff00;	
		padding: 0 13px; /* 위/아래 좌/우 0 1 이게 맞나??@@@@@@@@@@@@*/
		display: block;
		background-color: #A9F5F2;
		font : bold 16px/40px "Nanum Gothic", sans-serif;
		/*폰트의 굵기 | 글자의 킉/line-height 줄간격 | 글꼴 , 먼저 글꼴이 없다면 다음 글꼴*/
		text-transform: uppercase;
		text-decoration: none;
	}
	
	.mainNavigation li a:hover {
		color : #ffffff;	
		background-color: #ede611;
		/*폰트의 굵기 | 글자의 킉/line-height 줄간격 | 글꼴 , 먼저 글꼴이 없다면 다음 글꼴*/
	}	
	
</style>

	<ul class = "mainNavigation">
		<!-- href = "http://localhost:8080/miniPJ/board/boardWriteForm.do" -->
		<li><a id="menuWriteButton">글쓰기</a></li>
		<li><a href = "http://localhost:8080/miniPJ/board/boardList.do?pg=1">글목록</a></li>
	</ul>
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src = "http://localhost:8080/miniPJ/script/boardWrite.js"></script>

