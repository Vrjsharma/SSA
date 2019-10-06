package unsw.enrolment;
import java.util.ArrayList;

public class Student {

    private String zid;
    private ArrayList<Enrolment> enrolments = new ArrayList<Enrolment>();

	public ArrayList<Enrolment> getEnrolments() {
		return enrolments;
	}

	public void adjust(int index,Enrolment updatedEnrolment) {
		enrolments.set(index, updatedEnrolment);
	}

	public Student(String zid) {
        this.zid = zid;
    }

	public String getZID() {
		return zid;
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
    
	public boolean completedCourse(Course course) {
		for (Enrolment course1: enrolments) {
			if ((course1.getCourse().getCourseTitle().equals(course.getCourseTitle())
					&& course1.getCourse().getCourseCode().equals(course.getCourseCode()))) {
				if(course1.getGrade() >= 50) return true;
			}
		}
		return false;
	}
	
	public void makeEnrolment(Enrolment newEnrolment) {
		enrolments.add(newEnrolment);
	}

}
