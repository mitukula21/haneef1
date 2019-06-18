package com.capg.categorymanagement.dao;

import java.sql.*;
import java.util.Scanner;

import com.capg.categorymanagement.bean.Bean;
import com.capg.categorymanagement.connection.DbConnection;

public class DaoClass implements DaoInterface
{ 
	Bean bean= new Bean();
     Scanner sc=new Scanner(System.in);

	public void takeDetails() 
	{
		// TODO Auto-generated method stub
	  Connection con= null;
	  DbConnection db= new DbConnection();
	 
	  try {
		  con= db.getConnection();
		  ResultSet rs=null;
		  PreparedStatement ps=null;
		  ps=con.prepareStatement("select * from customermanagement");
		  rs=ps.executeQuery();
		 while(rs.next())
		 {
			 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "); 
		 }
		  
		  
		  
		  
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
		
	}

	
	public boolean createCategory(String cat)
	{
		// TODO Auto-generated method stub
		  Connection con= null;
		  boolean b;
		  DbConnection db= new DbConnection();
		  Bean bean= new Bean();
		  try {
			  ResultSet rs=null;
			  PreparedStatement ps=null;
			  PreparedStatement ps1=null;
			  con= db.getConnection();
		
			  ps=con.prepareStatement("Insert into categorymanagement values(category_id_seq.nextval,?) ");
			  ps.setString(1, cat);
			 int rs1=ps.executeUpdate();
			 System.out.println(cat);
			/* while(rs.next())
			 {
				 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "); 
			 }*/
			 if(rs1==1)
			 {
			
				// ps1=con.prepareStatement(" select category_id from categorymanagement where category_name="+cat);
				 System.out.print("A new Category is created with category_id ");
				 ps1=con.prepareStatement("select category_id_seq.currval from dual");
			     rs=ps1.executeQuery();
			 }
			
			 while(rs.next())
			 {
				 System.out.println(rs.getInt(1));
			 }
				 
			 b=true;
		  }
		
			 catch (ClassNotFoundException | SQLException e)
			 {
					// TODO Auto-generated catch block
				 System.out.println("Already existing category");
				 b=false;
					
				}
		return b ;
  
	
    }
	  public void editCategory()
	  {
		  Connection con= null;
		  DbConnection db= new DbConnection();
		  String a=null,b=null;
		  boolean b1=true;
		  
		  try {
			 
			 con= db.getConnection();
			 ResultSet rs=null;
			 ResultSet rs1=null,rs2=null;
			 PreparedStatement ps=null;
			 PreparedStatement ps1=null,ps2=null;
			 System.out.println("Enter the name of the category to Edit");
			 
			
			 a=sc.next();
			
			 ps=con.prepareStatement("select category_name from categorymanagement where category_name=?" );
			 ps.setString(1,a);
			 rs=ps.executeQuery();
			if(!rs.next())
			{
				System.out.println("this category is not existing");
		        b1=false;
			}
			 while(rs.next())
			 {
				 System.out.println(rs.getString(1));
			 }
			 if(b1)
			 {
				 System.out.println("Enter the new name of the category to Edit");
				 b=sc.next();
				 ps1=con.prepareStatement("update categorymanagement set category_name=? where category_name=?" );
				 ps1.setString(1,b);
				 ps1.setString(2,a);
				 rs1=ps1.executeQuery();
				System.out.println("The Category name is successfully edited");
				ps2=con.prepareStatement("select category_id from categorymanagement where category_name='"+b+"'" );
				 rs2=ps2.executeQuery();
				 while(rs2.next())
				 {
					 System.out.printf("The category id is %d",rs2.getInt(1));
				 }
			 } 
			 
			  
			 
		      }
		  
		  catch (ClassNotFoundException | SQLException e) 
		  {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			  System.out.println("The name of the category is already existing");
			
		}
		 
	  }
	  public void deleteCategory()  
	  {
		  Connection con= null;
		  DbConnection db= new DbConnection();
		  boolean b1=true;
		  
		  try {
			    con= db.getConnection();
			    System.out.println("Enter the name of the category to delete");
			    String a = sc.next();
			    PreparedStatement ps = con.prepareStatement("select category_name from categorymanagement where category_name=?" );
				ps.setString(1,a);
				ResultSet rs = ps.executeQuery();
				
				if(!rs.next())
				{
					System.out.println("this category is not existing");
			         b1 = false;
				}
			    
				 while(rs.next())
				 {
					 System.out.println(rs.getString(1));
				 }
				 if(b1)
				 {
					 PreparedStatement ps1 = con.prepareStatement("delete  from categorymanagement where category_name=?" ); 
					 ps1.setString(1,a);
					 ResultSet rs1 = ps1.executeQuery();
					 System.out.println("The category is deleted successfully");
				 }
		  } 
		  
		  
		  catch (ClassNotFoundException | SQLException e) 
		  {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
		  
	  }
	
	}


