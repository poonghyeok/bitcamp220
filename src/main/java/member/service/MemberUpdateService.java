package member.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess3;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class MemberUpdateService implements CommandProcess3 {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//수업시간에 session으로 풀면 어떡하지? 이것까지 다 생각을 해놓자. 
		MemberDTO memberDTO = new MemberDTO();
		Map<String, String> memberDataMap = new HashMap<>();
		HttpSession session = request.getSession();
		System.out.println("@@@수정절차 돌입 , 현재 로그인 하고 있는 아이디 : " + session.getAttribute("sessionId"));
	
		
		String name = request.getParameter("nameWrite");
		String id = request.getParameter("idWrite");
		String pwd = request.getParameter("pwdWrite");
		String gender = request.getParameter("gender");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String zipcode = request.getParameter("zipcode");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		
		memberDataMap.put("oldId", (String)session.getAttribute("sessionId"));
		memberDataMap.put("name", name);
		memberDataMap.put("id", id);
		memberDataMap.put("pwd", pwd);
		memberDataMap.put("gender", gender);
		memberDataMap.put("email1", email1);
		memberDataMap.put("email2", email2);
		memberDataMap.put("tel1", tel1);
		memberDataMap.put("tel2", tel2);
		memberDataMap.put("tel3", tel3);
		memberDataMap.put("zipcode", zipcode);
		memberDataMap.put("address1", address1);
		memberDataMap.put("address2", address2);
		
		//DB
		MemberDAO memberDAO = new MemberDAO();
		
		int updatedLine = memberDAO.memberUpdate(memberDataMap);
		
		session.removeAttribute("sessionName");
		session.removeAttribute("sessionId");
		
		request.setAttribute("updatedLine", updatedLine);
		request.setAttribute("display", "/member/memberUpdate.jsp");
		
		return "/";

		
	}

}
