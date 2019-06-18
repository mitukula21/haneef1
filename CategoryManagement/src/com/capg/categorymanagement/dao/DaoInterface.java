package com.capg.categorymanagement.dao;

public interface DaoInterface 
{
   public void takeDetails() throws ClassNotFoundException;
   boolean createCategory(String cat);
   void editCategory();
}
