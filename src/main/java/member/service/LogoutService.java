package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

public class LogoutService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		/*
		 * Cookie [] cookieArr = request.getCookies();
		 * 
		 * if(cookieArr != null) { for(int i = 0; i < cookieArr.length; i++) {
		 * if(cookieArr[i].getName().equals("memName")) { cookieArr[i].setPath("/");
		 * //슬래시부터 시작해서 모든 쿠키를 삭제하겠다는 뜻이다..? cookieArr[i].setMaxAge(0);
		 * response.addCookie(cookieArr[i]); }
		 * 
		 * if(cookieArr[i].getName().equals("memId")) { cookieArr[i].setPath("/");
		 * 
		 * cookieArr[i].setMaxAge(0); response.addCookie(cookieArr[i]); } } }
		 */
		
		HttpSession session = request.getSession();
		
		//각각의 세션 삭제 
		session.removeAttribute("sessionName");
		session.removeAttribute("sessionId");
		
		//한번에 모든 세션 삭제
		//session.invalidate();
		
		
		return "/";
	}

}
