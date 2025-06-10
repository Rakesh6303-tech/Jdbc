package jdbc_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Inserting {
	
	
	//	private static String sql = "Insert into emp(`id`,`name`,`desig`,`salary`)"
	// 		+ "values(?,?,?,?)";    ---> We can Create Like This Also in the data
	private static String INSERT_EMP = "Insert into emp(id,name,desig,salary)"
			+ "values(?,?,?,?)";
	static Connection con;
	static PreparedStatement pstmt;
	static ResultSet resultSet;
	public static void main(String[] args) {
		
		try {
			System.out.println("Enter the Employee Id:");
			int empid = new Scanner(System.in).nextInt();
			
			System.out.println("Enter the Employee Name:");
			String empname = new Scanner(System.in).nextLine();
			
			System.out.println("Enter the Employee Designation:");
			String empdesig = new Scanner(System.in).nextLine();
			
			System.out.println("Enter the Employee Salary:");
			int empsalary = new Scanner(System.in).nextInt();
			
			// 1) Load Driver  2)Establish Connection
			con = MyConnection.connect();
			
			// 3) prepare Sql Stmt bcz query is Incomplete
			pstmt = con.prepareStatement(INSERT_EMP);
			
			pstmt.setInt(1, empid);
			pstmt.setString(2, empname);
			pstmt.setString(3, empdesig);
			pstmt.setInt(4, empid);
			
			// 4) Execute Query
			int x = pstmt.executeUpdate();
			System.out.println(x+"row inserted");
			
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}



}
