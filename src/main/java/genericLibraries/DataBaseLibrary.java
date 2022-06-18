package genericLibraries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * This class consists of generic methods related to database
 * @author Chaitra M
 *
 */
public class DataBaseLibrary {
	
	Driver driverRef;
	Connection conn;
	
	/**
	 * This method will establish connection with database
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException
	{
		driverRef =new Driver();
		DriverManager.registerDriver(driverRef);
		conn=DriverManager.getConnection(ConstantsLibrary.dbURL, ConstantsLibrary.dbUsername, ConstantsLibrary.dbPassword);
		
	}
	
	/**
	 * This method will close the connection
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException
	{
		conn.close();
	}
	
	/**
	 * This method will execute query and return the data if its present in database
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return
	 * @throws SQLException
	 */
	public String executeQueryAndGetTheData(String query, int columnIndex, String expData) throws SQLException 
	{
		boolean flag = false;
		String actData = null;
		ResultSet result = conn.createStatement().executeQuery(query);
		while(result.next())
		{
			 actData = result.getString(columnIndex);
			if(actData.equalsIgnoreCase(expData))
			{
				flag = true;
				break;
			}
		}
		
		if(flag)
		{
			System.out.println("data verification successful");
			return expData;
		}
		
		else
		{
			System.out.println("data not verified");
			return " ";
		}
	}
	
	
	
	
	
	
	
	
	
	

}
