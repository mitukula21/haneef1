package com.capg.categorymanagement.service;

public interface ServiceInterface 
{
     void takeDetails() throws ClassNotFoundException;
     boolean createCategory(String cat);
     void editCategory();
     void deleteCategory();
}
