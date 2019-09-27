package se.ecutb.oscarjohanneson.Interface;

import se.ecutb.oscarjohanneson.DataAccess.CourseDaoList;
import se.ecutb.oscarjohanneson.DataAccess.StudentDaoList;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ConsoleProgram {

    static Scanner scan = new Scanner(System.in);
    CourseDaoList courseDao = new CourseDaoList();
    StudentDaoList studentDao = new StudentDaoList();

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
        System.out.println("---- School Management ----");
        System.out.println("\n");
        System.out.println("1.  Create new Coursers and Students");
        System.out.println("2.  Register or remove Students to/from Courses");
        System.out.println("3.  Find Students or Courses");
        System.out.println("4.  Edit Students or Courses");
        System.out.println("\n");
        System.out.println("Q.  Quit program");
    }

    private static void createNew() {
        System.out.println("Create New Student/Course menu");
    }

    private static void registerUnregister() {
        System.out.println("Register/Unregister students to courses menu");

    }

    private static void editObjects() {
        System.out.println("Edit sudents or courses menu");
    }

    private static void findObjects() {
        System.out.println("Find courses or students menu");
    }

}
