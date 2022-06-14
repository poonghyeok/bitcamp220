package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.control.CommandProcess3;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class GetMemberService implements CommandProcess3 {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		System.out.println("@@@@@@@@ get Member 서블릿 탑승 @@@@@@@@");
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("sessionId");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.getMemberData(id);
		/*dto를 json 형식으로 변환이 필요하다. spring */
		System.out.println("dto 하나 뽑아보기 : " + dto.getName()); 
		JSONObject json = new JSONObject();
		
		json.put("name", dto.getName());
		json.put("id", dto.getId());
		json.put("gender", dto.getGender());
		json.put("email1", dto.getEmail1());
		json.put("email2", dto.getEmail2());
		json.put("tel1", dto.getTel1());
		json.put("tel2", dto.getTel2());
		json.put("tel3", dto.getTel3());
		json.put("zipcode", dto.getZipcode());
		json.put("address1", dto.getAddress1());
		json.put("address2", dto.getAddress2());
		
		System.out.println("json  :::::" + json );
		request.setAttribute("json", json);
		
		return "/member/getMember.jsp";
	}
}
