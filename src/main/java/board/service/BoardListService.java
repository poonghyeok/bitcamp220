package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess3;

public class BoardListService implements CommandProcess3 {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {

		
		 HttpSession session = request.getSession();
		 session.removeAttribute("viewSession");
		 
		// 여기서는 DTO가 필요가 없고 D
		// 한페이지당 5개씩 끌고 오고 싶다
		int pg = Integer.parseInt(request.getParameter("pg"));
		/*
		 * System.out.println("@@@@@boardListService@@@@@ 넘어온 page : " + pg); 
		 * int endNum= pg*5; //5 
		 * int startNum = endNum - 4; //1
		 * 
		 * 
		 * System.out.println("pg : " + pg); System.out.println("endNum : " + endNum);
		 * System.out.println("startNUM : " + startNum);
		 * 
		 * 
		 * 여기서 세션 확인해서 로그인 안되어있으면 보여주지말자
		 * 
		 * BoardDAO dao = new BoardDAO(); int totalA = dao.getTotalB();
		 * System.out.println("@@totla A : " + totalA); //글의 총수
		 * 
		 * BoardPaging boardPaging = new BoardPaging(); 
		 * boardPaging.setCurrentPage(pg);
		 * boardPaging.setPageBlock(3);
		 * boardPaging.setPageSize(5);
		 * boardPaging.setTotalA(totalA);
		 * boardPaging.makePagingHTML();
		 * System.out.println("boardPaging  HTML : " + boardPaging.getPagingHTML());
		 * 
		 * Map<String, Integer> map = new HashMap<>();
		 *  map.put("startNum", startNum);
		 * map.put("endNum", endNum);
		 * 
		 */
		/*
		 * request.setAttribute("boardPaging", boardPaging);
		 * request.setAttribute("elements", dao.getBoardRange(map));
		 */
		request.setAttribute("pg", pg);
		request.setAttribute("display", "/board/boardList.jsp");

		return "/";
	}

}
