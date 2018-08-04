package com.sahil;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SystemAdmin extends JFrame implements ActionListener {

    private JPanel systemadminframepanel;
    private JPanel systemadmincreateIDpanel;
    private JTextField systemadminemployeeIDtextfield;
    private JTable systemadminemployeetable;
    private JPanel systemadminsearchframepanel;
    private JLabel systemadminsearchlabel;
    private JSeparator searchSeparator;
    private JSeparator tableSeperator;
    private JButton systemadminlogoutbutton;
    private JButton systemadmincreateusernamebutton;
    private JButton systemadminsearchbutton;
    public SystemAdmin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 745, 541);
        systemadminframepanel = new JPanel();
        systemadminframepanel.setLayout(null);
        setContentPane(systemadminframepanel);
        systemadminframepanel.setLayout(null);
        systemadmincreateIDpanel = new JPanel();
        systemadminframepanel.add(systemadmincreateIDpanel);
        systemadmincreateIDpanel.setLayout(null);
        systemadmincreateIDpanel.setBounds(00, 00, 745, 541);
        systemadmincreateIDpanel.setBackground(new Color(0, 102, 153));
        systemadminsearchframepanel = new JPanel();
        systemadminsearchframepanel.setBackground(new Color(0, 153, 153));
        systemadminsearchframepanel.setBounds(0, 0, 236, 501);
        systemadmincreateIDpanel.add(systemadminsearchframepanel);
        systemadminsearchframepanel.setLayout(null);
        systemadminsearchlabel = new JLabel("Search");
        systemadminsearchlabel.setBounds(44, 33, 163, 62);
        systemadminsearchframepanel.add(systemadminsearchlabel);
        systemadminsearchlabel.setForeground(new Color(255, 255, 255));
        systemadminsearchlabel.setFont(new Font("Sylfaen", Font.PLAIN, 50));
        systemadminsearchbutton = new JButton("Search");
        systemadminsearchbutton.setForeground(new Color(0, 153, 153));
        systemadminsearchbutton.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
        systemadminsearchbutton.setBounds(111, 322, 119, 35);
        systemadminsearchframepanel.add(systemadminsearchbutton);
        JLabel labelEmployeeID = new JLabel("Employee ID :");
        labelEmployeeID.setBounds(10, 221, 191, 34);
        systemadminsearchframepanel.add(labelEmployeeID);
        labelEmployeeID.setForeground(Color.WHITE);
        labelEmployeeID.setFont(new Font("Sitka Subheading", Font.PLAIN, 30));
        systemadminemployeeIDtextfield = new JTextField();
        systemadminemployeeIDtextfield.setBounds(10, 279, 210, 28);
        systemadminsearchframepanel.add(systemadminemployeeIDtextfield);
        systemadminemployeeIDtextfield.setText("Employee  ID");
        systemadminemployeeIDtextfield.setForeground(new Color(0, 102, 153));
        systemadminemployeeIDtextfield.setFont(new Font("Tahoma", Font.ITALIC, 16));
        systemadminemployeeIDtextfield.setColumns(10);
        searchSeparator = new JSeparator();
        searchSeparator.setBounds(20, 84, 219, 2);
        systemadminsearchframepanel.add(searchSeparator);
        tableSeperator = new JSeparator();
        tableSeperator.setBounds(234, 438, 493, 2);
        systemadmincreateIDpanel.add(tableSeperator);
        systemadminlogoutbutton = new JButton("Log out");
        systemadminlogoutbutton.setForeground(new Color(0, 102, 153));
        systemadminlogoutbutton.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
        systemadminlogoutbutton.setBounds(599, 452, 101, 35);
        systemadmincreateIDpanel.add(systemadminlogoutbutton);

        systemadmincreateusernamebutton = new JButton("Create Username");
        systemadmincreateusernamebutton.setBounds(407, 454, 170, 35);
        systemadmincreateIDpanel.add(systemadmincreateusernamebutton);
        systemadmincreateusernamebutton.setForeground(new Color(0, 102, 153));
        systemadmincreateusernamebutton.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
        systemadminemployeetable = new JTable();
        systemadminemployeetable.setBounds(248, 11, 470, 415);
        systemadmincreateIDpanel.add(systemadminemployeetable);
        systemadminsearchbutton.addActionListener(this);
        systemadminlogoutbutton.addActionListener(this);
        systemadmincreateusernamebutton.addActionListener(this);

        showallintable();
    }
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeelogindatabase", "root", "");
        } catch (Exception ep) {
            ep.printStackTrace();
        }

        return connection;
    }
    public void showallintable()
    {

        try
        {
            Connection con=getConnection();
            PreparedStatement pst=con.prepareStatement("Select * from employeelogintable");
            ResultSet rst=pst.executeQuery();
            systemadminemployeetable.setModel(DbUtils.resultSetToTableModel(rst));
            rst.close();
            con.close();

        }
        catch (Exception ep)
        {
            ep.printStackTrace();
        }
    }
    public void actionPerformed(ActionEvent ae)
    {
        String command=ae.getActionCommand();
        if(command.equals("Search"))
        {
            if(systemadminemployeeIDtextfield.getText().equals(""))
            {
                JOptionPane.showMessageDialog(SystemAdmin.this,String.format("Employee ID textfield left empty"));
                systemadminemployeeIDtextfield.requestFocus();
            }
            else
            {   try {
                Connection con = getConnection();
                int tempemployeeID = Integer.parseInt(systemadminemployeeIDtextfield.getText());
                PreparedStatement pst = con.prepareStatement("Select * from employeelogintable where EmployeeID='" + tempemployeeID + "'");
                ResultSet rst1 = pst.executeQuery();
                    systemadminemployeetable.setModel(DbUtils.resultSetToTableModel(rst1));
                    systemadminemployeeIDtextfield.setText("");
                    systemadminemployeeIDtextfield.requestFocus();

                }
                catch (Exception ep)
                {
                    ep.printStackTrace();
                }
            }
        } else if(command.equals("Log out"))
        {
            int confirmlogout=JOptionPane.showConfirmDialog(this,"Are you sure you want to Log Out?");
            if(confirmlogout==JOptionPane.YES_OPTION)
            {
            setVisible(false);
            Login ln=new Login();
            ln.setVisible(true);
            }
            else if(confirmlogout==JOptionPane.CANCEL_OPTION)
            {
                systemadminemployeeIDtextfield.setText("");
                showallintable();
                systemadminemployeeIDtextfield.requestFocus();

            }
        }
        else
        {
            JTextField employeeusername = new JTextField();
            JTextField employeepassword = new JTextField();
            JComboBox employeetype=new JComboBox();
            employeetype.addItem("Manager");
            employeetype.addItem("Teller");
            employeetype.addItem("Customer Service");
            employeetype.addItem("System Admin");
            JTextField employeename=new JTextField();
            JTextField employeecontactnum=new JTextField();
            JTextField employeeaddress=new JTextField();
            //JLabel errorlabel=new JLabel("No Error");
            Object[] systemadminregistrationcomponents = {
              //      "Error Label",errorlabel,
                    "Username:", employeeusername,
                    "Password:", employeepassword,
                    "Job type:",employeetype,
                    "Name:",employeename,
                    "Contact Number:",employeecontactnum,
                    "Address:",employeeaddress
            };

            int option = JOptionPane.showConfirmDialog(null, systemadminregistrationcomponents, "Register Employee", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                String sh =employeetype.getItemAt(employeetype.getSelectedIndex()).toString();
                EmployeeSQLConnection esqlcon=new EmployeeSQLConnection();
                esqlcon.insertintodatabase(employeeusername.getText(),employeepassword.getText(),sh,employeename.getText(),employeeaddress.getText(),employeecontactnum.getText());
                JOptionPane.showMessageDialog(SystemAdmin.this,String.format("New Employee Registered"));
                showallintable();

            } else {
                System.out.println("Login canceled");
            }
        }
    }
}
