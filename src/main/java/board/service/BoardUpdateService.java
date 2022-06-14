package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.control.CommandProcess3;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardUpdateService implements CommandProcess3 {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Board Update 서블릿 탑승! 수정시작!@@@@");
		HttpSession session = request.getSession();
		
		//updatedSubject
		String subject = request.getParameter("subject");
		System.out.println("subject : " + subject);
		
		//updatedContent
		String content = request.getParameter("content");
		System.out.println("content : " + content);
		
		String seq = request.getParameter("seq");
		System.out.println("seq : " + seq);
		
		String pg = request.getParameter("pg");
		System.out.println("pg : " + pg);
		
		BoardDTO dto = new BoardDTO();
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setSeq(Integer.parseInt(seq));
		
		System.out.println("subject : " + dto.getSubject());
		System.out.println("content : " + dto.getContent());
		System.out.println("seq : " + dto.getSeq());
		
		JSONObject updateJson = new JSONObject();
		
		BoardDAO dao = new BoardDAO();
		int boardUpdatedNum = dao.boardUpdate(dto);
		
		updateJson.put("subject", subject);
		updateJson.put("content", content);
		updateJson.put("seq", seq);
		updateJson.put("pg", pg);
		
		System.out.println("updateBoard Json :::: " + updateJson);
		request.setAttribute("boardUpdatedNum", boardUpdatedNum);
		/* request.setAttribute("display", "/board/boardUpdate.jsp"); */
		request.setAttribute("updateJson", updateJson);
		return "/board/boardUpdate.jsp";
	}

}
