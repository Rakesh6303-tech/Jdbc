package jdbc;
/*
 * Download Jar file--> mysql jar file --> select platform independent-->download Jar Extract file
 * 
 * -->Copy and choose new folder in D drive.
 * 
 *-- Create New Folder like Lib --> copy only mysql connector and paste in the Lib folder
 *
 * How to add Jar File To Programs?
 * 
 * ..>Select Project -->Right click-->Properties-->Java Build Path
 * 
 * -->Libraries-->Classpath-->Add Jars-->Select Folder-->Choose Jar File-->Apply
 */
import java.util.*;
public class FirstJdbc {

	public static void main(String[] args) 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
		}
		catch(Exception e)
		{
			System.out.println("Class not found");
			e.printStackTrace();
		}
	}

}
