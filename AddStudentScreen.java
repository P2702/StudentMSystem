package com.tca.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.tca.entities.Student;
import com.tca.student.util.StudentOperations;

public class AddStudentScreen extends JFrame implements ActionListener
{
	
	JLabel lRno,lName, lPer;
	JTextField tfRno, tfName, tfPer;
	JButton bSave, bClear;
	
	public AddStudentScreen()
	{
		setLayout(null);
		
		lRno = new JLabel("Roll Num :");
		lRno.setSize(100,30);
		lRno.setLocation(30,30);
		add(lRno);
		
		tfRno = new JTextField();
		tfRno.setSize(200,30);
		tfRno.setLocation(150,30);
		add(tfRno);
		
		lName = new JLabel("Name :");
		lName.setSize(100,30);
		lName.setLocation(30, 80);
		add(lName);
		
		tfName = new JTextField();
		tfName.setSize(200,30);
		tfName.setLocation(150,80);
		add(tfName);
		
		lPer = new JLabel("Percentage :");
		lPer.setSize(100,30);
		lPer.setLocation(30, 130);
		add(lPer);
		
		tfPer = new JTextField();
		tfPer.setSize(200,30);
		tfPer.setLocation(150,130);
		add(tfPer);
		
		bSave = new JButton("SAVE");
		bSave.setSize(100,30);
		bSave.setLocation(60,190);
		bSave.addActionListener(this);
		add(bSave);
		
		bClear = new JButton("CLEAR");
		bClear.setSize(100,30);
		bClear.setLocation(200, 190);
		bClear.addActionListener(this);
		add(bClear);
		
		setTitle("Add Student");
		setSize(400,300);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) // e --> SAVE
	{
		String command = e.getActionCommand(); // command --> SAVE
				
		if(command.equals("SAVE"))
		{
			try
			{
				int srno     =  Integer.parseInt(tfRno.getText());   // "101" --> 101 --> srno
				String sname =  tfName.getText();                    // "AAA"          --> sname
				double sper   =  Double.parseDouble(tfPer.getText()); // "60.0" --> 60.0 --> sper
			
				Student s = new Student(srno,sname,sper);
			
				boolean status = StudentOperations.save(s);
			
				if(status==true)
				{
					JOptionPane.showMessageDialog(null, "Record is Saved Successfully for Roll Number:" + srno);
					tfRno.setText("");
					tfName.setText("");
					tfPer.setText("");
					tfRno.requestFocus();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Unable to Save Record for Roll Number :" + srno);
				}
			}
			catch(Exception exception)
			{
				JOptionPane.showMessageDialog(null, "Invalid Input is Given !!");
			}
		}
		
		if(command.equals("CLEAR"))
		{
			tfRno.setText("");
			tfName.setText("");
			tfPer.setText("");
			tfRno.requestFocus();
		}
		
		
	}
}







