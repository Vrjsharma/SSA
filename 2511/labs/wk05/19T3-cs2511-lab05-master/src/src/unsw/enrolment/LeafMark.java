package unsw.enrolment;

public class LeafMark implements MarkComponent{
	private int mark;
	private String name;

	
	
	public int calculateTotalMark() {
		return this.mark;
	}
	public LeafMark(int mark, String name) {
		super();
		this.mark = mark;
		this.name = name;
	}
	
	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}


	public int averageMark() {
		return this.mark;
	}
	public String getName() {
		return name;
	}
	

	

}
