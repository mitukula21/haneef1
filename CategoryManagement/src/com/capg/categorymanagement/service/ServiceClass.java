package com.capg.categorymanagement.service;

import com.capg.categorymanagement.dao.DaoClass;

public class ServiceClass implements ServiceInterface
{
	DaoClass dao= new DaoClass();
	public void takeDetails() throws ClassNotFoundException 
	{
		 dao.takeDetails();
	}
   
	public boolean createCategory(String cat)
	{
	
	   boolean b= dao.createCategory(cat);
	   return b;
		
	}

	public void editCategory() 
	{
		dao.editCategory();
	}

	public void deleteCategory()
	{
		// TODO Auto-generated method stub
		dao.deleteCategory();
		
		
	}
	
}
