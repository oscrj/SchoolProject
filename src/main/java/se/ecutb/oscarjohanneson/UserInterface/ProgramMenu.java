package se.ecutb.oscarjohanneson.UserInterface;

public class ProgramMenu {

    public static void printStartMenu(){
        System.out.println("\n ---- School Management ---- \n");
        System.out.println("1.  Create new Students / Courses");
        System.out.println("2.  Register / remove Students to/from Courses");
        System.out.println("3.  Find Students / Courses");
        System.out.println("4.  Edit Students / Courses");
        System.out.println("Q.  Quit program\n");
    }

    public static void printCreateNewMenu(){
        System.out.println("\n ---- Create New ---- \n");
        System.out.println("1.  Create new student");
        System.out.println("2.  Create new course");
        System.out.println("B.  Back to Main Menu\n");
    }

    public static void printRegisterUnregisterMenu(){
        System.out.println("\n ---- Register / Unregister ---- \n");
        System.out.println("1.  Register student / course ");
        System.out.println("2.  Unregister student from course");
        System.out.println("B.  Back to Main Menu\n");
    }

    public static void printFindObjectsMenu(){
        System.out.println("\n ---- Find Student / Course ---- \n");
        System.out.println("1.  Find Student ");
        System.out.println("2.  Find Course");
        System.out.println("B.  Back to Main Menu\n");
    }

    public static void printFindStudentMenu(){
        System.out.println("\n ---- Find Student ---- \n");
        System.out.println("1.  Find Student by ID");
        System.out.println("2.  Find Student by Name");
        System.out.println("3.  Find Student by Email");
        System.out.println("4.  Find all Students");
        System.out.println("B.  Back to Find Student/Course menu\n");
    }

    public static void printFindCourseMenu(){
        System.out.println("\n ---- Find Course ---- \n");
        System.out.println("1.  Find Course by ID");
        System.out.println("2.  Find Course by Name");
        System.out.println("3.  Find Course by Date");
        System.out.println("4.  Find all Courses");
        System.out.println("B.  Back to Find Student/Course menu\n");
    }

    public static void printEditObjectsMenu(){
        System.out.println("\n ---- Edit Student / Course ---- ");
        System.out.println("1.  Edit Student ");
        System.out.println("2.  Edit Course");
        System.out.println("B.  Back to Main Menu\n");
    }

    public static void printEditStudentMenu() {
        System.out.println("\n ---- Edit Student ---- \n");
        System.out.println("1.  Edit Student Name");
        System.out.println("2.  Edit Student Email");
        System.out.println("3.  Edit Student Address");
        System.out.println("4.  Delete Student");
        System.out.println("B.  Back to Edit Student/Course menu\n");
    }

    public static void printEditCourseMenu() {
        System.out.println("\n ---- Edit Course ---- \n");
        System.out.println("1.  Edit Course Name");
        System.out.println("2.  Edit Course Start date");
        System.out.println("3.  Edit Course Duration");
        System.out.println("4.  Delete Course");
        System.out.println("B.  Back to Edit Student/Course menu\n");
    }
}
