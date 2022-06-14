package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess3;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardWriteService implements CommandProcess3 {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		String sessionId = (String)session.getAttribute("sessionId");
		String sessionName = (String)session.getAttribute("sessionName");
		String sessionEmail = (String)session.getAttribute("sessionEmail");
		System.out.println("저자 id : " + sessionId);
		System.out.println("저자 name : " + sessionName);
		System.out.println("저자 email : " + sessionEmail);
		
		String subject = request.getParameter("subject");
		System.out.println("subject : " + subject);
		
		String content = request.getParameter("content");
		System.out.println("content : " + content);
		
		if(subject != null && content != null) {
			BoardDTO dto = new BoardDTO();
			dto.setSubject(subject);
			dto.setContent(content);
			dto.setEmail(sessionEmail);
			dto.setName(sessionName);
			dto.setId(sessionId);
			
			BoardDAO dao = new BoardDAO();
			int boardWrittenNum = dao.write(dto);
				
			request.setAttribute("boardWrittenNum", boardWrittenNum);
			request.setAttribute("display", "/board/boardWrite.jsp");
		}else {
			System.out.println("null 이다!");
		}
		
		return "/board/boardWrite.jsp";
	}

}
