package project;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
//        DatabaseConnectivity.connect();

        System.out.println("---CRUD Application on Student Database---");
        System.out.print("Enter 1 for create, 2 for read, 3 for update, 4 for delete: ");
        Scanner sc = new Scanner(System.in);
        try {
            int option = sc.nextInt();
        switch (option) {
            case 1: //create student record
                System.out.print("Enter student id: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter student name: ");
                String name = sc.nextLine();
//
                System.out.print("Enter student email: ");
                String email = sc.nextLine();

                StudentInput student = new StudentInput(id, name, email);
                try {
                    DataAccessObject.createRecord(student);
                    System.out.println("record created successfully!!!");
                } catch (SQLException e) {
//            e.getStackTrace();
                    System.out.println(e.getMessage());
                }
                break;

            case 2: //read student records
                try {
                    ArrayList<StudentInput> list = DataAccessObject.readRecords();
                    System.out.println("Student Record Table Data");
                    for (StudentInput records : list) {
                        System.out.println(records);
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            case 3: //update student record
                System.out.print("Update student id: ");
                int upId = sc.nextInt();
                sc.nextLine();
                System.out.print("Update student name: ");
                String upName = sc.nextLine();
                System.out.print("Update student email: ");
                String upEmail = sc.nextLine();

                try {
                    DataAccessObject.updateRecord(upId, upName, upEmail);
                    System.out.println("record updated successfully!!!");
                } catch (SQLException e) {
//                    throw new RuntimeException(e);
                    System.out.println(e.getMessage());
                }
                break;

            case 4: //delete student record
                System.out.print("Student id: ");
                int delId = sc.nextInt();
                try {
                    DataAccessObject.deleteRecord(delId);
                    System.out.println("record data deleted successfully!!!");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            default:
                System.out.println("You entered invalid number!!!");
        }
        } catch (InputMismatchException ime) {
            System.out.println("Invalid input, "+ime.getMessage()+"!!!");
        }



    }
}