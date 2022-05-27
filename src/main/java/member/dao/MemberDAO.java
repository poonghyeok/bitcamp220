package member.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.bean.MemberDTO;

public class MemberDAO {
	private	SqlSessionFactory sqlSessionFactory;
	private Scanner sc = new Scanner(System.in);
	
	public MemberDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml"); //myBatis-config.xml로 부터 일단 읽어오고 sqlSessionFactory에 꽂아준다./
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader); //sql 
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	//input은 String output은 MemberDTO
	public MemberDTO getMemberData(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemberDTO dto =  sqlSession.selectOne("memberSQL.getMemberById", id);
		sqlSession.close();
		return dto;
	}
	
	
	//MemberDTO 객체로 받아오기 input은 dto
	//입력정보가 많지 않다면 map으로 받아오는 것도 무방할듯 
	public MemberDTO getMemberData(MemberDTO inputDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemberDTO dto =  sqlSession.selectOne("memberSQL.loginResult", inputDTO);
		sqlSession.close();
		return dto;
	}
	
	public boolean isExist(String id) {
		boolean result = false;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemberDTO resultDTO = new MemberDTO();
		resultDTO = sqlSession.selectOne("memberSQL.getMemberById", id);
		
		if(resultDTO != null) {
			result = true;
		}
		
		return result;
	}
	
	public int memberWrite(MemberDTO inputDTO) {
		int insertNum = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		insertNum = sqlSession.insert("memberSQL.memberWrite", inputDTO);
		sqlSession.commit();
		sqlSession.close();
		
		return insertNum;
	}
	
	public int memberUpdate(Map<String, String> memberDataMap) {
		int updateNum = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		updateNum = sqlSession.insert("memberSQL.memberUpdate", memberDataMap);
		sqlSession.commit();
		sqlSession.close();
		
		return updateNum;
	}
	
	
	/*
	 * public boolean isExistId(String id)
	 * 
	 * public int write(MemberDTO dto) public int memberUpdate(MemberDTO dto) public
	 * boolean getMember
	 */
	/*
	 * public void getConnection() { try { conn = DriverManager.getConnection(url,
	 * username, password); System.out.println("접속");
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 */

	/*
	 * public String loginResult(String id, String pw) { String result = "initial";
	 * this.getConnection(); String sql = "SELECT * FROM member WHERE id = ?"; try {
	 * pstmt = conn.prepareStatement(sql); pstmt.setString(1, id); rs =
	 * pstmt.executeQuery(); } catch (SQLException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); } try {
	 * 
	 * if(rs.next()) { if(rs.getString("id").equals(id)) {
	 * if(rs.getString("pwd").equals(pw)) { result = rs.getString("name"); }else {
	 * result = "-1"; } } }else { result = "-1";
	 * 
	 * }
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); }finally { try { if(rs !=
	 * null) { rs.close(); pstmt.close(); conn.close(); } } catch (SQLException e) {
	 * e.printStackTrace(); } }
	 * 
	 * return result; }
	 * 
	 * 
	 * public boolean isExistId(String id) { boolean result = false;
	 * this.getConnection(); String sql = "SELECT * FROM member WHERE id = ?"; try {
	 * pstmt = conn.prepareStatement(sql); pstmt.setString(1, id); rs =
	 * pstmt.executeQuery(); if(rs.next()) { result = true; } } catch (SQLException
	 * e) { e.printStackTrace(); }finally { try { if(rs != null) { rs.close();
	 * pstmt.close(); conn.close(); } } catch (SQLException e) {
	 * e.printStackTrace(); } }
	 * 
	 * return result; } public void rsToDto(MemberDTO dto, ResultSet rs) { try {
	 * if(rs.next()) { dto.setName(rs.getString("name"));
	 * dto.setId(rs.getString("id")); dto.setGender(rs.getString("gender"));
	 * dto.setEmail1(rs.getString("email1")); dto.setEmail2(rs.getString("email2"));
	 * dto.setTel1(rs.getString("tel1")); dto.setTel2(rs.getString("tel2"));
	 * dto.setTel3(rs.getString("tel3")); dto.setZipcode(rs.getString("zipcode"));
	 * dto.setAddress1(rs.getString("address1"));
	 * dto.setAddress2(rs.getString("address2"));
	 * System.out.println("rs to dto 작업 완료!!@@@@"); } } catch (SQLException e) {
	 * e.printStackTrace(); } }
	 * 
	 * public MemberDTO getMemberData(String id) {
	 * System.out.println("@@ DB로 부터 멤버데이터 받아오기!!@@"); MemberDTO dto = new
	 * MemberDTO(); this.getConnection(); String sql =
	 * "SELECT * FROM member WHERE id = ?"; try { pstmt =
	 * conn.prepareStatement(sql); pstmt.setString(1, id); rs =
	 * pstmt.executeQuery(); rsToDto(dto, rs); } catch (SQLException e) {
	 * e.printStackTrace(); }finally { try { if(rs != null) { rs.close();
	 * pstmt.close(); conn.close(); } } catch (SQLException e) {
	 * e.printStackTrace(); } } return dto; }
	 * 
	 * public int write(MemberDTO dto) { this.getConnection(); int rowNum = 0; try {
	 * String sql = "insert into member values(?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";
	 * pstmt = conn.prepareStatement(sql); pstmt.setString(1, dto.getName());
	 * pstmt.setString(2, dto.getId()); pstmt.setString(3, dto.getPwd());
	 * pstmt.setString(4, dto.getGender()); pstmt.setString(5, dto.getEmail1());
	 * pstmt.setString(6, dto.getEmail2()); pstmt.setString(7, dto.getTel1());
	 * pstmt.setString(8, dto.getTel2()); pstmt.setString(9, dto.getTel3());
	 * pstmt.setString(10, dto.getZipcode()); pstmt.setString(11,
	 * dto.getAddress1()); pstmt.setString(12, dto.getAddress2());
	 * 
	 * rowNum = pstmt.executeUpdate();
	 * 
	 * }catch (SQLException e) { e.printStackTrace(); } finally { try { if(pstmt !=
	 * null) { pstmt.close(); } if(conn != null) { conn.close(); } } catch
	 * (SQLException e) { e.printStackTrace(); } }
	 * 
	 * return rowNum; }
	 * 
	 * public int memberUpdate(MemberDTO dto) { this.getConnection(); int rowNum =
	 * 0; try { System.out.println("@@Member Update 시작!! @@@");
	 * 
	 * //이름 수정안할거임 String sql = "UPDATE member SET NAME = ?, " //1 + "PWD = ?," //2
	 * + "GENDER = ?," //3 + "EMAIL1 = ?," //4 + "EMAIL2 = ?," //5 + "TEL1 = ?," //6
	 * + "TEL2 = ?," //7 + "TEL3 = ?," //8 + "ZIPCODE = ?," //9 + "ADDRESS1 = ?,"
	 * //10 + "ADDRESS2 = ?"//11 + "WHERE ID = ?"//12
	 * 
	 * ; pstmt = conn.prepareStatement(sql); pstmt.setString(1, dto.getName());
	 * pstmt.setString(2, dto.getPwd()); pstmt.setString(3, dto.getGender());
	 * pstmt.setString(4, dto.getEmail1()); pstmt.setString(5, dto.getEmail2());
	 * pstmt.setString(6, dto.getTel1()); pstmt.setString(7, dto.getTel2());
	 * pstmt.setString(8, dto.getTel3()); pstmt.setString(9, dto.getZipcode());
	 * pstmt.setString(10, dto.getAddress1()); pstmt.setString(11,
	 * dto.getAddress2()); pstmt.setString(12, dto.getId());
	 * 
	 * 
	 * rowNum = pstmt.executeUpdate();
	 * System.out.println("@@@@ member update 완료 !!! @@@@ 수정 결과 : " + rowNum +
	 * "@@@@");
	 * 
	 * }catch (SQLException e) { e.printStackTrace(); } finally { try { if(pstmt !=
	 * null) { pstmt.close(); } if(conn != null) { conn.close(); } } catch
	 * (SQLException e) { e.printStackTrace(); } }
	 * 
	 * return rowNum; }
	 * 
	 */
}

/*
 * public boolean getMember(String id, String pw) {
 * 
 * this.getConnection(); String sql = "SELECT * FROM member WHERE id = ?";
 * boolean result = false;
 * 
 * try { pstmt = conn.prepareStatement(sql); pstmt.setString(1, id); this.rs =
 * pstmt.executeQuery(); } catch (SQLException e) { // TODO Auto-generated catch
 * block e.printStackTrace(); }
 * 
 * if(this.rs.next()) { System.out.println("검색된 아이디 : " + rs.getString("id"));
 * System.out.println("검색된 비번 : " + rs.getString("pwd"));
 * if(this.rs.getString("id").equals(id)) {
 * if(this.rs.getString("pwd").equals(pw)) { result = true; } } }
 * 
 * 
 * return resultSet; }
 * 
 * public int isMember(String id, String pw) {
 * 
 * ResultSet resultSet = getMember(id, pw); int result = 0;
 * 
 * try { if(resultSet.next()) {
 * System.out.println("resultset을 받고 들어왔다. 아이디 비교한다.");
 * if(resultSet.getString("id").equals(id)) {
 * if(resultSet.getString("pwd").equals(pw)) { result = 1; }else { result = -1;
 * } } }else { System.out.println("resultset은 아무것도 안담고있다."); result = -2; } }
 * catch (SQLException e) { e.printStackTrace(); }
 * 
 * return result; }
 * 
 * public String loginReuslt(String id, String pw) {
 * 
 * ResultSet resultSet = getMember(id, pw); String result = "";
 * 
 * switch(isMember(id,pw)) { case 0 : result = "시스템상 오류가 있습니다."; break; case 1 :
 * try { result = (resultSet.getString("name") + "님 반갑습니다."); break; } catch
 * (SQLException e) { e.printStackTrace(); } break; case -1 : result =
 * "아이디 일치, 비밀번호 불일치"; break; case -2 : result = "등록된 회원이 없습니다.";break; default
 * : return "시스템상 오류 존재. 디퐅트로 흘러내림"; }
 * 
 * return result; }
 */
	
	

	//-2 : no such a member
	//-1 : id right, but pw wrong
	//1 : login success