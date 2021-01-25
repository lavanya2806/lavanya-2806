package swing1;
import java.awt.*;  
import java.awt.event.*;  
import java.util.*;
import javax.swing.*;
import java.io.*;


class Students implements Comparable<Students>
{
	private int roll;
	private String name;
	private double marks;
	
	public Students(int roll, String name, double marks) {
		this.roll = roll;
		this.name = name;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Students [roll=" + roll + ", name=" + name + ", marks=" + marks
				+ "]";
	}

	public int getRoll() {
		return roll;
	}

	public String getName() {
		return name;
	}

	public double getMarks() {
		return marks;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}
	
	 public static Comparator<Students> StuNameComparator = new Comparator<Students>() {

			public int compare(Students s1, Students s2) {
				 String StudentName1 = s1.getName().toUpperCase();
				   String StudentName2 = s2.getName().toUpperCase();
			   //ascending order
			   return StudentName1.compareTo(StudentName2);

			   //descending order
			   //return StudentName2.compareTo(StudentName1);
		    }};
		    public static Comparator<Students> StuRollno = new Comparator<Students>() {

		    	public int compare(Students s1, Students s2) {

		    	   int rollno1 = s1.getRoll();
		    	   int rollno2 = s2.getRoll();

		    	   
		    	   return rollno1-rollno2;

		    	   
		    	   //rollno2-rollno1;
		       }};
     public static Comparator<Students> Stumarks = new Comparator<Students>() {

			    	public int compare(Students s1, Students s2) {

			    	  double marks1 = s1.getMarks();
			    	   double marks2 = s2.getMarks();

			    	   
			    	   return (int)(marks1-marks2);

			    	   
			    	   //rollno2-rollno1;
			       }};

	  @Override
			public int compareTo(Students o) {
				// TODO Auto-generated method stub
				return 0;
			}}

public class StudentDa implements ActionListener,ItemListener{
	JTextField tf1,tf2,tf3;
	JTextArea tf4;
	JButton b1,b2,b3;
	 JLabel lname,lrollno,lmarks,lsort;  
	JRadioButton r1,r2,r3;
	ButtonGroup bg;
	@SuppressWarnings("rawtypes")
	final JComboBox r;
	JTable table;
	ArrayList<Students> al =new ArrayList<Students>();
	StudentDa()
	{
		JFrame f = new JFrame("Student Data"); 
		tf1=new JTextField();  
	     tf1.setBounds(75,50,150,20);  
	      tf2=new JTextField();  
	        tf2.setBounds(75,100,150,20);  
	      tf3=new JTextField();  
	        tf3.setBounds(75,150,150,20);   
	       
	        tf4=new JTextArea();  
	        tf4.setBounds(75,300,500,300);  
	          
	        
	        f.add(tf1);
			f.add(tf2);
			f.add(tf3);
			f.add(tf4);
	        
			lrollno=new JLabel("Roll No :");  
	        lrollno.setBounds(10,50, 150,20); 
	        lname=new JLabel("Name : ");  
	        lname.setBounds(10,100, 150,20); 
	        lmarks=new JLabel("Marks : ");  
	        lmarks.setBounds(10,150, 150,20); 
	        lsort=new JLabel("Sort according to : ");  
	        lsort.setBounds(250,50, 150,20);  
	        f.add(lsort);
	        f.add(lname);
	        f.add(lmarks);
	        f.add(lrollno);
	        
	        String Sort[]= {"Roll No","Name","Marks"};
	        r=new JComboBox(Sort);
	        r.setBounds(250,70,100,30);
	        
	       
	        f.add(r);
	        
	        
	         b1=new JButton("Submit Data");
	        b1.setBounds(75,200,150,30);  
	         b2 = new JButton("List all Students");
	        b2.setBounds(75,240,150,30);
	         b3 = new JButton("Sort Data");
	        b3.setBounds(250,200,150,30);

		    f.add(b1);  
		    f.add(b2); 
		    f.add(b3); 
		    
        f.setSize(700,700);
        f.setLayout(null);
        f.setVisible(true);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        tf1.addActionListener(this);
        tf2.addActionListener(this);
        tf3.addActionListener(this);
       
        
        
     
        }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new StudentDa();
		ArrayList<Students> al =new ArrayList<Students>();
		
		

	}
	public void reset()
	{
		tf1.setText("");
		tf2.setText("");
		tf3.setText("");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == b1)
		{
			
			String roll = tf1.getText();
			 int rollno=Integer. parseInt(roll);
			 String name = tf2.getText();
			 String mark =tf3.getText();
		     double marks=Double.parseDouble(mark);
			 Students s=new Students(rollno,name,marks);
			 al.add(s);
			 reset();
			 
		}
		if(e.getSource() == b2)
		{
			tf4.setText("");
			int size=al.size();
			if(al.size()==0)
			{
				tf4.append("No Data to Show");
			}
			else {
		for(int i=0;i<al.size();i++) {
		tf4.append("Roll No: "+al.get(i).getRoll()+" Name: "+al.get(i).getName()+" Marks: "+al.get(i).getMarks());
		tf4.append("\n");
		}
			
			}
			
		}
		if(e.getSource() == b3)
		{
			String data = (String) r.getItemAt(r.getSelectedIndex());  
			if(data=="Roll No")
			{
				 Collections.sort(al, Students.StuRollno);
				
			}
			else if(data=="Name"){
				 Collections.sort(al, Students.StuNameComparator);
				
			}
			else if(data=="Marks") {
				 Collections.sort(al, Students.Stumarks);
				
			}
			tf4.setText("Sorted Data Acc to "+data+": \n");
			int size=al.size();
			if(al.size()==0)
			{
				tf4.append("No Data to Show");
			}
			else {
		for(int i=0;i<al.size();i++) {
		tf4.append("Roll No: "+al.get(i).getRoll()+" Name: "+al.get(i).getName()+" Marks: "+al.get(i).getMarks());
		tf4.append("\n");
		}
			
			}
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

}
