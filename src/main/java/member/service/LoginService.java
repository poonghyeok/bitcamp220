package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess3;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class LoginService implements CommandProcess3 {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		System.out.println("loginService 모델 탑승!!");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MemberDTO inputDTO = new MemberDTO();
		inputDTO.setId(id);
		inputDTO.setPwd(pwd);
		MemberDAO dao = new MemberDAO();
		MemberDTO resultDTO = dao.getMemberData(inputDTO);
		HttpSession session = request.getSession(); 
		
		if(resultDTO != null) {
			System.out.println("@@일치하는 회원 검색했습니다!@@");
			session.setAttribute("sessionId", resultDTO.getId());
			session.setAttribute("sessionName", resultDTO.getName());
			session.setAttribute("sessionEmail", resultDTO.getEmail1()+"@"+resultDTO.getEmail2());
			return "/";
		}else {
			System.out.println("로그인 실패했으니 loginFail 실어보낸다.");
			session.setAttribute("loginFail", "로그인실패..다시시도");
			return "/";
		}
		
	}

}
