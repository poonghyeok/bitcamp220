package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess3;

public class BoardWriteFormService implements CommandProcess3 {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardWriteForm 서블릿 탑승완료! ");
		HttpSession session = request.getSession();
		System.out.println("로그인 상태 여부 :: " + (String)session.getAttribute("sessionId"));
		
		if(session.getAttribute("sessionId") != null) {
			request.setAttribute("display", "/board/boardWriteForm.jsp");		
		}else{
			request.setAttribute("requireLoginMsg", "글 작성을 하려면 로그인이 필요합니다!");
		} 	
		

		return "/";
	}

}
