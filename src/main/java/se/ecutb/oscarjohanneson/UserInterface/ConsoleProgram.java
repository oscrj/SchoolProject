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
            ProgramMenu.printStartMenu();
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

    static void createNew() {
        boolean keepRun = true;
        while (keepRun){
            ProgramMenu.printCreateNewMenu();
            String operator = scan.nextLine();
            switch (operator){
                case "1":
                    //Create empty strings that later going to store user inputs.
                    String name = "";
                    String email = "";
                    String address = "";
                    //Take input from user store it in variables.
                    try{
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

                    //Take input from user store it in variables.
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
                    //Create new course using inputs from user.
                    Course newCourse = new Course(courseName, LocalDate.parse(startDate), weekDuration);
                    //Save student to studentDao ArrayList.
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

    private static void registerUnregister() {
        System.out.println("Register/Unregister students to courses menu");

        boolean keepRun = true;
        while (keepRun){
            ProgramMenu.printRegisterUnregisterMenu();
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

    private static void findObjects() {
        boolean keepRun = true;
        while (keepRun){
            ProgramMenu.printFindObjectsMenu();
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

    private static void findStudent(){
        boolean keepRun = true;
        while (keepRun){
            ProgramMenu.printFindStudentMenu();
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

    private static void findCourse(){
        boolean keepRun = true;
        while (keepRun){
            ProgramMenu.printFindCourseMenu();
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

    private static void editObjects() {
        boolean keepRun = true;
        while (keepRun){
            ProgramMenu.printEditObjectsMenu();
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

    private static void editStudent(){
        boolean keepRun = true;
        while (keepRun){
            ProgramMenu.printEditStudentMenu();
            String operator = scan.nextLine();
            //Variable used to store StudentID.
            int id = 0;
            //Create a new student that will store the student with the unique ID.
            Student editStudent;
            switch (operator){
                case "1":
                    System.out.println("Find the student by searching on StudentID:");
                    try{
                        id = Integer.parseInt(scan.nextLine());
                    }catch (RuntimeException e){
                        System.out.println(e + "Enter StudentID.");
                    }
                    //Set editStudent to the student with the unique ID.
                    editStudent = studentDao.findById(id);
                    //Create empty string that will be set by user input.
                    String newName = "";
                    System.out.println("Enter the new name on the student.");
                    try{
                        newName = scan.nextLine();
                    }catch (RuntimeException e){
                        System.out.println(e + "Enter a name.");
                    }
                    //Set the student new name using setters in class Student.
                    editStudent.setName(newName);
                    break;
                case "2":
                    //int StudentId = 0;
                    System.out.println("Find the student by searching on StudentID: ");
                    try{
                        id = Integer.parseInt(scan.nextLine());
                    }catch (RuntimeException e){
                        System.out.println(e + "Enter StudentID");
                    }
                    //Set editStudent to the student with the unique ID.
                    editStudent = studentDao.findById(id);
                    //Create empty string that will be set by user input.
                    String newEmail = "";
                    System.out.println("Enter a new email: ");
                    try{
                        newEmail = scan.nextLine();
                    }catch (RuntimeException e){
                        System.out.println(e + "Enter a email.");
                    }
                    //Set the student new email using setters in class Student.
                    editStudent.setEmail(newEmail);
                    break;
                case "3":
                    System.out.println("Find the student by searching on StudentID: ");
                    try{
                        id = Integer.parseInt(scan.nextLine());
                    }catch (RuntimeException e){
                        System.out.println(e + "Enter StudentID.");
                    }
                    editStudent = studentDao.findById(id);

                    String newAddress = "";
                    System.out.println("Enter a new address: ");
                    try{
                        newAddress = scan.nextLine();
                    }catch (RuntimeException e){
                        System.out.println(e + "Enter a Adress.");
                    }
                    editStudent.setAddress(newAddress);
                    break;
                case "4":
                    System.out.println("Find the student by searching on StudentID: ");
                    try{
                        id = Integer.parseInt(scan.nextLine());
                    }catch (RuntimeException e){
                        System.out.println(e + "Enter StudentID.");
                    }
                    studentDao.deleteStudent(studentDao.findById(id));
                    break;
                case "B": case "b":
                    keepRun = false;
                    break;
                default:
                    System.out.println("\nPlease select option 1 or 2. \nSelection B take you back to Main Menu.");
            }
        }
    }

    private static void editCourse(){
        boolean keepRun = true;
        while (keepRun){
            ProgramMenu.printEditCourseMenu();
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

}
