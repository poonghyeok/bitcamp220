package board.service;

import java.util.ArrayList;
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

public class JQueryBoardSearchService implements CommandProcess3 {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String searchOption = null;
		String searchCondition = null;
		
		int pg = Integer.parseInt(request.getParameter("pg"));
		int endNum = pg*5; //5, 10개씩 표시하라고 하면 여기를 바꾸면 될듯
		int startNum = endNum - 4; //1
		int totalA = 0;
		
		System.out.println("@@@@@jqeury board search service@@@@@ 넘어온 page : " + pg);
		System.out.println("@@@@ search 서블릿 탑승 !");
		
		searchOption =  request.getParameter("searchOption");
		searchCondition = request.getParameter("searchCondition");
		System.out.println("넘어온 검색 조건들 - searchOption " + searchOption + " searchCondition : " + searchCondition);
		
		BoardDAO dao = new BoardDAO();
		//${requestScope.boardPaging.getPagingHTML()}
		
		List<BoardDTO> list = new ArrayList<>();
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("startNum", Integer.toString(startNum));
		searchMap.put("endNum", Integer.toString(endNum));
		searchMap.put("searchCondition", searchCondition);
		
		if(searchOption.equals("author")) {
			totalA = dao.getTotalSearchById(searchCondition);
			list = dao.getBoardById(searchMap);
		}else if(searchOption.equals("subject")) {
			totalA = dao.getTotalSearchBySubject(searchCondition);
			list = dao.getBoardBySubject(searchMap);
		}
		
		System.out.println("\n 검색결과 하나 꺼내보기 : " + list.get(0).getSubject() + "\n");
		
		JSONObject json = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		
		for(BoardDTO dto : list) {
			JSONObject jsonTemp = new JSONObject();
			jsonTemp.put("seq", dto.getSeq());
			jsonTemp.put("id", dto.getId());
			jsonTemp.put("name", dto.getName());
			jsonTemp.put("email", dto.getEmail());
			jsonTemp.put("subject", dto.getSubject());
			jsonTemp.put("content", dto.getContent());
			jsonTemp.put("ref", dto.getRef());
			jsonTemp.put("lev", dto.getLev());
			jsonTemp.put("step", dto.getStep());
			jsonTemp.put("pseq", dto.getPseq());
			jsonTemp.put("reply", dto.getReply());
			jsonTemp.put("hit", dto.getHit());
			jsonTemp.put("logtime", dto.getLogtime());
			
			jsonArr.add(jsonTemp);
		}
		
		json.put("list", jsonArr);

		BoardPaging boardPaging = new BoardPaging(); 
		boardPaging.setCurrentPage(pg);
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(5);
		boardPaging.setTotalA(totalA);
		boardPaging.makeSearchPagingHTML();
		System.out.println("boardPaging  HTML : " + boardPaging.getPagingHTML());
		String pagingHTML = boardPaging.getPagingHTML().toString();
		
		
		json.put("pagingHTML", pagingHTML);

		request.setAttribute("json", json);
		
		return "/board/getBoardList.jsp";
	}
}

