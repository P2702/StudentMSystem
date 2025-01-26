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

public class DeleteStudentScreen   extends JFrame implements ActionListener
{
	
	JLabel lRno,lName, lPer;
	JTextField tfRno, tfName, tfPer;
	JButton bSave, bClear;
	
	public DeleteStudentScreen ()
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
		tfName.setEditable(false);
		add(tfName);
		
		lPer = new JLabel("Percentage :");
		lPer.setSize(100,30);
		lPer.setLocation(30, 130);
		add(lPer);
		
		tfPer = new JTextField();
		tfPer.setSize(200,30);
		tfPer.setLocation(150,130);
		tfPer.setEditable(false);
		add(tfPer);
		
		bSave = new JButton("SEARCH");
		bSave.setSize(100,30);
		bSave.setLocation(60,190);
		bSave.addActionListener(this);
		add(bSave);
		
		bClear = new JButton("DELETE");
		bClear.setSize(100,30);
		bClear.setLocation(200, 190);
		bClear.addActionListener(this);
		//bClear.setVisible(false);
		add(bClear);
		
		setTitle("Display Student");
		setSize(400,300);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String command = e.getActionCommand(); 
				
		if(command.equals("SEARCH"))
		{
			try
			{
				int srno = Integer.parseInt(tfRno.getText());
				Student s = StudentOperations.searchStudent(srno);
				
				if(s==null)
				{
					JOptionPane.showMessageDialog(null, "No Record Exist for Roll Number :" + srno);
				}
				else
				{
					tfName.setText(s.getName());
					tfPer.setText(Double.toString(s.getPer()));
					
					//bClear.setVisible(true);
				}
				
			}
			catch(Exception exception)
			{
				JOptionPane.showMessageDialog(null, "Invalid Input is Given !!");
			}
		}
		
		if(command.equals("DELETE"))
		{
			try
			{
				int srno = Integer.parseInt(tfRno.getText());
			
				boolean status = StudentOperations.deleteStudent(srno);
			
				if(status)
				{
					JOptionPane.showMessageDialog(null, "Record is Deleted for Roll Number :" + srno);
					tfRno.setText("");
					tfName.setText("");
					tfPer.setText("");
					tfRno.requestFocus();
					//bClear.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Unable to Delete Record for Roll Number :" + srno);
				}
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null," Invalid Input !!!");
			}
			
		}
		
		
	}
}

