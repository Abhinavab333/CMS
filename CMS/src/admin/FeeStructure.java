package admin;



import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.*;

import java.awt.*;

class Student {
	private String year;
	private int btech,bpharma,mba;
	Student(String s,int l,int a,int p){
		year=s;
		btech=l;
		bpharma=a;
		mba=p;
	
	}
	public String getyear() {
		return year;
	}
	public int getbtech(){
		return btech;
	}
	public int getbpharma() {
		return bpharma;
	}
	public int getmba() {
		return mba;
	}
	
}
public class FeeStructure {

	private JFrame frame;
	private JTable table;
	static ArrayList<Student> getStudent(){
		ArrayList<Student> student=new ArrayList<Student>();
		Student r;
		try {
			 Class.forName("com.mysql.jdbc.Driver");  
   		  
   		  Connection con=DriverManager.getConnection(  
   		  "jdbc:mysql://localhost:3306/cms","root",""); 
   		  con.setAutoCommit(false);
         	Statement stmt=con.createStatement();
         	ResultSet rs=stmt.executeQuery("select *from fee");
         	while(rs.next()) {
         		r=new Student(
         				rs.getString("Year"),
         				rs.getInt("btech"),
         				rs.getInt("bpharma"),
         				rs.getInt("mba"));
         		student.add(r);
         	}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return student;
	}


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FeeStructure window = new FeeStructure();
					window.frame.setVisible(true);
					window.initialize();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FeeStructure() {
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
		//frame.setVisible(true);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.setBackground(Color.WHITE);
		DefaultTableModel model=new DefaultTableModel();
		Object[] column=new Object[4];
		column[0]="Year";
		column[1]="B.Tech";
		column[2]="B.Pharma";
		column[3]="M.B.A";
		
		model.setColumnIdentifiers(column);
		Object[] row=new Object[5];
		for(int i=0;i<getStudent().size();i++)
		{
			row[0]=getStudent().get(i).getyear();
			row[1]=getStudent().get(i).getbtech();
			row[2]=getStudent().get(i).getbpharma();
			row[3]=getStudent().get(i).getmba();
			
			
			model.addRow(row);
		}
	 table.setModel(model);
 		
		table.setBounds(10, 54, 563, 108);
		frame.getContentPane().add(table);
		
		JLabel lblSubject = new JLabel("Year");
		lblSubject.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSubject.setBounds(10, 29, 46, 14);
		frame.getContentPane().add(lblSubject);
		
		JLabel lblTotalLectures = new JLabel(" B.Tech");
		lblTotalLectures.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTotalLectures.setBounds(147, 29, 66, 14);
		frame.getContentPane().add(lblTotalLectures);
		
		JLabel lblAbsent = new JLabel("B.Pharma");
		lblAbsent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAbsent.setBounds(295, 29, 75, 14);
		frame.getContentPane().add(lblAbsent);
		
		JLabel lblPresent = new JLabel("M.B.A");
		lblPresent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPresent.setBounds(440, 29, 90, 14);
		frame.getContentPane().add(lblPresent);
		
		
		
		
	
	}
}
