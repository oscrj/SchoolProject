package se.ecutb.oscarjohanneson;

import java.util.Scanner;

public class App {
    static Scanner scan = new Scanner(System.in);

    public static void main( String[] args ){
        boolean keepRun = true;
        //As long keepRun is true the program will continue.
        while (keepRun){
            //call method printMenu().
            printMenu();
            String startQuit = scan.nextLine();
            switch (startQuit){
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

    private static void printMenu(){
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

    }

    private static void registerUnregister() {

    }

    private static void editObjects() {

    }

    private static void findObjects() {

    }

}
