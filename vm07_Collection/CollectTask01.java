package vm07_Collection;

import java.util.Scanner;

public class CollectTask01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("문자열 입력 : ");
		String str = sc.next().toLowerCase();
		int initialStrLength = str.length();
		
		System.out.println("현재 문자열을 입력해주세요 : ");
		String oldStr = sc.next().toLowerCase();
		
		System.out.println("바꿀 문자열을 입력해주세요 : ");
		String newStr = sc.next().toLowerCase();
		
		int rplCount = 0;
		
		if(oldStr.length() > str.length()) {
			System.out.println(" 변경이 불가능합니다. 변경을 희망하는 문자열은 기존 문자열보다 작거나 같아야합니다.");
		}else {
			int searchLoc = 0;
			while(true) {
				int oldIndex = str.indexOf(oldStr,searchLoc);
				
				if(oldIndex >= initialStrLength) {
					break;
				}
				
				if(oldIndex != -1) {
					str = str.replaceFirst(oldStr, newStr);
					rplCount++;
					searchLoc += (oldIndex + newStr.length());
				}else {
					if(rplCount == 0) {
						System.out.println("입력하신 문자열을 찾을 수 없습니다.");
						System.exit(0);
					}
					break;
					
				}
			}
			System.out.println(str);
			System.out.println(rplCount + "번 치환완료했습니다.");
		}
		
		
		
			
	}
	


}
