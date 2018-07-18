package employee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;

import student.Login;
import student.Profile;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

import student.*;
public class EmployeeHome {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public EmployeeHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 774, 395);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JLabel lblEmployeeHome = new JLabel("              Employee Home");
		lblEmployeeHome.setFont(new Font("Sitka Subheading", Font.BOLD, 28));
		lblEmployeeHome.setBounds(174, 0, 447, 42);
		frame.getContentPane().add(lblEmployeeHome);
		
		JButton btnNewButton_1 = new JButton("MyProfile");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Profile1();
				
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/cms";

			Connection con=DriverManager.getConnection(url,"root","");
			//System.out.println("abc");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select *from employee where EmpId='"+Login.eid+"'");
			
			while(rs.next()) {
				
				Profile1.label_1.setText(rs.getString("EmpName"));
				Profile1.label_2.setText(rs.getString("Email"));
				Profile1.label_3.setText(rs.getString("DOJ"));
				Profile1.label_4.setText(rs.getString("Mob"));
				
				
			}

				
					
				}	
				catch(Exception a) {
					System.out.println(a);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(275, 150, 161, 34);
		frame.getContentPane().add(btnNewButton_1);
	}
}
