package jdbc_connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
public class DeleteData {
	
	final private static String DELETE_EMP = "delete from emp where `id`=?";
	static Connection con;
	static PreparedStatement pstmt;
	public static void main(String[] args) throws SQLException {  // line 37 pass the exception
		
		System.out.println("Whose Information You want to Delete");
		int empid =  new Scanner(System.in).nextInt();
		
		// 1)load the Driver & Establish Connection
		try {
			con = MyConnection.connect();
			
			pstmt = con.prepareStatement(DELETE_EMP);
			
			pstmt.setInt(1, empid);
		
			
			int x = pstmt.executeUpdate();
			
			System.out.println(x+" row/s Deleted");
			
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			
			if(pstmt!=null)
			{
				pstmt.close();
			}
			if(con!=null)
			{
				con.close();
			}
			System.out.println("Pstmt & Con are Closed");
		}
	}

}
