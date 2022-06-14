package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess3;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class WriteService implements CommandProcess3 {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//get Data
		System.out.println("@@회원가입 서블릿 탑승완료!");
		MemberDTO memberDTO = new MemberDTO();
		
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

		System.out.println("@@@@@@ajax로 넘어온 애들 @@@@@@@@@");
		System.out.println("name : " + name);
		System.out.println("pwd : " + pwd);
		System.out.println("gender : " + gender);
		System.out.println("email1 : " + email1);
		System.out.println("email2 : " + email2);
		System.out.println("tel1 : " + tel1);
		System.out.println("tel2 : " + tel2);
		System.out.println("tel3 : " + tel3);
		System.out.println("zipcode : " + zipcode);
		System.out.println("address1 : " + address1);
		System.out.println("address2 : " + address2);
		
		memberDTO.setName(name);
		memberDTO.setId(id);
		memberDTO.setPwd(pwd);
		memberDTO.setGender(gender);
		memberDTO.setEmail1(email1);
		memberDTO.setEmail2(email2);
		memberDTO.setTel1(tel1);
		memberDTO.setTel2(tel2);
		memberDTO.setTel3(tel3);
		memberDTO.setZipcode(zipcode);
		memberDTO.setAddress1(address1);
		memberDTO.setAddress2(address2);
		
		//DB
		MemberDAO memberDAO = new MemberDAO();
		System.out.println("input name : " + memberDTO.getName());
		System.out.println("input id : " + memberDTO.getId());
		
		int executedLine = memberDAO.memberWrite(memberDTO);
		
		String msg;
		if(executedLine == 1){
			msg = "회원가입이 완료되었습니다.";
		}else{
			msg = "회원가입에 문제가 생겼습니다. 다시 시도해주세요!";
		}
		
		request.setAttribute("su", executedLine);
		request.setAttribute("display", "/member/write.jsp");
		
		return "/member/write.jsp";
	}

}
