package se.ecutb.oscarjohanneson.DataAccess;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.ecutb.oscarjohanneson.Models.Course;

import java.time.LocalDate;

public class CourseDaoListTest {

    private Course testObject;
    private CourseDaoList testObjectList;

    @Before
    public void setUp(){
        testObject = new Course(1,"English", LocalDate.parse("2019-08-01"),8);
        testObjectList = new CourseDaoList();
    }

    @Test
    public void test_Save_Course_To_List(){

    }

    @Test
    public void test_Save_Course_That_Already_In_List(){

    }

    @After
    public void afterTest(){
        testObjectList.findAll().clear();
    }
}
