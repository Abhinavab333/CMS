
package admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;

public class Employee implements ActionListener 
{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	static Connection conn;
	static PreparedStatement pst,pst1;
	static ResultSet rs;
	
	JButton btnFirst,btnPrevious,btnNext,btnLast;
	

	/**
	 * Create the application.
	 */
	public Employee() throws ClassNotFoundException,SQLException
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws ClassNotFoundException,SQLException 
	{
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/cms";
			conn=DriverManager.getConnection(url, "root", "");
			//JOptionPane.showMessageDialog(null, "Connect");
			pst1=conn.prepareStatement("select * from employee",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=pst1.executeQuery();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.setBounds(0, 0, 918, 701);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblEmployeeRegistrationForm = new JLabel("Employee Registration Form");
		lblEmployeeRegistrationForm.setBackground(new Color(0, 255, 0));
		lblEmployeeRegistrationForm.setFont(new Font("Lucida Handwriting", Font.PLAIN, 40));
		lblEmployeeRegistrationForm.setBounds(120, 23, 664, 62);
		frame.getContentPane().add(lblEmployeeRegistrationForm);
		
		JLabel lblNewLabel = new JLabel("Employee Id");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(194, 130, 130, 20);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(446, 126, 221, 32);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNmae = new JLabel("Name");
		lblNmae.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNmae.setBounds(194, 196, 73, 20);
		frame.getContentPane().add(lblNmae);
		
		textField_1 = new JTextField();
		textField_1.setBounds(446, 190, 221, 32);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(80, 282, 56, -17);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblEmail_1 = new JLabel("Email");
		lblEmail_1.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblEmail_1.setBounds(194, 257, 73, 27);
		frame.getContentPane().add(lblEmail_1);
		
		textField_2 = new JTextField();
		textField_2.setText("");
		textField_2.setBounds(446, 258, 221, 34);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPassword.setBounds(194, 319, 130, 26);
		frame.getContentPane().add(lblPassword);
		
		textField_3 = new JPasswordField();
		textField_3.setBounds(446, 320, 221, 32);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblDateOfJoining = new JLabel("Date of Joining");
		lblDateOfJoining.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblDateOfJoining.setBounds(194, 371, 165, 32);
		frame.getContentPane().add(lblDateOfJoining);
		
		textField_4 = new JTextField();
		textField_4.setBounds(446, 375, 221, 32);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblPhoneNo = new JLabel("Phone No");
		lblPhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPhoneNo.setBounds(194, 433, 117, 32);
		frame.getContentPane().add(lblPhoneNo);
		
		textField_5 = new JTextField();
		textField_5.setBounds(446, 437, 221, 32);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		btnFirst = new JButton("First");
		btnFirst.addActionListener(this);
		btnFirst.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFirst.setBounds(120, 530, 97, 25);
		frame.getContentPane().add(btnFirst);
		
		btnPrevious = new JButton("Previous");
		btnPrevious.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPrevious.setBounds(299, 530, 123, 25);
		btnPrevious.addActionListener(this);
		frame.getContentPane().add(btnPrevious);
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(this);
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNext.setBounds(484, 530, 112, 25);
		frame.getContentPane().add(btnNext);
		
		btnLast = new JButton("Last");
		btnLast.addActionListener(this);
		btnLast.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLast.setBounds(667, 530, 97, 25);
		frame.getContentPane().add(btnLast);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(SystemColor.activeCaption);
		btnSubmit.setForeground(SystemColor.activeCaptionText);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try {					
					pst=conn.prepareStatement("insert into Employee values(?,?,?,?,?,?)");
					pst.setInt(1, Integer.parseInt(textField.getText()));
					pst.setString(2, textField_1.getText());
					pst.setString(3, textField_2.getText());
					pst.setString(4, textField_3.getText());
					pst.setString(5, textField_4.getText());
					pst.setInt(6, Integer.parseInt(textField_5.getText()));
					final String EMAIL_PATTERN = 
						    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
					String email=textField_2.getText();
					  if(!textField_1.getText().matches("[A-Z][a-zA-Z]*")) {
						   JOptionPane.showMessageDialog(null,"Please enter name in name format only");
					   }
					  else if (!email.matches(EMAIL_PATTERN)) 
						{
							JOptionPane.showMessageDialog(null, "Please Enter Valid Email ID");							
						}
						else
						{
							pst.executeUpdate();
							JOptionPane.showMessageDialog(null, "Successfully inserted");
						}
					
				} catch (SQLException e1) {
					System.out.println(e1);
				}
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnSubmit.setBounds(127, 610, 123, 36);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					pst=conn.prepareStatement("update employee set EmpName=?,Email=?,Password=?,DOJ=?,Mob=? where EmpId=?");
					pst.setString(1, textField_1.getText());
					pst.setString(2, textField_2.getText());
					pst.setString(3, textField_3.getText());
					pst.setString(4, textField_4.getText());
					pst.setInt(5, Integer.parseInt(textField_5.getText()));
					pst.setInt(6, Integer.parseInt(textField.getText()));
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Successfully Updated....");
				} 
				catch (SQLException e1) 
				{
					System.out.println(e1);
				}
			}
		});
		btnUpdate.setBackground(SystemColor.activeCaption);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnUpdate.setBounds(318, 611, 112, 34);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(SystemColor.activeCaption);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try 
				{
					pst=conn.prepareStatement("Delete from employee where EmpID=?");
					pst.setInt(1, Integer.parseInt(textField.getText()));
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Your Data is Successfully Deleted..");
				} 
				catch (SQLException e1) 
				{
					System.out.println(e1);
					
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnDelete.setBounds(508, 610, 123, 36);
		frame.getContentPane().add(btnDelete);
		
		JButton btnNewButton = new JButton("Find\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					pst=conn.prepareStatement("select * from employee where EmpId=?");
					pst.setInt(1, Integer.parseInt(textField.getText()));
					rs=pst.executeQuery();
					rs.next();
					textField_1.setText(rs.getString(2));
					textField_2.setText(rs.getString(3));
					textField_3.setText(rs.getString(4));
					textField_4.setText(rs.getString(5));
					textField_5.setText(rs.getString(6));
				}
				catch (SQLException e1) 
				{
					JOptionPane.showMessageDialog(null, "Id Not Found");
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(667, 610, 117, 36);
		frame.getContentPane().add(btnNewButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object o=e.getSource();

		if(o==btnFirst)
		{
			try 
			{
				rs.first();
				textField.setText(rs.getString(1));
				textField_1.setText(rs.getString(2));
				textField_2.setText(rs.getString(3));
				textField_3.setText(rs.getString(4));
				textField_4.setText(rs.getString(5));
				textField_5.setText(rs.getString(6));
			}
			catch (SQLException e1) 
			{
				System.out.println(e1);
			}
		}
		else if(o==btnPrevious)
		{
			try 
			{
				if(rs.previous())
				{
				textField.setText(rs.getString(1));
				textField_1.setText(rs.getString(2));
				textField_2.setText(rs.getString(3));
				textField_3.setText(rs.getString(4));
				textField_4.setText(rs.getString(5));
				textField_5.setText(rs.getString(6));
				}
				else
				{
					rs.next();
					JOptionPane.showMessageDialog(null, "End of Record....");							
				}
			}
			catch (SQLException e1) 
			{
				System.out.println(e1);
			}
		}
		else if(o==btnNext)
		{
			try 
			{
				if(rs.next())
				{				
				textField.setText(rs.getString(1));
				textField_1.setText(rs.getString(2));
				textField_2.setText(rs.getString(3));
				textField_3.setText(rs.getString(4));
				textField_4.setText(rs.getString(5));
				textField_5.setText(rs.getString(6));
				}
				else
				{
					rs.previous();
					JOptionPane.showMessageDialog(null, "End of Record......");
				}
			}
			catch (SQLException e1) 
			{
				System.out.println(e1);
			}
		}
		else if(o==btnLast)
		{
			try 
			{
				rs.last();
				textField.setText(rs.getString(1));
				textField_1.setText(rs.getString(2));
				textField_2.setText(rs.getString(3));
				textField_3.setText(rs.getString(4));
				textField_4.setText(rs.getString(5));
				textField_5.setText(rs.getString(6));
			}
			catch (SQLException e1) 
			{
				System.out.println(e1);
			}				
		}
		
	}
}


