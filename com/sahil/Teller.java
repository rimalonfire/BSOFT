package com.sahil;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Teller extends JFrame {
    public JTextField accountNumberField;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_3;
    private JButton EnterBtn;
    private JTextField firstField;
    private JTextField middleField;
    private JTextField lastField;
    public  Long acc_no;

    public Teller() {

        setAlwaysOnTop(true);
        itscustomerdetailframe();
    }
    public Long getaccno()
    {
        return acc_no;
    }
    public void itscustomerdetailframe() {
        //code for frame
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("logIn");
        setUndecorated(true);
        setResizable(false);
        setBounds(100, 100, 723, 498);

        //panel1 and panel2 is made to separate the frame and required components are inserted
        JPanel telpanel1 = new JPanel();
        telpanel1.setSize(new Dimension(200,800));

        telpanel1.setBackground(new Color(0, 153, 153));
        getContentPane().add(telpanel1);
        telpanel1.setLayout(null);

        JPanel telpanel2 = new JPanel();
        telpanel2.setBackground(new Color(0, 102, 153));
        telpanel2.setLayout(null);
        getContentPane().add(telpanel2);

        JLabel telicon = new JLabel();
        telicon.setIcon(new ImageIcon("C:\\Users\\adarsha\\Desktop\\LOGOTELLER.png"));
        telicon.setBounds(10, 271, 180, 185);
        telpanel1.add(telicon);



        JLabel tellabel1 =new JLabel("CUSTOMER DETAILS", SwingConstants.CENTER);
        tellabel1.setForeground(Color.WHITE);
        tellabel1.setFont(new Font("Serif", Font.BOLD,30));
        telpanel2.add(tellabel1);

        lblNewLabel_1 = new JLabel("CUSTOMER DETAILS");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 40));
        lblNewLabel_1.setBounds(237, 48, 437, 58);
        telpanel2.add(lblNewLabel_1);

  /*
txtEnterName.addFocusListener(new FocusListener() {

	@Override
	public void focusLost(FocusEvent arg0) {
		if(txtEnterName.getText().equals("")) {
			txtEnterName.setText("ENTER NAME");
			}

	}

	@Override
	public void focusGained(FocusEvent arg0) {
		if(txtEnterName.getText().equals("ENTER NAME")) {
			txtEnterName.setText("");
			}

	}
});

*/


        JLabel warningText = new JLabel("");
        warningText.setFont(new Font("Monotype Corsiva", Font.PLAIN, 15));
        warningText.setForeground(Color.WHITE);
        warningText.setBounds(237, 337, 218, 14);
        telpanel2.add(warningText);

        accountNumberField = new JTextField(20);
        accountNumberField.setForeground(new Color(255, 255, 255));
        accountNumberField.setBackground(new Color(0, 102, 153));
        accountNumberField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent eee) {
                char  c= eee.getKeyChar();
                if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE )) {
                    eee.consume();
                    warningText.setText("****Please enter the numeric value***");
                }
                if((Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE )) {
                    warningText.setText("");
                }
            }
        });
        accountNumberField.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 17));
        //accountNumber.setText("ENTER ACC NUM");
        accountNumberField.setBounds(337, 363, 247, 37);
        accountNumberField.setBorder(new LineBorder(new Color(255, 255, 255)));
        telpanel2.add(accountNumberField);
        accountNumberField.setColumns(10);





        lblNewLabel_3 = new JLabel("ACC. NUM:");
        lblNewLabel_3.setFont(new Font("Sylfaen", Font.PLAIN, 22));
        lblNewLabel_3.setForeground(Color.WHITE);
        lblNewLabel_3.setBounds(204, 370, 121, 26);
        telpanel2.add(lblNewLabel_3);

        EnterBtn = new JButton("ENTER");
        EnterBtn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
        EnterBtn.setForeground(new Color(0, 102, 153));
        EnterBtn.setBackground(Color.LIGHT_GRAY);
        EnterBtn.setBounds(329, 419, 109, 37);
        telpanel2.add(EnterBtn);

        firstField = new JTextField();
        firstField.setForeground(new Color(255, 255, 255));
        firstField.setFont(new Font("Segoe UI Semilight", Font.ITALIC, 17));
        firstField.setBackground(new Color(0, 102, 153));
        firstField.setBounds(337, 197, 247, 37);
        firstField.setBorder(new LineBorder(new Color(255, 255, 255)));
        telpanel2.add(firstField);
        firstField.setColumns(10);

        middleField = new JTextField();
        middleField.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 17));
        middleField.setForeground(new Color(255, 255, 255));
        middleField.setBackground(new Color(0, 102, 153));
        middleField.setBorder(new LineBorder(new Color(255, 255, 255)));
        middleField.setBounds(337, 248, 247, 37);
        telpanel2.add(middleField);
        middleField.setColumns(10);

        lastField = new JTextField();
        lastField.setFont(new Font("Segoe UI Semilight", Font.ITALIC, 17));
        lastField.setForeground(new Color(255, 255, 255));
        lastField.setBackground(new Color(0, 102, 153));
        lastField.setBorder(new LineBorder(new Color(255, 255, 255)));
        lastField.setBounds(337, 297, 247, 37);
        telpanel2.add(lastField);
        lastField.setColumns(10);

        JLabel firstNamelbl = new JLabel("First Name:");
        firstNamelbl.setForeground(Color.WHITE);
        firstNamelbl.setFont(new Font("Sylfaen", Font.PLAIN, 22));
        firstNamelbl.setBounds(206, 207, 121, 26);
        telpanel2.add(firstNamelbl);

        JLabel middleNamelbl = new JLabel("Middle Name:");
        middleNamelbl.setForeground(Color.WHITE);
        middleNamelbl.setFont(new Font("Sylfaen", Font.PLAIN, 21));
        middleNamelbl.setBounds(206, 257, 136, 28);
        telpanel2.add(middleNamelbl);

        JLabel lastNamelbl = new JLabel("Last Name:");
        lastNamelbl.setForeground(Color.WHITE);
        lastNamelbl.setFont(new Font("Sylfaen", Font.PLAIN, 22));
        lastNamelbl.setBounds(206, 307, 121, 27);
        telpanel2.add(lastNamelbl);

        JButton ExitButton = new JButton("Exit");
        ExitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dispose();
            }
        });
        ExitButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
        ExitButton.setForeground(new Color(0, 102, 153));
        ExitButton.setBounds(484, 419, 125, 37);
        telpanel2.add(ExitButton);

        JLabel lblNewLabel_2 = new JLabel("Enter Customer's");
        lblNewLabel_2.setBounds(217, 151, 252, 31);
        telpanel2.add(lblNewLabel_2);
        lblNewLabel_2.setFont(new Font("Sylfaen", Font.PLAIN, 30));
        lblNewLabel_2.setForeground(Color.WHITE);




        EnterBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ee) {
                String firstname = firstField.getText();
                String lastname= lastField.getText();
                if ((accountNumberField.getText().equals("")) && firstname.equals("") && lastname.equals("")) {
                    JOptionPane.showMessageDialog(Teller.this, String.format("PLEASE ENTER NAME AND ACCOUNT NUMBER"));
                    firstField.requestFocus();

                }
                else if (accountNumberField.getText().equals("")) {
                    JOptionPane.showMessageDialog(Teller.this, String.format("PLEASE ENTER ACCOUNT NUMBER"));
                    accountNumberField.requestFocus();
                }
                else if(firstname.equals("") && lastname.equals("")) {
                    JOptionPane.showMessageDialog(Teller.this, String.format("PLEASE ENTER THE NAME"));
                    firstField.requestFocus();
                }
                else if(firstname.equals("")) {
                    JOptionPane.showMessageDialog(Teller.this, String.format("PLEASE ENTER FIRST NAME"));
                    firstField.requestFocus();
                }
                else if(lastname.equals("")) {
                    JOptionPane.showMessageDialog(Teller.this, String.format("PLEASE ENTER LAST NAME"));
                    lastField.requestFocus();
                }

                else {

                    checkAccountNumber();
                }
            }
        });


        //verify account holder






        setVisible(true);

    }




    public void checkAccountNumber() {
        try {
            System.out.println("entering the check");
            String firstname = firstField.getText();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientdatabase", "root", "");
            int accountnumber=Integer.parseInt(accountNumberField.getText());
            PreparedStatement pst2 = con.prepareStatement
                    ("Select ClientFirstName FROM clientpersonalinfo where isDeleted='0' AND AccountNum='"+accountnumber+"'");
            ResultSet rst2 =pst2.executeQuery();

//			 while(!rst2.next()) {
//	        	  JOptionPane.showMessageDialog(Teller.this, String.format("Account Number is invalid"));
//	        	  break;
//	          }

            if (rst2.next()) {
                System.out.println("entered the while loop" + rst2.getString("ClientFirstName"));

                if (firstname.equals(rst2.getString("ClientFirstName"))) {
                    Teller2 ts = new Teller2(accountnumber);
                    System.out.println("successful !!");
                }
                else {
                    JOptionPane.showMessageDialog(Teller.this, String.format("First name doesn't match with the provided acc number"));
                }
            }
            else {
                JOptionPane.showMessageDialog(Teller.this, String.format("Please provide valid information"));
            }

        }catch(Exception e) {
            System.out.println("Exception occured");
        }
    }
}