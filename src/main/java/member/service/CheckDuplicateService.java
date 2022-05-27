package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import member.dao.MemberDAO;

public class CheckDuplicateService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String deliveredId = request.getParameter("id");
		MemberDAO dao = new MemberDAO();
		boolean isExist = dao.isExist(deliveredId);
		
		request.setAttribute("usableId", deliveredId);
		
		if(isExist) {
			return "/member/checkDuplicateFail.jsp";
		}else {
			return "/member/checkDuplicateOk.jsp";
		}
	}

}
