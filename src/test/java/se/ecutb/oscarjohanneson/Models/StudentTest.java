package se.ecutb.oscarjohanneson.Models;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void test_If_Student_Was_created(){
        Student testStudent = new Student(1, "Anna", "anna@gmail.com", "Storgatan 1");

        Assert.assertNotNull(testStudent.getId());
        Assert.assertEquals("Anna", testStudent.getName());
        Assert.assertEquals("anna@gmail.com", testStudent.getEmail());
        Assert.assertEquals("Storgatan 1", testStudent.getAddress());
    }

}
