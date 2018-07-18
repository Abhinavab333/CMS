package student;
import java.awt.EventQueue;
import faculty.*;
import employee.*;
import admin.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.SystemColor;
public  class Login {
	static int sid;
public static int eid;
	private JFrame frame;
	private JTextField textField;
	private JPasswordField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaptionBorder);
		frame.setForeground(SystemColor.activeCaption);
		frame.getContentPane().setForeground(SystemColor.windowBorder);
		frame.setBounds(100, 100, 647, 443);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JLabel lblCms = new JLabel("       CMS ");
		lblCms.setForeground(new Color(0, 128, 128));
		lblCms.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
		lblCms.setBounds(185, 0, 244, 40);
		frame.getContentPane().add(lblCms);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Abhinav\\Desktop\\administrator-icon.png"));
		label.setBounds(234, 62, 161, 107);
		frame.getContentPane().add(label);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserId.setBounds(166, 200, 65, 14);
		frame.getContentPane().add(lblUserId);
		
		textField = new JTextField();
		textField.setBounds(254, 197, 154, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(163, 246, 68, 14);
		frame.getContentPane().add(lblPassword);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(254, 243, 154, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		JButton btnLogin = new JButton("Student Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/cms";

			Connection con=DriverManager.getConnection(url,"root","");
			//System.out.println("abc");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select *from studentdb");
			String b=textField.getText();
			 String a=textField_1.getText();
			 sid=Integer.parseInt(b);
			while(rs.next()) {
				if(b.equals(rs.getString("STUDENTID"))&&a.equals(rs.getString("STUDENTPASSWORD"))) {
					new Home();
				}
				
				
			}

				
					
				}	
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Invalid Input");
				}
			}
		});
		btnLogin.setBounds(10, 301, 140, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnEmployeeLogin = new JButton("Faculty Login");
		btnEmployeeLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{					
					Class.forName("com.mysql.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/cms";
			Connection con=DriverManager.getConnection(url,"root","");
						
			String b=textField.getText();
			 String a=textField_1.getText();
			int eid=Integer.parseInt(b);
			PreparedStatement pst=con.prepareStatement("select * from employee where EmpId=?");
			pst.setInt(1, eid);
			ResultSet rs=pst.executeQuery();
			
			if(rs.next())
			{
				if(a.equals(rs.getString(4))) 
				{
					new FacultyHome();
				}
				else
				{
					
					JOptionPane.showMessageDialog(null, "Invalid Password");
				}
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Invalid User Id");
			}

				
					
				}	
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Invalid Input");
					//System.out.println(e);
				}
			}
				
			
		});
		btnEmployeeLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEmployeeLogin.setBounds(166, 301, 157, 23);
		frame.getContentPane().add(btnEmployeeLogin);
		
		JButton btnAdminLogin = new JButton("Admin Login");
		btnAdminLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().equals("admin")&&textField_1.getText().equals("admin@123"))
				{
					new AdminHome();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Wrong Login Credentials");
				}
			}
		
		});
		btnAdminLogin.setBounds(493, 301, 128, 23);
		frame.getContentPane().add(btnAdminLogin);
		
		JButton btnEmployeeLogin_1 = new JButton("Employee Login");
		btnEmployeeLogin_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{					
					Class.forName("com.mysql.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/cms";
			Connection con=DriverManager.getConnection(url,"root","");
						
			String b=textField.getText();
			 String a=textField_1.getText();
		  eid=Integer.parseInt(b);
			PreparedStatement pst=con.prepareStatement("select * from employee where EmpId=?");
			pst.setInt(1, eid);
			ResultSet rs=pst.executeQuery();
			
			if(rs.next())
			{
				if(a.equals(rs.getString(4))) 
				{
					new EmployeeHome();
				}
				else
				{
					
					JOptionPane.showMessageDialog(null, "Invalid Password");
				}
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Invalid User Id");
			}

				
					
				}	
				catch(Exception ee) {
					JOptionPane.showMessageDialog(null, "Invalid Input");
					//System.out.println(e);
				}
			}
		});
		btnEmployeeLogin_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEmployeeLogin_1.setBounds(333, 301, 150, 23);
		frame.getContentPane().add(btnEmployeeLogin_1);
	}
	public void seeProfile(String b) {
		
	}
}
