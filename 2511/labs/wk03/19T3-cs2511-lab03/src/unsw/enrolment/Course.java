package unsw.enrolment;
import java.util.ArrayList;
import java.util.List;

/**
 * A course in the enrolment system.
 * @author Robert Clifton-Everest
 *
 */
public class Course {

    private String courseCode;
    private String title;
    private int uoc;
    private List<Course> prereqs = new ArrayList<Course>();
    private List<CourseOffering> courseOfferings = new ArrayList<CourseOffering>();


    public Course(String courseCode, String title,int uoc) {
        this.courseCode = courseCode;
        this.title = title;
        this.uoc = uoc;        
    }

    public void addPrereq(Course course) {
        this.prereqs.add(course);
    }
    
    public void addCourseOffering(CourseOffering courseOffering) {
    	this.courseOfferings.add(courseOffering);
    }

    public List<Course> getPrereqs() {
		return prereqs;
	}

	public void setPrereqs(List<Course> prereqs) {
		this.prereqs = prereqs;
	}

	public String getCourseCode() {
        return this.courseCode;
    }
    
    public String getCourseTitle() {
    	return this.title;
    }

    public int getUOC() {
        return this.uoc;
    }

}
