package vm07_Collection;

import java.util.Scanner;

public class CollectTask01_way2 {

	private String str, oldStr, newStr;
	private int rplCount;
	
	private void setInitial() {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("���ڿ� �Է� : ");
		this.str = sc1.next().toLowerCase();
		System.out.println("���� ���ڿ��� �Է����ּ��� : ");
		this.oldStr = sc1.next().toLowerCase();
		System.out.println("�ٲ� ���ڿ��� �Է����ּ��� : ");
		this.newStr = sc1.next().toLowerCase();
		
	}
	
	private void replaceProcess() {
		if(oldStr.length() > str.length()) {
			System.out.println("�������� �� ���ڿ��� �ٲ� �� �����ϴ�. ������ �����մϴ�.");
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
						System.out.println("�Է��Ͻ� ���ڿ��� ã�� �� �����ϴ�.");
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
		System.out.println(rplCount + "�� ġȯ�Ϸ��߽��ϴ�.");
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
