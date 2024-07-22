package project;

import java.sql.*;
import java.util.ArrayList;

public class DataAccessObject {
    //create record data
    public static void createRecord(StudentInput si) throws SQLException{
        DatabaseConnectivity.connection = DatabaseConnectivity.connect();
        String query = Query.insert;
        PreparedStatement statement = DatabaseConnectivity.connection.prepareStatement(query);
        statement.setInt(1, si.getId());
        statement.setString(2, si.getName());
        statement.setString(3, si.getEmail());

//        System.out.println("record created successfully!!!");
        statement.execute();
        statement.close();
        DatabaseConnectivity.connection.close();
    }

    //read record data
    public static ArrayList<StudentInput> readRecords() throws SQLException{
        ArrayList<StudentInput> emptyList = new ArrayList<>();
        DatabaseConnectivity.connection = DatabaseConnectivity.connect();
        String query = Query.select;

        Statement statement = DatabaseConnectivity.connection.createStatement();
        ResultSet result = statement.executeQuery(query);

        while (result.next()) {
            StudentInput student = new StudentInput(result.getInt(1), result.getString(2), result.getString(3));
            emptyList.add(student);
        }
        statement.close();
        DatabaseConnectivity.connection.close();
        return emptyList;
    }

    //update record data
    public static void updateRecord(int id, String name, String email) throws SQLException{
        DatabaseConnectivity.connection = DatabaseConnectivity.connect();
        String query = Query.update;

        PreparedStatement statement = DatabaseConnectivity.connection.prepareStatement(query);
        statement.setString(1, name);
        statement.setString(2, email);
        statement.setInt(3, id);

        statement.executeUpdate();
        DatabaseConnectivity.connection.close();
        statement.close();

    }

    //delete record data
    public static void deleteRecord(int id) throws SQLException{
        DatabaseConnectivity.connection = DatabaseConnectivity.connect();
        String query = Query.delete;

        PreparedStatement statement = DatabaseConnectivity.connection.prepareStatement(query);
        statement.setInt(1, id);

        statement.execute();
        statement.close();
        DatabaseConnectivity.connection.close();
    }
}
