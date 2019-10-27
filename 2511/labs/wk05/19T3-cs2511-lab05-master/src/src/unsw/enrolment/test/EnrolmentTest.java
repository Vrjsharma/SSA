package unsw.enrolment.test;

import java.time.DayOfWeek;
import java.time.LocalTime;


import unsw.enrolment.CompositeMark;
import unsw.enrolment.Course;
import unsw.enrolment.CourseOffering;
import unsw.enrolment.Enrolment;
import unsw.enrolment.EnrolmentPrinter;
import unsw.enrolment.LeafMark;
import unsw.enrolment.Lecture;
import unsw.enrolment.Student;

import unsw.enrolment.Tutorial;

public class EnrolmentTest {

    public static void main(String[] args) {

        // Create courses
        Course comp1511 = new Course("COMP1511", "Programming Fundamentals");
        Course comp1531 = new Course("COMP1531", "Software Engineering Fundamentals");
        comp1531.addPrereq(comp1511);
        Course comp2521 = new Course("COMP2521", "Data Structures and Algorithms");
        comp2521.addPrereq(comp1511);

        CourseOffering comp1511Offering = new CourseOffering(comp1511, "19T1");
        CourseOffering comp1531Offering = new CourseOffering(comp1531, "19T1");
        CourseOffering comp2521Offering = new CourseOffering(comp2521, "19T2");

        // Create some sessions for the courses
        Lecture lecture1511 = new Lecture(comp1511Offering, "Rex Vowels", DayOfWeek.TUESDAY, LocalTime.of(12, 0),LocalTime.of(14, 0), "Andrew Taylor");
        Lecture lecture1531 = new Lecture(comp1531Offering, "CLB 5", DayOfWeek.MONDAY, LocalTime.of(9, 0),LocalTime.of(11, 0), "Aarthi Natarajan");
        Lecture lecture2521 = new Lecture(comp2521Offering, "Clancy Auditorium", DayOfWeek.FRIDAY, LocalTime.of(15, 0),LocalTime.of(17, 0), "Ashesh Mahidadia");

        Tutorial tute1531 = new Tutorial(comp1531Offering, "Quad 1041", DayOfWeek.WEDNESDAY, LocalTime.of(18, 0), LocalTime.of(19,0), "Hugh Chan");

        // Create a student
        Student student = new Student("z5555555");

        // Enrol the student in COMP1511 for T1 (this should succeed)
        Enrolment comp1511Enrolment = comp1511Offering.enrol(student, lecture1511);

        if (comp1511Enrolment != null)
            System.out.println("Enrolled in COMP1511");

        // Enrol the student in COMP1531 for T1 (this should fail as they
        // have not met the prereq)
        Enrolment comp1531Enrolment = comp1531Offering.enrol(student, lecture1531, tute1531);

        if (comp1531Enrolment == null)
            System.out.println("Can't enrol in COMP1531");
       


        // Give the student a passing grade for COMP1511
//        comp1511Enrolment.assignMark(65);
        //now all marks have to be assigned before the final grade is assigned.

        
        // Assign marks for comp1511
	    @SuppressWarnings("unused")
		EnrolmentPrinter printer = new EnrolmentPrinter(comp1511Enrolment.makePrinterID());
	    comp1511Enrolment.registerObserver(printer);
        // TODO Give the student a passing mark for assignment 1
        //prac has maximum mark of 50 
        CompositeMark prac = new CompositeMark(50, "prac");
        //student gets 15 marks for assignment 1  (20 mark maximum)
        LeafMark assignment1 = new LeafMark( 15, "Assignment 1");
        comp1511Enrolment.addMark(assignment1);
        //30 is the maximum marks you can get for ass2
        CompositeMark assignment2 = new CompositeMark(30, "Assignment 2");
        

        // TODO Give the student a passing mark for milestone 1 of assignment 2
        LeafMark milestone1 = new LeafMark(20, "Milestone 1");
        comp1511Enrolment.addMark(milestone1);
        // TODO Give the student a passing mark for milestone 2 of assignment 2
        LeafMark milestone2 = new LeafMark(30, "Milestone 2");  
        comp1511Enrolment.addMark(milestone2);
        
        // TODO Give the student an assignment 2 mark which is the average of
        // milestone 1 and 2
        assignment2.add(milestone1);
        assignment2.add(milestone2);
        //this sets the mark for ass2
        assignment2.setAverageMark();
        comp1511Enrolment.addMark(assignment2);
       System.out.println(assignment2.getMark() + "printing the ass2 mark");
        
        // TODO Give the student a prac mark which is the sum of assignment 1
        // and 2
       prac.add(assignment1);
       prac.add(assignment2);
       prac.setTotalMark();
       comp1511Enrolment.addMark(prac);
       	
        System.out.println(prac.getMark() + "printing the prac mark");
        
        // TODO Give the student a passing exam mark.
        LeafMark exam = new LeafMark(45, "exam");
        comp1511Enrolment.addMark(exam);
        //final mark has max mark 100
        CompositeMark finalMark = new CompositeMark(100, "finalMark");
        finalMark.add(prac);
        finalMark.add(exam);
        finalMark.setTotalMark();
        comp1511Enrolment.addMark(finalMark);
        int overallMark = finalMark.getMark();
        System.out.println(finalMark.getMark() + "printing the total");
        comp1511Enrolment.setGrade(overallMark);
        
        // Enrol the student in 2521 (this should succeed as they have met
        // the prereqs)
        
        Enrolment comp2521Enrolment = comp2521Offering.enrol(student, lecture2521);

        if (comp2521Enrolment != null)
            System.out.println("Enrolled in COMP2521");
        
    }
}
