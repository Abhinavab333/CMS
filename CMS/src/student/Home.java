package student;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.sql.*;
import admin.*;
import java.awt.Font;
import java.awt.Color;
public class Home {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		frame.setBounds(100, 100, 702, 372);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JButton btnProfile = new JButton("Profile");
		btnProfile.setBackground(new Color(192, 192, 192));
		btnProfile.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Profile();
			
					try{
						Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/cms";

				Connection con=DriverManager.getConnection(url,"root","");
				//System.out.println("abc");
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select *from studentdb where sid='"+Login.sid+"'");
				
				while(rs.next()) {
					
					Profile.lable_1.setText(rs.getString("sname"));
					Profile.label_2.setText(rs.getString("scourse"));
					Profile.label_3.setText(rs.getString("sbranch"));
					Profile.label_4.setText(rs.getString("semail"));
					Profile.label_5.setText(rs.getString("sphone"));
					
				}

					
						
					}	
					catch(Exception e) {
						System.out.println(e);
					}
			}
		});
		btnProfile.setBounds(90, 77, 174, 49);
		frame.getContentPane().add(btnProfile);
		
		JButton btnAttendence = new JButton("Attendence");
		btnAttendence.setBackground(new Color(192, 192, 192));
		btnAttendence.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAttendence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Table();
			}
		});
		btnAttendence.setBounds(366, 79, 174, 47);
		frame.getContentPane().add(btnAttendence);
		
		JButton btnNewButton = new JButton("Semester Marks");
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Marks();
			}
		});
		btnNewButton.setBounds(90, 197, 184, 49);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnFeeStructure = new JButton("Fee Structure");
		btnFeeStructure.setBackground(new Color(192, 192, 192));
		btnFeeStructure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FeeStructure();
			}
		});
		btnFeeStructure.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnFeeStructure.setBounds(372, 197, 168, 49);
		frame.getContentPane().add(btnFeeStructure);
	}
}
