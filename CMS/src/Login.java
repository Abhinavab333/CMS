import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class Login {
	static int sid;

	private JFrame frame;
	private JTextField textField;
	private JPasswordField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 647, 443);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCms = new JLabel("       CMS ");
		lblCms.setForeground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		lblCms.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblCms.setBounds(185, 11, 244, 40);
		frame.getContentPane().add(lblCms);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("E:\\EclipseEE\\CMS\\img\\administrator-icon.png"));
		label.setBounds(234, 62, 161, 107);
		frame.getContentPane().add(label);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setBounds(166, 200, 65, 14);
		frame.getContentPane().add(lblUserId);
		
		textField = new JTextField();
		textField.setBounds(254, 197, 154, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(163, 246, 68, 14);
		frame.getContentPane().add(lblPassword);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(254, 243, 154, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/cms";

			Connection con=DriverManager.getConnection(url,"root","");
			//System.out.println("abc");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select *from studentdb");
			String b=textField.getText();
			 String a=textField_1.getText();
			 sid=Integer.parseInt(b);
			while(rs.next()) {
				if(b.equals(rs.getString("sid"))&&a.equals(rs.getString("spass"))) {
					new Home();
				}
				
			}

				
					
				}	
				catch(Exception e) {
					System.out.println(e);
				}
			}
		});
		btnLogin.setBounds(166, 298, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(284, 298, 89, 23);
		frame.getContentPane().add(btnCancel);
	}
	public void seeProfile(String b) {
		
	}
}
