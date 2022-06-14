package board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.control.CommandProcess3;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAO;

public class GetBoardListService implements CommandProcess3 {

	@Override 
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int pg = Integer.parseInt(request.getParameter("pg"));
		System.out.println("getBoardList 서블릿 탑승!!!");
		
		BoardDAO dao = new BoardDAO();
		
		JSONObject json = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		
		int endNum = pg * 5; //5 int startNum = endNum - 4; //1
		int startNum = endNum - 4;  
		
		Map<String, Integer> map = new HashMap<>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		System.out.println("pg : " + pg); System.out.println("endNum : " + endNum);
		System.out.println("startNUM : " + startNum);
		  
		List<BoardDTO> list = dao.getBoardRange(map);
		System.out.println("@@@@@@@ getBoardList하나 이름 뽑아보기 ::: " + list.get(0).getName());
		if(list != null) {
			int iterNum = 1;
			for(BoardDTO dto : list) {
				JSONObject jsonTemp = new JSONObject();
				jsonTemp.put("seq", (int)dto.getSeq());
				jsonTemp.put("id", dto.getId());
				jsonTemp.put("name", dto.getName());
				jsonTemp.put("email", dto.getEmail());
				jsonTemp.put("subject", dto.getSubject());
				jsonTemp.put("content", dto.getContent());
				jsonTemp.put("ref", (int)dto.getRef());
				jsonTemp.put("lev", (int)dto.getLev());
				jsonTemp.put("step", (int)dto.getStep());
				jsonTemp.put("pseq", (int)dto.getPseq());
				jsonTemp.put("reply", (int)dto.getReply());
				jsonTemp.put("hit", (int)dto.getHit());
				jsonTemp.put("logtime", dto.getLogtime());
				
				jsonArr.add(jsonTemp);
				iterNum++;
			}
			json.put("list", jsonArr);
		}else{
			System.out.println("list 없어!!!!@!@!@!@!@!@!");
			System.exit(0);
		}
		request.setAttribute("json", json);
		
		int totalA = dao.getTotalB();
		
		BoardPaging boardPaging = new BoardPaging(); 
		boardPaging.setCurrentPage(pg);
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(5);
		boardPaging.setTotalA(totalA);
		boardPaging.makePagingHTML();
		System.out.println("boardPaging  HTML : " + boardPaging.getPagingHTML());
		String pagingHTML = boardPaging.getPagingHTML().toString();
		
		json.put("pagingHTML", pagingHTML);
		String sessionId = (String)request.getSession().getAttribute("sessionId");
		json.put("sessionId", sessionId);
		return "/board/getBoardList.jsp";
	}

}
