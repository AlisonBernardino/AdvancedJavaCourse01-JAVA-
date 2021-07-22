// Database imports
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        // Connection strings and server access data
        String chosenServer = "jdbc:sqlserver://localhost:1433;databaseName=carShop";
        String chosenUser = "administrator";
        String chosenPassword = "admin";
        
        // Connection
        Connection connection01;
        // SQL instruction
        Statement SQLInstruction;
        // Database output
        ResultSet databaseOutput;
        
        try{
            // To connect to database
            connection01 = DriverManager.getConnection(chosenServer, chosenUser, chosenPassword);
            
            // To create the SQL instruction
            SQLInstruction = connection01.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            databaseOutput = SQLInstruction.executeQuery("SELECT * FROM availableVehicles");
        }catch(SQLException sqlError){
            System.out.println(sqlError.getMessage());
        }
    }
}
