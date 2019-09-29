package se.ecutb.oscarjohanneson.DataAccess;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.ecutb.oscarjohanneson.Models.Course;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoListTest {

    private Course testObject;
    private Course testObject2;
    private CourseDaoList testObjectList;

    @Before
    public void setUp(){
        testObjectList = new CourseDaoList();
        testObjectList.saveCourse(testObject = new Course(1,"English", LocalDate.parse("2019-08-01"),8));
        testObjectList.saveCourse(testObject2 = new Course(2, "Mathematics", LocalDate.parse("2019-08-03"), 8));
    }

    @Test
    public void test_if_course_is_saved(){
        int expectedSize = 2;

        Assert.assertEquals(expectedSize, testObjectList.findAll().size());
    }

    @Test
    public void test_if_course_already_saved(){
        int expectedSize = 2;
        Course duplicateCourse = new Course(2, "Mathematics", LocalDate.parse("2019-08-03"), 8);
        testObjectList.saveCourse(duplicateCourse);

        Assert.assertEquals(expectedSize, testObjectList.findAll().size());
    }

    @Test
    public void test_if_course_was_found_by_id(){
        int id = 1;
        Course result = testObjectList.findById(id);

        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.getId());
    }

    @Test
    public void test_if_course_not_was_found_by_id(){
        int id = 4;
        Course result = testObjectList.findById(id);

        Assert.assertNull(result);
    }

    @Test
    public void test_if_course_was_found_by_name(){
        String name = "English";
        List<Course> result = testObjectList.findByName(name);
        List<Course> testList = new ArrayList<>();
        testList.add(testObject);

        Assert.assertNotNull(result);
        Assert.assertEquals(testList, result);
    }

    @Test
    public void test_if_course_not_found_by_name(){
        String name = "Swedish";
        List<Course> result = testObjectList.findByName(name);

        Assert.assertNull(result);
    }

    @Test
    public void test_if_course_with_startDate_is_found(){
        LocalDate date = LocalDate.parse("2019-08-01");
        List<Course> result = testObjectList.findByDate(date);
        List<Course> testList = new ArrayList<>();
        testList.add(testObject);

        Assert.assertNotNull(result);
        Assert.assertEquals(testList, result);
    }

    @Test
    public void test_if_course_with_startDate_is_not_found(){
        LocalDate date = LocalDate.parse("2019-09-01");
        List<Course> result = testObjectList.findByDate(date);

        Assert.assertNull(result);
    }

    @Test
    public void test_find_all_courses(){
        int expectedSize = 2;

        Assert.assertEquals(expectedSize, testObjectList.findAll().size());
    }

    @Test
    public void test_if_course_was_removed(){
        int expectedSize = 1;
        testObjectList.removeCourse(testObject2);

        Assert.assertEquals(expectedSize, testObjectList.findAll().size());
    }

    @After
    public void afterTest(){
        testObjectList.findAll().clear();
    }
}
