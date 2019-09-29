package se.ecutb.oscarjohanneson.UserInterface;

import se.ecutb.oscarjohanneson.DataAccess.CourseDaoList;
import se.ecutb.oscarjohanneson.DataAccess.StudentDaoList;
import se.ecutb.oscarjohanneson.Models.Course;
import se.ecutb.oscarjohanneson.Models.Student;

import java.time.DateTimeException;
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

    private static void createNew() {
        boolean keepRun = true;
        while (keepRun){
            ProgramMenu.printCreateNewMenu();
            String operator = scan.nextLine();
            switch (operator){
                case "1":
                    //Take input from user store it in variables.
                    System.out.println("Enter your first name:");
                    String name = scan.nextLine();
                    System.out.println("Enter your email:");
                    String email = scan.nextLine();
                    System.out.println("Enter your address:");
                    String address = scan.nextLine();
                    if(name.isEmpty() || email.isEmpty() || address.isEmpty()) {
                        System.out.println("No student was created!" + " Please enter a Name, Email and Address.");
                    }else {
                        //Creating a student by using user inputs. StudentID will be created by the two co-working constructors in class student.
                        Student newStudent = new Student(name, email, address);
                        //Save student to studentDao ArrayList.
                        studentDao.saveStudent(newStudent);
                    }
                    break;
                case "2":
                    try {
                    int  weekDuration = 0;
                    //Take input from user store it in variables.
                    System.out.println("Enter course name:");
                    String courseName = scan.nextLine();
                    System.out.println("Enter start date of course. (YYYY-MM-DD):");
                    String startDate = scan.nextLine();
                    System.out.println("Enter the duration of the course in number of weeks:");
                    weekDuration = Integer.parseInt(scan.nextLine());
                    if(courseName.isEmpty() || startDate.isEmpty() || weekDuration <= 0) {
                        System.out.println("No student was created!" + " Please enter a CourseName and Start date (YYYY-MM-DD) och number of weeks.");
                    }else {
                        //Create new course using inputs from user.
                        Course newCourse = new Course(courseName, LocalDate.parse(startDate), weekDuration);
                        //Save student to studentDao ArrayList.
                        courseDao.saveCourse(newCourse);
                    }
                    }catch (NumberFormatException | DateTimeException e){
                        System.out.println("Please enter a name, start date(YYYY-MM-DD), and number of weeks duration.");
                    }
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
        boolean keepRun = true;
        while (keepRun){
            ProgramMenu.printRegisterUnregisterMenu();
            int studentId = 0;
            int courseId = 0;
            String operator = scan.nextLine();
            switch (operator){
                case "1":
                        System.out.println(" --- List of Coursers: ---\n");
                        System.out.println(courseDao.findAll().toString());
                        System.out.print("\nChoose which Course you will register to by enter CourseID: ");
                    try {
                        courseId = Integer.parseInt(scan.nextLine());
                        System.out.println(" --- List of Students: ---\n");
                        System.out.println(studentDao.findAll().toString());
                        System.out.print("\nChoose which Student you will register by enter StudentID: ");
                        studentId = Integer.parseInt(scan.nextLine());
                    }catch (NumberFormatException e){
                        System.out.println("Enter a number as ID.");
                    }
                    try{
                        //Registered Student to course by using unique CourseId and StudentID.
                        courseDao.findById(courseId).register(studentDao.findById(studentId));
                    }catch (NullPointerException e){
                        System.out.println("Something went very wrong :P.");
                    }
                    break;
                case "2":
                        System.out.println(" --- List of Coursers: ---\n");
                        System.out.println(courseDao.findAll().toString());
                        System.out.print("\nChoose which Course you will register to by enter CourseID: ");
                    try {
                        courseId = Integer.parseInt(scan.nextLine());
                        System.out.println("Enter id by number");
                        System.out.println(" --- List of Students: ---\n");
                        System.out.println(studentDao.findAll().toString());
                        System.out.print("\nChoose which Student you will register by enter StudentID: ");
                        studentId = Integer.parseInt(scan.nextLine());
                    }catch (NumberFormatException e){
                        System.out.println("Enter a number as ID.");
                    }
                    try{
                    //Unregistered Student from course by using unique CourseId and StudentID.
                    courseDao.findById(courseId).unregister(studentDao.findById(studentId));
                    }catch (NullPointerException e){
                        System.out.println("Something went very wrong :P.");
                    }
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
                    try{
                        System.out.print("Enter StudentID:\t");
                        System.out.println(studentDao.findById(Integer.parseInt(scan.nextLine())).toString());
                        scan.nextLine();
                    }catch (NumberFormatException e){
                        System.out.println("Enter StudentID using numbers.");
                    }
                    break;
                case "2":
                    try{
                        System.out.print("Enter Student name:\t");
                        System.out.println(studentDao.findByName(scan.nextLine()).toString());
                        scan.nextLine();
                    }catch (NullPointerException e){
                        System.out.println("Enter name of the student you are looking for.");
                    }
                    break;
                case "3":
                    try {
                        System.out.print("Enter an email:\t");
                        System.out.println(studentDao.findByEmail(scan.nextLine()).toString());
                        scan.nextLine();
                    }catch (NullPointerException e){
                        System.out.println("Enter the email you are looking for.");
                    }
                    break;
                case "4":
                    System.out.println(studentDao.findAll().toString());
                    break;
                case "B": case "b":
                    keepRun = false;
                    break;
                default:
                    System.out.println("\nPlease select option 1 or 4. \nSelection B take you back to Find Student/Course Menu.");
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
                    try{
                        System.out.print("Enter CourseID:\t");
                        System.out.println(courseDao.findById(Integer.parseInt(scan.nextLine())).toString());
                        scan.nextLine();
                    }catch (NumberFormatException e){
                        System.out.println("Enter CourseID using numbers.");
                    }
                    break;
                case "2":
                    try{
                        System.out.print("Enter Course name:\t");
                        System.out.println(courseDao.findByName(scan.nextLine()).toString());
                        scan.nextLine();
                    }catch (NullPointerException e){
                        System.out.println("Enter name you are looking for.");
                    }
                    break;
                case "3":
                    try {
                        System.out.print("Enter start date of the course (YYYY-MM-DD):\t");
                        System.out.println(courseDao.findByDate(LocalDate.parse(scan.nextLine())));
                        scan.nextLine();
                    }catch (Exception e){
                        System.out.println("Enter date (YYYY-MM-DD)");
                    }
                    break;
                case "4":
                    System.out.println(courseDao.findAll().toString());
                    break;
                case "B": case "b":
                    keepRun = false;
                    break;
                default:
                    System.out.println("\nPlease select option 1 or 4. \nSelection B take you back to Find Student/Course Menu.");
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
                    System.out.println("\nPlease select option 1 or 2. \nSelection B take you back to Main Menu");
            }
        }
    }

    private static void editStudent(){
        boolean keepRun = true;
        while (keepRun){
            ProgramMenu.printEditStudentMenu();
            //Create a new student that will store the student with the unique ID.
            Student editStudent;
            String operator = scan.nextLine();
            switch (operator){
                case "1":
                    try{
                        System.out.print("Enter StudentID: ");
                        //Find student with the unique ID received by user and store it in editStudent.
                        editStudent = studentDao.findById(Integer.parseInt(scan.nextLine()));
                        System.out.print("\nEnter the new name of the student: ");
                        //Set the new name received from user on the student with unique ID.
                        editStudent.setName(scan.nextLine());
                    }catch (NullPointerException | NumberFormatException e) {
                        System.out.println("Enter a name.");
                    }
                    break;
                case "2":
                    try{
                        System.out.print("Enter StudentID: ");
                        editStudent = studentDao.findById(Integer.parseInt(scan.nextLine()));
                        System.out.print("\nEnter a new email: ");
                        editStudent.setEmail(scan.nextLine());
                    }catch (NullPointerException | NumberFormatException e){
                        System.out.println("Enter a email");
                    }
                    break;
                case "3":
                    try{
                        System.out.print("Enter StudentID: ");
                        editStudent = studentDao.findById(Integer.parseInt(scan.nextLine()));
                        System.out.print("\nEnter a new address: ");
                        editStudent.setAddress(scan.nextLine());
                    }catch (NullPointerException | NumberFormatException e){
                        System.out.println("Enter a address");
                    }
                    break;
                case "4":
                    try{
                        System.out.print("Enter StudentID: ");
                        editStudent = studentDao.findById(Integer.parseInt(scan.nextLine()));
                        System.out.println(editStudent.toString());
                        System.out.print("\nDo you want to delete this student :");
                        System.out.println("\nYes(Y) / No(N) :");
                        String opr = scan.nextLine();
                        //A switch case to confirm that user wants to delete student.
                        boolean run = true;
                        while(run) {
                            switch (opr) {
                                case "Y": case "y":
                                    //Delete student with unique ID.
                                    studentDao.deleteStudent(editStudent);
                                    run = false;
                                    break;
                                case "N": case "n":
                                    run = false;
                                    break;
                            }
                        }
                    }catch (NullPointerException | NumberFormatException e){
                        System.out.println("Enter ID by number.");
                    }
                    break;
                case "B": case "b":
                    keepRun = false;
                    break;
                default:
                    System.out.println("\nPlease select option 1 or 4. \nSelection B take you back to Edit Student/Course Menu.");
            }
        }
    }

    private static void editCourse(){
        boolean keepRun = true;
        while (keepRun){
            ProgramMenu.printEditCourseMenu();
            //Create a new Course that will store the course with the unique ID.
            Course editCourse;
            String operator = scan.nextLine();
            switch (operator){
                case "1":
                    try{
                        System.out.print("Enter CourseID: ");
                        //Find course with the unique ID received by user and store it in editCourse.
                        editCourse = courseDao.findById(Integer.parseInt(scan.nextLine()));
                        System.out.print("Enter the new name of the course: ");
                        //Set the new name received from user on the course with unique ID.
                        editCourse.setCourseName(scan.nextLine());
                    }catch (NullPointerException | NumberFormatException e) {
                        System.out.println("Enter a name.");
                    }
                    break;
                case "2":
                    try{
                        System.out.print("Enter CourseID: ");
                        editCourse = courseDao.findById(Integer.parseInt(scan.nextLine()));
                        System.out.print("Enter a new start date (YYYY-MM-DD): ");
                        editCourse.setStartDate(LocalDate.parse(scan.nextLine()));
                    }catch (NullPointerException | NumberFormatException e) {
                        System.out.println("Enter a date(YYYY-MM-DD)");
                    }
                    break;
                case "3":
                    try{
                        System.out.print("Enter CourseID: ");
                        editCourse = courseDao.findById(Integer.parseInt(scan.nextLine()));
                        System.out.print("Enter new duration in weeks: ");
                        editCourse.setWeekDuration(Integer.parseInt(scan.nextLine()));
                    }catch (NullPointerException | NumberFormatException e) {
                        System.out.println("Enter number of weeks.");
                    }
                    break;
                case "4":
                    try{
                        System.out.print("Enter CourseID: ");
                        editCourse = courseDao.findById(Integer.parseInt(scan.nextLine()));
                        System.out.println("Do you want to delete this Course :");
                        System.out.println(editCourse.toString());
                        System.out.println("\nYes(Y) / No(N) :");
                        String opr = scan.nextLine();
                        boolean run = true;
                        while(run) {
                            switch (opr) {
                                case "Y": case "y":
                                    //Delete course with unique ID.
                                    courseDao.removeCourse(editCourse);
                                    run = false;
                                    break;
                                case "N": case "n":
                                    run = false;
                                    break;
                            }
                        }
                    }catch (NullPointerException | NumberFormatException e) {
                        System.out.println("Enter ID by number.");
                    }
                    break;
                case "B": case "b":
                    keepRun = false;
                    break;
                default:
                    System.out.println("\nPlease select option 1 or 4. \nSelection B take you back to Edit Student/Course Menu");
            }
        }
    }
}