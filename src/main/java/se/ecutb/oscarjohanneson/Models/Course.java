package se.ecutb.oscarjohanneson.Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course {

    private static int idCounter;
    private int id;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private List<Student> students;

    //Constructor used for testing.
    public Course(int id, String courseName, LocalDate startDate, int weekDuration) {
        this.id = id;
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
        this.students = new ArrayList<>();
    }

    //Constructor used for creating a course.
    public Course(String courseName, LocalDate startDate, int weekDuration){
        this(++idCounter, courseName, startDate, weekDuration);
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getWeekDuration() {
        return weekDuration;
    }

    public void setWeekDuration(int weekDuration) {
        this.weekDuration = weekDuration;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    //Method to add a student to course.
    public void register(Student student){
        //If student already is registered to this course.
        if(students.contains(student)){
            System.out.println(student.getName() + " is already registered to this course.");
        }else{
            //Adding student to studentList.
            students.add(student);
            System.out.println(student.getName() + " was added to this course");
        }
    }

    //Method to remove a student from course.
    public void unregister(Student student){
        if(students.contains(student)){
            //Remove student from studentList.
            students.remove(student);
            System.out.println(student.getName() + " was removed.");
        }else{
            System.out.println("No object was found.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id &&
                weekDuration == course.weekDuration &&
                Objects.equals(courseName, course.courseName) &&
                Objects.equals(startDate, course.startDate) &&
                Objects.equals(students, course.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseName, startDate, weekDuration, students);
    }

    @Override
    public String toString() {
        return " --- Course: --- " + "\nid = " + id + "\ncourseName = " + courseName  + "\nstartDate = " + startDate + "\nweekDuration = " + weekDuration +
                "\nstudents = " + students;
    }
}
