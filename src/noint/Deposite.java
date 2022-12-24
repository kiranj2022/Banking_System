package noint;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposite extends JFrame implements ActionListener{
	
	JLabel text;
	
	JTextField depfield;
	
	JButton deposite,home1;
	String pinnumbers,cardno;
	public Deposite(String pin, String cardno) {
		pinnumbers=pin;
		this.cardno=cardno;
		setLayout(null);
		getContentPane().setBackground(Color.black);
		
		text=new JLabel("Enter the amount you want to Deposite ".toUpperCase());
		text.setFont(new Font("Osward",Font.BOLD,23));
		text.setForeground(Color.white);
		text.setBounds(150,50,600,30);
		add(text);
		
		depfield=new JTextField();
		depfield.setBounds(200,200,400,30);
		depfield.setFont(new Font("Ariel",Font.PLAIN,23));
		add(depfield);
		
		deposite=new JButton("deposite ".toUpperCase());
		deposite.setFont(new Font("Osward",Font.BOLD,20));
		deposite.setForeground(Color.RED);
		deposite.setBounds(500,450,250,30);
		deposite.addActionListener(this);
		add(deposite);
		
		home1=new JButton("Back ".toUpperCase());
		home1.setFont(new Font("Osward",Font.BOLD,20));
		home1.setForeground(Color.RED);
		home1.setBounds(200,450,250,30);
		home1.addActionListener(this);
		add(home1);
		setSize(900,600);
		setVisible(true);
		setLocation(200,50);
	}

	public static void main(String[] args) {
		new Deposite("","");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==deposite) {
			String am=depfield.getText();
			int intam=Integer.parseInt(am);
			Date da=new Date();
			if(am.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter the amount");
			}
			else {
				try {
				DBConn c=new DBConn();
				String s="insert into bankacc values('"+cardno+"','"+pinnumbers+"','"+da+"','Deposite',"+intam+");";
				String f="SELECT bal FROM bank_one.custaccbal where cardno="+cardno+";";
				ResultSet rs=c.st.executeQuery(f);
				rs.next();
				int bal=rs.getInt("bal");
				bal+=intam;
				String sbal="UPDATE custaccbal SET bal = "+bal+" WHERE cardno = "+cardno+" and pin="+pinnumbers+";";
				
				c.st.executeUpdate(s);
				c.st.executeUpdate(sbal);
				JOptionPane.showMessageDialog(null, "Deposited Successfully");
				setVisible(false);
				new Transactions(pinnumbers,cardno).setVisible(true);
				}
				catch (Exception eee) {
					System.out.println(eee);
				}
				
			}
		} else if(e.getSource()==home1) {
			setVisible(false);
			new Transactions(pinnumbers,cardno);
		}
		
	}

}
