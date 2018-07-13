package admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//import com.mysql.jdbc.ResultSet;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class Studentreg implements ActionListener{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	JButton btnNewButton,btnNewButton_1,btnNewButton_2,btnNewButton_3;
	JComboBox comboBox,comboBox_1;
	JDateChooser dob;
	static Connection conn;
	static PreparedStatement pst,pst1;
	 static java.sql.ResultSet rs;
	public static void main(String[] args) throws ClassNotFoundException,SQLException
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Studentreg window = new Studentreg();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Class.forName("com.mysql.jdbc.Driver");		
		 conn=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/student","root","");
		 pst1=conn.prepareStatement("select * from registration");	
		 rs=pst1.executeQuery();
	
	}
	public Studentreg() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("STUDENT REGISTRATION PAGE");
		frame.getContentPane().setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		frame.getContentPane().setForeground(Color.GREEN);
		frame.setBounds(100, 100, 701, 481);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("STUDENT REGISTRATION FORM");
		lblNewLabel.setForeground(new Color(0, 51, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(150, 11, 435, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("STUDENT ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setForeground(SystemColor.textInactiveText);
		lblNewLabel_1.setBounds(10, 56, 111, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(128, 58, 162, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("STUDENT NAME");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setForeground(SystemColor.windowBorder);
		lblNewLabel_2.setBounds(12, 98, 106, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(128, 92, 162, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("STUDENT EMAIL");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setForeground(SystemColor.windowBorder);
		lblNewLabel_6.setBounds(10, 248, 106, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		textField_3 = new JTextField();
		textField_3.setBounds(128, 245, 162, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("PASSWORD");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setForeground(SystemColor.windowBorder);
		lblNewLabel_7.setBounds(10, 279, 134, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		textField_4 = new JTextField();
		textField_4.setBounds(128, 276, 162, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("MOB NO.");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_8.setForeground(SystemColor.windowBorder);
		lblNewLabel_8.setBounds(10, 310, 66, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		textField_5 = new JTextField();
		textField_5.setBounds(128, 307, 162, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		btnNewButton = new JButton("FIRST");
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setForeground(Color.BLUE);		
		btnNewButton.setBounds(75, 353, 89, 23);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		btnNewButton_1 = new JButton("NEXT");		
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setBounds(226, 353, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(this);
		
		btnNewButton_2 = new JButton("PREVIOUS");
		btnNewButton_2.setBackground(Color.CYAN);
		btnNewButton_2.setForeground(Color.BLUE);
		btnNewButton_2.setBounds(352, 353, 118, 23);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(this);
		
		btnNewButton_3 = new JButton("LAST");		
		btnNewButton_3.setBackground(Color.CYAN);
		btnNewButton_3.setForeground(Color.BLUE);
		btnNewButton_3.setBounds(510, 353, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		btnNewButton_3.addActionListener(this);
		
		JButton btnNewButton_4 = new JButton("SUBMIT");
		btnNewButton_4.setBackground(Color.CYAN);
		btnNewButton_4.setForeground(Color.BLUE);
		btnNewButton_4.setBounds(85, 391, 89, 40);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("UPDATE");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try 
				{
					pst=conn.prepareStatement("update registration set STUDENTNAME=?,COURSES=?,BRANCH=?,STUDENTEMAIL=?,STUDENTPASSWORD=?,MOBNO=?,dob=? where STUDENTID=?");
					pst.setInt(8,Integer.parseInt(textField.getText()));
					pst.setString(1, textField_1.getText());
					String s=comboBox.getSelectedItem().toString();
					pst.setString(2, s);
					String s1=comboBox_1.getSelectedItem().toString();
					pst.setString(3, s1);
					pst.setString(4, textField_3.getText());
					pst.setString(5, textField_4.getText());
				   pst.setInt(6, Integer.parseInt(textField_5.getText()));
				   pst.setString(7,((JTextField)dob.getDateEditor().getUiComponent()).getText());
				   pst.executeUpdate();
				   JOptionPane.showMessageDialog(null, "Successfully Updated...");
				} 
				catch (SQLException e) 
				{
					System.out.println(e);
				}
			}
		});
		btnNewButton_5.setBackground(Color.CYAN);
		btnNewButton_5.setForeground(Color.BLUE);
		btnNewButton_5.setBounds(226, 392, 89, 39);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("DELETE");
		btnNewButton_6.setBackground(Color.CYAN);
		btnNewButton_6.setForeground(Color.BLUE);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_6){
					try{
						Class.forName("com.mysql.jdbc.Driver");  
						Connection conn=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/student","root","");
						pst=conn.prepareStatement("delete from registration where STUDENTID=?");
						pst.setInt(1,Integer.parseInt(textField.getText()));
						
					   pst.executeUpdate();
					   JOptionPane.showMessageDialog(null, "Data successfully deleted");
					}
					catch(Exception e1){
						System.out.println(e1);
					}
					
					}
			
					}
				
			
		});
		btnNewButton_6.setBounds(370, 392, 85, 39);
		frame.getContentPane().add(btnNewButton_6);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"BTECH", "MBA", "MCA", "BPHARMA"}));
		comboBox.setBounds(128, 182, 162, 20);
		frame.getContentPane().add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"CSE ", "ME", "CE", "IT", "EC", "EEE"}));
		comboBox_1.setBounds(128, 213, 162, 20);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_4 = new JLabel("COURSES");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setForeground(SystemColor.windowBorder);
		lblNewLabel_4.setBounds(12, 185, 85, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblBranch = new JLabel("BRANCH");
		lblBranch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBranch.setForeground(SystemColor.windowBorder);
		lblBranch.setBounds(10, 216, 80, 14);
		frame.getContentPane().add(lblBranch);
		
		dob = new JDateChooser();
		dob.setDateFormatString("yyyy-MM-dd");
		dob.setBounds(128, 138, 162, 20);
		frame.getContentPane().add(dob);
		
		JLabel lblDate = new JLabel("DATE OF BIRTH");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDate.setForeground(SystemColor.windowBorder);
		lblDate.setBounds(14, 144, 107, 14);
		frame.getContentPane().add(lblDate);
		
		JButton btnNewButton_7 = new JButton("FIND");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try 
				{
					pst=conn.prepareStatement("select * from registration where STUDENTID=?");
					pst.setInt(1, Integer.parseInt(textField.getText()));
					rs=pst.executeQuery();
					rs.next();
					String a=rs.getString(1);
					String b=rs.getString(2);
					String c=rs.getString(4);
					String e9=rs.getString(5);
					String f=rs.getString(6);
					String g=rs.getString(7);
					String co=rs.getString(3);
					Date d=rs.getDate(8);
					textField.setText(a);
					textField_1.setText(b);
					textField_3.setText(e9);
					textField_4.setText(f);
					textField_5.setText(g);
					comboBox_1.setSelectedItem(c);
					comboBox.setSelectedItem(co);
					dob.setDate(d);
				} 
				catch (SQLException e) 
				{
					System.out.println(e);
				}
			}
		});
		btnNewButton_7.setBackground(Color.CYAN);
		btnNewButton_7.setForeground(Color.BLUE);
		btnNewButton_7.setBounds(519, 392, 80, 39);
		frame.getContentPane().add(btnNewButton_7);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_4){
				
					try{
						Class.forName("com.mysql.jdbc.Driver");  
						Connection conn=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/student","root","");
						pst=conn.prepareStatement("insert into registration(STUDENTID,STUDENTNAME,COURSES,BRANCH,STUDENTEMAIL,STUDENTPASSWORD,MOBNO,dob) values(?,?,?,?,?,?,?,?)");
						pst.setInt(1,Integer.parseInt(textField.getText()));
						pst.setString(2, textField_1.getText());
						String s=comboBox.getSelectedItem().toString();
						pst.setString(3, s);
						String s1=comboBox_1.getSelectedItem().toString();
						pst.setString(4, s1);
						pst.setString(5, textField_3.getText());
						pst.setString(6, textField_4.getText());
					   pst.setInt(7, Integer.parseInt(textField_5.getText()));
					   pst.setString(8,((JTextField)dob.getDateEditor().getUiComponent()).getText());
					   pst.executeUpdate();
					   JOptionPane.showMessageDialog(null, "Data successfully inserted");
					}  catch(NumberFormatException e3){
						   System.out.println(e3);
					}
					catch(Exception e1){
						System.out.println(e1);
					}
					
					}
			}

			/*private Date getCurrentDate() {
				// TODO Auto-generated method stub
				return null;
			}*/
		});
		
	}
@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object o=e.getSource();
		if(o==btnNewButton)
		{
			try
			{			
				rs.first();		
				String a=rs.getString(1);
						String b=rs.getString(2);
						String c=rs.getString(4);
						String e9=rs.getString(5);
						String f=rs.getString(6);
						String g=rs.getString(7);
						String co=rs.getString(3);
						Date d=rs.getDate(8);
						textField.setText(a);
						textField_1.setText(b);
						textField_3.setText(e9);
						textField_4.setText(f);
						textField_5.setText(g);
						comboBox_1.setSelectedItem(c);
						comboBox.setSelectedItem(co);
						dob.setDate(d);
			}						
			catch(Exception e7)
			{
					System.out.println(e7);
			}
		}
		else if(o==btnNewButton_1)
		{			
			try
			{	
				if(rs.next())
				{		
						String a=rs.getString(1);
						String b=rs.getString(2);
						String c=rs.getString(4);
						String e9=rs.getString(5);
						String f=rs.getString(6);
						String g=rs.getString(7);
						String co=rs.getString(3);
						Date d=rs.getDate(8);
						textField.setText(a);
						textField_1.setText(b);
						textField_3.setText(e9);
						textField_4.setText(f);
						textField_5.setText(g);
						comboBox_1.setSelectedItem(c);
						comboBox.setSelectedItem(co);
						dob.setDate(d);
				}
				else
				{
					rs.previous();
					JOptionPane.showMessageDialog(null, "End of Record....");
				}
					
			}	
			catch(Exception e7)
			{
					System.out.println(e7);
			}
		}
		else if(o==btnNewButton_2)
		{
			try
			{			
				if(rs.previous())
				{	
				String a=rs.getString(1);
						String b=rs.getString(2);
						String c=rs.getString(4);
						String e9=rs.getString(5);
						String f=rs.getString(6);
						String g=rs.getString(7);
						String co=rs.getString(3);
						Date d=rs.getDate(8);
						textField.setText(a);
						textField_1.setText(b);
						textField_3.setText(e9);
						textField_4.setText(f);
						textField_5.setText(g);
						comboBox_1.setSelectedItem(c);
						comboBox.setSelectedItem(co);
						dob.setDate(d);
				}
				else
				{
					rs.next();
					JOptionPane.showMessageDialog(null, "End of Record....");
				}
					
			}						
			catch(Exception e7)
			{
					System.out.println(e7);
			}
		}
		else if(o==btnNewButton_3)
		{
			try
			{			
				rs.last();		
				String a=rs.getString(1);
						String b=rs.getString(2);
						String c=rs.getString(4);
						String e9=rs.getString(5);
						String f=rs.getString(6);
						String g=rs.getString(7);
						String co=rs.getString(3);
						Date d=rs.getDate(8);
						textField.setText(a);
						textField_1.setText(b);
						textField_3.setText(e9);
						textField_4.setText(f);
						textField_5.setText(g);
						comboBox_1.setSelectedItem(c);
						comboBox.setSelectedItem(co);
						dob.setDate(d);
			}						
			catch(Exception e7)
			{
					System.out.println(e7);
			}
		}
		
	}
}
	