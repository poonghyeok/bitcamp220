package board.service;

import board.dao.BoardDAO;

public class boardTest {

	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		int  num = dao.getTotalB();
		System.out.println(num);
	}

}
