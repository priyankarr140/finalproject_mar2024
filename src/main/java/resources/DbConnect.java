package resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbConnect {
	
	public ArrayList<String> dbconnection() throws SQLException
	{
		String host="localhost";
		String port="3306";
		String url="jdbc:mysql://"+host+":"+port+"/maybatch";
		Connection conn=DriverManager.getConnection(url,"root","123456");
       Statement s = conn.createStatement();
       ArrayList<String>fulldata=new ArrayList<String>();
  
       // s.executeUpdate("insert into phonebook "+ "values(4,'D',400,'false','false')");
       // s.executeUpdate("update phonebook set phonenumber=500 where id=4;");
		  ResultSet result= s.executeQuery("select * from student");
		  while(result.next())
		  {
			 String data=result.getString("name"); 
			 fulldata.add(data);
		  }
		  return fulldata;
	}
	public static void main(String[]args) throws Exception
	{
		DbConnect db=new DbConnect();
		System.out.println(db.dbconnection());
	}

}
