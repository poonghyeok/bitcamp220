package board.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardReplyService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession();
		
		String pseq =request.getParameter("pseq"); //원글번호 
		String pg =request.getParameter("pg");	//원글이 속한 페이지
		String subject =request.getParameter("subject");
		String content =request.getParameter("content");
		
		String id = (String)session.getAttribute("sessionId");
		String name = (String)session.getAttribute("sessionName");
		String email = (String)session.getAttribute("sessionEmail");
		
		System.out.println("@@@@ Board Reply 서블릿 탑승 @@@@");
		System.out.println("받은 정보들 : \n " + pseq + "\t" + pg + "\t"+ subject + "\t"+ content + "\t"+ id + "\t"+ name + "\t"+ email);
		
		Map<String, String> map = new HashMap<>();
		
		map.put("pseq", pseq);
		map.put("pg", pg);
		map.put("subject", subject);
		map.put("content", content);
		map.put("id", id);
		map.put("name", name);
		map.put("email", email);
		
		BoardDAO dao = new BoardDAO();
		int boardRepliedNum = dao.boardReply(map);
		request.setAttribute("boardRepliedNum", boardRepliedNum);
		request.setAttribute("pg", pg);
		request.setAttribute("display", "/board/boardReply.jsp");
		
		return "/";
	}

}
