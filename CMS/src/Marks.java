import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Font;
public class Marks {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Marks window = new Marks();
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
	public Marks() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 776, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"First", "Second"}));
		comboBox.setBounds(379, 28, 138, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblSelectSemester = new JLabel("Select Semester");
		lblSelectSemester.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSelectSemester.setBounds(206, 31, 123, 14);
		frame.getContentPane().add(lblSelectSemester);
		
		JButton btnViewMarks = new JButton("View Marks");
		btnViewMarks.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		btnViewMarks.setBounds(291, 73, 117, 23);
		frame.getContentPane().add(btnViewMarks);
		
		JLabel label = new JLabel();
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(104, 132, 110, 20);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_1.setBounds(283, 132, 172, 20);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_2.setBounds(503, 132, 162, 20);
		frame.getContentPane().add(label_2);
		
		JLabel subject1 = new JLabel("");
		subject1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		subject1.setBounds(104, 163, 100, 20);
		frame.getContentPane().add(subject1);
		
		JLabel subject2 = new JLabel("");
		subject2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		subject2.setBounds(104, 233, 117, 23);
		frame.getContentPane().add(subject2);
		
		JLabel subject3 = new JLabel("");
		subject3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		subject3.setBounds(104, 298, 103, 20);
		frame.getContentPane().add(subject3);
		
		JLabel mark1 = new JLabel("");
		mark1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mark1.setBounds(307, 163, 104, 20);
		frame.getContentPane().add(mark1);
		
		JLabel mark2 = new JLabel("");
		mark2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mark2.setBounds(308, 233, 100, 23);
		frame.getContentPane().add(mark2);
		
		JLabel mark3 = new JLabel("");
		mark3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mark3.setBounds(308, 298, 100, 20);
		frame.getContentPane().add(mark3);
		
		JLabel m1 = new JLabel("");
		m1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		m1.setBounds(503, 163, 123, 20);
		frame.getContentPane().add(m1);
		
		JLabel m2 = new JLabel("");
		m2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		m2.setBounds(503, 233, 119, 23);
		frame.getContentPane().add(m2);
		
		JLabel m3 = new JLabel("");
		m3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		m3.setBounds(503, 298, 115, 20);
		frame.getContentPane().add(m3);
		
		JLabel tm = new JLabel("");
		tm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tm.setBounds(209, 367, 120, 23);
		frame.getContentPane().add(tm);
		
		JLabel m = new JLabel("");
		m.setFont(new Font("Tahoma", Font.PLAIN, 13));
		m.setBounds(379, 367, 46, 23);
		frame.getContentPane().add(m);
		
		JLabel upon = new JLabel("");
		upon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		upon.setBounds(433, 367, 46, 23);
		frame.getContentPane().add(upon);
		
		JLabel per = new JLabel("");
		per.setFont(new Font("Tahoma", Font.PLAIN, 15));
		per.setBounds(206, 432, 149, 28);
		frame.getContentPane().add(per);
		
		JLabel get = new JLabel("");
		get.setFont(new Font("Tahoma", Font.PLAIN, 13));
		get.setBounds(379, 432, 46, 28);
		frame.getContentPane().add(get);
		
		JLabel percentage = new JLabel("");
		percentage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		percentage.setBounds(433, 432, 46, 28);
		frame.getContentPane().add(percentage);
		btnViewMarks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/cms";

			Connection con=DriverManager.getConnection(url,"root","");
			String d=comboBox.getSelectedItem().toString();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select *from firstsemmarks where sid=123");
			
			while(rs.next()) {
				if(d.equals("First")) {
				label.setText("Subjects");
				label_1.setText("Obtained Marks");
				label_2.setText("Maximum Marks");
				subject1.setText("OS");
				subject2.setText("DBMS");
				subject3.setText("DAA");
				mark1.setText(rs.getString("OS"));
				mark2.setText(rs.getString("DBMS"));
				mark3.setText(rs.getString("DAA"));
				m1.setText("100");
				m2.setText("100");
				m3.setText("100");
				int a=rs.getInt("OS");
				int b=rs.getInt("DBMS");
				int c=rs.getInt("DAA");
				int sum=(a+b+c);
				double pr=((double)sum/300)*100;
				String tmarks=String.valueOf(sum);
				String getpercent=String.valueOf(pr);
				tm.setText("Total Marks");
				m.setText(tmarks);
				upon.setText("/ 300");
				per.setText("Semester Percentage");
				get.setText(getpercent);
				percentage.setText("%");
			}
			}
				
					
				}	
				catch(Exception e) {
					System.out.println(e);
				}

			}
		});
	}
}
