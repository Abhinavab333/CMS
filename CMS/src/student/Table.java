package student;


import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.*;

import java.awt.*;

class Student {
	private String subject;
	private int lectures,absent,present,percentage;
	Student(String s,int l,int a,int p,int per){
		subject=s;
		lectures=l;
		absent=a;
		present=p;
		percentage=per;
	}
	public String getsubject() {
		return subject;
	}
	public int getlectures(){
		return lectures;
	}
	public int getabsent() {
		return absent;
	}
	public int getpresent() {
		return present;
	}
	public int getpercentage() {
		return percentage;
	}
}
public class Table {

	private JFrame frame;
	private JTable table;
	static ArrayList<Student> getStudent(){
		ArrayList<Student> student=new ArrayList<Student>();
		Student r;
		try {
			 Class.forName("com.mysql.jdbc.Driver");  
   		  
   		  Connection con=DriverManager.getConnection(  
   		  "jdbc:mysql://localhost:3306/oes","root",""); 
   		  con.setAutoCommit(false);
         	Statement stmt=con.createStatement();
         	ResultSet rs=stmt.executeQuery("select *from attendence");
         	while(rs.next()) {
         		r=new Student(
         				rs.getString("subject"),
         				rs.getInt("lectures"),
         				rs.getInt("absent"),
         				rs.getInt("present"),
         				rs.getInt("percentage"));
         		student.add(r);
         	}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return student;
	}


	

	/**
	 * Create the application.
	 */
	public Table() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 615, 348);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.setBackground(Color.WHITE);
		DefaultTableModel model=new DefaultTableModel();
		Object[] column=new Object[5];
		column[0]="Subject";
		column[1]="Total Lectures";
		column[2]="Absent";
		column[3]="Present";
		column[4]="Percent";
		model.setColumnIdentifiers(column);
		Object[] row=new Object[5];
		for(int i=0;i<getStudent().size();i++)
		{
			row[0]=getStudent().get(i).getsubject();
			row[1]=getStudent().get(i).getlectures();
			row[2]=getStudent().get(i).getabsent();
			row[3]=getStudent().get(i).getpresent();
			
			row[4]=getStudent().get(i).getpercentage();
			model.addRow(row);
		}
	 table.setModel(model);
 		
		table.setBounds(10, 54, 563, 108);
		frame.getContentPane().add(table);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSubject.setBounds(10, 29, 46, 14);
		frame.getContentPane().add(lblSubject);
		
		JLabel lblTotalLectures = new JLabel(" Lectures");
		lblTotalLectures.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTotalLectures.setBounds(117, 29, 66, 14);
		frame.getContentPane().add(lblTotalLectures);
		
		JLabel lblAbsent = new JLabel("Absent");
		lblAbsent.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAbsent.setBounds(235, 29, 46, 14);
		frame.getContentPane().add(lblAbsent);
		
		JLabel lblPresent = new JLabel("Present");
		lblPresent.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPresent.setBounds(346, 29, 46, 14);
		frame.getContentPane().add(lblPresent);
		
		JLabel lblPercentage =new JLabel("Percentage");
		lblPercentage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPercentage.setBounds(462, 29, 66, 14);
		frame.getContentPane().add(lblPercentage);
		
		
	
	}
}
