package unsw.enrolment;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class EnrolmentPrinter implements EnrolmentObserver {
	private String id;
	
	
	//an enrolmentpinter's id is the  course + subject + student
	public EnrolmentPrinter(String id) {
		super();
		this.id = id;
	}


	@Override
	public void update(EnrolmentSubj e) {
		if (e instanceof Enrolment) {
			update((Enrolment) e);
		}
		
	}
	public void update(Enrolment e) {
		String cwd = System.getProperty("user.dir");
		String filename = cwd + "/" + id;
		//learned off stackoverflow
		String info = getMarkInfo(e);
        try { 
        	//this should work?
            BufferedWriter out = new BufferedWriter( 
                   new FileWriter(filename, true)); 
            out.write(info); 
            out.close(); 
        } 
        catch (IOException i) { 
            System.out.println("exception occoured" + i); 
        } 
	}

//get current date and time, the assessment, and the new mark 
	private String getMarkInfo(Enrolment e) {
		LocalDateTime now = LocalDateTime.now();
		String timeNow = now.toString();
		String formattedDate = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

		String info = "Date: " + formattedDate + " " + " mark name: " + e.getLatestMark().getName() +" " +  
		"Mark: " + e.getLatestMark().getMark() + "\n";
		return info;
	}

}
