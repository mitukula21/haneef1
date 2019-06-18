package com.capg.categorymanagement.ui;

import java.util.Scanner;

import com.capg.categorymanagement.bean.Bean;
import com.capg.categorymanagement.service.ServiceClass;

public class CategoryManagementMain {
	
	
	public static void main(String[] args)
	{
		
		    Scanner s = new Scanner(System.in);
			ServiceClass sc= new ServiceClass();
			//ServiceClass sc1= new ServiceClass();
			
			Bean bean= new Bean();
			
		int option = 0;
		while(true) {
		System.out.println("   CATEGORY MANAGEMENT ");
		System.out.println("_______________________________\n");

		System.out.println("1.Listing Categories ");
		System.out.println("2.Creating Category");
		System.out.println("3.Editing Category");
		System.out.println("4.Deleting Category");
		System.out.println("________________________________");
		System.out.println("Select an option:");
		
		try {
			option = s.nextInt();

			switch (option) {

			case 1:
				System.out.println("Listing ");
				
				sc.takeDetails();
                break;
                
			case 2:
				boolean b;
				do {
				System.out.println("Creating ");
				System.out.println("Enter the category Name");
				String cat= s.next();
				bean.setCategory_name(cat);
				b=sc.createCategory(cat);
               
				}
				while(!b);
				 break;
			case 3:
				System.out.println("Editing ");
				sc.editCategory();
                break;
                
			case 4:
				System.out.println("deleting ");
				sc.deleteCategory();
                break;
                           
		}
		}
			catch(Exception e)
			{
				
				System.out.println(e);
			}
				
			

}
}
}
