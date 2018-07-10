package admin;

import java.awt.EventQueue;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.sql.Date;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;
public class empattendence {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	static int a,b;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					empattendence window = new empattendence();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws ParseException 
	 */
	public empattendence() throws ParseException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ParseException 
	 */
	private void initialize()  {
		Connection con=null;
		java.util.Date date;
		java.sql.Date sqldate;
		frame = new JFrame();
		frame.setBounds(100, 100, 751, 538);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblEmployeeAttendence = new JLabel("        Employee Attendence");
		lblEmployeeAttendence.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEmployeeAttendence.setBounds(171, 11, 389, 51);
		frame.getContentPane().add(lblEmployeeAttendence);
		
		JLabel lblEnterEmployeeId = new JLabel("     Enter Employee Id");
		lblEnterEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterEmployeeId.setBounds(86, 109, 197, 26);
		frame.getContentPane().add(lblEnterEmployeeId);
		
		textField = new JTextField();
		textField.setBounds(309, 109, 197, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnEnter = new JButton("Enter");
		
		btnEnter.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEnter.setBounds(309, 159, 104, 26);
		frame.getContentPane().add(btnEnter);
		
		JLabel lblEmployeeName = new JLabel("Employee Name");
		lblEmployeeName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmployeeName.setBounds(51, 219, 113, 20);
		frame.getContentPane().add(lblEmployeeName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(208, 219, 142, 20);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPoneNumber = new JLabel("Pone Number");
		lblPoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPoneNumber.setBounds(382, 222, 89, 14);
		frame.getContentPane().add(lblPoneNumber);
		
		JLabel lblDateOfJoining = new JLabel("Date Of Joining");
		lblDateOfJoining.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDateOfJoining.setBounds(563, 221, 121, 17);
		frame.getContentPane().add(lblDateOfJoining);
		
		JLabel name = new JLabel("");
		name.setBounds(51, 259, 113, 14);
		frame.getContentPane().add(name);
		
		JLabel email = new JLabel("");
		email.setBounds(194, 259, 142, 26);
		frame.getContentPane().add(email);
		
		JLabel phone = new JLabel("");
		phone.setBounds(382, 259, 124, 26);
		frame.getContentPane().add(phone);
		
		JLabel doj = new JLabel("");
		doj.setBounds(563, 259, 121, 28);
		frame.getContentPane().add(doj);
		
		JLabel lblEnterDate = new JLabel("Enter Date");
		lblEnterDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterDate.setBounds(117, 350, 121, 20);
		frame.getContentPane().add(lblEnterDate);
		
		JLabel lblMarkAttendence = new JLabel("Mark Attendence");
		lblMarkAttendence.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMarkAttendence.setBounds(117, 381, 121, 26);
		frame.getContentPane().add(lblMarkAttendence);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Absent", "Present"}));
		comboBox.setBounds(309, 381, 197, 20);
		frame.getContentPane().add(comboBox);
		
		JButton btnSave = new JButton("Save");
	
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setBounds(172, 446, 89, 23);
		frame.getContentPane().add(btnSave);
		
		JLabel lblEmployeeId = new JLabel("Employee id");
		lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmployeeId.setBounds(117, 309, 104, 20);
		frame.getContentPane().add(lblEmployeeId);
		
		textField_1 = new JTextField();
		textField_1.setBounds(307, 311, 199, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JDateChooser dob = new JDateChooser();
		dob.setDateFormatString("yyyy-MM-dd");
		dob.setBounds(309, 350, 197, 20);
		frame.getContentPane().add(dob);
		
		JButton btnEdit = new JButton("Edit");
		
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEdit.setBounds(339, 446, 96, 23);
		frame.getContentPane().add(btnEdit);
		
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					try{
						Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/cms";

				Connection con=DriverManager.getConnection(url,"root","");
				//System.out.println("abc");
				Statement stmt=con.createStatement();
				int b=Integer.parseInt(textField.getText());
				ResultSet rs=stmt.executeQuery("select *from emp where empid='"+b+"'");
				while(rs.next()) {
					name.setText(rs.getString("empname"));
					email.setText(rs.getString("empemail"));
					phone.setText(rs.getString("emphone"));
					doj.setText(rs.getString("doj"));
				}
				
				
					}
					catch(Exception e) {
						System.out.println(e);
					}
				
			}
		});
		String at=comboBox.getSelectedItem().toString();

		
		 
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/cms";
	int c=Integer.parseInt(textField_1.getText());
	
					Connection con=DriverManager.getConnection(url,"root","");
				PreparedStatement ps=con.prepareStatement("insert into empattendence(empid,date,attendence) values(?,?,?)");
				ps.setInt(1,c);
				ps.setString(2, ((JTextField)dob.getDateEditor().getUiComponent()).getText());
				ps.setString(3, at);
				int res=ps.executeUpdate();
				}
				catch(Exception e) {
					System.out.println(e);
				}
				JOptionPane.showMessageDialog(null,"Succesfully Updated","Operation Information",JOptionPane.INFORMATION_MESSAGE);
			}
				
		});
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String date1=((JTextField)dob.getDateEditor().getUiComponent()).getText();
				int d=Integer.parseInt(textField_1.getText());
				String attendence1=comboBox.getSelectedItem().toString();
				String sql="update empattendence set attendence=? where empid=? and date=?";
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/cms";
					Connection con=DriverManager.getConnection(url,"root","");
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1,attendence1);
				ps.setInt(2, d);
				ps.setString(3, date1);
				ps.executeUpdate();
				}
				catch(Exception e) {
					System.out.println(e);
				}
			}
		});
	}
}
