package board.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardListService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		
		//여기서는 DTO가 필요가 없고 D
		//한페이지당 5개씩 끌고 오고 싶다
		int pg = Integer.parseInt(request.getParameter("pg"));
		System.out.println("@@@@@boardListService@@@@@ 넘어온 page : " + pg);
		int endNum = pg*5; //10
		int startNum = endNum - 4; //6
		
		/*
		 * System.out.println("pg : " + pg); System.out.println("endNum : " + endNum);
		 * System.out.println("startNUM : " + startNum);
		 */
		
		/* 여기서 세션 확인해서 로그인 안되어있으면 보여주지말자 */
		
		BoardDAO dao = new BoardDAO();
		int totalA = dao.getTotalB();
		int totalP = (totalA-1)/5 + 1;
		
		System.out.println("total page num : " + totalA);
		System.out.println("total page button num : " + totalP);
		
		request.setAttribute("totalPageNum", totalP);
		System.out.println("list service java start, end index : " + startNum + ", "+ endNum);
		Map<String, Integer> map = new HashMap<>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		request.setAttribute("elements", dao.getBoardRange(map));
		request.setAttribute("pg", pg);
		request.setAttribute("display", "/board/boardList.jsp");
		
		
		return "/";
	}

}
