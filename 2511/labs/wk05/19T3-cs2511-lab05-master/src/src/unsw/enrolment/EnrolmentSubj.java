package unsw.enrolment;



public interface EnrolmentSubj {
	public void registerObserver(EnrolmentObserver o);
	public void removeObserver(EnrolmentObserver o);
	public void notifyObservers();
}
