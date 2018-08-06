package com.sahil;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class LoginDemo 
{
	
public static StringBuffer shaFunction(String plainText)
{
	StringBuffer hexString = new StringBuffer();
	try
	{
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] encodedHash = md.digest(plainText.getBytes(StandardCharsets.UTF_8));
		for (int i = 0; i < encodedHash.length; i++)
		{
			String hex = Integer.toHexString(0xff & encodedHash[i]); //to convert bytes to hexadecimal equivalent and that to string
			if (hex.length() == 1) hexString.append('0');
			hexString.append(hex);
		}
		//System.out.println(hexString);
		return hexString;
	} catch (NoSuchAlgorithmException e)
	{
		e.printStackTrace();
	}
	return hexString;
}

	public static void main(String args[])
	{
		
	try {

		Connection conn;
		Class.forName("com.mysql.jdbc.Driver");
		
	    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/staffdetails","root","");

	    String sql="SELECT id,password,idcategory FROM staffdet";
	    PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs=stmt.executeQuery();
	    boolean exist=false;
	while(rs.next() && exist == false)
	{
		String id1="asdf1234";
		String Password="admin";
		//These have no such acoount in the database
		//String id1="notsuchvalue";
		//String Password="notsuchvalue";
		String Category1="admin";
		String Category2="staff";
		StringBuffer bu = new StringBuffer(shaFunction(Password));
		String s= new String(bu);

		String id=rs.getString("id");
		String pass=rs.getString("password");

		String cate = rs.getString("idcategory");
		if(id.equals(id1) && pass.equals(s) && cate.equals(Category1))
		{
			System.out.println("Logged in as Admin");
		//open admin frame
				exist=true;
		}
		else if(id.equals(id1) && pass.equals(s) && cate.equals(Category2))
		{
			System.out.println("Logged in as Staff");
			//open staff frame
			exist=true;
		}
		else
		{
			exist=false;
			//for the entire loop exist is false, when the record finishes the while loop ends
		}

	}
	if(exist==false)
	{
		System.out.println("No such employee record found");
	}
	

	}
	catch(Exception e)
	{
		System.out.println(e);
	}
}
	

}
