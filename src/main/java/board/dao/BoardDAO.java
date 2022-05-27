package board.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.bean.BoardDTO;

public class BoardDAO {

	private List<BoardDTO> list = new ArrayList<>();
	private List<String> tableMeta = new ArrayList<>();
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ResultSetMetaData rsmd;
	private SimpleDateFormat datefmt;
	private SqlSessionFactory sqlSessionFactory;
	 
	
	public BoardDAO() {
	
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml"); //myBatis-config.xml로 부터 일단 읽어오고 sqlSessionFactory에 꽂아준다./
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader); //sql 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/* !!!mapper작성할 때, integer는 $에, string은 #에!!! */
	public int write(BoardDTO dto) {
		int rowNum = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		rowNum = sqlSession.insert("boardSQL.boardWrite", dto);
		sqlSession.commit();
		sqlSession.close();
		
		return rowNum;
	}//boardWrite
	
	public List<BoardDTO> getBoardAll(){
		List<BoardDTO> boardList = new ArrayList<>();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		boardList = sqlSession.selectList("boardSQL.getBoardAll");
		sqlSession.close();
		
		return boardList;
	}
	
	public List<BoardDTO> getBoardRange(Map<String, Integer> map){
		List<BoardDTO> boardList = new ArrayList<>();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		boardList = sqlSession.selectList("boardSQL.getBoardRange", map);
		sqlSession.close();
		
		return boardList;
	}
	
	public BoardDTO getBoardBySeq(int seq) {
		BoardDTO result = new BoardDTO();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.selectOne("boardSQL.getBoardBySeq", seq);
		sqlSession.close();
		
		return result;
	}
	
	public int getTotalA() {
		int totalBoardNum = 0;
		List<BoardDTO> totalBoardList = getBoardAll();
		
		for(BoardDTO dto : totalBoardList) {
			totalBoardNum++;
		}
		
		return totalBoardNum;
	}//method자체가 너무 무겁다. >> 더 가벼운 method로 대체하자 	
	
	public int getTotalB() {
		int totalBoardNum = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		totalBoardNum = sqlSession.selectOne("boardSQL.getTotalBoardNum");
		
		return totalBoardNum;
	}
	
	public void increaseBoardHit(int seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("boardSQL.increaseBoardHit", seq);
		sqlSession.commit();
		sqlSession.close();
		
		return;
	}
	
	public int boardUpdate(BoardDTO dto) {
		int updatedNum = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		updatedNum = sqlSession.update("boardSQL.boardUpdate", dto);
		sqlSession.commit();
		sqlSession.close();
		
		return updatedNum;
	}
	
	public int boardReply(Map<String,String> map) {
		BoardDTO pdto = this.getBoardBySeq(Integer.parseInt(map.get("pseq")));
		//원글까진 받아왔는데 여기다가 content 추가를 dto 값을 변경해주면 되는구나 
		System.out.println("@@@boardReyply method 실행, 원글의 pseq = " + map.get("pseq"));
		//update 원래 있던 애들 밀어주기
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/* sqlSession.update("boardSQL.boardReply1", pdto); */ //원글의 ref, lev, step 등이 필요하니깐 dto를 들고가자 
		
		//insert
		//map에 다가 먼저 필요한 정보 추가해ㅑ주기
		map.put("ref", Long.toString(pdto.getRef()));
		System.out.println("#####원글 제목 : " + pdto.getSubject() + ", 원글 level : " + pdto.getLev());
		map.put("lev", Long.toString(pdto.getLev()+1)); /* 원글의 lev + 1 */
		//map.put("step", Long.toString(pdto.getStep()+1)); /*원글의 step + 1*/
		
		sqlSession.insert("boardSQL.boardReply2", map); //원글의 ref, lev, step 등이 필요하니깐 dto를 들고가자 
		int result = sqlSession.update("boardSQL.boardReply3", pdto.getSeq()); //원글의 ref, lev, step 등이 필요하니깐 dto를 들고가자 
		sqlSession.commit();
		sqlSession.close();
		
		System.out.println("답글이 성공적으로 작성되었습니다.");
		return result;
	}
	
	
	/*
	 * public List<BoardDTO> getTableElements(int startuNum, int endNum) {
	 * 
	 * String sql = "select * from" + "(select rownum rn, tt.* from" +
	 * "(select * from board order by seq desc)tt)" + "WHERE rn >= ? and rn <= ?";
	 * //sql문 인라인뷰 아주 중요 try { pstmt = conn.prepareStatement(sql);
	 * pstmt.setInt(1,startuNum); pstmt.setInt(2, endNum); rs =
	 * pstmt.executeQuery(); rsmd = rs.getMetaData(); dataTrans(list, tableMeta, rs,
	 * rsmd);
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } finally { allClose(); }
	 * 
	 * return this.list; }
	 */
	/*
	 * public int getTotalA2() { this.getConnection(); int totalA = 0; String sql =
	 * "SELECT count(1) as cnt FROM board";
	 * 
	 * try { pstmt = conn.prepareStatement(sql); rs = pstmt.executeQuery();
	 * if(rs.next()) { totalA = rs.getInt("cnt"); } } catch (SQLException e) {
	 * e.printStackTrace(); } finally { allClose(); }
	 * 
	 * return totalA; }
	 */	/*
	 * public int getTotalA() {
	 * 
	 * 
	 * //this.getConnection(); int totalA = 0; String sql = "SELECT * FROM board";
	 * 
	 * try { pstmt = conn.prepareStatement(sql); rs = pstmt.executeQuery();
	 * while(rs.next()){ totalA++; } } catch (SQLException e) { e.printStackTrace();
	 * } finally { allClose(); }
	 * 
	 * return totalA; }
	 */
	
	/*
	 * private void dataTrans(List<BoardDTO> list, List<String> tableMeta, ResultSet
	 * rs, ResultSetMetaData rsmd) {
	 * 
	 * try { System.out.println("rsmd.getColumnCount() : " + rsmd.getColumnCount());
	 * datefmt = new SimpleDateFormat("yyyy-MM-dd");
	 * 
	 * for(int i = 1; i <= rsmd.getColumnCount(); i++) {
	 * tableMeta.add(rsmd.getColumnName(i)); } while(rs.next()) { BoardDTO dtoTemp =
	 * new BoardDTO(); dtoTemp.setSeq(rs.getLong("SEQ"));
	 * dtoTemp.setId(rs.getString("ID")); dtoTemp.setName(rs.getString("NAME"));
	 * dtoTemp.setEmail(rs.getString("EMAIL"));
	 * dtoTemp.setSubject(rs.getString("SUBJECT"));
	 * dtoTemp.setContent(rs.getString("CONTENT"));
	 * dtoTemp.setRef(rs.getLong("REF")); dtoTemp.setLev(rs.getLong("LEV"));
	 * dtoTemp.setPseq(rs.getLong("PSEQ")); dtoTemp.setStep(rs.getLong("STEP"));
	 * dtoTemp.setReply(rs.getLong("Reply")); dtoTemp.setHit(rs.getLong("HIT"));
	 * dtoTemp.setLogtime(datefmt.format(rs.getTimestamp("LOGTIME")));
	 * list.add(dtoTemp); } } catch (SQLException e) { e.printStackTrace(); } }
	 * 
	 * public List<BoardDTO> getTableElements(int startuNum, int endNum) {
	 * this.getConnection(); //System.out.println("start : " + startuNum + "end : "
	 * + endNum); String sql = "select * from" + "(select rownum rn, tt.* from" +
	 * "(select * from board order by seq desc)tt)" + "WHERE rn >= ? and rn <= ?";
	 * //sql문 인라인뷰 아주 중요 try { pstmt = conn.prepareStatement(sql); pstmt.setInt(1,
	 * startuNum); pstmt.setInt(2, endNum); rs = pstmt.executeQuery(); rsmd =
	 * rs.getMetaData(); dataTrans(list, tableMeta, rs, rsmd);
*	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } finally { allClose(); }
	 * 
	 * return this.list; }
	 * 
	 * //컬럼의 제목을 받아낼건데 자료형을 list로 받는게 좋은가? public List<String> getTableTitle() {
	 * return this.tableMeta; }
	 * 
	 * //method to public List<BoardDTO> getTableElements(String seq) { //url을 통해서
	 * 전달이 되니깐 seq는 string이 맞다. this.getConnection(); String sqlHit =
	 * "UPDATE board SET HIT = HIT + 1 WHERE SEQ = ?"; String sql =
	 * "SELECT * FROM board WHERE SEQ = ?"; try { pstmt =
	 * conn.prepareStatement(sqlHit); pstmt.setString(1,seq); pstmt.executeUpdate();
	 * pstmt = conn.prepareStatement(sql); pstmt.setString(1, seq); rs =
	 * pstmt.executeQuery(); rsmd = rs.getMetaData(); dataTrans(list, tableMeta, rs,
	 * rsmd);
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } finally { allClose(); }
	 * return this.list; }
	 * 
	 * public int getTotalA() { this.getConnection(); int totalA = 0; String sql =
	 * "SELECT * FROM board";
	 * 
	 * try { pstmt = conn.prepareStatement(sql); rs = pstmt.executeQuery();
	 * while(rs.next()) { totalA++; } } catch (SQLException e) {
	 * e.printStackTrace(); } finally { allClose(); }
	 * 
	 * return totalA; }
	 * 
	 * public int getTotalA2() { this.getConnection(); int totalA = 0; String sql =
	 * "SELECT count(1) as cnt FROM board";
	 * 
	 * try { pstmt = conn.prepareStatement(sql); rs = pstmt.executeQuery();
	 * if(rs.next()) { totalA = rs.getInt("cnt"); } } catch (SQLException e) {
	 * e.printStackTrace(); } finally { allClose(); }
	 * 
	 * return totalA; }
	 */
}
