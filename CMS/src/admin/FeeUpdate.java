package admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FeeUpdate {

	private JFrame frame;
	private JTextField textField;
	static Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FeeUpdate window = new FeeUpdate();
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
	public FeeUpdate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/cms";
			con=DriverManager.getConnection(url, "root", "");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.setBounds(100, 100, 734, 458);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblFeeUpdate = new JLabel("                Fee Update");
		lblFeeUpdate.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblFeeUpdate.setBounds(182, 11, 446, 37);
		frame.getContentPane().add(lblFeeUpdate);
		
		JLabel lblSelectCourse = new JLabel("Select Course");
		lblSelectCourse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSelectCourse.setBounds(160, 99, 133, 29);
		frame.getContentPane().add(lblSelectCourse);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"B.Tech", "B.Pharma", "M.B.A"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setBounds(309, 105, 151, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblSelectYear = new JLabel("Select Year");
		lblSelectYear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSelectYear.setBounds(160, 183, 133, 20);
		frame.getContentPane().add(lblSelectYear);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"First Year", "Second Year"}));
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox_1.setBounds(309, 185, 151, 20);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblNewAmount = new JLabel("New Amount");
		lblNewAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewAmount.setBounds(160, 255, 133, 20);
		frame.getContentPane().add(lblNewAmount);
		
		textField = new JTextField();
		textField.setBounds(308, 257, 152, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((comboBox.getSelectedItem().toString()).equals("B.Tech"))
						{
							if((comboBox_1.getSelectedItem().toString()).equals("First Year"))
									{
										
											try {
												
												//String input1=comboBox.getSelectedItem().toString();
												String input2=comboBox_1.getSelectedItem().toString();
												String input3=textField.getText();
												int newamount=Integer.parseInt(input3);
												
												
												Statement stmt=con.createStatement();
												String sql="update fee set btech=? where Year=?";
												//stmt.executeUpdate("update fee set btech='"+newamount+"' where Year='"+input2+"'");
												
												PreparedStatement ps=con.prepareStatement(sql);
												ps.setInt(1, newamount);
												
												ps.setString(2, input2);
												ps.executeUpdate();
												JOptionPane.showMessageDialog(null, "Record Updated");
												con.close();
																								
												}
												catch(Exception e)
												{
													System.out.println(e);
												}
											
									}
							if((comboBox_1.getSelectedItem().toString()).equals("Second Year"))
							{
								
									try {
										
										//String input1=comboBox.getSelectedItem().toString();
										String input2=comboBox_1.getSelectedItem().toString();
										String input3=textField.getText();
										int newamount=Integer.parseInt(input3);
										
										
										Statement stmt=con.createStatement();
										String sql="update fee set btech=? where Year=?";
										//stmt.executeUpdate("update fee set btech='"+newamount+"' where Year='"+input2+"'");
										
										PreparedStatement ps=con.prepareStatement(sql);
										ps.setInt(1, newamount);
										
										ps.setString(2, input2);
										ps.executeUpdate();
										JOptionPane.showMessageDialog(null, "Record Updated");
										con.close();
																						
										}
										catch(Exception e)
										{
											System.out.println(e);
										}
									
							}

						}
				else if((comboBox.getSelectedItem().toString()).equals("B.Pharma"))
				{
					if((comboBox_1.getSelectedItem().toString()).equals("First Year"))
							{
								
									try {
										
										//String input1=comboBox.getSelectedItem().toString();
										String input2=comboBox_1.getSelectedItem().toString();
										String input3=textField.getText();
										int newamount=Integer.parseInt(input3);
										
										
										Statement stmt=con.createStatement();
										String sql="update fee set bpharma=? where Year=?";
										//stmt.executeUpdate("update fee set btech='"+newamount+"' where Year='"+input2+"'");
										
										PreparedStatement ps=con.prepareStatement(sql);
										ps.setInt(1, newamount);
										
										ps.setString(2, input2);
										ps.executeUpdate();
										JOptionPane.showMessageDialog(null, "Record Updated");
										con.close();
																						
										}
										catch(Exception e)
										{
											System.out.println(e);
										}
									
							}
					if((comboBox_1.getSelectedItem().toString()).equals("Second Year"))
					{
						
							try {
								
								//String input1=comboBox.getSelectedItem().toString();
								String input2=comboBox_1.getSelectedItem().toString();
								String input3=textField.getText();
								int newamount=Integer.parseInt(input3);
								
								
								Statement stmt=con.createStatement();
								String sql="update fee set bpharma=? where Year=?";
								//stmt.executeUpdate("update fee set btech='"+newamount+"' where Year='"+input2+"'");
								
								PreparedStatement ps=con.prepareStatement(sql);
								ps.setInt(1, newamount);
								
								ps.setString(2, input2);
								ps.executeUpdate();
								JOptionPane.showMessageDialog(null, "Record Updated");
								con.close();
																				
								}
								catch(Exception e)
								{
									System.out.println(e);
								}
							
					}

				}
				else if((comboBox.getSelectedItem().toString()).equals("M.B.A"))
				{
					if((comboBox_1.getSelectedItem().toString()).equals("First Year"))
							{
								
									try {
										
										//String input1=comboBox.getSelectedItem().toString();
										String input2=comboBox_1.getSelectedItem().toString();
										String input3=textField.getText();
										int newamount=Integer.parseInt(input3);
										
										
										Statement stmt=con.createStatement();
										String sql="update fee set mba=? where Year=?";
										//stmt.executeUpdate("update fee set btech='"+newamount+"' where Year='"+input2+"'");
										
										PreparedStatement ps=con.prepareStatement(sql);
										ps.setInt(1, newamount);
										
										ps.setString(2, input2);
										ps.executeUpdate();
										JOptionPane.showMessageDialog(null, "Record Updated");
										con.close();
																						
										}
										catch(Exception e)
										{
											System.out.println(e);
										}
									
							}
					if((comboBox_1.getSelectedItem().toString()).equals("Second Year"))
					{
						
							try {
								
								//String input1=comboBox.getSelectedItem().toString();
								String input2=comboBox_1.getSelectedItem().toString();
								String input3=textField.getText();
								int newamount=Integer.parseInt(input3);
								
								
								Statement stmt=con.createStatement();
								String sql="update fee set mba=? where Year=?";
								//stmt.executeUpdate("update fee set btech='"+newamount+"' where Year='"+input2+"'");
								
								PreparedStatement ps=con.prepareStatement(sql);
								ps.setInt(1, newamount);
								
								ps.setString(2, input2);
								ps.executeUpdate();
								JOptionPane.showMessageDialog(null, "Record Updated");
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
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdate.setBounds(246, 323, 105, 23);
		frame.getContentPane().add(btnUpdate);
	}
}
