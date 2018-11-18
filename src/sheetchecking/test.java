/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sheetchecking;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.*;

public class test extends JFrame{
    private String msg;
    private DataAccess dt;
    private int x,y,m;
    public TextField tf;
        public test(DataAccess da,int mark,String id){
               
		super("Java Demo");
                x=200;y=100;
                this.m=mark;
		Button b=new Button("Add Contact to DB");
                Label n=new Label("mark");
                msg="Frame is created";
                add(n);
                add(b);
                ButtonSensor bs = new ButtonSensor(this, da,b,mark,id);
                b.addActionListener(bs);
                setSize(400,400);
		setLayout(new FlowLayout());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
        public void paint(Graphics g){
                
		g.setColor(Color.RED);
	        g.drawString(String.valueOf(m),x,y);
	}
}
        

        
        class ButtonSensor implements ActionListener
        {
            DataAccess da;
            test acf;
            Button b;
            int m;
            String i;
            public ButtonSensor(test acf, DataAccess da,Button b1,int mark,String id)
            {
		this.acf = acf;
                this.da = da;
                this.b=b1;
                this.m=mark;
                this.i=id;
            }

            public void actionPerformed(ActionEvent ae)
            {
                 Button c=(Button)ae.getSource();
                 if(c==b){
		 String q="UPDATE `student` SET `Mark`="+m+" where id='012345678'";
                 int c1=da.updateDB(q);
                 }
            }
        }
