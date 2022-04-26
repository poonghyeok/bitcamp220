package vm07_Collection;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class ScoreService {
	private ArrayList<ScoreDTO> article;
	private ListIterator<ScoreDTO> listIter;
	
	private String decoStar = "*******************";
	private Scanner sc = new Scanner(System.in);
	
	public ScoreService() {
		article = new ArrayList<>();
		
		mainProcess();
	}
	
	private void mainProcess() {
		
		while(true) {
			int userSelec = menu();
			
			if(inRange(userSelec)){
				switch(userSelec){
					case 1: 
						insertArticle(); break;
					case 2:
						printArticle();break;
					case 3:
						searchArticle();break;
					case 4:
						deleteArticle(); break;
					case 6:
						System.out.println("프로그램을 종료합니다.");
						System.exit(0);
				}//switch
				
			}else {
				System.out.println("1~6 중 입력해주세요");
				continue;
			}
		
		}//while
			
	}//mainProcess
	
	//menu method for a user to execute a certain utility.
	private int menu() {
		System.out.println(decoStar);
		System.out.println("1. 입력 : " );
		System.out.println("2. 출력 : ");
		System.out.println("3. 검색 : ");
		System.out.println("4. 삭제 : ");
		System.out.println("6. 끝 : ");
		System.out.println(decoStar);
		
		int userInput = sc.nextInt();
		return userInput;
	}//menu
	
	private boolean inRange(int menu) {
		if(menu >= 1 && menu <= 6) {
			return true;
		}else {
			return false;
		}
	}//isRange
	
	//insertArticle : method to add data to the object of ScoreDTO 
	private void insertArticle() {
		System.out.println("번호 입력 : ");
		int inputNo = sc.nextInt();
		
		System.out.println("이름 입력 : ");
		String inputName = sc.next();
		
		System.out.println("국어 입력 : ");
		int inputKor = sc.nextInt();
		
		System.out.println("영어 입력 : ");
		int inputEng = sc.nextInt();	
		
		System.out.println("수학 입력 : ");
		int inputMath = sc.nextInt();
		
		article.add(new ScoreDTO(inputNo, inputName, inputKor, inputEng, inputMath));
		
		System.out.println("데이터를 저장하였습니다. ");
		
		
	}//insertArticle

	//method to print article..
	private void printArticle() {
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
		listIter = article.listIterator();
		
		while(listIter.hasNext()) {
			System.out.println(listIter.next().toString());
		}
	
	}//printArticle

	//searchArticle_main_method to search and print row that meet the condition of same name.
	private void searchArticle() {
		SEARCH_LOOP: while(true) {

			System.out.println("검색 할 이름 입력 : ");
			String searchName = sc.next();
			
			listIter = article.listIterator();
			System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");

			int searchCount = 0;
			
			while(listIter.hasNext()) {
				ScoreDTO tempDTO = listIter.next();
				if(tempDTO.getName().equals(searchName)) {
					System.out.println(tempDTO.toString());
					searchCount++;
				}
			}
			if(searchCount > 0) {
				break SEARCH_LOOP;
			}else {
				continue;
			}
		}
		
	}//searchArticle
	
	private void deleteArticle() {
		DELETE_LOOP: while(true) {

			System.out.println("삭제 할 이름 입력 : ");
			String deleteName = sc.next();
			
			listIter = article.listIterator();
			
			int deleteCount = 0;
			
			while(listIter.hasNext()) {
				ScoreDTO tempDTO = listIter.next();
				if(tempDTO.getName().equals(deleteName)) {
					System.out.println(tempDTO.messageDelete()); 
					listIter.remove();
					deleteCount++;
				}
			}
			
			if(deleteCount > 0) {
				System.out.println(deleteCount + " 번 삭제를 완료하였습니다.");
				break DELETE_LOOP;
			}else {
				System.out.println("삭제하고자 하는 이름이 데이터에 없습니다. 다시 입력해주세요.");
				continue;
			}
			
			
		}
	}//delteArticle
}
