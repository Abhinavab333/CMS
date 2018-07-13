package student;
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Library {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Library window = new Library();
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
	public Library() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 376);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblEnterStudentId = new JLabel("Enter Student ID:-");
		lblEnterStudentId.setBounds(40, 86, 108, 14);
		frame.getContentPane().add(lblEnterStudentId);
		
		textField = new JTextField();
		textField.setBounds(158, 83, 152, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		JLabel lblLibrary = new JLabel("                  Library");
		lblLibrary.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLibrary.setBounds(78, 23, 263, 39);
		frame.getContentPane().add(lblLibrary);
		
		JLabel lblBookIssued = new JLabel("Book Issued -");
		lblBookIssued.setBounds(44, 196, 89, 14);
		frame.getContentPane().add(lblBookIssued);
		
		JLabel label = new JLabel();
		label.setBounds(157, 196, 123, 14);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("Status -");
		lblNewLabel.setBounds(45, 221, 93, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel();
		
		lblNewLabel_1.setBounds(158, 221, 100, 14);
		frame.getContentPane().add(lblNewLabel_1);

		
		JButton btnShow = new JButton("   Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/cms";

			Connection con=DriverManager.getConnection(url,"root","");
			//System.out.println("abc");
			Statement stmt=con.createStatement();
			String b=textField.getText();
			String a=String.valueOf(b);
			ResultSet rs=stmt.executeQuery("select lid from library  ");
			//retrieve record from column
			while(rs.next()) {
				if(b.equals(rs.getString("lid"))) {
					ResultSet rs1=stmt.executeQuery("select * from library where lid='"+b+"'");
				while(rs1.next()) {
			label.setText(rs1.getString("bissue"));
			lblNewLabel_1.setText(rs1.getString("status"));
			}
				}
			}
		
			
			con.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}

				
			}
		});
		btnShow.setBounds(194, 137, 89, 23);
		frame.getContentPane().add(btnShow);
		
			}
}
