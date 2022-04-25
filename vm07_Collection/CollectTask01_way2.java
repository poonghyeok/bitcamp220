package vm07_Collection;

import java.util.Scanner;

public class CollectTask01_way2 {

	private String str, oldStr, newStr;
	private int rplCount;
	
	private void setInitial() {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("문자열 입력 : ");
		this.str = sc1.next().toLowerCase();
		System.out.println("현재 문자열을 입력해주세요 : ");
		this.oldStr = sc1.next().toLowerCase();
		System.out.println("바꿀 문자열을 입력해주세요 : ");
		this.newStr = sc1.next().toLowerCase();
		
	}
	
	private void replaceProcess() {
		if(oldStr.length() > str.length()) {
			System.out.println("본문보다 긴 문자열은 바꿀 수 없습니다. 변경을 종료합니다.");
		}else {
			int searchLoc = 0;
			int initialLength = str.length();
			
			while(true) {
				
				int oldIndex = str.indexOf(oldStr,searchLoc);
				if(oldIndex >= initialLength) {
					break;
				}
				
				if(oldIndex != -1) {
					rplCount++;
					searchLoc = (oldIndex + oldStr.length());
				}else {
					if(rplCount == 0) {
						System.out.println("입력하신 문자열을 찾을 수 없습니다.");
						System.exit(0);
					}
					break;
				}
			}
			printResult();
		}
	}
	
	private void printResult() {
		System.out.println(str.replace(oldStr, newStr));
		System.out.println(rplCount + "번 치환완료했습니다.");
	}
	
	//constructor
	public CollectTask01_way2() {
		this.setInitial();
		this.replaceProcess();
	}
	
	
	public static void main(String[] args) {

		CollectTask01_way2 collect = new CollectTask01_way2();
		
	}
	
	
}
