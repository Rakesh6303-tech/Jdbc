 package jdbc_connection;
 /*
  * Complete Query----> create SQL Stmt
  * Incomplete Query ---> Prepare Sql stmt
  * Fetching means -->We have a Data in Table we have to Display  
  */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
//import jdbc_connection.MyConnection;// Accessing the connection from different Package

public class FetchSpecificData 
{
	 /// ----> ? Place holder
	private static String sql = "Select * from emp where id=?";
	static Connection con;
	static PreparedStatement pstmt;
	static ResultSet resultSet;
	public static void main(String[] args) {
		
		try {
			System.out.println("Enter the Employee Id:");
			
			int input = new Scanner(System.in).nextInt();
			// 1) Load Driver  2)Establish Connection
			con = MyConnection.connect();
			
			// 3) prepare Sql Stmt bcz query is Incomplete
			pstmt = con.prepareStatement(sql);
			
			              //user Input
			pstmt.setInt(1,input);
			// 4) Execute Query
			resultSet = pstmt.executeQuery();
			
			// 5) process Result if data will found
				if(resultSet.next())
				{
					System.out.println(
							resultSet.getInt("id")+" "+
					        resultSet.getString("name")+" "+
							resultSet.getString("desig")+" "+
					        resultSet.getInt("salary"));
				}
		 // No records are Found
				else
				{
					System.out.println("No Records Found");
				}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
