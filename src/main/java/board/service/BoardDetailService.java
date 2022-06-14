package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess3;

import board.dao.BoardDAO;

public class BoardDetailService implements CommandProcess3 {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		//여기서 quertyString을 물어와서 글 번호랑 글 제목이랑, 글 작성자, 작성시간을 request 객체에 담아서 보내서 
		//jsp파일에서 받아서 detail page에 표시해줘야한다. 
		//seq 기반으로 
		HttpSession session = request.getSession();
		String requestedSeq = request.getParameter("seq");
		String previousPage = request.getParameter("pg");
		
		System.out.println("BoardDetailService서블릿 탑승 seq : " + requestedSeq + " 이전 페이지 : " + previousPage + " \n");
		
		//조회수 증가
		BoardDAO dao = new BoardDAO();
		
		if(session.getAttribute("viewSession") == null) {
			dao.increaseBoardHit(Integer.parseInt(requestedSeq));
			session.setAttribute("viewSession", requestedSeq);
		}
		
		
		request.setAttribute("seq", requestedSeq);
		request.setAttribute("pg", previousPage);
		request.setAttribute("display", "/board/boardDetail.jsp");
		
		return "/";	
	}

}
