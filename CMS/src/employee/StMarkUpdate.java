package employee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class StMarkUpdate {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	static Connection con;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public StMarkUpdate() {
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
		frame.setBounds(100, 100, 735, 399);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblStudentMarks = new JLabel("                     Student Marks");
		lblStudentMarks.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblStudentMarks.setBounds(88, 11, 504, 38);
		frame.getContentPane().add(lblStudentMarks);
		
		JLabel lblStudentId = new JLabel("Student id");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblStudentId.setBounds(123, 112, 130, 23);
		frame.getContentPane().add(lblStudentId);
		
		JLabel lblChooseSubject = new JLabel("Choose Subject");
		lblChooseSubject.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblChooseSubject.setBounds(123, 172, 130, 23);
		frame.getContentPane().add(lblChooseSubject);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"OS", "DBMS", "DAA"}));
		comboBox_1.setBounds(290, 175, 148, 20);
		frame.getContentPane().add(comboBox_1);
		
		textField = new JTextField();
		textField.setBounds(290, 116, 148, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(288, 234, 150, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEnterNewMarks = new JLabel("Enter New Marks");
		lblEnterNewMarks.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnterNewMarks.setBounds(123, 231, 130, 23);
		frame.getContentPane().add(lblEnterNewMarks);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a=Integer.parseInt(textField.getText());
				String b=comboBox_1.getSelectedItem().toString();
				int c=Integer.parseInt(textField_1.getText());
				if(b.equals("Os"))
				{
					try {
						
						PreparedStatement ps=con.prepareStatement("update firstsemmarks set OS=? where sid=?");
						ps.setInt(1, c);
						ps.setInt(2, a);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null,"Record Updated");
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
				}
				else if(b.equals("DBMS"))
				{
					try {
						PreparedStatement ps=con.prepareStatement("update firstsemmarks set DBMS=? where sid=?");
						ps.setInt(1, c);
						ps.setInt(2, a);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null,"Record Updated");
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
					
				}
				else if(b.equals("DAA"))
				{
					try {
						PreparedStatement ps=con.prepareStatement("update firstsemmarks set DAA=? where sid=?");
						ps.setInt(1, c);
						ps.setInt(2, a);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null,"Record Updated");
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.setBounds(288, 286, 89, 23);
		frame.getContentPane().add(btnUpdate);
	}
}
