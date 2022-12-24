package noint;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class Transactions extends JFrame implements ActionListener{
	
	JLabel text;
	JButton deposite,withdraw,fastcash,minist,pinchange,balanceenquiry,exit;
	String pinnumbers,cardno;
	public Transactions(String pinnumbers ,String cardno) {
		setLayout(null);
		this.pinnumbers=pinnumbers;
		this.cardno=cardno;
		
		getContentPane().setBackground(Color.black);
		
		text=new JLabel("Please select your trasaction ".toUpperCase());
		text.setFont(new Font("Osward",Font.BOLD,23));
		text.setForeground(Color.white);
		text.setBounds(250,50,500,30);
		add(text);
		
		deposite=new JButton("deposite".toUpperCase());
		deposite.setFont(new Font("Osward",Font.BOLD,20));
		deposite.setForeground(Color.RED);
		deposite.setBounds(100,150,250,30);
		deposite.addActionListener(this);
		add(deposite);
		
		withdraw=new JButton("withdraw".toUpperCase());
		withdraw.setFont(new Font("Osward",Font.BOLD,20));
		withdraw.setForeground(Color.RED);
		withdraw.setBounds(550,150,250,30);
		withdraw.addActionListener(this);
		add(withdraw);
		
		fastcash=new JButton("fastcash".toUpperCase());
		fastcash.setFont(new Font("Osward",Font.BOLD,20));
		fastcash.setForeground(Color.RED);
		fastcash.setBounds(100,250,250,30);
		fastcash.addActionListener(this);
		add(fastcash);
		
		minist=new JButton("Mini Statement".toUpperCase());
		minist.setFont(new Font("Osward",Font.BOLD,20));
		minist.setForeground(Color.RED);
		minist.setBounds(550,250,250,30);
		minist.addActionListener(this);
		add(minist);
		
		pinchange=new JButton("pin change".toUpperCase());
		pinchange.setFont(new Font("Osward",Font.BOLD,20));
		pinchange.setForeground(Color.RED);
		pinchange.setBounds(100,350,250,30);
		pinchange.addActionListener(this);
		add(pinchange);
		
		balanceenquiry=new JButton("balance enquiry".toUpperCase());
		balanceenquiry.setFont(new Font("Osward",Font.BOLD,20));
		balanceenquiry.setForeground(Color.RED);
		balanceenquiry.setBounds(550,350,250,30);
		balanceenquiry.addActionListener(this);
		add(balanceenquiry);
		
		exit=new JButton("exit".toUpperCase());
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
		new Transactions("","");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==exit) {
			System.exit(0);
		}
		else if(e.getSource()==deposite) {
			setVisible(false);
			new Deposite(pinnumbers,cardno).setVisible(true);
			
		}
		else if(e.getSource()==withdraw) {
			setVisible(false);
			new withdraw(pinnumbers,cardno).setVisible(true);
			
		}
		else if(e.getSource()==fastcash) {
			setVisible(false);
			new fastcash(pinnumbers,cardno).setVisible(true);
			
		}
		else if(e.getSource()==pinchange) {
			setVisible(false);
			new pinchange(pinnumbers,cardno).setVisible(true);
			
		}
		else if(e.getSource()==balanceenquiry) {
			DBConn c=new DBConn();
			String f="SELECT bal FROM bank_one.custaccbal where cardno="+cardno+";";
			ResultSet rs = null;
			int bal = 0;
			try {
				rs = c.st.executeQuery(f);
				rs.next();
				bal = rs.getInt("bal");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Balance is "+bal);
			setVisible(false);
			new Transactions(pinnumbers, cardno).setVisible(true);
			
		}
		
	}

}
