package service;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import model.Users;

public class UsersDao {
	public boolean registerUser(Users users)
	{ boolean result=false;
	Connection connection=null;
		try{
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		
//		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@192.168.101.50s:1521:xe", "hr", "hr");
		//FileInputStream fis=new FileInputStream("C:\\Users\\lntinfotech\\workspace\\Egroup4\\src\\main\\resources\\database.properties"); 
		 
			
			Properties p=new Properties (); 
		    p.load (this.getClass().getResourceAsStream("/database.properties")); 
		    
		    String driver = p.getProperty("jdbc.driver");
		    if(driver != null)
		    	Class.forName(driver);
		    
		    String url = p.getProperty("jdbc.url");
		    String user = p.getProperty("jdbc.user");
		    String password = p.getProperty("jdbc.password");
		    connection =  DriverManager.getConnection(url,user,password);
			
			
		String sql="insert into college values (?,?,?,?,?,?)";
		
		PreparedStatement ps= connection.prepareStatement(sql);
		ps.setString(1, users.getCid());
		ps.setString(2, users.getCname());
		ps.setString(3, users.getCoursetype());
		ps.setString(4, users.getCity() );
		ps.setString(5, users.getFees());
		ps.setString(6, users.getPincode());
		
		int res=ps.executeUpdate();
		connection.close();
		if(res>0)
		{
			result=true;
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return result;
	}

	
	/*public List<Users> viewUser()
	{ boolean result=false;
	List<Users> clist=new ArrayList<Users>();
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		String sql="select cname from college where city='Mumbai' and coursetype ='Engg'";
		
		PreparedStatement ps= con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery(sql);
	
		
		while(rs.next())
		{
			Users users=new Users(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			clist.add(users);
		}
		con.close();
		}	
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return clist;
		
	}*/

}
