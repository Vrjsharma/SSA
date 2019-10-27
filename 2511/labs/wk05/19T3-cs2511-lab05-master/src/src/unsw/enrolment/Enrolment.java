package unsw.enrolment;

import java.util.ArrayList;
import java.util.List;

public class Enrolment implements EnrolmentSubj{

    private CourseOffering offering;
    private Grade grade;
    private Student student;
    private List<Session> sessions;
    private ArrayList<MarkComponent> allMarks;
    private ArrayList<EnrolmentObserver> observers;
    

    public Enrolment(CourseOffering offering, Student student, Session... sessions) {
        this.offering = offering;
        this.student = student;
        this.grade = null; // Student has not completed course yet.
        student.addEnrolment(this);
        offering.addEnrolment(this);
        this.sessions = new ArrayList<>();
        for (Session session : sessions) {
            this.sessions.add(session);
        };
        this.allMarks = new ArrayList<MarkComponent>();
        this.observers = new ArrayList<>();
    }

    public Course getCourse() {
        return offering.getCourse();
    }

    public String getTerm() {
        return offering.getTerm();
    }

    public boolean hasPassed() {
        return grade != null && grade.isPassing();
    }
    
    //a students grade is the final overall mark for thier course
    public void setGrade(int finalMark) {
    	this.grade = new Grade(finalMark);
    }
    
    //evereytime a new mark is added to enrolment update the observer
    public void addMark(MarkComponent mark) {
    	allMarks.add(mark);
    	notifyObservers();
    }

	@Override
	public void registerObserver(EnrolmentObserver o) {
		if (!observers.contains(o)) {
			observers.add(o);
		}
		
	}

	@Override
	public void removeObserver(EnrolmentObserver o) {
		observers.remove(o);
		
	}

	@Override
	public void notifyObservers() {
		for (EnrolmentObserver o: observers) {
			o.update(this);
		}
		
	}

	public CourseOffering getOffering() {
		return offering;
	}

	public Grade getGrade() {
		return grade;
	}

	public Student getStudent() {
		return student;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public ArrayList<MarkComponent> getAllMarks() {
		return allMarks;
	}
	//returns most recent mark added s
	public  MarkComponent getLatestMark() {
		int index =  allMarks.size() -1;
		return  allMarks.get(index);
	}
	
	


	public ArrayList<EnrolmentObserver> getObservers() {
		return observers;
	}

	//returns the printer id in the format of course code + term + student 
	public String makePrinterID() {
		// TODO Auto-generated method stub
		return offering.getCourse().getCourseCode() + "-" + offering.getTerm() + "-" + student.getZID();
	}
	


}
