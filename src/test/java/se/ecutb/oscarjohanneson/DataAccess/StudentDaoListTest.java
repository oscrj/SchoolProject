package se.ecutb.oscarjohanneson.DataAccess;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.ecutb.oscarjohanneson.Models.Student;

public class StudentDaoListTest {

    private Student testObject;
    private StudentDaoList testObjectList;

    @Before
    public void setUp(){
        testObject = new Student(1,"Anna", "anna@gmail.com","Storgatan 2");
        testObjectList = new StudentDaoList();

    }

    @Test

    @After
    public void afterTest(){
        testObjectList.findAll().clear();
    }
}
