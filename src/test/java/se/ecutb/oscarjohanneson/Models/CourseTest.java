package se.ecutb.oscarjohanneson.Models;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;

public class CourseTest {

    private Student testStudent;
    private Student testStudent2;
    private Course testObject;


    @Before
    public void setUp(){
        testStudent = new Student(1, "anna", "anna@gmail.com", "Storgatan 1");
        testStudent2 = new Student(2 , "Anders", "anders@gmail.com", "Parkgatan 2");
        testObject = new Course(1, "Matematik", LocalDate.parse("2019-08-03"), 6);
    }

    @Test
    public void test_If_Course_Was_Created(){
        String expectedName = "Matematik";
        LocalDate expectedDate = LocalDate.parse("2019-08-03");
        int expectedWeekDuration = 6;

        Assert.assertTrue(testObject.getId() > 0);
        Assert.assertEquals(expectedName, testObject.getCourseName());
        Assert.assertEquals(expectedDate, testObject.getStartDate());
        Assert.assertEquals(expectedWeekDuration, testObject.getWeekDuration());
    }

    @Test
    public void test_If_Student_Was_Added(){
        int expectedSize = 2;
        testObject.register(testStudent);
        testObject.register(testStudent2);

        Assert.assertEquals(expectedSize, testObject.getStudents().size());

    }

    @Test
    public void test_If_Possible_To_Add_Already_Existing_Student(){
        int expectedSize = 1;
        testObject.register(testStudent);
        testObject.register(testStudent);

        Assert.assertEquals(expectedSize, testObject.getStudents().size());
    }

    @Test
    public void test_If_Student_Was_removed(){
        int expectedSize = 1;
        testObject.register(testStudent);
        testObject.register(testStudent2);
        testObject.unregister(testStudent2);

        Assert.assertEquals(expectedSize, testObject.getStudents().size());
    }

    @Test
    public void test_If_possible_To_Remove_Unregistered_Student(){
        int expectedSize = 0;
        testObject.unregister(testStudent);

        Assert.assertEquals(expectedSize, testObject.getStudents().size());
    }

    @After
    public void afterTest(){
        testObject.getStudents().clear();
    }

}
