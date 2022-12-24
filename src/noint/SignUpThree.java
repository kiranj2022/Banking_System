package noint;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class SignUpThree extends JFrame implements ActionListener{
	JLabel adddetail,acctype,CardNumber,CardNo,PinNumber,PinNo,service;

	JComboBox accbox;
	String formno;

	JCheckBox c1,c2,c3,c4,c5,c6,c7;

	JButton submit,cancel;

	Random random;
	String card,ping;

	public SignUpThree(String formno) {
		this.formno=formno;
		getContentPane().setBackground(Color.white);

		random=new Random();
		card=Math.abs(random.nextLong()%90000000L)+5040936000000000L+"";
		ping=Math.abs(random.nextLong()%9000L)+1000L+"";

		setLayout(null);
		setBackground(Color.WHITE);

		adddetail=new JLabel("Page 3 : Account Details ");
		adddetail.setFont(new Font("Osward",Font.BOLD,23));
		adddetail.setBounds(100,30,400,30);
		add(adddetail);

		acctype=new JLabel("Account type : ");
		acctype.setFont(new Font("Osward",Font.PLAIN,20));
		acctype.setBounds(100,150,500,30);
		add(acctype);

		String reg[]= {"Savings","Fixed Deposit","Current","Recurring Deposite"};
		accbox=new JComboBox(reg);
		accbox.setBounds(250,150,400,30);
		accbox.setFont(new Font("Ariel",Font.ITALIC,20));
		add(accbox);

		CardNumber=new JLabel("Card Number : ");
		CardNumber.setFont(new Font("Osward",Font.PLAIN,20));
		CardNumber.setBounds(100,200,500,30);
		add(CardNumber);

		CardNo=new JLabel(card);
		CardNo.setFont(new Font("Osward",Font.BOLD,20));
		CardNo.setBounds(300,200,500,30);
		add(CardNo);

		PinNumber=new JLabel("PIN :(Your 4 Digit PIN) ");
		PinNumber.setFont(new Font("Osward",Font.PLAIN,20));
		PinNumber.setBounds(100,250,500,30);
		add(PinNumber);

		PinNo=new JLabel(ping);
		PinNo.setFont(new Font("Osward",Font.BOLD,20));
		PinNo.setBounds(400,250,500,30);
		add(PinNo);

		service=new JLabel("Service Needed");
		service.setFont(new Font("Osward",Font.BOLD,20));
		service.setBounds(100,300,500,30);
		add(service);

		c1=new JCheckBox("ATM CARD");
		c1.setBackground(Color.white);
		c1.setFont(new Font("Osward",Font.PLAIN,20));
		c1.setBounds(100,350,200,30);
		add(c1);

		c2=new JCheckBox("Internet Banking");
		c2.setBackground(Color.white);
		c2.setFont(new Font("Osward",Font.PLAIN,20));
		c2.setBounds(400,350,200,30);
		add(c2);

		c3=new JCheckBox("Mobile Banking");
		c3.setBackground(Color.white);
		c3.setFont(new Font("Osward",Font.PLAIN,20));
		c3.setBounds(100,400,200,30);
		add(c3);

		c4=new JCheckBox("Email Service");
		c4.setBackground(Color.white);
		c4.setFont(new Font("Osward",Font.PLAIN,20));
		c4.setBounds(400,400,200,30);
		add(c4);

		c5=new JCheckBox("Cheque Book");
		c5.setBackground(Color.white);
		c5.setFont(new Font("Osward",Font.PLAIN,20));
		c5.setBounds(100,450,200,30);
		add(c5);

		c6=new JCheckBox("E-Statement");
		c6.setBackground(Color.white);
		c6.setFont(new Font("Osward",Font.PLAIN,20));
		c6.setBounds(400,450,200,30);
		add(c6);

		c7=new JCheckBox("I hereby declare that the information provided is true and correct.");
		c7.setBackground(Color.white);
		c7.setFont(new Font("Osward",Font.PLAIN,15));
		c7.setBounds(100,500,500,30);
		add(c7);

		submit=new JButton("Submit");
		submit.setBounds(400,600,200,30);
		submit.setBackground(Color.red);
		submit.addActionListener(this);
		add(submit);

		cancel=new JButton("Cancel");
		cancel.setBounds(100,600,200,30);
		cancel.setBackground(Color.red);
		cancel.addActionListener(this);
		add(cancel);

		setSize(850,800);
		setVisible(true);
		setLocation(200,50);
	}

	public static void main(String[] args) {
		new SignUpThree("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource()==submit) {
				String acc=(String) accbox.getSelectedItem();
				String fac="";

				if(c1.isSelected()) {
					fac+="ATM CARD, ";
				} if(c2.isSelected()) {
					fac+="Internet Banking, ";
				} if(c3.isSelected()) {
					fac+="Mobile Banking, ";
				} if(c4.isSelected()) {
					fac+="Email, ";
				} if(c5.isSelected()) {
					fac+="Cheque Book, ";
				} if(c6.isSelected()) {
					fac+="E-statement";
				}


				DBConn DB1=new DBConn();
				
				String query="insert into custacc values('"+formno+"', '"+acc+"', '"+card+"', '"+ping+"', '"+fac+"');";
				String query_bal="insert into custaccbal values('"+card+"',0,'"+ping+"');";
				
				DB1.st.execute(query);
				DB1.st.execute(query_bal);
				System.out.println("Done");
				
				setVisible(false);
				JOptionPane.showMessageDialog(null, "Application Submitted Successfully");
				new Login().setVisible(true);

			}else if(e.getSource()==cancel) {
				setVisible(false);
				
				new Login().setVisible(true);
			}
		}
		catch (Exception e2) {
			System.out.println("Fill all details");
			System.out.println(e2);
			JOptionPane.showMessageDialog(null, "Enter all Details");

		}



	}
}
