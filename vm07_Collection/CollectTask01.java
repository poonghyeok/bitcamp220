package vm07_Collection;

import java.util.Scanner;

public class CollectTask01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("���ڿ� �Է� : ");
		String str = sc.next().toLowerCase();
		int initialStrLength = str.length();
		
		System.out.println("���� ���ڿ��� �Է����ּ��� : ");
		String oldStr = sc.next().toLowerCase();
		
		System.out.println("�ٲ� ���ڿ��� �Է����ּ��� : ");
		String newStr = sc.next().toLowerCase();
		
		int rplCount = 0;
		
		if(oldStr.length() > str.length()) {
			System.out.println(" ������ �Ұ����մϴ�. ������ ����ϴ� ���ڿ��� ���� ���ڿ����� �۰ų� ���ƾ��մϴ�.");
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
						System.out.println("�Է��Ͻ� ���ڿ��� ã�� �� �����ϴ�.");
						System.exit(0);
					}
					break;
					
				}
			}
			System.out.println(str);
			System.out.println(rplCount + "�� ġȯ�Ϸ��߽��ϴ�.");
		}
		
		
		
			
	}
	


}
