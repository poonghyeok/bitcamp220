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
						System.out.println("���α׷��� �����մϴ�.");
						System.exit(0);
				}//switch
				
			}else {
				System.out.println("1~6 �� �Է����ּ���");
				continue;
			}
		
		}//while
			
	}//mainProcess
	
	//menu method for a user to execute a certain utility.
	private int menu() {
		System.out.println(decoStar);
		System.out.println("1. �Է� : " );
		System.out.println("2. ��� : ");
		System.out.println("3. �˻� : ");
		System.out.println("4. ���� : ");
		System.out.println("6. �� : ");
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
		System.out.println("��ȣ �Է� : ");
		int inputNo = sc.nextInt();
		
		System.out.println("�̸� �Է� : ");
		String inputName = sc.next();
		
		System.out.println("���� �Է� : ");
		int inputKor = sc.nextInt();
		
		System.out.println("���� �Է� : ");
		int inputEng = sc.nextInt();	
		
		System.out.println("���� �Է� : ");
		int inputMath = sc.nextInt();
		
		article.add(new ScoreDTO(inputNo, inputName, inputKor, inputEng, inputMath));
		
		System.out.println("�����͸� �����Ͽ����ϴ�. ");
		
		
	}//insertArticle

	//method to print article..
	private void printArticle() {
		System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");
		listIter = article.listIterator();
		
		while(listIter.hasNext()) {
			System.out.println(listIter.next().toString());
		}
	
	}//printArticle

	//searchArticle_main_method to search and print row that meet the condition of same name.
	private void searchArticle() {
		SEARCH_LOOP: while(true) {

			System.out.println("�˻� �� �̸� �Է� : ");
			String searchName = sc.next();
			
			listIter = article.listIterator();
			System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");

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

			System.out.println("���� �� �̸� �Է� : ");
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
				System.out.println(deleteCount + " �� ������ �Ϸ��Ͽ����ϴ�.");
				break DELETE_LOOP;
			}else {
				System.out.println("�����ϰ��� �ϴ� �̸��� �����Ϳ� �����ϴ�. �ٽ� �Է����ּ���.");
				continue;
			}
			
			
		}
	}//delteArticle
}
