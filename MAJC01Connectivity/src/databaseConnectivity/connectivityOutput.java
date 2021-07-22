// connectivityOutput = This class is used to return all the database 
// information
package databaseConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// "Students" system example
public class connectivityOutput {

    public static void main(String[] args) {
        String selectedServer = "jdbc:sqlserver://localhost:1433;databaseName=studentsDatabase";
        String selectedUser = "administrator";
        String selectedPassword = "admin";

        Connection dataConnection;
        Statement SQLCommands;
        ResultSet dataResults;

        try {
            dataConnection = DriverManager.getConnection(selectedServer, selectedUser, selectedPassword);
            SQLCommands = dataConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            dataResults = SQLCommands.executeQuery("SELECT * from exampleTable");

            // "While" loop to return the entire database content
            while (dataResults.next()) {
                int studentID = dataResults.getInt("studentID");
                String studentFirstName = dataResults.getString("studentFirstName");
                String studentLastName = dataResults.getString("studentLastName");
                int studentAge = dataResults.getInt("studentAge");
                float studentWeight = dataResults.getFloat("studentWeight");
                float studentHeight = dataResults.getFloat("studentHeight");
                String studentCellphone = dataResults.getString("studentCellphone");
                String studentEmail = dataResults.getString("studentEmail");
                String studentSlack = dataResults.getString("studentSlack");
            }
        }catch(SQLException sqlError) {
            System.out.println(sqlError.getMessage());
        }
    }
}
