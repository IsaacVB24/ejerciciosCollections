package com.generation;

import java.util.HashMap;
import java.util.List;

public class CourseService {
    HashMap<String, Student> students = new HashMap<>();

    HashMap<String, Course> courses = new HashMap<>();
    
    HashMap<String, Integer> studentsEnrolled = new HashMap<>();

    public CourseService() {
        students.put( "120120", new Student( "Santiago", "120120" ) );
        students.put( "884545", new Student( "Kate", "884545" ) );
        students.put( "458787", new Student( "Alejandra", "458787" ) );
        students.put( "135464", new Student( "Maria", "135464" ) );
        students.put( "778979", new Student( "Peter", "778979" ) );

        courses.put( "math_01", new Course( "Mathematics 1", "math_01", 8 ) );
        courses.put( "biol_01", new Course( "Biology 1", "biol_01", 8 ) );
        courses.put( "phys_01", new Course( "Physics 1", "phys_01", 8 ) );
        courses.put( "art_01", new Course( "Arts 1", "art_01", 8 ) );
        courses.put( "chem_01", new Course( "Chemistry 1", "chem_01", 8 ) );
        courses.put( "sport_01", new Course( "Sports 1", "sport_01", 8 ) );
    }

    public void enrollStudent(String studentId, String courseId) {
    	Student estudiante = students.get(studentId);
    	Course curso = courses.get(courseId);
    	estudiante.enroll(curso);
    	System.out.println("The student with ID " + studentId + " has been enrolled to " + curso.name + ".\n");
    }

    public void unEnrollStudent(String studentId, String courseId) {
    	Student estudiante = students.get(studentId);
    	Course curso = courses.get(courseId);
    	estudiante.unEnroll(curso);
    	System.out.println("The student with ID " + studentId + " has been unenrolled to " + curso.name + ".\n");
    }

    public void displayCourseInformation(String courseId) {
    	Course curso = courses.get(courseId);
    	System.out.println("<<< Information of " + curso.name + " >>>");
    	System.out.println("ID: " + curso.id + "\nCredits: " + curso.credits + "\n");
    }

    public void displayStudentInformation(String studentId) {
    	Student estudiante = students.get(studentId);
    	List<Course> enrolledCourses = estudiante.getEnrolledCourses();
    	System.out.println("<<< Information of " + estudiante.name + " >>>");
    	if(enrolledCourses.size() > 0) {
	    	System.out.println("The student with ID: " + estudiante.id + " is enrolled to:");
	    	for (Course course : enrolledCourses) {
				System.out.println(course.name);
			}
	    	System.out.println();
    	} else {
    		System.out.println("The student with ID: " + estudiante.id + " is not enrolled to any course yet.\n");
    	}
    }
}
