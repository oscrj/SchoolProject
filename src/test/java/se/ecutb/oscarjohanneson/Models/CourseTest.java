package se.ecutb.oscarjohanneson.Models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseTest {

    Student testStudent;
    Student testStudent2;
    Course course;
    List<Student> students;


    @Before
    public void setUp(){
        testStudent = new Student(1, "anna", "anna@gmail.com", "Storgatan 1");
        testStudent2 = new Student(2 , "Anders", "anders@gmail.com", "Parkgatan 2");
        students = new ArrayList<>(Arrays.asList(testStudent));
        course = new Course(1, "Matematik", LocalDate.parse("2019-08-03"), 6, students);
    }

    @Test
    public void test_If_Course_Was_Created(){
        Assert.assertEquals(1, course.getId());
        Assert.assertEquals("Matematik", course.getCourseName());
        Assert.assertEquals(LocalDate.parse("2019-08-03"), course.getStartDate());
        Assert.assertEquals(6, course.getWeekDuration());
        Assert.assertEquals(students, course.getStudentList());
    }

    @Test
    public void test_If_Student_Was_Added(){

    }

    @Test
    public void test_If_Student_Was_removed(){

    }

}
