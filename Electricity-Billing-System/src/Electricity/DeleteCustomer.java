/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class DeleteCustomer extends JFrame implements ActionListener{ 
    JLabel l1,l2,l8;
    JTextField t1,t11,t2;
    JButton b1,b2;
    
    DeleteCustomer(){
        setLocation(600,200);
        setSize(700,500);
        
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.WHITE);
        p.setBackground(new Color(173,216,230));
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel title = new JLabel("Delete Customer");
        title.setBounds(180, 10, 200, 26);
        title.setFont(new Font("Tahoma", Font.PLAIN, 24));
        p.add(title);
        
        
        l2 = new JLabel("Meter No");
        l2.setBounds(100, 120, 100, 20);
        t11 = new JTextField();
        t11.setBounds(240, 120, 200, 20);
        p.add(l2);
        p.add(t11);
       
        b1 = new JButton("Delete");
        b1.setBounds(120, 390, 100, 25);
        b2 = new JButton("Cancel");
        b2.setBounds(250, 390, 100, 25);
        
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        p.add(b1);
        p.add(b2);
        setLayout(new BorderLayout());
        
        add(p,"Center");
        
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i3 = ic1.getImage().getScaledInstance(150, 300,Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(i3);
        l8 = new JLabel(ic2);
        
        
        add(l8,"West");
        //for changing the color of the whole Frame
        getContentPane().setBackground(Color.WHITE);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
    }
     public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String meter_no = t11.getText();
             try{
                int cnt = 0;
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from customer where meter='"+meter_no+"'");
                while(rs.next()){
                    cnt++;
                }
                if(cnt==0){JOptionPane.showMessageDialog(null,"MeterNo is not present in our database");}
                else{
                    c.s.executeUpdate("delete from customer where meter='"+meter_no+"'");
                    c.s.executeUpdate("delete from bill where meter='"+meter_no+"'");
                    c.s.executeUpdate("delete from meter_info where meter_number='"+meter_no+"'");
                    c.s.executeUpdate("delete from login where meter_no='"+meter_no+"'");
                    JOptionPane.showMessageDialog(null,"Deleted successfully");
                    this.setVisible(false);
                    this.dispose();
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Exception occured: "+e);
            }
        }
        if(ae.getSource()==b2){
            this.setVisible(false);
            this.dispose();
        }
     }

}
