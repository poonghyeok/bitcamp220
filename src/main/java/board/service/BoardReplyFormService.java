package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

public class BoardReplyFormService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		System.out.println("@@@@답글 서블릿 탐승!@@@");
		String pseq = request.getParameter("seq");
		System.out.println("@@@@seq : " + pseq);
		String pg = request.getParameter("updatePg");
		System.out.println("@@@@pg : " + pg);
		
		request.setAttribute("pseq", Integer.parseInt(pseq));
		request.setAttribute("pg", Integer.parseInt(pg));
		request.setAttribute("display", "/board/boardReplyForm.jsp");
		
		return "/";
	}

}
