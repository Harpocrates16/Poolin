import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
class reg extends JFrame implements ActionListener
{
JButton b1;
JTextField t1;
JPasswordField f1;
JLabel l1,l2,l3;
static String s2;
reg()
{
b1 = new JButton("Sign In");
t1 = new JTextField(8);
f1 = new JPasswordField(16);
l1 = new JLabel("Username : ");
l2 = new JLabel("Password : ");
l3 = new JLabel("");
b1.setBounds(125,75,100,20);
t1.setBounds(125,10,100,20);
f1.setBounds(125,45,100,20);
l1.setBounds(10,10,100,20);
l2.setBounds(10,45,100,20);
l3.setBounds(100,100,200,20);
add(b1);add(l1);add(l2);add(t1);add(f1);add(l3);
setLayout(null);
setVisible(true);
setSize(300,175);
setLocation(500,250);
b1.addActionListener(this);
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
}
public void actionPerformed(ActionEvent ae)
{
try
{
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rset","root","1234");
Statement stm=con.createStatement();  
ResultSet rs=stm.executeQuery("select * from user"); 
while(rs.next())  
{
String s1 = rs.getString(1);
s2 = t1.getText();
String s3 = rs.getString(2);
char c1[] = f1.getPassword();
String s4  = String. valueOf(c1);
if(s1.equals(s2))
{
 if(s3.equals(s4))
 {
	l3.setText("Sign In Successfull");
	frame f3= new frame();
	dispose();
 }
 else
	 l3.setText("Invalid Password");
}
else
	l3.setText("Invalid Username");
}
	rs.close();
	stm.close();
	con.close();
}
catch(SQLException e)
{
	System.out.println(e);
}
catch(ClassNotFoundException e1){
	System.out.println(e1);
}
}
}
class GUI1 implements ActionListener
{
JFrame f2;
JLabel op,name,dept,addr,name1,dept1,addr1,dob,dob1,reg,reg1,gen,gen1,fail;
JTextField user;
JPasswordField pass;
JButton b1;
GUI1()
{
f2 = new JFrame("WELCOME!!");
name=new JLabel("Name");
addr=new JLabel("Address");
name1=new JLabel();
addr1=new JLabel();
dob=new JLabel("Date of Birth");
dob1=new JLabel();
gen=new JLabel("Gender");
gen1=new JLabel();
name.setBounds(10,20,70,30);
name1.setBounds(150,20,150,30);
dob.setBounds(10,140,70,30);
dob1.setBounds(150,140,270,30);
gen.setBounds(10,200,70,30);
gen1.setBounds(150,200,70,30);
addr.setBounds(10,260,70,30);
addr1.setBounds(150,260,150,30);
f2.add(name);
f2.add(name1);
f2.add(addr);
f2.add(addr1);
f2.add(dob);
f2.add(dob1);
f2.add(gen);
f2.add(gen1);
f2.setSize(500,500);
f2.setLayout(null);
f2.setVisible(true);
f2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
}
public void actionPerformed(ActionEvent ae)
{
}
}

class frame extends JFrame implements ActionListener
{
	JButton b2,b3,b6;
	JLabel l4,l8,l9;;
	String s6;
	String s8= reg.s2;
	String s9;
	frame()
	{
		b2 = new JButton("RIDER ");
		b3 = new JButton("PASSENGER");
		b6 = new JButton("Logout");
		l8 = new JLabel(s8);
		l4 = new JLabel("Welcome To POOLIN:");
		add(b3);add(b2);add(l4);add(b6);add(l8);
		l9 = new JLabel();
		add(l9);
		l9.setBounds(10,1,100,20);
		setLayout(null);
		setVisible(true);
		setSize(450,200);
		setLocation(500,250);
		l8.setBounds(10,20,120,20);
		l4.setBounds(10,45,220,20);
		b2.setBounds(10,72,200,75);
		b3.setBounds(220,72,200,75);
		b6.setBounds(320,10,100,20);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b6.addActionListener(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rset","root","1234");
			Statement stm1 = con.createStatement();
			String qry2 ="select * from login where uname ='"+s8+"'";
			ResultSet rs1 = stm1.executeQuery(qry2);
			while(rs1.next()){
			s9=rs1.getString(3);l9.setText(s9);
			}
			rs1.close();
			stm1.close();con.close();
		}
		catch(Exception e5){System.out.println(e5);}
		
	}
	public void actionPerformed(ActionEvent as)
	{
		
		if(as.getSource()==b2)
		{
			GUI1 g1 = new GUI1();
		}
		if(as.getSource()==b3)
		{
			pview p1=new pview();	
		}
		if(as.getSource()==b6)
		{
			reg r1 = new reg();
			dispose();
		}
	}
}
class Psel extends JFrame //implements ActionListener
{	
	JButton b1,b2,b3;
	Psel()
	{
		b1 = new JButton("Driver A  ETA 5mins  ₹45");
		b1.setBounds(20,20,300,40);
		b2 = new JButton("Driver B  ETA 10mins  ₹105");
		b2.setBounds(20,80,300,40);
		b3 = new JButton("Driver C  ETA 15mins  ₹75");
		b3.setBounds(20,140,300,40);
		add(b3);add(b2);add(b1);
		setLayout(null);
		setVisible(true);
		setSize(450,400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
class pview extends JFrame implements ActionListener
{
	JLabel l1,l2,pno;
	JTextField from,dest,pnum;
	JButton b1;
	pview()
	{
		//f2 = new JFrame("WELCOME!!");
		l1 = new JLabel("FROM");
		l1.setBounds(20,20,200,50);
		add(l1);
		from = new JTextField(50);
		from.setBounds(230,20,200,25);
		add(from);
		dest = new JTextField(50);
		dest.setBounds(230,80,200,25);
		add(dest);
		l2 = new JLabel("DESTINATION");
		l2.setBounds(20,80,200,50);
		add(l2);
		pno = new JLabel("no of passengers");
		pno.setBounds(20,100,200,50);
		add(pnum);
		pnum = new JTextField(50);
		pnum.setBounds(230,100,200,25);
		add(pnum);
		b1 = new JButton("SEARCH");
		b1.setBounds(20,300,100,40);
		add(b1);
		setSize(500,500);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
	}
	public void actionPerformed(ActionEvent af)
	{
		if(af.getSource()==b1){
		Psel obj1= new Psel();
		}
	}
}

class poolin1
{
public static void main(String args[])
{
reg r = new reg();
}
}