package com.tca.student.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tca.entities.Student;

/**
 	Document Comment
 	
 */

public class StudentOperations 
{
	
	public static  boolean save(Student ob)  // ob[101,DDD,95]
	{
		
		try
		{
			int     srno = ob.getRno();
			String  sname= ob.getName();
			double  sper = ob.getPer();
			
			Student s = StudentOperations.searchStudent(srno); // s--> 101,AAA, 60
			
			if(s==null)
			{
			
				FileWriter fw = new FileWriter("resources\\student.csv", true);  // Opening file for append mode
				BufferedWriter bw = new BufferedWriter(fw);
						
				String line = srno+","+ sname +","+ sper+"\n";
				bw.write(line);
					
				bw.close();
				fw.close();
				return true;
			}
			else
			{
				
				return false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	
	public static void saveAll( List<Student> listofStudents)  // 101 102 104
	{
	
		if(listofStudents==null)
		{
			return;
		}
		
		for(Student ob : listofStudents)  // ob--> [102,BBB,70]
		{
			boolean status = StudentOperations.save(ob);
			
			if(status==true)
			{
				System.out.println("Record Saved for Roll Number : " + ob.getRno());
			}
			
		}
	}
		
	public static List<Student> getAllStudents()
	{
		List<Student> L = new ArrayList<>();   // [101,AAA,60] [102,BBB,70] [103,CCC,80]
		
		try
		{
			FileReader fr     = new FileReader("resources\\student.csv");
			BufferedReader br = new BufferedReader(fr);
			
			while(true)
			{
				String line = br.readLine(); // line --> null
				
				if(line==null)
				{
					break;
				}
				
				String tok[] = line.split(","); // tok[0]: "13"  tok[1]:"CCC"  tok[2]:"80.0"
				
				int srno     = Integer.parseInt(tok[0]);
				String sname = tok[1];
				double sper  = Double.parseDouble(tok[2]);
				
				Student s = new Student(srno,sname,sper);
				L.add(s);
				
			}
					
			br.close();
			fr.close();
			return L;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
										    
	public static Student searchStudent(int trno)
	{
		List<Student> L = StudentOperations.getAllStudents(); //L--> [101,aaa,60] [102,bbb,70] [103,ccc,80]
		
		for(Student S :  L ) // S--> [102,bbb,70]
		{
		 
			if(trno == S.getRno())
			{
				return S;
			}
			   
		}
			
		return null;		
	}
	
	
	/**
	   Author : Sachin Dhanae
	   Date   : 06-11-2024
	   deleteStudent(int trno) method:
	        Input : Roll Number
	        Output: true/false
	   
	   This function takes input as a Roll number & delter that record from a file.
	                                         
	 */
	public static boolean deleteStudent(int trno)
	{
		
		List<Student> L = StudentOperations.getAllStudents(); //L --> [101] [102]  [104]
				
		for(Student ts : L) // ts-->[103]
		{
				if(trno==ts.getRno())
				{
					L.remove(ts);
					
					/*
					 	Deleting file with old data.
					 	Then Creating new empty file with same name 
					 	Then Saving whole List<Student> in file
					 */
					
					File f = new File("resources\\student.csv");
					f.delete();
					
					try
					{
						f.createNewFile();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				
				/*
					try 
					{
						FileWriter fw = new FileWriter("resources\\student.csv");
						fw.close();
					} 
					catch (IOException e) {
						
						e.printStackTrace();
					}
				*/	
					
					
					StudentOperations.saveAll(L);  // over-writing
					
					return true;
				}
		}
			
		return false;	
		
	}
	
	
	public static boolean updateStudent(Student s) //s --> 101, ZZZ 90
	{
		
		List<Student> L = StudentOperations.getAllStudents(); // L -> [101 ZZZ 90]  [102]  [103]  [104]
		
		for(Student ts : L)
		{
			   
			if(s.getRno() ==  ts.getRno())  // ts -->  [101 aaa 60]
			{
				ts.setName( s.getName()  );
				ts.setPer(  s.getPer()    );
				
				File f = new File("resources\\student.csv");
				f.delete();
				
				try
				{
					f.createNewFile();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				StudentOperations.saveAll(L);  // over-writing
				
				return true;
			}
			
		}
		
		return false;
	}
}

















