package noint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class SignUpTwo extends JFrame implements ActionListener {
	
	JTextField dobfield,namefield,fnamefield,genderfield,emailfield,maritalfield,pincodefield,statefield,Adhafield,panfield;
	
	String formno;
	
	JButton next2;
	
	JLabel adddetails,Religion,Category,Income,Educational,Qualification,Occupation,PanNo,AadharNo,SeniorCitizen,ExistingAccount;
	
	JComboBox Religionbox,catbox,edubox,OCbox,SCbox,exbox,ICbox;
	
	Random ran;
	long random;
	
	public SignUpTwo(String formno) {
		
		this.formno=formno;
		
		setLayout(null);
		setBackground(Color.white);
		
		
		adddetails=new JLabel("Page 2 : Additional Details ");
		adddetails.setFont(new Font("Osward",Font.BOLD,23));
		adddetails.setBounds(100,100,500,30);
		add(adddetails);
		
		Religion=new JLabel("Religion : ");
		Religion.setFont(new Font("Osward",Font.PLAIN,20));
		Religion.setBounds(100,150,500,30);
		add(Religion);
		
		String reg[]= {"Hindu","Muslim","Sikh","Christian","Others"};
		Religionbox=new JComboBox(reg);
		Religionbox.setBounds(250,150,400,30);
		Religionbox.setFont(new Font("Ariel",Font.ITALIC,20));
		add(Religionbox);
		
		Category=new JLabel("Category : ");
		Category.setFont(new Font("Osward",Font.PLAIN,20));
		Category.setBounds(100,200,500,30);
		add(Category);
		
		String cat[]= {"General","OBC","SC","ST","Others"};
		catbox=new JComboBox(cat);
		catbox.setBounds(250,200,400,30);
		catbox.setFont(new Font("Ariel",Font.ITALIC,23));
		add(catbox);
		
		Income=new JLabel("Income : ");
		Income.setFont(new Font("Osward",Font.PLAIN,20));
		Income.setBounds(100,250,500,30);
		add(Income);
		
		String IC[]= {"0-2 lac","2-5 la","5-15 la","above 15 la"};
		ICbox=new JComboBox(IC);
		ICbox.setBounds(250,250,400,30);
		ICbox.setFont(new Font("Ariel",Font.PLAIN,23));
		add(ICbox);
		
		Educational=new JLabel("Educational : ");
		Educational.setFont(new Font("Osward",Font.PLAIN,20));
		Educational.setBounds(100,300,500,30);
		add(Educational);
		
		String ED[]= {"None","Below 10th","10th","12th","Under Graduated","Graduated","Post Graduated"};
		edubox=new JComboBox(ED);
		edubox.setBounds(250,300,400,30);
		edubox.setFont(new Font("Ariel",Font.PLAIN,23));
		add(edubox);
		
		getContentPane().setBackground(Color.white);
		
		Occupation=new JLabel("Occupation : ");
		Occupation.setFont(new Font("Osward",Font.PLAIN,20));
		Occupation.setBounds(100,400,500,30);
		add(Occupation);
		
		String OC[]= {"None","Government Employee","Private Employee","Self Employee","Business","Farming","Other"};
		OCbox=new JComboBox(OC);
		OCbox.setBounds(250,400,400,30);
		OCbox.setFont(new Font("Ariel",Font.PLAIN,23));
		add(OCbox);
		
		PanNo=new JLabel("Pan No : ");
		PanNo.setFont(new Font("Osward",Font.PLAIN,20));
		PanNo.setBounds(100,450,500,30);
		add(PanNo);
		
		panfield=new JTextField();
		panfield.setBounds(250,450,400,30);
		panfield.setFont(new Font("Ariel",Font.PLAIN,23));
		add(panfield);
		
		AadharNo=new JLabel("Aadhar No : ");
		AadharNo.setFont(new Font("Osward",Font.PLAIN,20));
		AadharNo.setBounds(100,500,500,30);
		add(AadharNo);
		
		Adhafield=new JTextField();
		Adhafield.setBounds(250,500,400,30);
		Adhafield.setFont(new Font("Ariel",Font.PLAIN,23));
		add(Adhafield);
		
		SeniorCitizen=new JLabel("Senior Citizen : ");
		SeniorCitizen.setFont(new Font("Osward",Font.PLAIN,20));
		SeniorCitizen.setBounds(100,550,500,30);
		add(SeniorCitizen);
		
		String SC[]= {"No","Yes"};
		SCbox=new JComboBox(SC);
		SCbox.setBounds(250,550,400,30);
		SCbox.setFont(new Font("Ariel",Font.PLAIN,23));
		add(SCbox);
		
		ExistingAccount=new JLabel("Existing Account : ");
		ExistingAccount.setFont(new Font("Osward",Font.PLAIN,20));
		ExistingAccount.setBounds(100,600,500,30);
		add(ExistingAccount);
		
		String ex[]= {"No","Yes"};
		exbox=new JComboBox(ex);
		exbox.setBounds(250,600,400,30);
		exbox.setFont(new Font("Ariel",Font.PLAIN,23));
		add(exbox);
		
		next2=new JButton("next");
		next2.setBounds(300,700,255,30);
		next2.setBackground(Color.red);
		next2.addActionListener(this);
		add(next2);
		
		setSize(850,800);
		setVisible(true);
		setLocation(200,50);
	}
	
	public static void main(String[] args) {
		new SignUpTwo("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String reli=(String)Religionbox.getSelectedItem();
		String cata=(String)catbox.getSelectedItem();
		String inc=(String)ICbox.getSelectedItem();
		String edu=(String)edubox.getSelectedItem();
		String ocu=(String)OCbox.getSelectedItem();
		String pan=panfield.getText();
		String adh=Adhafield.getText();
		String Senior=(String)SCbox.getSelectedItem();
		String Ex=(String)exbox.getSelectedItem();
		
		try {
			if (pan.equals("")||adh.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter all Details");
			}else {
				DBConn DB=new DBConn();
				String query="insert into custadd values('"+formno+"', '"+reli+"', '"+cata+"', '"+inc+"', '"+edu+"', '"+ocu+"', '"+pan+"', '"+adh+"', '"+Senior+"', '"+Ex+"');";    
				DB.st.execute(query);
				System.out.println("Done");
				setVisible(false);
				new SignUpThree(formno).setVisible(true);;
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			System.out.println(e2);
		}
		System.out.println("Done");
		
	}

	
}
