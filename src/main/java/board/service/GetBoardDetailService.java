package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.control.CommandProcess3;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class GetBoardDetailService implements CommandProcess3 {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		System.out.println("@@@@@ ajax getBoardDetail 서블릿 탑승 @@@@@");
		//json request에 실어줘야됨.
		String requestedSeq = request.getParameter("seq");
		String previousPage = request.getParameter("pg");
		
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO();
		
		dto = dao.getBoardBySeq(Integer.parseInt(requestedSeq));
		JSONObject json = new JSONObject();
		stringToJson(json, dto);
		json.put("prevPg", previousPage);
		
		request.setAttribute("json", json);
		
		return "/board/getBoardDetail.jsp";
	}
	
	public void stringToJson(JSONObject json, BoardDTO dto) {
		System.out.println("\n 글정보 : " + dto.getSubject() + dto.getContent() + dto.getHit() + dto.getName() + dto.getSeq() + "\n");
		json.put("subject", dto.getSubject());
		json.put("content", dto.getContent());
		json.put("hit", dto.getHit());
		json.put("name", dto.getName());
		json.put("id", dto.getId());
		json.put("seq", dto.getSeq());
	}
}


