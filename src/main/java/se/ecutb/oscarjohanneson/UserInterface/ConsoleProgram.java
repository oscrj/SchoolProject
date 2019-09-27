package se.ecutb.oscarjohanneson.UserInterface;

import se.ecutb.oscarjohanneson.DataAccess.CourseDaoList;
import se.ecutb.oscarjohanneson.DataAccess.StudentDaoList;
import se.ecutb.oscarjohanneson.Models.Course;
import se.ecutb.oscarjohanneson.Models.Student;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleProgram {

    private static Scanner scan = new Scanner(System.in);
    private static CourseDaoList courseDao = new CourseDaoList();
    private static StudentDaoList studentDao = new StudentDaoList();

    public static void runProgram(){

        boolean keepRun = true;
        //As long keepRun is true the program will continue.
        while (keepRun){
            //call method printMenu().
            printStartMenu();
            String operator = scan.nextLine();
            switch (operator){
                case "1":
                    createNew();
                    break;
                case "2":
                    registerUnregister();
                    break;
                case "3":
                    findObjects();
                    break;
                case "4":
                    editObjects();
                    break;
                case "Q": case "q":
                    System.out.println("Quit....");
                    keepRun = false;
                    break;
                default:
                    System.out.println("\nYou have to enter a number between 1-4 or Q");
            }
        }
    }

    private static void printStartMenu(){
        System.out.println("\n ---- School Management ---- \n");
        System.out.println("1.  Create new Coursers and Students");
        System.out.println("2.  Register or remove Students to/from Courses");
        System.out.println("3.  Find Students or Courses");
        System.out.println("4.  Edit Students or Courses");
        System.out.println("Q.  Quit program\n");
    }

    static void createNew() {

        boolean keepRun = true;
        while (keepRun){
            printCreateNewMenu();
            String operator = scan.nextLine();
            switch (operator){
                case "1":
                    //Create empty strings that later going to store user inputs.
                    String name = "";
                    String email = "";
                    String address = "";

                    try{
                        //Take input from user store it in name.
                        System.out.println("Enter your first name:");
                        name = scan.nextLine();

                        System.out.println("Enter your email:");
                        email = scan.nextLine();

                        System.out.println("Enter your address:");
                        address = scan.nextLine();

                    }catch (RuntimeException e){
                        System.out.println(e + "Enter ");
                    }
                        //Creating a student by using user inputs. StudentID will be created by the two co-working constructors in class student.
                        Student newStudent = new Student(name,email,address);
                        //Save student to studentDao ArrayList.
                        studentDao.saveStudent(newStudent);
                    break;
                case "2":
                    String courseName = "";
                    String startDate = "";
                    int weekDuration = 0;

                    try{
                        System.out.println("Enter course name:");
                        courseName = scan.nextLine();

                        System.out.println("Enter start date of course. (YYYY-MM-DD):");
                        startDate = scan.nextLine();

                        System.out.println("Enter the duration of the course in number of weeks:");
                        weekDuration = Integer.parseInt(scan.nextLine());

                    }catch (RuntimeException e){
                        System.out.println(e + " Please enter the name of the course\n The start date of the course: YYYY-MM-DD\n The number of week duration of the course.");
                    }

                    Course newCourse = new Course(courseName, LocalDate.parse(startDate), weekDuration);
                    courseDao.saveCourse(newCourse);
                    break;
                case "B": case "b":
                    keepRun = false;
                    break;
                default:
                    System.out.println("\nPlease select option 1 or 2. \nSelection B take you back to Main Menu.");
            }
        }
    }

    private static void printCreateNewMenu(){

        System.out.println("\n ---- Create New ---- \n");
        System.out.println("1.  Create new student");
        System.out.println("2.  Create new course");
        System.out.println("B.  Back to Main Menu\n");
    }

    private static void registerUnregister() {
        System.out.println("Register/Unregister students to courses menu");

        boolean keepRun = true;
        while (keepRun){
            printRegisterUnregisterMenu();
            String operator = scan.nextLine();
            switch (operator){
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "B": case "b":
                    keepRun = false;
                    break;
                default:
                    System.out.println("\nPlease select option 1 or 2. \nSelection B take you back to Main Menu.");
            }
        }

    }

    private static void printRegisterUnregisterMenu(){
        System.out.println("\n ---- Register / Unregister ---- \n");
        System.out.println("1.  Register student to course ");
        System.out.println("2.  Unregister student from course");
        System.out.println("B.  Back to Main Menu\n");
    }

    private static void findObjects() {
        boolean keepRun = true;
        while (keepRun){
            printFindObjectsMenu();
            String operator = scan.nextLine();
            switch (operator){
                case "1":
                    findStudent();
                    break;
                case "2":
                    findCourse();
                    break;
                case "B": case "b":
                    keepRun = false;
                    break;
                default:
                    System.out.println("\nPlease select option 1 or 2. \nSelection B take you back to Main Menu.");
            }
        }
    }

    private static void printFindObjectsMenu(){
        System.out.println("\n ---- Find Student / Course ---- \n");
        System.out.println("1.  Find Student ");
        System.out.println("2.  Find Course");
        System.out.println("B.  Back to Main Menu\n");

    }

    private static void findStudent(){
        boolean keepRun = true;
        while (keepRun){
            printFindStudentMenu();
            String operator = scan.nextLine();
            switch (operator){
                case "1":
                    int id = 0;
                    try{
                        System.out.print("Enter StudentID:\t");
                        id = Integer.parseInt(scan.nextLine());
                    }catch (RuntimeException e){
                        System.out.println(e + "Enter StudentID using numbers.");
                    }
                    System.out.println(studentDao.findById(id).toString());
                    scan.nextLine();
                    break;
                case "2":
                    String name = "";
                    try{
                        System.out.print("Enter Student name:\t");
                        name = scan.nextLine();
                    }catch (RuntimeException e){
                        System.out.println(e + "Enter name you are looking for.");
                    }
                    System.out.println(studentDao.findByName(name).toString());
                    scan.nextLine();
                    break;
                case "3":
                    String email = "";
                    try {
                        System.out.print("Enter an email:\t");
                        email = scan.nextLine();
                    }catch (RuntimeException e){
                        System.out.println(e + "Enter the email you are looking for.");
                    }
                    System.out.println(studentDao.findByEmail(email).toString());
                    scan.nextLine();
                    break;
                case "4":
                    System.out.println(studentDao.findAll().toString());
                    break;
                case "B": case "b":
                    keepRun = false;
                    break;
                default:
                    System.out.println("\nPlease select option 1 or 4. \nSelection B take you back to Find Student/Course menu.");
            }
        }
    }

    private static void printFindStudentMenu(){
        System.out.println("\n ---- Find Student ---- \n");
        System.out.println("1.  Find Student by ID");
        System.out.println("2.  Find Student by Name");
        System.out.println("3.  Find Student by Email");
        System.out.println("4.  Find all Students");
        System.out.println("B.  Back to Find Student/Course menu\n");

    }

    private static void findCourse(){
        boolean keepRun = true;
        while (keepRun){
            printFindCourseMenu();
            String operator = scan.nextLine();
            switch (operator){
                case "1":
                    int id = 0;
                    try{
                        System.out.print("Enter CourseID:\t");
                        id = Integer.parseInt(scan.nextLine());
                    }catch (RuntimeException e){
                        System.out.println(e + "Enter CourseID using numbers.");
                    }
                    System.out.println(courseDao.findById(id).toString());
                    scan.nextLine();
                    break;
                case "2":
                    String name = "";
                    try{
                        System.out.print("Enter Course name:\t");
                        name = scan.nextLine();
                    }catch (RuntimeException e){
                        System.out.println(e + "Enter name you are looking for.");
                    }
                    System.out.println(courseDao.findByName(name).toString());
                    scan.nextLine();
                    break;
                case "3":
                    LocalDate date = null;
                    try {
                        System.out.print("Enter start date of the course (YYYY-MM-DD):\t");
                        date = LocalDate.parse(scan.nextLine());
                    }catch (RuntimeException e){
                        System.out.println(e + "Enter date (YYYY-MM-DD)");
                    }
                    System.out.println(courseDao.findByDate(date));
                    scan.nextLine();
                    break;
                case "4":
                    System.out.println(courseDao.findAll().toString());
                    break;
                case "B": case "b":
                    keepRun = false;
                    break;
                default:
                    System.out.println("\nPlease select option 1 or 4. \nSelection B take you back to Find Student/Course menu.");
            }
        }
    }

    private static void printFindCourseMenu(){
        System.out.println("\n ---- Find Course ---- \n");
        System.out.println("1.  Find Course by ID");
        System.out.println("2.  Find Course by Name");
        System.out.println("3.  Find Course by Date");
        System.out.println("4.  Find all Courses");
        System.out.println("B.  Back to Find Student/Course menu\n");

    }

    private static void editObjects() {
        boolean keepRun = true;
        while (keepRun){
            printEditObjectsMenu();
            String operator = scan.nextLine();
            switch (operator){
                case "1":
                    editStudent();
                    break;
                case "2":
                    editCourse();
                    break;
                case "B": case "b":
                    keepRun = false;
                    break;
                default:
                    System.out.println("\nPlease select option 1 or 4. \nSelection B take you back toEdit Student/Course menu");
            }
        }
    }

    private static void printEditObjectsMenu(){
        System.out.println("\n ---- Edit Student / Course ---- ");
        System.out.println("1.  Edit Student ");
        System.out.println("2.  Edit Course");
        System.out.println("\n");
        System.out.println("B.  Back to Main Menu\n");
    }

    public static void editStudent(){
        boolean keepRun = true;
        while (keepRun){
            printEditStudentMenu();
            String operator = scan.nextLine();
            switch (operator){
                case "1":
                    int id = 0;
                    try{
                        id = Integer.parseInt(scan.nextLine());
                    }catch (RuntimeException e){
                        System.out.println(e + "Enter a name.");
                    }
                    //Set editStudent to the student with the unique ID.
                    Student editStudent = studentDao.findById(id);
                    //Create empty string that will be set by user input.
                    String newName = "";
                    try{
                        newName = scan.nextLine();
                    }catch (RuntimeException e){
                        System.out.println(e + "Enter a name.");
                    }
                    //Set the student new name using setters in class Student.
                    editStudent.setName(newName);
                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "B": case "b":
                    keepRun = false;
                    break;
                default:
                    System.out.println("\nPlease select option 1 or 2. \nSelection B take you back to Main Menu.");
            }
        }
    }

    private static void printEditStudentMenu() {
        System.out.println("\n ---- Edit Student ---- \n");
        System.out.println("1.  Edit Student Name");
        System.out.println("2.  Edit Student Email");
        System.out.println("3.  Edit Student Address");
        System.out.println("4.  Delete Student");
        System.out.println("B.  Back to Edit Student/Course menu\n");
    }

    private static void editCourse(){
        boolean keepRun = true;
        while (keepRun){
            printEditCourseMenu();
            String operator = scan.nextLine();
            switch (operator){
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "B": case "b":
                    keepRun = false;
                    break;
                default:
                    System.out.println("\nPlease select option 1 or 4. \nSelection B take you back to Edit Student/Course menu");
            }
        }
    }

    private static void printEditCourseMenu() {
        System.out.println("\n ---- Edit Course ---- \n");
        System.out.println("1.  Edit Course Name");
        System.out.println("2.  Edit Course Start date");
        System.out.println("3.  Edit Course Duration");
        System.out.println("4.  Delete Course");
        System.out.println("B.  Back to Edit Student/Course menu\n");
    }


}
