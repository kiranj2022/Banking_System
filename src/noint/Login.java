package noint;

import java.awt.Color;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;

public class Login extends JFrame implements ActionListener{
	JButton login, clear, signup;
	
	JTextField cardTextField;
	JPasswordField PINField;
	
	public Login() {
		
		setTitle("One Bank");
		
		setLayout(null);
		//logo
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("logo/Onebanklogo.jpg"));
		Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel lable1=new JLabel(i3);
		lable1.setBounds(70,10,100,100);
		add(lable1);
		
		//text
		JLabel text=new JLabel("Welcome to One Bank");
		text.setFont(new Font("Osward",Font.BOLD,38));
		text.setBounds(200,30,500,100);
		add(text);
		
		//Input text Card Number
		JLabel cardno=new JLabel("Card No : ");
		cardno.setFont(new Font("Raleway",Font.BOLD,28));
		cardno.setBounds(150,30,200,250);
		add(cardno);
		
		//input text PIN
		JLabel pin=new JLabel("PIN : ");
		pin.setFont(new Font("Raleway",Font.BOLD,28));
		pin.setBounds(210,30,100,400);
		add(pin);
		
		//text box card number
		cardTextField=new JTextField();
		cardTextField.setBounds(280,140,300,40);
		cardTextField.setFont(new Font("Ariel",Font.PLAIN,23));
		add(cardTextField);
		
		//text box PIN
		PINField=new JPasswordField();
		PINField.setBounds(280,215,300,40);
		PINField.setFont(new Font("Ariel",Font.PLAIN,23));
		add(PINField);
		
		//button
		login=new JButton("SIGN IN");
		login.setBounds(300,280,100,30);
		login.setBackground(Color.red);
		login.addActionListener(this);
		add(login);
		
		//button
		clear=new JButton("CLEAR");
		clear.setBounds(450,280,100,30);
		clear.setBackground(Color.red);
		clear.addActionListener(this);
		add(clear);

		//button
		signup=new JButton("SIGN UP");
		signup.setBounds(300,320,255,30);
		signup.setBackground(Color.red);
		signup.addActionListener(this);
		add(signup);
		
		//frame design
		getContentPane().setBackground(Color.white);
		
		
		//frame size and position
		setSize(800,480);
		setVisible(true);
		setLocation(350,200);
		
	}
	
	public static void main(String[] args) {
		new Login();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==clear) {
			cardTextField.setText("");
			PINField.setText("");
		}
		else if(e.getSource()==login) {
			DBConn con=new DBConn();
			String cards=cardTextField.getText();
			String pins=PINField.getText();
			
			String query1="select * from custacc where cardno='"+cards+"' and pin='"+pins+"';";
			
			try {
				ResultSet rs=(ResultSet) con.st.executeQuery(query1);
				if(rs.next()) {
					setVisible(false);
					new Transactions(pins,cards).setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Incorrect card number or pin");
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Incorrect card number or pin");
				e2.printStackTrace();
			}
			
		}
		else if(e.getSource()==signup) {
			setVisible(false);
			new SignUpOne().setVisible(true);
		}
		
	}
}
