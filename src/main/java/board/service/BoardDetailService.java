package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardDetailService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		//여기서 quertyString을 물어와서 글 번호랑 글 제목이랑, 글 작성자, 작성시간을 request 객체에 담아서 보내서 
		//jsp파일에서 받아서 detail page에 표시해줘야한다. 
		//seq 기반으로 
		String requestedSeq = request.getParameter("seq");
		String previousPage = request.getParameter("pg");
		
		
		System.out.println("requestedPg : " + previousPage); 	
		System.out.println("requestedSeq : " + requestedSeq); 	
		BoardDAO dao = new BoardDAO();
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("viewPage") == null) {
			session.setAttribute("viewPage", requestedSeq);
			dao.increaseBoardHit(Integer.parseInt(requestedSeq));
		}
		
		System.out.println(session.getAttribute("viewPage"));
		
		request.setAttribute("rqPage", dao.getBoardBySeq(Integer.parseInt(requestedSeq)));
		request.setAttribute("previousPage", previousPage);
		request.setAttribute("display", "/board/boardDetail.jsp");
		return "/";	
	}

}
