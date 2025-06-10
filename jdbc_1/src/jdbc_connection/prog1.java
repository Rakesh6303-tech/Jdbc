package jdbc_connection;
/*
 * JDBC -->Java DataBase Connectivity
 * Driver-->Which is used to Connect The Java Program to Database
 * Whenever we want to conncect any Application--> Ip Address , Port Number
 * Steps For Connect
 * 1)Load The Driver--> Class(Inbulit class) Class.forName();
 *   ---> Class.forName("com.mysql.cj.jdbc.Driver");
 * 2) Establish the Connection  
 *  ---> DriverManager.getConnection(url,username,password);
 * 3) Create a SQL Statement
 * ---> stmt = con.createStatement();
 * 4) Execute the Query
 * ---> stmt.exectu
 * 5) Process the Data
 * ---> By using While loop
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class prog1 {	
	// Instance Varaibles
	static Connection con;
	static Statement stmt;
	static ResultSet resultSet;
	public static void main(String[] args) {
		
		try {
			// The Connect method present inside differnt class and diff package
			con = MyConnection.connect();
			// 3rd Step Create Stament
			stmt = con.createStatement();

			// 4th Execute SQL statement    select * from TBN --> Data Present in resultSet
			resultSet  = stmt.executeQuery("select * from emp");
			
			// 5th Process The Data & Updating the code 
			while(resultSet.next())
			{
				System.out.println(resultSet.getInt(1)+" "+
			                        resultSet.getString(2)+" "+
						            resultSet.getString(3)+" "+
			                        resultSet.getInt(4));
			}
			
		} catch (SQLException e) {
			e.printStackTrace(); // We can provide multiple exceptions in the catch block
		}  
		
		// Closing Connections which we placed inside a final block
		finally
		{   
			// classname.methodname(parameters)
			MyConnection.closeConnection(resultSet, stmt, con);
		}
	}

 
 }

