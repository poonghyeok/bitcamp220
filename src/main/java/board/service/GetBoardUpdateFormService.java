package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.control.CommandProcess3;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class GetBoardUpdateFormService implements CommandProcess3 {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String seq = request.getParameter("seq");
		String pg = request.getParameter("pg");
		
		System.out.println("\n GetBoardUpdate class seq : " + seq + " pg : " + pg);
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.getBoardBySeq(Integer.parseInt(seq));
		
		JSONObject json = new JSONObject();
		json.put("subject", dto.getSubject());
		json.put("content", dto.getContent());
		
		request.setAttribute("json", json);
		
		return "/board/getBoardUpdateForm.jsp";
	}

}
