package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class project {

	private Connection connect()
	 {
	 Connection con = null;
	 try
	 {
	 Class.forName("com.mysql.cj.jdbc.Driver");

	 //Provide the correct details: DBServer/DBName, username, password
	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmanagement", "root", "");
	
	 
	 }
	 catch (Exception e)
	 {e.printStackTrace();}
	 return con;
	 }
	
	
public String insertProject(String aname, String pcategory, String ptitile,String price, String aemail, String pdesc)
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Did'nt connect to the database when inserting data"; }
	 // create a prepared statement
	 String query = "insert into project (`projectID`,`authorName`,`projectCategory`,`projectName`,`projectPrice`,`authorEmail`,`projectDesc`)"
	 + " values (?, ?, ?, ?, ?,?,?)";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 preparedStmt.setInt(1, 0);
	 preparedStmt.setString(2, aname);
	 preparedStmt.setString(3, pcategory);
	 preparedStmt.setString(4, ptitile);
	 preparedStmt.setDouble(5, Double.parseDouble(price));
	 preparedStmt.setString(6, aemail);
	 preparedStmt.setString(7, pdesc);
	// execute the statement
	 preparedStmt.execute();
	 con.close();
	 String newProjects = viewProjects();
	 output = "{\"status\":\"success\", \"data\": \"" +
	newProjects + "\"}"; 
	 }
	 catch (Exception e)
	 {
		 output = "{\"status\":\"error\", \"data\": \"Error while inserting the project.\"}";
		 System.err.println(e.getMessage()); 
		 
	 }
	 return output;
	 }
	
public String viewProjects()
{
String output = "";
try
{
Connection con = connect();
if (con == null)
{return "Did'nt connect to the database"; }
//Prepare the html table to be displayed
output = "<table border='1'>"
	   +"<tr><th>Author Name</th>"
       +"<th>Project Category</th>" 
       +"<th>Project Name</th>" 
       +"<th>Project Price ($)</th>" 		
       +"<th>Author Email </th>" 
       +"<th>Project Description</th>"
       +"<th>Update</th><th>Remove</th></tr>";

String query = "select * from project";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(query);
//iterate through the rows in the result set
while (rs.next())
{
String projectID  = Integer.toString(rs.getInt("projectID"));
String authorName = rs.getString("authorName");
String projectCategory = rs.getString("projectCategory");
String projectName = rs.getString("projectName");
String projectPrice = Double.toString(rs.getDouble("projectPrice"));
String authorEmail = rs.getString("authorEmail");
String projectDesc = rs.getString("projectDesc");



//Add into the html table
output += "<tr><td><input id='hidProjectIDUpdate' name='hidProjectIDUpdate' type='hidden' value='" + projectID 
       + "'>" + authorName + "</td>";	
output += "<td>" + projectCategory + "</td>";
output += "<td>" + projectName + "</td>";
output += "<td>" + projectPrice + "</td>";
output += "<td>" + authorEmail + "</td>";
output += "<td>" + projectDesc + "</td>";

//buttons
output += "<td><input name='btnUpdate' type='button' value='Update' "
	   + "class='btnUpdate btn btn-secondary'></td>"
       + "<td><input name='btnRemove' type='button' value='Remove'"
       + "class='btnRemove btn btn-danger' data-projectid='" + projectID + "'></td></tr>";
}
con.close();
//Complete the html table
output += "</table>";
}
catch (Exception e)
{
output = "Error when reading the Project Data ";
System.err.println(e.getMessage());
}
return output;
}


public String updateProject(String id,String aname, String pcategory, String ptitile,String price, String aemail, String pdesc)
{
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Did'nt connect to the database update the Project data"; }
	 // create a prepared statement
	 String query = "UPDATE project SET  authorName=?,projectCategory=?,projectName=?,projectPrice=?,authorEmail=?,projectDesc=?  WHERE projectID=?";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 preparedStmt.setString(1, aname);
	 preparedStmt.setString(2, pcategory);
	 preparedStmt.setString(3, ptitile);
	 preparedStmt.setDouble(4, Double.parseDouble(price));
	 preparedStmt.setString(5, aemail);
	 preparedStmt.setString(6, pdesc);
	 preparedStmt.setInt(7, Integer.parseInt(id));
	 // execute the statement
	 preparedStmt.execute();
	 con.close();
	 String newProjects = viewProjects();
	 output = "{\"status\":\"success\", \"data\": \"" +
	  newProjects + "\"}"; 
	 }
	 catch (Exception e)
	 {
		 output = "{\"status\":\"error\", \"data\":\"Error while updating the Projects.\"}";
		 System.err.println(e.getMessage()); 
	 }
	 return output;
	 }
	

public String deleteProject(String projectID)
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Did'nt connect to the database when deleting data"; }
	 // create a prepared statement
	 String query = "delete from project where projectID=?";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 preparedStmt.setInt(1, Integer.parseInt(projectID));
	 // execute the statement
	 preparedStmt.execute();
	 con.close();
	 String newProjects = viewProjects();
	 output = "{\"status\":\"success\", \"data\": \"" +
	 newProjects + "\"}"; output = "Deleted successfully";
	 }
	 catch (Exception e)
	 {
		 output = "{\"status\":\"error\", \"data\": \"Error while deleting the Project.\"}";
		 System.err.println(e.getMessage()); 
	 }
	 return output;
	 }

	
}
