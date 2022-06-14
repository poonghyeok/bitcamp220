package board.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess3;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAO;

public class BoardSearchService implements CommandProcess3 {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String searchOption = null;
		String searchCondition = null;
		
		HttpSession session = request.getSession();
		session.removeAttribute("viewPage");
		
		int pg = Integer.parseInt(request.getParameter("pg"));
		int endNum = pg*5; //5, 10개씩 표시하라고 하면 여기를 바꾸면 될듯
		int startNum = endNum - 4; //1
		int totalA = 0;
		
		System.out.println("@@@@@boardListService@@@@@ 넘어온 page : " + pg);
		System.out.println("@@@@ search 서블릿 탑승 !");
		
		searchOption =  request.getParameter("searchOption");
		searchCondition = request.getParameter("searchCondition");
		System.out.println("넘어온 검색 조건들 - searchOption " + searchOption + " searchCondition : " + searchCondition);
		
		/* 받자마자 바로 넘겨 다른페이지에도 디폴트로 걸어버리게 */
		
		request.setAttribute("searchCondition", searchCondition);
		request.setAttribute("searchOption", searchOption);
		BoardDAO dao = new BoardDAO();
		//${requestScope.boardPaging.getPagingHTML()}
		
		List<BoardDTO> list = new ArrayList<>();
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("startNum", Integer.toString(startNum));
		searchMap.put("endNum", Integer.toString(endNum));
		searchMap.put("searchCondition", searchCondition);
		
		if(searchOption.equals("author")) {
			totalA = dao.getTotalSearchById(searchCondition);
			list = dao.getBoardById(searchMap);
		}else if(searchOption.equals("subject")) {
			totalA = dao.getTotalSearchBySubject(searchCondition);
			list = dao.getBoardBySubject(searchMap);
		}
		
		System.out.println("list 0 번째 꺼내보기 : " + list.get(0).getSubject());
		
		request.setAttribute("elements", list);
		//글의 총수 
		
		BoardPaging boardPaging = new BoardPaging();
		boardPaging.setCurrentPage(pg);
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(5);
		boardPaging.setTotalA(totalA);
		boardPaging.makePagingHTML();	

		
		request.setAttribute("boardPaging", boardPaging);
		request.setAttribute("pg", pg);
		//request.setAttribute("display", "/board/boardList.jsp");
		request.setAttribute("display", "/board/boardSearchList2.jsp");

		return "/board/boardList.jsp";
		
	}
}




