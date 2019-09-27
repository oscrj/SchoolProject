package se.ecutb.oscarjohanneson.DataAccess;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.ecutb.oscarjohanneson.Models.Student;

import java.util.List;

public class StudentDaoListTest {

    private Student testObject;
    private Student testObject2;
    private Student testObject3;
    private StudentDaoList testObjectList;

    @Before
    public void setUp(){
        //Created 3 testObjects.
        testObject = new Student(1,"Anna", "anna@gmail.com","Storgatan 2");
        testObject2 = new Student(2, "Anders", "Anders@Gmail.com", "Storgatan 5");
        testObject3 = new Student(3, "Fredrik","fredrik@gmail.com", "Storgatan 10");

        testObjectList = new StudentDaoList();

        //Added testObject to testObjectList.
        testObjectList.saveStudent(testObject);
        testObjectList.saveStudent(testObject2);
        testObjectList.saveStudent(testObject3);
    }

    @Test
    public void test_if_student_was_saved(){
        int expectedSize = 3;

        Assert.assertEquals(expectedSize, testObjectList.findAll().size());
    }

    @Test
    public void test_if_student_already_saved_was_saved(){
        int expectedSize = 3;
        Student duplicateStudent = new Student(1,"Anna", "anna@gmail.com","Storgatan 2");
        testObjectList.saveStudent(duplicateStudent);

        Assert.assertEquals(expectedSize, testObjectList.findAll().size());
    }

    @Test
    public void test_if_student_was_found_by_mail(){
        String email = "anna@gmail.com";
        Student result = testObjectList.findByEmail(email);

        Assert.assertNotNull(result);
        Assert.assertEquals(email, result.getEmail());
    }

    @Test
    public void test_if_student_was_not_found_by_mail(){
        String email = "annaAnka@gmail.com";
        Student result = testObjectList.findByEmail(email);

        Assert.assertNull(result);
    }

    @Test
    public void test_if_student_was_found_by_Name(){
        String name = "Anna";
        List<Student> result = testObjectList.findByName(name);

        Assert.assertNotNull(result);
        //Assert.assertEquals(testObject.toString(), result);
    }

    @Test
    public void test_if_student_was_not_found_by_Name(){
        String name = "Ake";
        List<Student> result = testObjectList.findByName(name);

        Assert.assertNull(result);
    }

    @Test
    public void test_if_student_was_found_by_id(){
        int id = 1;
        Student result = testObjectList.findById(id);

        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.getId());
    }

    @Test
    public void test_if_student_not_was_found_by_id(){
        int id = 4;
        Student result = testObjectList.findById(id);

        Assert.assertNull(result);
    }

    @Test
    public void test_find_all_students(){
        int expectedSize = 3;

        Assert.assertEquals(expectedSize, testObjectList.findAll().size());
    }

    @Test
    public void test_if_student_was_removed(){
        int expectedSize = 2;
        testObjectList.deleteStudent(testObject);

        Assert.assertEquals(expectedSize, testObjectList.findAll().size());
    }

    @Test
    public void test_if_student_was_removed_by_id(){
        int expectedSize = 2;
        int testObjectId = 3;
        testObjectList.deleteStudent(testObjectId);

        Assert.assertEquals(expectedSize,testObjectList.findAll().size());
    }

    @After
    public void after_test(){
        testObjectList.findAll().clear();
    }
}
