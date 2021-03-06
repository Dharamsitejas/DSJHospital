import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class DoctorDetails extends JFrame implements ActionListener
{
 JLabel ldid;
 JButton bsub,bback,bclr;
 JTextField tfdid;
 String did;
 String name;
 
 DoctorDetails(String x)
 {
  super("Logged in as " +x);
  name=x;
  setSize(400,400);
  setVisible(true);
  setLayout(null);

  ldid=new JLabel("Enter Doctor Id");
  ldid.setBounds(100,100,180,20);
  add(ldid);
  
  tfdid=new JTextField(30);
  tfdid.setBounds(200,100,100,20);
  add(tfdid);
  
  bclr=new JButton("CLEAR",new ImageIcon("images/LOGGOFF.PNG"));
  bclr.setBounds(160,180,100,30);
  add(bclr);
  
  bsub=new JButton("Submit",new ImageIcon("images/backup.png"));
  bsub.setBounds(100,220,100,30);
  add(bsub);
  
  bback=new JButton("BACK",new ImageIcon("images/restore.png"));
  bback.setBounds(220,220,100,30);
  add(bback);
  
  bclr.addActionListener(new clear());
  bsub.addActionListener(new submit());
  bback.addActionListener(new back());

 }
 
 public void actionPerformed(ActionEvent ae)
        {}

    class back implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            new  ViewDoctorOptions(name);
            setVisible(false);
        }
    }
    
    class clear implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {

            tfdid.setText("");
        }
    }


  class submit implements ActionListener
  {
        public void actionPerformed(ActionEvent ae)
            {
         did=tfdid.getText().trim();
         if(did.equals(""))
         {
          new ErrorDialog1();
         }
         else
         {
             try
             {
             LoadDoc load = new LoadDoc();
             DRNODE doc = new DrAvai().searchDocById(Integer.parseInt(did));
             if(doc != null)
             {
             new DoctorDisplay(name,doc.name,(doc.regno+""),(doc.hrs+""),doc.speciality,doc.qualific,doc.salary+ "");
             setVisible(false);
            }
            else
            {
                JOptionPane.showMessageDialog(new JFrame(), "Doctor not found", "SORRY", JOptionPane.ERROR_MESSAGE);
            }
        }
            catch(Exception e)
            {
            }
     }
    }
    
    /*public static void main(String args[])
    {
     String n="xyz";
     new DoctorDetails(n);
    }*/
   }

  

}
