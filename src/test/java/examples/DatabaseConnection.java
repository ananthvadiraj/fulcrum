package examples; /**
 * Created with IntelliJ IDEA.
 * User: Ananth
 * Date: 29/03/14
 * Time: 22:06
 * To change this template use File | Settings | File Templates.
 *
 * Selenium Database Connectivity using Java
 //        We can easily connect Database with Selenium. The below example illustrates how to use/connect MySQL with Selenium using Java.
 //
 //        Prerequisites:
 //
 //        mysql-connector-java-5.1.0-bin.jar  or above versions
 //        Create a table with some data
 //
 //        Snippet:
 */

//


import java.sql.*;
import javax.sql.*;

public class DatabaseConnection {

    public static void main(String args[]) {
        String email;
        String dbUrl = "jdbc:mysql://localhost:3306/test";  //This URL is based on your IP address
        String username = "username"; //Default username is root
        String password = "password"; //Default password is root
        String dbClass = "com.mysql.jdbc.Driver";
        String query = "Select email from users where user_id = 1;";

        try {
            Class.forName(dbClass);
            Connection con = DriverManager.getConnection(dbUrl, username, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
//                dbtime = rs.getString(1);
//                System.out.println(email);
            }

            con.close();
        }

        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
