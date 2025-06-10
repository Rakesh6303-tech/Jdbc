package jdbc_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConnection {
     
	 //2 lst) url = api:vendor://ip-address:port num/ db_name
	
	static Connection con;
	public static Connection connect()
	{
		
		try {
			//1)Load The Driver-->
			Class.forName("com.mysql.cj.jdbc.Driver"); // 
			

			// 2st) Establish the Connection // using anotherclass and accesing password,username,url
			con= DriverManager.getConnection( Credentials.url,Credentials.username,Credentials.password  );
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
    // For without creating the closeconnection object
		static public void closeConnection(ResultSet resultSet,Statement stmt,Connection con)
		 {
			 try {
					if(con!=null)
					{
						con.close();
						System.out.println("Connection Closed");
					}
					if(stmt!=null)
					{
						stmt.close();
						System.out.println("Statement is Closed");
					}
					if(resultSet!=null)
					{
						resultSet.close();
						System.out.println("ResultSet is Closed");
					}				
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
		 }

public static void main(String[] args) 
{
	
}
}
