import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.text.*;


class PatientAddIn extends JFrame implements ActionListener
{

    JLabel lmain,lpi,lname,ladd,ltel,lmi,lbg,ldob,lhis,lcur,lpno,lroom,ldate,lgender,lrtype,licu,ldtip,ldtip2,ldocname,ldateadd;
    JTextField tfname,tftel,tfdob,tficu,tfpno,tfroom,tfdocname;
    TextArea taadd,tahis,tacur;
    Choice chbg,chrt;
    CheckboxGroup cbmf;
    Checkbox cbm,cbf;
    JButton bsub,bclr,bback,bhome;
    String name1,tel,dob,pno,room,dateadd,docname,add,cur,bloodgp,rt;
    int hrs;
        String dialogmessage;
    String dialogs;
     int dialogtype = JOptionPane.PLAIN_MESSAGE;
     String name;



PatientAddIn(String x)
{
    super("Logged in as " +x);
    name=x;
    setSize(1024,768);
    setVisible(true);
    setLayout(null);
    
// PERSONAL INFORMATION

    lmain=new JLabel("Add Patient Information");
    lmain.setBounds(40,40,160,15);
    add(lmain);
    
    lname=new JLabel("Name :");
    lname.setBounds(104,97,70,25);
    add(lname);

    tfname=new JTextField(30);
    tfname.setBounds(270,97,250,20);
    add(tfname);

    ladd=new JLabel("Address :");
    ladd.setBounds(104,138,70,15);
    add(ladd);

    taadd=new TextArea();
    taadd.setBounds(270,138,250,100);
    add(taadd);

    licu=new JLabel("ICU Hours :");
    licu.setBounds(575,138,75,25);
    add(licu);
    
    tficu=new JTextField(30);
    tficu.setBounds(665,138,250,20);
    add(tficu); 

    lpno=new JLabel("Patient No.:");
    lpno.setBounds(570,97,70,25);
    add(lpno);


    tfpno=new JTextField(30);
    tfpno.setBounds(643,97,50,20);
    add(tfpno);

    lroom=new JLabel("Room No.:");
    lroom.setBounds(720,97,60,20);
    add(lroom);

    tfroom=new JTextField(30);
    tfroom.setBounds(788,97,60,20);
    add(tfroom);
    
    
    ldate=new JLabel("Date Of Admission :");
    ldate.setBounds(575,180,120,25);
    add(ldate);
    
    try
        {
        Calendar cal=Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        df.setLenient(false);  
         dateadd=df.format(cal.getTime());
        

        ldateadd=new JLabel(dateadd);
        ldateadd.setBounds(696,180,80,25);
        add(ldateadd);

    
        }
        catch (Exception e)
            {
                
            }
            
    ldtip2=new JLabel("(dd-mm-yyyy)");
    ldtip2.setBounds(782,180,100,25);
    add(ldtip2);

    
    lgender=new JLabel("Gender :");
    lgender.setBounds(596,223,50,15);
    add(lgender);


    
    cbmf=new CheckboxGroup();
    cbm=new Checkbox("Male",cbmf,true);
    cbf=new Checkbox("Female",cbmf,false);
    cbm.setBounds(698,223,50,15);
    add(cbm);
    cbf.setBounds(760,223,60,15);
    add(cbf);
    
    

    // End of personal information
    
    //Medical Information

    lmi=new JLabel("Add Medical Information");
    lmi.setBounds(40,268,160,15);
    add(lmi);
    
    lbg=new JLabel("Blood Group :");
    lbg.setBounds(104,306,79,15);
    add(lbg);

    chbg=new Choice();
    chbg.setBounds(270,306,53,15);
    chbg.addItem("A -ve");
    chbg.addItem("A +ve");
    chbg.addItem("B -ve");
    chbg.addItem("B +ve");
    chbg.addItem("AB -ve");
    chbg.addItem("AB +ve");
    chbg.addItem("O +ve");
    chbg.addItem("O -ve");
    add(chbg);
    
    ldob=new JLabel("Date of Birth :");
    ldob.setBounds(575,306,120,15);
    add(ldob);

    tfdob=new JTextField(15);
    tfdob.setBounds(696,305,80,20);
    add(tfdob);


    ldtip=new JLabel("(dd-mm-yyyy)");
    ldtip.setBounds(782,305,100,20);
    add(ldtip);

    lhis=new JLabel("History :");
    lhis.setBounds(104,365,50,15);
    add(lhis);

    tahis=new TextArea();
    tahis.setBounds(270,365,250,100);
    add(tahis);

    lcur=new JLabel("Current Problem :");
    lcur.setBounds(575,365,100,15);
    add(lcur);

    tacur=new TextArea();
    tacur.setBounds(720,365,250,100);
    add(tacur);     

    
    ldocname=new JLabel("Attending Doctor :");
    ldocname.setBounds(575,510,130,15);
    add(ldocname);

    tfdocname=new JTextField(100);
    tfdocname.setBounds(720,510,250,20);
    add(tfdocname);

        
    lrtype=new JLabel("Type Of Room : ");
    lrtype.setBounds(104,510,120,25);
    add(lrtype);

    chrt=new Choice();
    chrt.setBounds(270,510,80,15);
    //chrt.addItem("Deluxe");
    chrt.addItem("Private");
    chrt.addItem("Semi-Private");
    chrt.addItem("General");
    add(chrt);

//End of medical Information
   bhome=new JButton("HOME",new ImageIcon("images/branch.png"));
    bhome.setBounds(580,643,100,30);
    add(bhome);
    
    bsub=new JButton("ADD",new ImageIcon("images/add.gif"));
    bsub.setBounds(250,643,100,30);
    add(bsub);  

    bclr=new JButton("CLEAR",new ImageIcon("images/LOGGOFF.PNG"));
    bclr.setBounds(360,643,100,30);
    add(bclr);

    bback=new JButton("BACK",new ImageIcon("images/restore.png"));
    bback.setBounds(470,643,100,30);
    add(bback); 

    bclr.addActionListener(new clear());
    bsub.addActionListener(new submit());
    bback.addActionListener(new back());
    bhome.addActionListener(new home());

    Calendar cal=Calendar.getInstance();
    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");


    
}

//End of constructor

    

public void actionPerformed(ActionEvent ae)
    {}
    
/*public static void main(String[] args)
    {
     String n="xyz";
        new PatientAdd(n);
        
    }*/



class clear implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {

            tfname.setText("");
            tftel.setText("");
            tfdob.setText("");
            taadd.setText("");
            tahis.setText("");
            tacur.setText("");
            tfpno.setText("");
            tfroom.setText("");
        }
    }


class back implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            new PatOptionsIn(name);
            setVisible(false);
        }
    }
    
    class home implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            new Input(name);
            setVisible(false);
        }
    }


  
class submit implements ActionListener
{
    
    public void actionPerformed(ActionEvent ae)
    {
    
      name1=tfname.getText().trim();
      //tel=tftel.getText().trim();
      dob=tfdob.getText().trim();
      pno=tfpno.getText().trim();
      room=tfroom.getText();
      docname=tfdocname.getText().trim();
      add=taadd.getText().trim();
      cur=tacur.getText().trim();
      bloodgp=(String)chbg.getSelectedItem();
      rt=(String)chrt.getSelectedItem();
      hrs = Integer.parseInt(tficu.getText().trim());
      if((name1.equals(""))||(dob.equals(""))||(pno.equals(""))||(room.equals(""))||(docname.equals(""))||(add.equals(""))||(cur.equals("")))
      {
       new ErrorDialog1();
      }
      else
      {
        //String message = "Patient Added Sucessfully";
         //JOptionPane.showMessageDialog(new JFrame(), message, "DONE!!!",
         //JOptionPane.ERROR_MESSAGE);
         
          int rm = 0;
         if(rt.equals("Private"))
            rm = 10;
         else if(rt.equals("Semi-Private"))
            rm = 5;
            else if(rt.equals("General"))
            rm = 1;
                        
          try
          {
              DRNODE doc = new DrAvai().searchDocByName(docname);
              int id = doc.regno;
          String message = new addIP().addNew(name1,cur,Integer.parseInt(pno),id,dateadd,hrs,rm);
         JOptionPane.showMessageDialog(new JFrame(), message, "DONE!!!", JOptionPane.INFORMATION_MESSAGE);
                  new PatOptionsIn(name);
         setVisible(false);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(new JFrame(),"Doctor not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
         //(name,name1,tel,dob,pno,room,dateadd,docname,add,cur,bloodgp,rt)
         
      }
     }
    }
    
        }       
        






