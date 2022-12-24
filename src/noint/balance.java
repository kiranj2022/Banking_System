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

public class balance extends JFrame implements ActionListener{
	
	JLabel text;
	JButton c500,c1000,c2000,c5000,c10000,c15000,exit;
	String pinnumbers,cardno;
	public balance(String pinnumbers,String cardno) {
		setLayout(null);
		this.pinnumbers=pinnumbers;
		this.cardno=cardno;
	}

	public static void main(String[] args) {
		new balance("","");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Date da=new Date();
		if(e.getSource()==exit) {
			setVisible(false);
			new Transactions(pinnumbers,cardno).setVisible(true);
		}
		else {
			
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
