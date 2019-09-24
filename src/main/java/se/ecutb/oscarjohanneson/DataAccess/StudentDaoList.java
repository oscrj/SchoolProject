package se.ecutb.oscarjohanneson.DataAccess;

import se.ecutb.oscarjohanneson.Models.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoList implements StudentDao {

    private static List<Student> students;

    public StudentDaoList() {
        students = new ArrayList<>();
    }

    //Add objects to ArrayList and return the same object.
    @Override
    public Student saveStudent(Student student) {
        if(students.contains(student)){
            System.out.println(student + " is already attending this course.");
            return null;
        }else{
            students.add(student);
            return student;
        }
    }

    //Find student by searching for students email.
    @Override
    public Student findByEmail(String email) {
        //Search arrayList for students with matching email.
        for(Student s : students){
            //if a Student have the same email. Return that student.
            if(s.getEmail().equalsIgnoreCase(email)){
                return s;
            }
        }
        //if there are no match return null.
        System.out.println("Student not found");
        return null;
    }

    //Find student by searching for students name.
    @Override
    public List<Student> findByName(String name) {
        //create a new ArrayList

        for(Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {

                //Return the new ArrayList.
                return students;
            }
        }
        System.out.println("Student not found");
        return null;
    }

    //Find student by searching by students id.
    @Override
    public Student findById(int id) {
        for(Student s : students){
            if(s.getId() == id){
                return s;
            }
        }
        System.out.println("Student not found");
        return null;
    }

    //Find all students in ArrayList.
    @Override
    public List<Student> findAll() {
        //Return ArrayList students.
        return students;
    }

    //Delete students from ArrayList.
    @Override
    public boolean deleteStudent(Student student) {
        System.out.println(student + " was removed.");
        return students.remove(student);
    }
}
