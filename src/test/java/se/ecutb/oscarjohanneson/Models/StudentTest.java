package se.ecutb.oscarjohanneson.Models;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void test_If_Student_Was_created(){
        Student testStudent = new Student(1, "Anna", "anna@gmail.com", "Storgatan 1");

        String expectedName = "Anna";
        String expectedEmail = "anna@gmail.com";
        String expectedAddress = "Storgatan 1";

        Assert.assertTrue(testStudent.getId() > 0);
        Assert.assertEquals(expectedName, testStudent.getName());
        Assert.assertEquals(expectedEmail, testStudent.getEmail());
        Assert.assertEquals(expectedAddress, testStudent.getAddress());
    }
}
