package com.tca;

import com.tca.controller.HomeScreen;

public class App {

	
	public static void main(String[] args) 
	{
			
		// AddStudentScreen as = new AddStudentScreen();
		
		//DisplayStudentScreen ad = new DisplayStudentScreen();
		new HomeScreen();
		
/*
	
		// Test Code - save() method
		
		Student s1 = new Student(102,"BBB",70);
		
		boolean status = StudentOperations.save(s1);
		
		if(status==true)
		{
			System.out.println("Record is Saved for Roll Number : " + s1.getRno() );
		}
		else
		{
			System.out.println("Unable to Save for Roll Number : " + s1.getRno() );
		}
		
		
		
		//Test Code - saveAll() method
		Student s1 = new Student(101,"AAA", 60);
		Student s2 = new Student(102,"BBB", 70);
		Student s3 = new Student(103,"CCC", 80);
		
		List<Student> L =  new ArrayList<>();
		L.add(s1);
		L.add(s2);
		L.add(s3);
		
		StudentOperations.saveAll(L);
		
		
			//Test Code - getAllStudents() method
		
		List<Student> L = StudentOperations.getAllStudents();  // [101] [102] [103]
		
		for(Student S : L)  // S--> 
		{
			System.out.println(S);
		}
		
		
		//Test COde - searchStudent() method
		
		int trno = 107;
		
		Student s = StudentOperations.searchStudent(trno);
		if(s==null)
		{
			System.out.println("No Record Found for Roll Number : " +  trno);
		}
		else
		{
			System.out.println("Record Found for Roll Number : " +  s.getRno());
			s.display();
		}
		
		//Test Code - deleteStudent()
	
		int trno = 103;
		
		boolean status = StudentOperations.deleteStudent(trno);
		
		if(status==true)
		{
			System.out.println("Record is Deleted for Roll Number : " + trno);
		}
		else
		{
			System.out.println("Unable to delte Record is Roll Number : " + trno);
		}
		
		
		
		// Test Code - upadateStudent() method
		Student s = new Student(101,"Sachin",60);
		
		boolean status = StudentOperations.updateStudent(s);
		
		if(status==true)
		{
			System.out.println("Record is Update for Roll Number : " + s.getRno());
			s.display();
		}
		else
		{
			System.out.println("Unable to Update Record is Roll Number : " + s.getRno());
		}
		
*/		
	}

}
