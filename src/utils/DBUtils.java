package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface DBUtils {
//add a static method for getting a FIXED DB connection
	static Connection fetchDBConnection(String drvrClass, String url, String userName, String password) throws ClassNotFoundException,SQLException
	{

//		Class.forName(drvrClass);
		//get the fixed connection to DB
		
		return DriverManager.getConnection(url, userName,password);
	}
	
}
