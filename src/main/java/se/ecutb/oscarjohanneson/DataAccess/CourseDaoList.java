package se.ecutb.oscarjohanneson.DataAccess;

import se.ecutb.oscarjohanneson.Models.Course;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoList implements CourseDao {

    private static List<Course> courses;

    public CourseDaoList(){
        courses = new ArrayList<>();
    }

    @Override
    public Course saveCourse(Course course) {

        if(courses.contains(course)){
            System.out.println(course.getCourseName() + " already exists.");
            return null;
        }else {
            courses.add(course);
            System.out.println(course.getCourseName() + " was added.");
            return course;
        }
    }

    @Override
    public Course findById(int id) {

        for(Course c : courses){
            if(c.getId() == id){
                return c;
            }
        }
        System.out.println("Course not found");
        return null;
    }

    @Override
    public List<Course> findByName(String name) {
        //Create a new ArrayList to store the course you are searching for in your ArrayList Courses.
        //and makes it possible to return the exact course by using the new ArrayList.
        List<Course> findByName = new ArrayList<>();

        for(Course c : courses){
            if(c.getCourseName().equalsIgnoreCase(name)){
                //Adding course with the searched name in new ArrayList findByName.
                findByName.add(c);
                //Return the new ArrayList with the Course you searched for.
                return findByName;
            }
        }
        System.out.println("The course " + name + " can not be found.");
        //Return null if name not found.
        return null;
    }

    @Override
    public List<Course> findByDate(LocalDate date) {
        List<Course> findByDate = new ArrayList<>();
        for(Course c : courses){
            if(c.getStartDate().isEqual(date)) {
                //Adding the course with the date you are searching for to ArrayList findByDate.
                findByDate.add(c);
                return findByDate;
            }
        }
        System.out.println("The course can not be found.");
        return null;
    }

    @Override
    public List<Course> findAll() {
        return courses;
    }

    public boolean removeCourse(int id) {
        //Remove course with the unique id.
        return removeCourse(findById(id));
    }

    @Override
    public boolean removeCourse(Course course) {
        System.out.println(course.getCourseName() + " was removed.");
        //Remove course from ArrayList.
        return courses.remove(course);
    }
}
