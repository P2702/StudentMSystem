package com.tca.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.tca.view.AddStudentScreen;
import com.tca.view.DeleteStudentScreen;
import com.tca.view.DisplayStudentScreen;
import com.tca.view.UpdateStudentScreen;

public class HomeScreen extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JMenuBar mbr;
	JMenu mStudent, mHome, mContact , mHelp;
	JMenuItem miAddStudent, miDisplayStudent, miUpdateStudent, miDeleteStudent;
	
	public HomeScreen()
	{
		setLayout(null);
		mbr = new JMenuBar();
		mbr.setSize(800,30);
		mbr.setLocation(0, 0);
		add(mbr);
		
		mHome = new JMenu("Home");
		mbr.add(mHome);
		
		mStudent = new JMenu("Student");
		mbr.add(mStudent);
		
		mContact = new JMenu("Contact us");
		mbr.add(mContact);
		
		mHelp = new JMenu("Help");
		mbr.add(mHelp);
				
		miAddStudent= new JMenuItem("Add Student");
		miAddStudent.addActionListener(this);
		mStudent.add(miAddStudent);
		
		miDisplayStudent= new JMenuItem("Display Student");
		miDisplayStudent.addActionListener(this);
		mStudent.add(miDisplayStudent);
		
		
		miUpdateStudent= new JMenuItem("Update Student");
		miUpdateStudent.addActionListener(this);
		mStudent.add(miUpdateStudent);
		
		miDeleteStudent= new JMenuItem("Delete Student");
		miDeleteStudent.addActionListener(this);
		mStudent.add(miDeleteStudent);
		
		
		
		setTitle("TCA.COM");
		setSize(800,800);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand(); 
		
		if(command.equals("Add Student"))
		{
			new AddStudentScreen();
		}
		
		if(command.equals("Display Student"))
		{
			new DisplayStudentScreen();
		}
		
		if(command.equals("Update Student"))
		{
			new UpdateStudentScreen();
		}
		
		if(command.equals("Delete Student"))
		{
			new DeleteStudentScreen();
		}
		
		
	}
}




