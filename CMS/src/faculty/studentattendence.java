package faculty;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class studentattendence {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public studentattendence() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.setBounds(100, 100, 711, 356);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"DBMS", "OS", "DAA"}));
		comboBox.setBounds(350, 83, 102, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setForeground(new Color(0, 0, 0));
		lblSubject.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSubject.setBounds(219, 83, 71, 17);
		frame.getContentPane().add(lblSubject);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Absent", "Present"}));
		comboBox_1.setBounds(350, 124, 102, 20);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblAttendance = new JLabel("Attendance");
		lblAttendance.setForeground(new Color(0, 0, 0));
		lblAttendance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAttendance.setBounds(219, 124, 102, 20);
		frame.getContentPane().add(lblAttendance);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((comboBox.getSelectedItem().toString()).equals("DBMS"))
				{
					if((comboBox_1.getSelectedItem().toString()).equals("Absent"))
							{
						try {
						Class.forName("com.mysql.jdbc.Driver");
						String url="jdbc:mysql://localhost:3306/oes";

						Connection con=DriverManager.getConnection(url,"root","");
						
						Statement stmt=con.createStatement();
					
						ResultSet rs=stmt.executeQuery("select * from attendence where subject='DBMS' ");
						while(rs.next())
						{
							int a=rs.getInt("absent");
							int b=rs.getInt("lectures");
							b++;
							int c=rs.getInt("present");
							double d=(c*100)/b;
							a++;

							Statement stmt1=con.createStatement();
							stmt1.executeUpdate("update attendence set absent='"+a+"',percentage='"+d+"',lectures='"+b+"' where subject='DBMS'" );
							JOptionPane.showMessageDialog(null, "Record Updated", "Information", JOptionPane.INFORMATION_MESSAGE);
						}
					
						
						con.close();
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
				}
					else if((comboBox_1.getSelectedItem().toString()).equals("Present"))
					{
						try {
							Class.forName("com.mysql.jdbc.Driver");
							String url="jdbc:mysql://localhost:3306/oes";

							Connection con=DriverManager.getConnection(url,"root","");
							
							Statement stmt=con.createStatement();
						
							ResultSet rs=stmt.executeQuery("select * from attendence where subject='DBMS' ");
							while(rs.next())
							{
								int a=rs.getInt("absent");
								int b=rs.getInt("lectures");
								b++;
								int c=rs.getInt("present");
								c++;
								double d=(c*100)/b;
								a++;

								Statement stmt1=con.createStatement();
								stmt1.executeUpdate("update attendence set present='"+c+"',percentage='"+d+"',lectures='"+b+"' where subject='DBMS'" );
								JOptionPane.showMessageDialog(null, "Record Updated", "Information", JOptionPane.INFORMATION_MESSAGE);
							}
						
							
							con.close();
							}
							catch(Exception e)
							{
								System.out.println(e);
							}
					}
			}
				else if((comboBox.getSelectedItem().toString()).equals("OS"))
						{
				
						if((comboBox_1.getSelectedItem().toString()).equals("Absent"))
					{
							try {
							Class.forName("com.mysql.jdbc.Driver");
							String url="jdbc:mysql://localhost:3306/oes";

							Connection con=DriverManager.getConnection(url,"root","");
							
							Statement stmt=con.createStatement();
						
							ResultSet rs=stmt.executeQuery("select * from attendence where subject='OS' ");
							while(rs.next())
							{
								int a=rs.getInt("absent");
								int b=rs.getInt("lectures");
								b++;
								int c=rs.getInt("present");
								double d=(c*100)/b;
								a++;

								Statement stmt1=con.createStatement();
								stmt1.executeUpdate("update attendence set absent='"+a+"',percentage='"+d+"',lectures='"+b+"' where subject='OS'" );
								JOptionPane.showMessageDialog(null, "Record Updated", "Information", JOptionPane.INFORMATION_MESSAGE);
							}
						
							
							con.close();
							}
							catch(Exception e)
							{
								System.out.println(e);
							}
					}
						else if((comboBox_1.getSelectedItem().toString()).equals("Present"))
						{
							try {
								Class.forName("com.mysql.jdbc.Driver");
								String url="jdbc:mysql://localhost:3306/oes";

								Connection con=DriverManager.getConnection(url,"root","");
								
								Statement stmt=con.createStatement();
							
								ResultSet rs=stmt.executeQuery("select * from attendence where subject='OS' ");
								while(rs.next())
								{
									int a=rs.getInt("absent");
									int b=rs.getInt("lectures");
									b++;
									int c=rs.getInt("present");
									c++;
									double d=(c*100)/b;
									a++;

									Statement stmt1=con.createStatement();
									stmt1.executeUpdate("update attendence set present='"+c+"',percentage='"+d+"',lectures='"+b+"' where subject='OS'" );
									JOptionPane.showMessageDialog(null, "Record Updated", "Information", JOptionPane.INFORMATION_MESSAGE);
								}
							
								
								con.close();
								}
								catch(Exception e)
								{
									System.out.println(e);
								}
						}
				}
				else if((comboBox.getSelectedItem().toString()).equals("DAA"))
				{
		
				if((comboBox_1.getSelectedItem().toString()).equals("Absent"))
			{
					try {
					Class.forName("com.mysql.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/oes";

					Connection con=DriverManager.getConnection(url,"root","");
					
					Statement stmt=con.createStatement();
				
					ResultSet rs=stmt.executeQuery("select * from attendence where subject='DAA' ");
					while(rs.next())
					{
						int a=rs.getInt("absent");
						int b=rs.getInt("lectures");
						b++;
						int c=rs.getInt("present");
						double d=(c*100)/b;
						a++;

						Statement stmt1=con.createStatement();
						stmt1.executeUpdate("update attendence set absent='"+a+"',percentage='"+d+"',lectures='"+b+"' where subject='DAA'" );
						JOptionPane.showMessageDialog(null, "Record Updated", "Information", JOptionPane.INFORMATION_MESSAGE);
					}
				
					
					con.close();
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
			}
				else if((comboBox_1.getSelectedItem().toString()).equals("Present"))
				{
					try {
						Class.forName("com.mysql.jdbc.Driver");
						String url="jdbc:mysql://localhost:3306/oes";

						Connection con=DriverManager.getConnection(url,"root","");
						
						Statement stmt=con.createStatement();
					
						ResultSet rs=stmt.executeQuery("select * from attendence where subject='DAA' ");
						while(rs.next())
						{
							int a=rs.getInt("absent");
							int b=rs.getInt("lectures");
							b++;
							int c=rs.getInt("present");
							c++;
							double d=(c*100)/b;
							a++;

							Statement stmt1=con.createStatement();
							stmt1.executeUpdate("update attendence set present='"+c+"',percentage='"+d+"',lectures='"+b+"' where subject='DAA'" );
							JOptionPane.showMessageDialog(null, "Record Updated", "Information", JOptionPane.INFORMATION_MESSAGE);
						}
					
						
						con.close();
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
				}
		}

						
				
			}
		});
		btnSubmit.setForeground(new Color(51, 102, 153));
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSubmit.setBounds(282, 184, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblStudentAttendance = new JLabel("Student Attendance");
		lblStudentAttendance.setForeground(new Color(0, 0, 0));
		lblStudentAttendance.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblStudentAttendance.setBounds(231, 25, 251, 33);
		frame.getContentPane().add(lblStudentAttendance);
	}

}
