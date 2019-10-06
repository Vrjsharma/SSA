package unsw.enrolment;
import java.util.ArrayList;
import java.util.List;

public class EnrolmentSystem {
	
	private ArrayList<Course> courses = new ArrayList<Course>();
    private ArrayList<Enrolment> enrolments = new ArrayList<Enrolment>();
    private ArrayList<Student> students = new ArrayList<Student>();
    
    public EnrolmentSystem() {
    }
    
    public ArrayList<Enrolment> getEnrolments() {
		return enrolments;
	}

	public void setEnrolments(ArrayList<Enrolment> enrolments) {
		this.enrolments = enrolments;
	}

	public void addCourse(Course course) {
    	this.courses.add(course);
    }
    
    public static boolean checkPrereq(Course course,Student student) {
    	for(Course crs1: course.getPrereqs()) {
    		if(student.completedCourse(crs1) == true) continue;
    		return false;
    	}
    	return true;
    }
    
    public void addEnrolment(CourseOffering courseOffer, Student student) {
    	if(checkPrereq(courseOffer.getCourse(),student) == true) {
    		student.makeEnrolment(new Enrolment(courseOffer,student));
    		courseOffer.addEnrolment(new Enrolment(courseOffer,student));
    		enrolments.add(new Enrolment(courseOffer,student));
    		System.out.println("Enrolment Successful");
    	} else {
    		System.out.println("Enrolment Unsuccessful, doesnt meet requirements");
    	}
    }
    
    public void addStudents(Student student) {
    	students.add(student);
    }

    public void addCourses(Course course) {
    	courses.add(course);
    }
    
    public int searchEnrolment(CourseOffering Offer,Student student) {
    	for(int i = 0; i < enrolments.size();i++) {
			if(enrolments.get(i).getCourse().equals(Offer.getCourse()) &&
				enrolments.get(i).getTerm().equals(Offer.getTerm()) &&
				enrolments.get(i).getStudentZid().equals(student.getZID()))
				return i;
    	}
    	return 0;
    }
    public void assignGrades(CourseOffering Offer,Student student,
    		int mark,String grade) {
		int i = searchEnrolment(Offer,student);
		Enrolment newEnrolment = enrolments.get(i);
		newEnrolment.assignGrades(mark, grade);
		this.enrolments.set(i,newEnrolment);
		int j = student.searchEnrolment(Offer, student);
		student.adjust(j, newEnrolment);
		int k = Offer.searchEnrolment(Offer, student);
		Offer.adjust(k, newEnrolment);		
    }
    	
}
