package employee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Profile1 {
	static JLabel label_1,label_2,label_3,label_4;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile1 window = new Profile1();
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
	public Profile1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 789, 392);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JLabel lblEmployeeProfile = new JLabel("Employee Profile");
		lblEmployeeProfile.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblEmployeeProfile.setBounds(266, 11, 383, 40);
		frame.getContentPane().add(lblEmployeeProfile);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Abhinav\\Desktop\\administrator-icon.png"));
		label.setBounds(87, 87, 119, 141);
		frame.getContentPane().add(label);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(266, 98, 73, 24);
		frame.getContentPane().add(lblName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(266, 144, 73, 24);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblDateOfJoining = new JLabel("Date Of Joining");
		lblDateOfJoining.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDateOfJoining.setBounds(266, 190, 107, 24);
		frame.getContentPane().add(lblDateOfJoining);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMobileNumber.setBounds(266, 237, 107, 24);
		frame.getContentPane().add(lblMobileNumber);
		
		 label_1 = new JLabel("");
		label_1.setBounds(418, 108, 183, 16);
		frame.getContentPane().add(label_1);
		
		 label_2 = new JLabel("");
		label_2.setBounds(418, 154, 150, 14);
		frame.getContentPane().add(label_2);
		
		 label_3 = new JLabel("");
		label_3.setBounds(420, 190, 130, 24);
		frame.getContentPane().add(label_3);
		
		 label_4 = new JLabel("");
		label_4.setBounds(420, 244, 130, 14);
		frame.getContentPane().add(label_4);
	}
}
