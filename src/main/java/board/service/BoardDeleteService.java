package board.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess3;

import board.dao.BoardDAO;

public class BoardDeleteService implements CommandProcess3 {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		System.out.println("@@@@@boardDelete Service 탑승!!!@@@@@");
		BoardDAO dao = new BoardDAO();
		String seq = request.getParameter("seq");
		String pg = request.getParameter("pg");
		
		System.out.println("\n 삭제 seq : " + seq + " pg : " + pg + "\n");
		
		Map<String, Integer> map = new HashMap<>();
		map.put("seq", Integer.parseInt(seq));
		map.put("pg", Integer.parseInt(pg));
		
		int num = dao.boardDelte(map);
		
		request.setAttribute("previousPage", pg);
		request.setAttribute("num", num);
		request.setAttribute("display", "/board/boardDelete.jsp");
		
		return "/";
	}

}
