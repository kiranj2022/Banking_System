package noint;

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class SignUpOne extends JFrame implements ActionListener{
	
	JTextField dobfield,namefield,fnamefield,genderfield,emailfield,maritalfield,pincodefield,statefield,cityfield,addressfield;
	
	JButton next1;
	
	JLabel formno,personaldetails,Name,fname,DOB,gender,email,marital,address,city,state,pincode;
	
	JRadioButton male,female,married,unmarried,Divorced;
	
	Random ran;
	long random;
	
	public SignUpOne() {
		ran=new Random();
		random=Math.abs((ran.nextLong() % 9000L) +1000L);
		
		setLayout(null);
		setBackground(Color.white);
		
		formno=new JLabel("One Bank Account Application \n".toUpperCase()+random);
		formno.setFont(new Font("Osward",Font.BOLD,25));
		formno.setBounds(150,30,600,50);
		add(formno);
		
		personaldetails=new JLabel("Page 1 : Personal Details ");
		personaldetails.setFont(new Font("Osward",Font.BOLD,23));
		personaldetails.setBounds(100,100,500,30);
		add(personaldetails);
		
		Name=new JLabel("Name : ");
		Name.setFont(new Font("Osward",Font.PLAIN,20));
		Name.setBounds(100,150,500,30);
		add(Name);
		
		namefield=new JTextField();
		namefield.setBounds(250,150,400,30);
		namefield.setFont(new Font("Ariel",Font.PLAIN,23));
		add(namefield);
		
		fname=new JLabel("Father Name : ");
		fname.setFont(new Font("Osward",Font.PLAIN,20));
		fname.setBounds(100,200,500,30);
		add(fname);
		
		fnamefield=new JTextField();
		fnamefield.setBounds(250,200,400,30);
		fnamefield.setFont(new Font("Ariel",Font.PLAIN,23));
		add(fnamefield);
		
		DOB=new JLabel("Date of Birth : ");
		DOB.setFont(new Font("Osward",Font.PLAIN,20));
		DOB.setBounds(100,250,500,30);
		add(DOB);
		
		dobfield=new JTextField();
		dobfield.setBounds(250,250,400,30);
		dobfield.setFont(new Font("Ariel",Font.PLAIN,23));
		add(dobfield);
		
		gender=new JLabel("Gender : ");
		gender.setFont(new Font("Osward",Font.PLAIN,20));
		gender.setBounds(100,300,500,30);
		add(gender);
		
		male=new JRadioButton("Male");
		male.setBounds(250,300,100,30);
		add(male);
		
		female=new JRadioButton("Female");
		female.setBounds(400,300,100,30);
		add(female);
		
		ButtonGroup gen=new ButtonGroup();
		gen.add(male);
		gen.add(female);
		
		email=new JLabel("Email : ");
		email.setFont(new Font("Osward",Font.PLAIN,20));
		email.setBounds(100,350,500,30);
		add(email);
		
		emailfield=new JTextField();
		emailfield.setBounds(250,350,400,30);
		emailfield.setFont(new Font("Ariel",Font.PLAIN,23));
		add(emailfield);
		
		marital=new JLabel("marital : ");
		marital.setFont(new Font("Osward",Font.PLAIN,20));
		marital.setBounds(100,400,500,30);
		add(marital);
		
		married=new JRadioButton("Married");
		married.setBounds(250,400,100,30);
		add(married);
		
		unmarried=new JRadioButton("Unmarried");
		unmarried.setBounds(400,400,100,30);
		add(unmarried);
		
		Divorced=new JRadioButton("Divorced");
		Divorced.setBounds(550,400,100,30);
		add(Divorced);
		
		ButtonGroup gen1=new ButtonGroup();
		gen1.add(married);
		gen1.add(unmarried);
		gen1.add(Divorced);
		
		address=new JLabel("Address : ");
		address.setFont(new Font("Osward",Font.PLAIN,20));
		address.setBounds(100,450,500,30);
		add(address);
		
		addressfield=new JTextField();
		addressfield.setBounds(250,450,400,30);
		addressfield.setFont(new Font("Ariel",Font.PLAIN,23));
		add(addressfield);
		
		city=new JLabel("City : ");
		city.setFont(new Font("Osward",Font.PLAIN,20));
		city.setBounds(100,500,500,30);
		add(city);
		
		cityfield=new JTextField();
		cityfield.setBounds(250,500,400,30);
		cityfield.setFont(new Font("Ariel",Font.PLAIN,23));
		add(cityfield);
		
		state=new JLabel("State : ");
		state.setFont(new Font("Osward",Font.PLAIN,20));
		state.setBounds(100,550,500,30);
		add(state);
		
		statefield=new JTextField();
		statefield.setBounds(250,550,400,30);
		statefield.setFont(new Font("Ariel",Font.PLAIN,23));
		add(statefield);
		
		pincode=new JLabel("Pincode : ");
		pincode.setFont(new Font("Osward",Font.PLAIN,20));
		pincode.setBounds(100,600,500,30);
		add(pincode);
		
		pincodefield=new JTextField();
		pincodefield.setBounds(250,600,400,30);
		pincodefield.setFont(new Font("Ariel",Font.PLAIN,23));
		add(pincodefield);
		
		next1=new JButton("Next");
		next1.setBounds(300,700,255,30);
		next1.setBackground(Color.red);
		next1.addActionListener(this);
		add(next1);
		
		getContentPane().setBackground(Color.white);
		
		setSize(850,800);
		setVisible(true);
		setLocation(200,50);
	}
	
	public static void main(String[] args) {
		new SignUpOne(); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String formno=random+"";
		String name=namefield.getText();
		String fname=fnamefield.getText();
		String dob=DOB.getText();
		String gender=null;
		if(male.isSelected()) {
			gender="Male";
		} else if(female.isSelected()) {
			gender="Female";
		}
		String email=emailfield.getText();
		String marital=null;
		if(married.isSelected()) {
			marital="Married";
		} else if(unmarried.isSelected()) {
			marital="Unmarried";
		} else if(Divorced.isSelected()) {
			marital="Divorced";
		}
		
		String address=addressfield.getText();
		String city=cityfield.getText();
		String state=statefield.getText();
		String pincode=pincodefield.getText();
		
		
		
		try {
			if (name.equals("")||fname.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter all Details");
			}else {
				DBConn DB=new DBConn();
				String query="insert into cust values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+state+"', '"+pincode+"');";    
				DB.st.execute(query);
				setVisible(false);
				new SignUpTwo(formno).setVisible(true);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			System.out.println(e2);
		}
		System.out.println("Done");
	}
}
