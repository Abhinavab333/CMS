package admin;

import java.awt.EventQueue;
import student.*;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Color;

public class AdminHome {

	private JFrame frame;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public AdminHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 777, 398);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(128, 128, 128));
		menuBar.setBackground(new Color(95, 158, 160));
		frame.setJMenuBar(menuBar);
		
		JMenu mnRegistration = new JMenu("Registration");
		mnRegistration.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnRegistration);
		
		JMenuItem mntmEmployee = new JMenuItem("Employee");
		mntmEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new Employee();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		mntmEmployee.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnRegistration.add(mntmEmployee);
		
		JMenuItem mntmStudent = new JMenuItem("Student");
		mntmStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Studentreg();
			}
		});
		mntmStudent.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnRegistration.add(mntmStudent);
		
		JMenu mnAttendence = new JMenu("Attendence");
		mnAttendence.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnAttendence);
		
		JMenuItem mntmEmployee_1 = new JMenuItem("Employee");
		mntmEmployee_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new empattendence();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		mntmEmployee_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnAttendence.add(mntmEmployee_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Student");
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnAttendence.add(mntmNewMenuItem);
		
		JMenu mnFeeStructure = new JMenu("Fee Structure");
		mnFeeStructure.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnFeeStructure);
		
		JMenuItem mntmUpdate = new JMenuItem("Update");
		mntmUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FeeUpdate();
			}
		});
		mntmUpdate.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnFeeStructure.add(mntmUpdate);
		
		JMenu mnLogout = new JMenu("Logout");
		mnLogout.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnLogout);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//new Login();
				new Login();
				//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		});
		mntmLogout.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnLogout.add(mntmLogout);
	}
}
