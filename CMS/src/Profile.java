import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class Profile {
	static JLabel lable_1,label_2,label_3,label_4,label_5;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile window = new Profile();
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
	public Profile() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 531, 371);
		frame.setVisible(true);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(190, 41, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Course");
		lblNewLabel_1.setBounds(190, 86, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("E:\\EclipseEE\\CMS\\img\\administrator-icon.png"));
		label.setBounds(25, 41, 136, 114);
		frame.getContentPane().add(label);
		
		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setBounds(190, 129, 46, 14);
		frame.getContentPane().add(lblBranch);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(190, 169, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(190, 211, 96, 14);
		frame.getContentPane().add(lblPhoneNumber);
		
		lable_1 = new JLabel();
		lable_1.setBounds(294, 41, 173, 14);
		frame.getContentPane().add(lable_1);
		
		 label_2 = new JLabel("");
		label_2.setBounds(294, 86, 111, 14);
		frame.getContentPane().add(label_2);
		
		 label_3 = new JLabel("");
		label_3.setBounds(294, 129, 111, 14);
		frame.getContentPane().add(label_3);
		
	 label_4 = new JLabel("");
		label_4.setBounds(292, 169, 175, 14);
		frame.getContentPane().add(label_4);
		
		 label_5 = new JLabel("");
		label_5.setBounds(295, 211, 110, 14);
		frame.getContentPane().add(label_5);
	}
}
