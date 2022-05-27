package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardUpdateFormService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		BoardDAO dao = new BoardDAO();
		String requestedSeq = request.getParameter("seq");
		System.out.println("수정 요청 받은 seq : " + requestedSeq);
		
		request.setAttribute("updateSeq", requestedSeq);
		request.setAttribute("oldBoard", dao.getBoardBySeq(Integer.parseInt(requestedSeq)));
		request.setAttribute("display", "/board/boardUpdateForm.jsp");
		return "/";
	}

}
