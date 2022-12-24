package noint;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.*;

public class fastcash extends JFrame implements ActionListener{
	
	JLabel text;
	JButton c500,c1000,c2000,c5000,c10000,c15000,exit;
	String pinnumbers,cardno;
	public fastcash(String pinnumbers,String cardno) {
		setLayout(null);
		this.pinnumbers=pinnumbers;
		this.cardno=cardno;
		
		getContentPane().setBackground(Color.black);
		
		text=new JLabel("Please select Fast Cash ".toUpperCase());
		text.setFont(new Font("Osward",Font.BOLD,23));
		text.setForeground(Color.white);
		text.setBounds(250,50,500,30);
		add(text);
		
		c500=new JButton("500".toUpperCase());
		c500.setFont(new Font("Osward",Font.BOLD,20));
		c500.setForeground(Color.RED);
		c500.setBounds(100,150,250,30);
		c500.addActionListener(this);
		add(c500);
		
		c5000=new JButton("5000".toUpperCase());
		c5000.setFont(new Font("Osward",Font.BOLD,20));
		c5000.setForeground(Color.RED);
		c5000.setBounds(550,150,250,30);
		c5000.addActionListener(this);
		add(c5000);
		
		c1000=new JButton("1000".toUpperCase());
		c1000.setFont(new Font("Osward",Font.BOLD,20));
		c1000.setForeground(Color.RED);
		c1000.setBounds(100,250,250,30);
		c1000.addActionListener(this);
		add(c1000);
		
		c10000=new JButton("10000".toUpperCase());
		c10000.setFont(new Font("Osward",Font.BOLD,20));
		c10000.setForeground(Color.RED);
		c10000.setBounds(550,250,250,30);
		c10000.addActionListener(this);
		add(c10000);
		
		c2000=new JButton("2000".toUpperCase());
		c2000.setFont(new Font("Osward",Font.BOLD,20));
		c2000.setForeground(Color.RED);
		c2000.setBounds(100,350,250,30);
		c2000.addActionListener(this);
		add(c2000);
		
		c15000=new JButton("15000".toUpperCase());
		c15000.setFont(new Font("Osward",Font.BOLD,20));
		c15000.setForeground(Color.RED);
		c15000.setBounds(550,350,250,30);
		c15000.addActionListener(this);
		add(c15000);
		
		exit=new JButton("exit ".toUpperCase());
		exit.setFont(new Font("Osward",Font.BOLD,20));
		exit.setForeground(Color.RED);
		exit.setBounds(100,450,250,30);
		exit.addActionListener(this);
		add(exit);
		
		
		setSize(900,600);
		setVisible(true);
		setLocation(200,50);
	}

	public static void main(String[] args) {
		new fastcash("","");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Date da=new Date();
		if(e.getSource()==exit) {
			setVisible(false);
			new Transactions(pinnumbers,cardno).setVisible(true);
		}
		else {
			String amt= ((JButton)e.getSource()).getText();
			int intam=Integer.parseInt(amt);
			
			DBConn c=new DBConn();
			String f="SELECT bal FROM bank_one.custaccbal where cardno="+cardno+";";
			ResultSet rs = null;
			try {
				rs = c.st.executeQuery(f);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				rs.next();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int bal = 0;
			try {
				bal = rs.getInt("bal");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(intam>bal) {
				JOptionPane.showMessageDialog(null, "Insuffcient Balance");
				setVisible(false);
				new Transactions(pinnumbers, cardno).setVisible(true);
			}else {
				bal-=intam;
				String sbal="UPDATE custaccbal SET bal = "+bal+" WHERE cardno = "+cardno+" and pin="+pinnumbers+";";

				String s="insert into bankacc values('"+cardno+"','"+pinnumbers+"','"+da+"','Withdraw',"+intam+");";
				try {
					c.st.executeUpdate(s);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					c.st.executeUpdate(sbal);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "WithDrawn Successfully");
				setVisible(false);
				new Transactions(pinnumbers,cardno).setVisible(true);
			}
			
			try {
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}

}
