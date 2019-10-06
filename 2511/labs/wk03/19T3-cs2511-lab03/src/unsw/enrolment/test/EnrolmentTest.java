package unsw.enrolment.test;

import java.time.DayOfWeek;
import java.time.LocalTime;

import unsw.enrolment.Course;
import unsw.enrolment.CourseOffering;
import unsw.enrolment.Enrolment;
import unsw.enrolment.EnrolmentSystem;
import unsw.enrolment.Lecture;
import unsw.enrolment.Student;
import unsw.enrolment.Session;

public class EnrolmentTest {

    public static void main(String[] args) {

        // Create courses
        Course comp1511 = new Course("COMP1511", "Programming Fundamentals",6);
        Course comp1531 = new Course("COMP1531", "Software Engineering Fundamentals",6);
        comp1531.addPrereq(comp1511);
        Course comp2521 = new Course("COMP2521", "Data Structures and Algorithms",6);
        comp2521.addPrereq(comp1511);

        CourseOffering comp1511Offering = new CourseOffering(comp1511, "19T1");
        CourseOffering comp1531Offering = new CourseOffering(comp1531, "19T1");
        CourseOffering comp2521Offering = new CourseOffering(comp2521, "19T2");

        // TODO Create some sessions for the courses
        Session Comp1511Sesh1 = new Session("RC121",DayOfWeek.TUESDAY,LocalTime.of(14,0),LocalTime.of(17, 0));
        Session Comp1511Sesh2 = new Session("Quad1071",DayOfWeek.FRIDAY,LocalTime.of(11,0),LocalTime.of(14, 0));
        Session Comp1531Sesh1 = new Session("Business101",DayOfWeek.MONDAY,LocalTime.of(10,0),LocalTime.of(13, 0));
        Session Comp1531Sesh2 = new Session("Science12",DayOfWeek.TUESDAY,LocalTime.of(17,0),LocalTime.of(20, 0));
        Session Comp2521Sesh1 = new Session("Fun12",DayOfWeek.TUESDAY,LocalTime.of(13,0),LocalTime.of(16, 0));
        Session Comp2521Sesh2 = new Session("Copy123",DayOfWeek.THURSDAY,LocalTime.of(11,0),LocalTime.of(14, 0));
        
        EnrolmentSystem UNSWEnrolmentSystem = new EnrolmentSystem();
        // TODO Create a student
        Student stud1 = new Student("z5111111");
        UNSWEnrolmentSystem.addStudents(stud1);
        // TODO Enrol the student in COMP1511 for T1 (this should succeed)
        UNSWEnrolmentSystem.addEnrolment(comp1511Offering, stud1);
        
        
        // TODO Enrol the student in COMP1531 for T1 (this should fail as they
        // have not met the prereq)
        UNSWEnrolmentSystem.addEnrolment(comp1531Offering, stud1);

        
//        CourseOffering COMP1531S2 = new CourseOffering(Comp1531,"2");
//        Enrolment enroll1 = new Enrolment(COMP1531S2,stud1);
//        System.out.println(Comp1531.getUOC());

        // TODO Give the student a passing grade for COMP1511
        int i = UNSWEnrolmentSystem.searchEnrolment(comp1511Offering, stud1);
        
        //System.out.println(UNSWEnrolmentSystem.getEnrolments().get(i).getGrade());
        UNSWEnrolmentSystem.assignGrades(comp1511Offering, stud1, 65, "C");
        
        

        // TODO Enrol the student in 2521 (this should succeed as they have met
        // the prereqs)
        UNSWEnrolmentSystem.addEnrolment(comp2521Offering, stud1);
        

    }
}
