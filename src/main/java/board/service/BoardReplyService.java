package board.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.control.CommandProcess3;

import board.dao.BoardDAO;

public class BoardReplyService implements CommandProcess3 {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession();
		BoardDAO dao = new BoardDAO();

		
		String pseq =request.getParameter("pseq"); //원글번호 
		String pg =request.getParameter("pg");	//원글이 속한 페이지
		String subject =request.getParameter("subject");
		String content =request.getParameter("content");
		
		String id = (String)session.getAttribute("sessionId");
		String name = (String)session.getAttribute("sessionName");
		String email = (String)session.getAttribute("sessionEmail");
		
		System.out.println("@@@@ Board Reply 서블릿 탑승 @@@@");
		System.out.println("\n 답글 받은 정보들 : \n " + pseq + "\t" + pg + "\t"+ subject + "\t"+ content + "\t"+ id + "\t"+ name + "\t"+ email);
		
		Map<String, String> map = new HashMap<>();
		
		map.put("pseq", pseq);
		map.put("pg", pg);
		map.put("subject", subject);
		map.put("content", content);
		map.put("id", id);
		map.put("name", name);
		map.put("email", email);
		
		int seqCurrVal = dao.getSeqCurrVal();
		System.out.println("\n현재 seq 뽑아보기 : " + seqCurrVal);
		int boardRepliedNum = dao.boardReply(map);
		request.setAttribute("boardRepliedNum", boardRepliedNum);
		
		JSONObject json = new JSONObject();
		json.put("pg", pg);
		json.put("seq", seqCurrVal);
		
		System.out.println(" \n json 보내기 전, 뽑아보기 : " + json.get("pg") + "  : " + json.get("seq"));
		
		request.setAttribute("json", json);
		
		return "/board/boardReply.jsp"; //어짜피 ajax로 서블릿 태우면 이쪽으로 리디렉션 안먹힘. ajax에서 location.href 하는 곳이 목적지 
	}

}
