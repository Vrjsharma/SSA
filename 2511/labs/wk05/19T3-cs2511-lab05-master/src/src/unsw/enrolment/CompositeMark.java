package unsw.enrolment;

import java.util.ArrayList;



public class CompositeMark implements MarkComponent {
	 private String name;
	 private int mark;
	 private int maxMark;
	 ArrayList<MarkComponent>  children = new ArrayList<MarkComponent>();
	 

	 //making the component before the mark
	 public CompositeMark (int maxMark, String name) {
		 super();
		 this.name = name;
		 this.maxMark = maxMark;
		 this.mark = 0;
	 }

	public int calculateTotalMark() {
		int totalMark = this.getMark();
		for(MarkComponent c : children) {
			totalMark += c.getMark();
		}
		return totalMark;	
	}

	
	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}
	
	public void setAverageMark() {
		this.mark = averageMark();
	}
	public void setTotalMark() {
		this.mark = calculateTotalMark();
	}


	
	public int averageMark() {
		int totalMark = calculateTotalMark();
		int averageMark = (totalMark/children.size());
		return averageMark;	
	}

	public int getMaxMark() {
		return maxMark;
	}

	public void setMaxMark(int maxMark) {
		this.maxMark = maxMark;
	}
	
	public boolean add(MarkComponent child) {
		children.add(child);
		return true;
	}

	public boolean remove(MarkComponent child) {
		children.remove(child);
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	


}
