package vm08_Inheritance;

import java.util.Scanner;

class CalendarTest{
	
	private int year;
	private int month;
	private Scanner sc = new Scanner(System.in);
	private int[] initialDayWeek;
	
	//method that distinguish whether the given year is the leap one or not.
	public boolean isLeap(int year) {
		boolean result = false;
		
		if(year% 400 == 0) {
			result = true;
		}else {
			if(year % 4 == 0) {
				result = true;
			}
			
			if(year % 100 == 0) {
				result = false;
			}
		}
		
		return result;
		
	}//isLeap()
	
	//method that returns the long of a month.
	public int getLong(int year, int month) {
		int result = -1;
		
		switch(month) {
		case 1:
			result =  31; break;
		case 2:
			if(isLeap(year)) {
				result = 29;
			}else {
				result = 28;
			}
			break;
		case 3:
			result = 31; break;
		case 4:
			result = 30; break;
		case 5:
			result = 31; break;
		case 6:
			result = 30; break;
		case 7:
			result = 31; break;
		case 8:
			result = 31; break;
		case 9:
			result = 30; break;
		case 10:
			result = 31; break;
		case 11:
			result = 30; break;
		case 12:
			result = 30; break;
		}//switch(month)
		
		return result;
	}//getLong()
	
	//method that returns the initial day of each month of AC1.
	public int[] getInitialDay() {
		//index 0 is Jan.
		int[] initialDay = new int[12];
		initialDay[0] = 1;
		
		for(int i = 1; i < initialDay.length; i++) {
			int preMonth = i;
			initialDay[i] = (initialDay[i-1] + (getLong(1,preMonth) % 7)) % 7;
		}//for
		
		return initialDay;
	}//getInitialDay()
	
	//method to find the value how many days will be pushed by the passed year by considering the leap years.
	public int getPushedDay(int givenYear) {
		int passedYear = givenYear - 1;
		int leapYear = givenYear /4;
		int year100 = givenYear / 100;
		int year400 = givenYear / 400;
		int pushedDay = (passedYear + leapYear - year100 + year400) % 7;
		
		return pushedDay;
	}//getPushedDay();
	
	//method to get the beginning day of the given month of that year.
	public int getStartDay(int givenYear, int givenMonth) {
		int initialDay = initialDayWeek[givenMonth-1];
		//cos the Jan index in initialDayWeek integer array is 0.
		int startDay = -1;
		int pushedDay = getPushedDay(givenYear);
		
		startDay = (initialDay + pushedDay ) % 7;
		
		if(isLeap(givenYear)) {
			if(givenMonth < 3) {
				startDay--;
			}
		}
		
		if(startDay < 0) {
			startDay += 7;
		}
		
		return startDay;
	}//getStartDay();
	
	//printCalendar()
	public void printCalendar(int givenYear, int givenMonth) {
		int startDay = getStartDay(givenYear, givenMonth);
		int endDay = getLong(givenYear, givenMonth);
		
		System.out.printf("%3s%2s%3s%2s%3s%2s%3s\n",
				"일"," 월","화","  수","목"," 금","토");
		
		for(int c = 0; c < startDay + endDay; c++) {
			if(c!=0 && c%7 == 0) {
				System.out.println();
			}
			if(c >= startDay ) {
				System.out.printf("%3d",c-startDay + 1);
			}else {
				System.out.printf("%3s"," ");
			}
		}
	}//printCalendar()
	
	//constructor, which conducts initialize its field of class.
	public CalendarTest() {
		initialDayWeek = getInitialDay();
		System.out.println("년도 입력 : ");
		this.year = sc.nextInt();
		System.out.println("월 입력 : ");
		this.month = sc.nextInt();
		
		printCalendar(this.year, this.month);
	}//constructor()
	
}

public class myCalendarMain {

	public static void main(String[] args) {

		CalendarTest cal = new CalendarTest();
		//그냥 CalendarTest 객체 생성용
		
	}

}
