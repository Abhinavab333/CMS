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
		frame.setBounds(100, 100, 702, 372);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JButton btnProfile = new JButton("Profile");
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
		btnAttendence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Table();
			}
		});
		btnAttendence.setBounds(366, 79, 174, 47);
		frame.getContentPane().add(btnAttendence);
		
		JButton btnNewButton = new JButton("Semester Marks");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Marks();
			}
		});
		btnNewButton.setBounds(234, 194, 194, 56);
		frame.getContentPane().add(btnNewButton);
	}

}
