package unsw.enrolment;

public class Enrolment {

    private CourseOffering offering;
    private Grade grade;
    private Student student;

    public Enrolment(CourseOffering offering, Student student) {
        this.offering = offering;
        this.student = student;
        this.grade = new Grade(0,"TBA");
    }

    public Course getCourse() {
        return offering.getCourse();
    }

    public String getTerm() {
        return offering.getTerm();
    }
    
    public int getGrade() {
    	return grade.getMark();
    }
    
	public String getStudentZid() {
		return student.getZID();
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public void assignGrades(int mark,String grade) {
		this.grade.setMark(mark);
		this.grade.setGrade(grade);
	}

}
