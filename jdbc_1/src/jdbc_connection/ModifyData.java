package jdbc_connection;
import java.sql.Connection;
import java.util.*;
import java.sql.PreparedStatement;
public class ModifyData {
	
	static String MODIFY_EMP = "update `emp` set `desig` =?, `salary`=? where `id`=?";
	static Connection con;
	static PreparedStatement pstmt;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the desig");
		String empdesig = scan.nextLine();
		System.out.println("Enter the Emp salary:");
		int empsalary = scan.nextInt();
		System.out.println("Enter the Emp ID:");
		int empid = scan.nextInt();
		
		try
		{
			// 1) Load Driver & Establish Connection
			con = MyConnection.connect();
			
			pstmt = con.prepareStatement(MODIFY_EMP);
			
			pstmt.setString(1, empdesig);
			pstmt.setInt(2, empsalary);
			pstmt.setInt(3, empid);
			
			int res = pstmt.executeUpdate();
			System.out.println(res+" row/s Updated");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally { // for Closing the Connection 
			MyConnection.closeConnection(null, pstmt, con);
		}
	}

}
