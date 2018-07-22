package admin;

import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Signup extends JFrame{
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField f1,f2,f3,f4,f5,f6;
    JButton b1,b2;
    Signup()
    {
         setTitle("Student Registration");
                    setSize(850,600);
                    setVisible(true);
                    setDefaultCloseOperation(EXIT_ON_CLOSE);
                    setLayout(new BorderLayout());
                    JLabel bg=new JLabel(new ImageIcon("C:\\Users\\hp\\Downloads\\the-background-301144_960_720.png"));
                    add(bg);
                    bg.setLayout(null);
                    l1=new JLabel(" Student Name");
                     l2=new JLabel(" E-Mail");
                      l3=new JLabel(" Date Of Birth");
                       l4=new JLabel(" Course");
                        l5=new JLabel(" Branch");
                         l6=new JLabel(" Phone Number");
                         f1=new JTextField();
                          f2=new JTextField();
                           f3=new JTextField();
                            f4=new JTextField();
                             f5=new JTextField();
                              f6=new JTextField();
                              b1=new JButton(new ImageIcon("E:\\Abhinav Documents\\Projects\\OnlineExaminationSystem\\src\\Images\\submit.png"));
                              b2=new JButton(new ImageIcon("E:\\Abhinav Documents\\Projects\\OnlineExaminationSystem\\src\\cancel.png"));
                    l1.setBounds(150,50,110,20);
                    f1.setBounds(150,80,270,25);
                    bg.add(l1);
                    bg.add(f1);
                    l2.setBounds(150,120,110,20);
                    f2.setBounds(150,150,270,25);
                    bg.add(l2);
                    bg.add(f2);
                    l3.setBounds(150,190,110,20);
                    f3.setBounds(150,210,270,25);
                    bg.add(l3);
                    bg.add(f3);
                    l4.setBounds(150,250,110,20);
                    f4.setBounds(150,280,270,25);
                    bg.add(l4);
                    bg.add(f4);
                    l5.setBounds(150,320,110,20);
                    f5.setBounds(150,350,270,25);
                    bg.add(l5);
                    bg.add(f5);
                    l6.setBounds(150,390,110,20);
                    f6.setBounds(150,410,270,25);
                    bg.add(l6);
                    bg.add(f6);
                    b1.setBounds(150,470,130,30);           
                    b2.setBounds(290,470,130,30);
                    b1.addActionListener(new ActionListener() {
                    

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							String F1=f1.getText();
                        	String F2=f2.getText();
                        	String F3=f3.getText();
                        	String F4=f4.getText();
                        	String F5=f6.getText();
                        	//String F1=f1.getText();
                        	  try {
                        		  Class.forName("com.mysql.jdbc.Driver");  
                        		  
                        		  Connection con=DriverManager.getConnection(  
                        		  "jdbc:mysql://localhost:3306/oes","root",""); 
                        		  con.setAutoCommit(false);
                              	Statement stmt=con.createStatement();
                              
                              	stmt.executeUpdate("insert into Register values('"+F1+"','"+F2+"','"+F3+"','"+F4+"','"+F5+"')");	
                              	con.commit();
                        	  }
                              catch(Exception en) {
                              	en.printStackTrace();
                              }
							
						}
                    }
                    		);
                    bg.add(b1);
                    bg.add(b2);
    
    }
    
    public static void main(String[] args) {
        
        new Signup();
      }
	

}
