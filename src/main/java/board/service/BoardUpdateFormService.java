package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess3;

import board.dao.BoardDAO;

public class BoardUpdateFormService implements CommandProcess3 {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		/*
		 * BoardDAO dao = new BoardDAO(); String requestedSeq =
		 * request.getParameter("seq"); String requestedPg = request.getParameter("pg");
		 * 
		 * System.out.println("수정 요청 받은 seq : " + requestedSeq);
		 * System.out.println("수정 요청 페이지 pg ::::::" + requestedPg);
		 * 
		 * request.setAttribute("updateSeq", requestedSeq);
		 * request.setAttribute("updatePg", requestedPg);
		 * request.setAttribute("oldBoard",
		 * dao.getBoardBySeq(Integer.parseInt(requestedSeq)));
		 */
		String requestedSeq = request.getParameter("seq"); 
		String requestedPg = request.getParameter("pg");
		
		System.out.println("@@@@@@@ update 기본 폼 띄우기 서블릿 @@@@@@@");
		System.out.println("\n수정 요청 받은 seq : " + requestedSeq + "\n");
		System.out.println("\n수정 요청 페이지 pg ::::::" + requestedPg + "\n"); 
		
		request.setAttribute("display", "/board/boardUpdateForm.jsp");
		return "/";
	}

}
