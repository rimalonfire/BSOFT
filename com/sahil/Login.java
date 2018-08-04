package com.sahil;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Login extends JFrame
{
    public JTextField loginusernametextfield;
    public JPasswordField loginpasswordtextfield;
    public JButton loginexitbtn1;
    public JButton loginbtn1;
    public Login() {
        setAlwaysOnTop(true);
        setTitle("LogIn");
        setResizable(false);
        getContentPane().setBackground(new Color(51, 102, 153));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 490);
        getContentPane().setLayout(null);
        JPanel subPanel = new JPanel();
        subPanel.setBackground(new Color(0, 153, 153));
        subPanel.setBounds(0, 0, 192, 458);
        getContentPane().add(subPanel);
        subPanel.setLayout(null);

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("B:\\B-Soft Source\\loginphoto.jpg"));
        lblNewLabel.setBounds(10, 84, 125, 152);
        subPanel.add(lblNewLabel);

        JLabel lblBsoft = new JLabel("Bsoft");
        lblBsoft.setForeground(new Color(255, 255, 255));
        lblBsoft.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblBsoft.setBounds(38, 247, 97, 33);
        subPanel.add(lblBsoft);

        JLabel lblLogIn = new JLabel("Log In");
        lblLogIn.setForeground(new Color(255, 255, 255));
        lblLogIn.setFont(new Font("Sylfaen", Font.PLAIN, 50));
        lblLogIn.setBounds(365, 60, 171, 61);
        getContentPane().add(lblLogIn);

        loginusernametextfield = new JTextField();
        loginusernametextfield.setFont(new Font("Tahoma", Font.ITALIC, 14));
        loginusernametextfield.setText("");
        loginusernametextfield.setBackground(new Color(51, 102, 153));
        loginusernametextfield.setForeground(new Color(255, 255, 255));
        loginusernametextfield.setBounds(320, 190, 204, 18);
        loginusernametextfield.setBorder(null);
        getContentPane().add(loginusernametextfield);
        loginusernametextfield.setColumns(10);
        loginusernametextfield.hasFocus();

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblPassword.setBounds(313, 230, 155, 34);
        getContentPane().add(lblPassword);

        loginbtn1 = new JButton("LOGIN");
        loginbtn1.setForeground(new Color(0, 102, 153));
        loginbtn1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        loginbtn1.setBounds(370, 378, 100, 35);
        getContentPane().add(loginbtn1);

        loginexitbtn1 = new JButton("EXIT");
        loginexitbtn1.setForeground(new Color(0, 102, 153));
        loginexitbtn1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        loginexitbtn1.setBounds(494, 378, 100, 35);
        getContentPane().add(loginexitbtn1);

        JSeparator separator = new JSeparator();
        separator.setBounds(313, 210, 225, 2);
        getContentPane().add(separator);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(313, 290, 225, 2);
        getContentPane().add(separator_1);

        JLabel lblEmmployId = new JLabel("Username");
        lblEmmployId.setForeground(Color.WHITE);
        lblEmmployId.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblEmmployId.setBounds(307, 150, 161, 34);
        getContentPane().add(lblEmmployId);

        loginpasswordtextfield = new JPasswordField();
        loginpasswordtextfield.setBackground(new Color(51, 102, 153));
        loginpasswordtextfield.setToolTipText("");
        loginpasswordtextfield.setFont(new Font("Tahoma", Font.PLAIN, 14));
        loginpasswordtextfield.setForeground(new Color(255, 255, 255));
        loginpasswordtextfield.setBounds(320, 270, 225, 20);
        loginpasswordtextfield.setText("");
        loginpasswordtextfield.setBorder(null);
        getContentPane().add(loginpasswordtextfield);
        loginbtn1.addActionListener(this::actionPerformed);
        loginexitbtn1.addActionListener(this::actionPerformed);
    }
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        if (command.equals("LOGIN")) {
            String tempusername = loginusernametextfield.getText();
            String temppassword = loginpasswordtextfield.getText();

            if (loginusernametextfield.getText().equals("") && loginpasswordtextfield.getText().equals("")) {

                JOptionPane.showMessageDialog(Login.this, String.format("Username and Password field left empty"),"All fields left empty",JOptionPane.ERROR_MESSAGE);
                loginusernametextfield.requestFocus();//sets the focus back to username field
            } else if (tempusername.equals("")) {
                JOptionPane.showMessageDialog(Login.this, String.format("Username field left empty"),"Username Empty",JOptionPane.ERROR_MESSAGE);
                loginusernametextfield.requestFocus();// sets the focus back to username field
            } else if (temppassword.equals("")) {
                JOptionPane.showMessageDialog(Login.this, String.format("Password field left empty"),"Password Empty",JOptionPane.ERROR_MESSAGE);
                loginpasswordtextfield.requestFocus();// sets the focus back to password field

            } else {
                LoginSqlConnection msc = new LoginSqlConnection();
                int returnvalue;
                returnvalue = msc.authenticateemployees(getusername(), getpassword());
                switch (returnvalue) {
                    case 1:
                        admin adn = new admin();
                        setVisible(false);
                        break;
                    case 2:
                        Manager mgr = new Manager();
                        setVisible(false);
                        break;
                    case 3:
                        Teller tllr = new Teller();
                        setVisible(false);
                        break;
                    case 4:
                        SystemAdmin san = new SystemAdmin();
                        san.setVisible(true);
                        setVisible(false);
                        break;
                    case 5:
                        CustomerService cse = new CustomerService();
                        cse.setVisible(true);
                        setVisible(false);
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(Login.this, String.format("Username/Password incorrect"),"Incorrect Username/Passowrd",JOptionPane.ERROR_MESSAGE);
                        loginpasswordtextfield.setText("");
                        loginusernametextfield.setText("");
                        loginusernametextfield.requestFocus();
                }
            }
        }
    }
    public String getusername()
    {
        return loginusernametextfield.getText();
    }
    public String getpassword()
    {
        return loginpasswordtextfield.getText();
    }
}
