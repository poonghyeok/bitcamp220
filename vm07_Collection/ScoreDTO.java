package vm07_Collection;

public class ScoreDTO {
	
	private int no, kor, eng, math, total;
	private String name;
	private double avg;
	
	public ScoreDTO(int no, String name, int kor, int eng, int math) {
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor + eng + math;
		this.avg = (double)total / 3;
	}
	
	//getter
	public int getNo() {
		return this.no;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getKor() {
		return this.kor;
	}
	
	public int getEng() {
		return this.eng;
	}
	
	public int getMath() {
		return this.math;
	}
	
	public int getTotal() {
		return this.total;
	}
	
	public double getAvg() {
		return this.avg;
	}
	
	public String messageDelete() {
		
		return ("번호" + no + " 삭제 작업 완료..!");
		
	}
	
	public String toString() {
		if(this.avg - (int)this.avg > 0) {
			return String.format("%3d\t%5s\t%3d\t%3d\t%3d\t%3d\t%3.2f", this.no, this.name, this.kor, this.eng, this.math, this.total, this.avg);
		}else {
			return String.format("%3d\t%5s\t%3d\t%3d\t%3d\t%3d\t%3d", this.no, this.name, this.kor, this.eng, this.math, this.total, (int)this.avg);
			
		}
	}
	
	
	
}
