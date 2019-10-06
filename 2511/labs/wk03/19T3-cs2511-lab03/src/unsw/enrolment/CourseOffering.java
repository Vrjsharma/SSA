package unsw.enrolment;
import java.util.ArrayList;
import java.util.List;

public class CourseOffering {

    private Course course;
    private String term;
    private List<Session> sessions = new ArrayList<Session>();
    private List<Enrolment> enrolments = new ArrayList<Enrolment>();

    public CourseOffering(Course course, String term) {
        this.course = course;
        this.term = term;
    }

    public void addSession(Session session) {
        sessions.add(session);
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
    
	public void adjust(int index,Enrolment updatedEnrolment) {
		enrolments.set(index, updatedEnrolment);
	}    
    
    public void addEnrolment(Enrolment newEnrolment) {
    	enrolments.add(newEnrolment);
    }

    public Course getCourse() {
        return course;
    }

    public String getTerm() {
        return term;
    }

}
