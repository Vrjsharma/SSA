package unsw.enrolment;

/**
 * ONe enrolment can have many observers.
 * IN this case just need one  observer with the job to print things
 * But other observers which do different things can also be added
 * @author z5210294
 *
 */
public interface EnrolmentObserver {
	public void update(EnrolmentSubj e);
}
