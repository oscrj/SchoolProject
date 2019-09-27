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
        System.out.println(" ---- School Management ---- ");
        //Uses empty String to make the menu easier to read.
        System.out.println("");
        System.out.println("1.  Create new Coursers and Students");
        System.out.println("2.  Register or remove Students to/from Courses");
        System.out.println("3.  Find Students or Courses");
        System.out.println("4.  Edit Students or Courses");
        System.out.println("\n");
        System.out.println("Q.  Quit program");
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

                    System.out.println("Enter your first name:");
                    try(Scanner userInput = new Scanner(System.in)){
                        name = userInput.nextLine();
                    }catch (RuntimeException e){
                        System.out.println(e + " Please enter your name.");
                    }

                    System.out.println("Enter your email:");
                    try(Scanner userInput = new Scanner(System.in)){
                        email = userInput.nextLine();
                    }catch (RuntimeException e){
                        System.out.println(e + " Please enter your email");
                    }

                    System.out.println("Enter your address:");
                    try(Scanner userInput = new Scanner(System.in)){
                        address = userInput.nextLine();
                    }catch (RuntimeException e){
                        System.out.println(e + " Please enter your email");
                    }

                        Student newStudent = new Student(name,email,address);
                        studentDao.saveStudent(newStudent);
                    break;
                case "2":
                    String courseName = "";
                    String startDate = "";
                    int weekDuration = 0;

                    System.out.println("Enter course name:");
                    try(Scanner userInput = new Scanner(System.in)){
                        courseName = userInput.nextLine();
                    }catch (RuntimeException e){
                        System.out.println(e + " Please enter the name of the course");
                    }

                    System.out.println("Enter start date of course. (YYYY-MM-DD):");
                    try(Scanner userInput = new Scanner(System.in)){
                        startDate = userInput.nextLine();
                    }catch (RuntimeException e){
                        System.out.println(e + " Please enter the date by YYYY-MM-DD using numbers");
                    }

                    System.out.println("Enter the duration of the course in number of weeks:");
                    try(Scanner userInput = new Scanner(System.in)){
                        weekDuration = Integer.parseInt(userInput.nextLine());
                    }catch (RuntimeException e){
                        System.out.println(e + " Please enter the date by YYYY-MM-DD using numbers");
                    }

                    Course newCourse = new Course(courseName, LocalDate.parse(startDate), weekDuration);
                    courseDao.saveCourse(newCourse);
                    break;
                case "B": case "b":
                    keepRun = false;
                    break;
                default:
                    System.out.println("\nPlease select option 1 or 2. \nSelection B get you back to Main Menu.");
            }
        }
    }

    private static void printCreateNewMenu(){
        System.out.println("");
        System.out.println(" ---- Create New ---- ");
        System.out.println("1.  Create new student");
        System.out.println("2.  Create new course");
        System.out.println("\n");
        System.out.println("B.  Back to Main Menu");
    }

    private static void registerUnregister() {
        System.out.println("Register/Unregister students to courses menu");

    }

    private static void printRegisterUnregisterMenu(){
        System.out.println("");
        System.out.println(" ---- Register / Unregister ---- ");
        System.out.println("1.  Register student to course ");
        System.out.println("2.  Unregister student from course");
        System.out.println("\n");
        System.out.println("B.  Back to Main Menu");
    }

    private static void editObjects() {
        System.out.println("Edit sudents or courses menu");
    }

    private static void printEditObjectsMenu(){

    }

    private static void findObjects() {
        System.out.println("Find courses or students menu");
    }

    private static void printFindObjectsMenu(){

    }

}
