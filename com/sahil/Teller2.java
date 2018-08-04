package com.sahil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Teller2 extends JFrame {
    private JTextField withdrawTextfield;
    private JTextField depositeTextfield;
    private JPanel telpanel2;
    private JLabel TellerSecondLabel1;
    private int received_acc_from_TellerFirst;


    public Teller2(int a) {
        received_acc_from_TellerFirst = a;
        setAlwaysOnTop(true);
        itstransactionframe();
        topinfo();
        itsotherdetail();
    }

    public void itstransactionframe() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("logIn");
        setUndecorated(true);
        setResizable(false);
        setBounds(100, 100, 723, 498);

        telpanel2 = new JPanel();
        telpanel2.setForeground(Color.GREEN);
        telpanel2.setBackground(new Color(51,102,153));
        telpanel2.setLayout(null);
        getContentPane().add(telpanel2);



        JLabel lblNewLabel = new JLabel("CHOOSE OPTION:");
        lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(236, 223, 128, 14);
        telpanel2.add(lblNewLabel);





        JLabel warningTextfiled = new JLabel("");
        warningTextfiled.setFont(new Font("Monotype Corsiva", Font.PLAIN, 15));
        warningTextfiled.setForeground(Color.WHITE);
        warningTextfiled.setBounds(326, 331, 304, 14);
        telpanel2.add(warningTextfiled);

        depositeTextfield = new JTextField();
        depositeTextfield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent eee) {
                char  c= eee.getKeyChar();
                if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE )) {
                    eee.consume();
                    warningTextfiled.setText("***Please enter the numeric value***");
                }
                if((Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE )) {
                    warningTextfiled.setText("");
                }
            }
        });
        depositeTextfield.setBounds(374, 286, 202, 29);
        depositeTextfield.setEnabled(false);
        telpanel2.add(depositeTextfield);
        depositeTextfield.setColumns(10);



        String[] option = { "SELECT","WITHDRAW", "DEPOSITE" };
        JComboBox comboBox = new JComboBox(option);
        comboBox.setBounds(374, 221, 202, 34);
        telpanel2.add(comboBox);





        Integer[] saal = new Integer[60];
        int ini=2018;
        for(int i=0;i<50;i++){
            saal[i]= ini;
            ini++;
        }



        Integer[] mahina = new Integer[12];
        int initi=1;
        for(int i=0;i<12;i++){
            mahina[i]= initi;
            initi++;
        }


        Integer[] din = new Integer[31];
        int init=1;
        for(int i=0;i<31;i++){
            din[i]= init;
            init++;
        }




        withdrawTextfield = new JTextField();
        withdrawTextfield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char  c= evt.getKeyChar();
                if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE )) {
                    evt.consume();
                    warningTextfiled.setText("***Please enter the numeric value***");
                }
                if((Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE )) {
                    warningTextfiled.setText("");
                }
            }
        });
        withdrawTextfield.setBounds(374, 347, 202, 29);
        withdrawTextfield.setColumns(10);
        withdrawTextfield.setEnabled(false);
        telpanel2.add(withdrawTextfield);



        JLabel lblWithdraw = new JLabel("WITHDRAW:");
        lblWithdraw.setForeground(Color.WHITE);
        lblWithdraw.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblWithdraw.setBounds(272, 358, 128, 14);
        telpanel2.add(lblWithdraw);

        JLabel depositeLabel = new JLabel("DEPOSITE:");
        depositeLabel.setForeground(Color.WHITE);
        depositeLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
        depositeLabel.setBounds(272, 297, 92, 14);
        telpanel2.add(depositeLabel);

        JButton btnDeposite = new JButton("DEPOSITE");

        btnDeposite.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
        btnDeposite.setForeground(new Color(0, 102, 153));
        btnDeposite.setBackground(Color.LIGHT_GRAY);
        btnDeposite.setBounds(448, 403, 128, 29);
        btnDeposite.setEnabled(false);
        telpanel2.add(btnDeposite);

        JButton btnWithdraw = new JButton("WITHDRAW");

        btnWithdraw.setBackground(Color.LIGHT_GRAY);
        btnWithdraw.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
        btnWithdraw.setForeground(new Color(0, 102, 153));
        btnWithdraw.setBounds(287, 403, 128, 29);
        telpanel2.add(btnWithdraw);
        btnWithdraw.setEnabled(false);

        JButton backBtn = new JButton("BACK");
        backBtn.setSelectedIcon(new ImageIcon("C:\\Users\\adarsha\\Desktop\\download.png"));
        backBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
        backBtn.setForeground(new Color(0, 102, 153));
        backBtn.setBounds(611, 463, 79, 29);
        telpanel2.add(backBtn);


        comboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getSource()==comboBox) {
                    if(comboBox.getSelectedItem().equals("WITHDRAW")) {
                        btnDeposite.setEnabled(false);
                        depositeTextfield.setEnabled(false);
                        btnWithdraw.setEnabled(true);
                        withdrawTextfield.setEnabled(true);

                    }

                    else if(comboBox.getSelectedItem().equals("DEPOSITE")) {
                        btnDeposite.setEnabled(true);
                        depositeTextfield.setEnabled(true);
                        btnWithdraw.setEnabled(false);
                        withdrawTextfield.setEnabled(false);

                    }
                    else if(comboBox.getSelectedItem().equals("SELECT")) {
                        btnDeposite.setEnabled(false);
                        depositeTextfield.setEnabled(false);
                        btnWithdraw.setEnabled(false);
                        withdrawTextfield.setEnabled(false);
                    }

                }

            }
        });


        btnWithdraw.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {



                if(comboBox.getSelectedItem().equals("WITHDRAW")) {
                    if(withdrawTextfield.getText().equals("")) {
                        JOptionPane.showMessageDialog(Teller2.this, String.format("PLEASE ENTER WITHDRAW AMOUNT"));
                        withdrawTextfield.requestFocus();
                    }
                }
                withdrawLogic();
            }
        });
        btnDeposite.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {



                if(comboBox.getSelectedItem().equals("DEPOSITE")) {

                    if(depositeTextfield.getText().equals("")) {
                        JOptionPane.showMessageDialog(Teller2.this, String.format("PLEASE ENTER DEPOSITE AMOUNT"));
                        depositeTextfield.requestFocus();
                    }
                }

                depositeLogic();
            }
        });



        backBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Teller tt = new Teller();
                dispose();

            }
        } );





        JButton btnExit = new JButton("EXIT");
        btnExit.setForeground(new Color(0, 102, 153));
        btnExit.setBounds(498, 461, 89, 31);
        btnExit.setBorderPainted(false);
        btnExit.setFocusPainted(false);
        telpanel2.add(btnExit);



        btnExit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                dispose();


            }
        });


        JLabel lblName = new JLabel("NAME:");
        lblName.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblName.setForeground(new Color(255, 255, 255));
        lblName.setBounds(10, 28, 53, 14);
        telpanel2.add(lblName);


        JLabel lblNewLabel_1 = new JLabel("DATE OF BIRTH:");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblNewLabel_1.setBounds(10, 78, 123, 14);
        telpanel2.add(lblNewLabel_1);


        JLabel lblSex = new JLabel("SEX:");
        lblSex.setForeground(Color.WHITE);
        lblSex.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblSex.setBounds(10, 133, 63, 14);
        telpanel2.add(lblSex);

        JLabel lblCity = new JLabel("CITY:");
        lblCity.setForeground(Color.WHITE);
        lblCity.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblCity.setBounds(10, 183, 63, 14);
        telpanel2.add(lblCity);

        JLabel lblContact = new JLabel("CONTACT:");
        lblContact.setForeground(Color.WHITE);
        lblContact.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblContact.setBounds(10, 241, 104, 14);
        telpanel2.add(lblContact);

        setVisible(true);
    }

    public void topinfo() {

        TellerSecondLabel1 = new JLabel();
        TellerSecondLabel1.setForeground(Color.WHITE);
        TellerSecondLabel1.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 34));
        TellerSecondLabel1.setBounds(261, 11, 452, 56);

        telpanel2.add(TellerSecondLabel1);



        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientdatabase", "root", "");
            PreparedStatement pst1 = con.prepareStatement
                    ("Select ClientAmount FROM clientpersonalinfo WHERE AccountNum='"+received_acc_from_TellerFirst+"'");
            ResultSet rst = pst1.executeQuery();

            while (rst.next()){
                float temp1 = rst.getFloat("ClientAmount");

                TellerSecondLabel1.setText("BALANCE : RS "+temp1);
            }
        }

        catch (Exception ep) {
            ep.printStackTrace();
        }




    }

    public void itsotherdetail() {

        try {
            JLabel ClientName = new JLabel();
            ClientName.setFont(new Font("Sylfaen", Font.ITALIC, 16));
            ClientName.setForeground(Color.WHITE);
            ClientName.setBounds(10, 53, 216, 14);
            telpanel2.add(ClientName);



            JLabel dob = new JLabel();
            dob.setForeground(Color.WHITE);
            dob.setFont(new Font("Sylfaen", Font.ITALIC, 16));
            dob.setBounds(10, 105, 155, 14);
            telpanel2.add(dob);



            JLabel sx = new JLabel();
            sx.setFont(new Font("Sylfaen", Font.ITALIC, 16));
            sx.setForeground(Color.WHITE);
            sx.setBounds(10, 162, 142, 14);
            telpanel2.add(sx);



            JLabel city = new JLabel();
            city.setForeground(Color.WHITE);
            city.setFont(new Font("Sylfaen", Font.ITALIC, 16));
            city.setBounds(10, 212, 155, 14);
            telpanel2.add(city);


            JLabel contact = new JLabel();
            contact.setForeground(Color.WHITE);
            contact.setFont(new Font("Sylfaen", Font.ITALIC, 16));
            contact.setBounds(10, 267, 169, 20);
            telpanel2.add(contact);

            JPanel panel = new JPanel();
            panel.setBackground(new Color(0, 153, 153));
            panel.setBounds(0, 0, 231, 498);
            telpanel2.add(panel);




            Class.forName("com.mysql.cj.jdbc.Driver");


            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientdatabase", "root", "");
            PreparedStatement pst1 = con.prepareStatement
                    ("Select ClientFirstName FROM clientpersonalinfo WHERE AccountNum='"+received_acc_from_TellerFirst+"'");
            PreparedStatement pst2 = con.prepareStatement
                    ("Select ClientMiddleName FROM clientpersonalinfo WHERE AccountNum='"+received_acc_from_TellerFirst+"'");
            PreparedStatement pst3 = con.prepareStatement
                    ("Select ClientLastName FROM clientpersonalinfo WHERE AccountNum='"+received_acc_from_TellerFirst+"'");
            PreparedStatement pst4 = con.prepareStatement
                    ("Select ClientDateofBirth FROM clientpersonalinfo WHERE AccountNum='"+received_acc_from_TellerFirst+"'");
            PreparedStatement pst5 = con.prepareStatement
                    ("Select ClientSex FROM clientpersonalinfo WHERE AccountNum='"+received_acc_from_TellerFirst+"'");
            PreparedStatement pst6 = con.prepareStatement
                    ("Select ClientCity FROM clientpersonalinfo WHERE AccountNum='"+received_acc_from_TellerFirst+"'");
            PreparedStatement pst7 = con.prepareStatement
                    ("Select ClientContactNum FROM clientpersonalinfo WHERE AccountNum='"+received_acc_from_TellerFirst+"'");


            ResultSet rst1 = pst1.executeQuery();
            ResultSet rst2 = pst2.executeQuery();
            ResultSet rst3 = pst3.executeQuery();
            ResultSet rst4 = pst4.executeQuery();
            ResultSet rst5 = pst5.executeQuery();
            ResultSet rst6 = pst6.executeQuery();
            ResultSet rst7 = pst7.executeQuery();
            while(rst1.next() && rst2.next() && rst3.next()) {
                System.out.println("after  while loop");
                String firstname = rst1.getString("ClientFirstName");
                String middlename = rst2.getString("ClientMiddleName");
                String lastname = rst3.getString("ClientLastName");
                ClientName.setText(firstname+" "+middlename+" "+lastname);
            }
            while(rst4.next()) {
                Date dateofbirth = rst4.getDate("ClientDateofBirth");
                String dobs = dateofbirth.toString();
                dob.setText(dobs);
            }
            while(rst5.next()) {
                String sex = rst5.getString("ClientSex");
                sx.setText(sex);

            }
            while(rst6.next()) {
                String cty = rst6.getString("ClientCity");
                city.setText(cty);
            }
            while(rst7.next()) {
                Long cntc = rst7.getLong("ClientContactNum");
                String cn = cntc.toString();
                contact.setText(cn);
            }
        }

        catch (Exception ep) {
            ep.printStackTrace();
        }


    }


    public void withdrawLogic() {


        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientdatabase", "root", "");
            float withamount=Float.parseFloat(withdrawTextfield.getText());
            PreparedStatement pst = con.prepareStatement
                    ("Select ClientAmount FROM clientpersonalinfo WHERE AccountNum='"+received_acc_from_TellerFirst+"'");
            ResultSet rst = pst.executeQuery();

            while (rst.next()){
                float temp = rst.getFloat("ClientAmount");
                TellerSecondLabel1.setText("BALANCE: RS  "+temp);
                temp-=withamount;
                PreparedStatement pst1=con.prepareStatement
                        ("Update clientpersonalinfo set ClientAmount='"+temp+"' WHERE AccountNum='"+received_acc_from_TellerFirst+"'");
                pst1.executeUpdate();
                TellerSecondLabel1.setText("BALANCE: RS"+ temp);
            }
        }
        catch (Exception ep) {
            ep.printStackTrace();
        }


    }



    public void depositeLogic(){
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientdatabase", "root", "");
            float depoamount=Float.parseFloat(depositeTextfield.getText());
            PreparedStatement pst = con.prepareStatement
                    ("Select ClientAmount FROM clientpersonalinfo WHERE AccountNum='"+received_acc_from_TellerFirst+"'");
            ResultSet rst = pst.executeQuery();

            while (rst.next()){
                float temp = rst.getFloat("ClientAmount");
                TellerSecondLabel1.setText("BALANCE: RS "+temp);
                temp+=depoamount;
                PreparedStatement pst1=con.prepareStatement
                        ("Update clientpersonalinfo set ClientAmount='"+temp+"' WHERE AccountNum='"+received_acc_from_TellerFirst+"'");
                pst1.executeUpdate();
                TellerSecondLabel1.setText("BALANCE: RS "+temp);
            }
        }
        catch (Exception ep) {
            ep.printStackTrace();
        }


    }
}


