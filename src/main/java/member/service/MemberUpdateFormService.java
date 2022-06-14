package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess3;

public class MemberUpdateFormService implements CommandProcess3 {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		/*
		 * System.out.println("@@회원정보수정 서블릿 탑승!@@"); MemberDAO dao = new MemberDAO();
		 * MemberDTO userData = dao.getMemberData(request.getParameter("id"));
		 * System.out.println("@@@받아온 주소 " + userData.getZipcode() +
		 * 
		 * userData.getAddress1() + userData.getAddress2());
		 */
		  request.setAttribute("display", "/member/memberUpdateForm.jsp");
			/* request.setAttribute("userData", userData); */
		  request.setAttribute("loginStatus", "login");
		 
		
		return "/";
	}

}
