package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadixConverter extends JFrame implements ActionListener {
    JTextField textField=new JTextField();
    JButton[] numberButton=new JButton[10];
    JPanel panel1,panel2;
    JButton hex,bin,oct,goBack,delete,clear;
    JButton [] operations=new JButton[4];

    String num="";
    int number;
    public RadixConverter() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        this.setSize(new Dimension(300,300));
        this.setLayout(new BorderLayout());


        textField.setPreferredSize(new Dimension(280,60));
        textField.setFont(new Font("Consolas",Font.BOLD,20));
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(textField,BorderLayout.NORTH);
        textField.setText("Enter an Integer Here");
        textField.setEditable(false);

        this.setPanel1();
        this.setPanel2();
        this.setVisible(true);
    }
    public void setPanel1(){
        panel1=new JPanel();
        panel1.setPreferredSize(new Dimension(190,200));
        panel1.setLayout(new GridLayout(4,1,5,5));

        hex=new JButton("HEX");
        hex.setFont(new Font(null,Font.BOLD,15));
        hex.setPreferredSize(new Dimension(100,60));
        hex.setBackground(Color.RED);

        bin=new JButton("BIN");
        bin.setFont(new Font(null,Font.BOLD,15));
        bin.setPreferredSize(new Dimension(100,60));
        bin.setBackground(Color.LIGHT_GRAY);

        oct=new JButton("OCT");
        oct.setFont(new Font(null,Font.BOLD,15));
        oct.setPreferredSize(new Dimension(100,60));
        oct.setBackground(Color.BLUE);

        goBack=new JButton("GoBack");
        goBack.setFont(new Font(null,Font.BOLD,15));
        goBack.setPreferredSize(new Dimension(100,60));
        goBack.setBackground(Color.WHITE);


        goBack.setPreferredSize(new Dimension(100,60));
        goBack.setBackground(Color.WHITE);

        hex.addActionListener(this);
        bin.addActionListener(this);
        oct.addActionListener(this);
        goBack.addActionListener(this);



        panel1.add(hex);
        panel1.add(oct);
        panel1.add(bin);
        panel1.add(goBack);


        this.add(panel1);
    }
    public void setPanel2(){
        panel2=new JPanel();
        panel2.setPreferredSize(new Dimension(200,200));
        panel2.setLayout(new GridLayout(4,3,3,5));


        for(int i=0;i<10;i++){
            numberButton[i]=new JButton(Integer.toString(i));
            numberButton[i].setFont(new Font("Consolas",Font.BOLD,20));
            numberButton[i].setFocusable(false);
            panel2.add(numberButton[i]);
        }
        for (int i=0;i<numberButton.length;i++) {
            numberButton[i].addActionListener(this);
        }

        clear=new JButton("Clear");
        clear.setFont(new Font(null,Font.BOLD,15));
        clear.addActionListener(this);
        panel2.add(clear);

        delete=new JButton("Delete");
        delete.setFont(new Font(null,Font.BOLD,12));
        delete.addActionListener(this);
        panel2.add(delete);

        this.add(panel2,BorderLayout.WEST);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<numberButton.length;i++){
            if(e.getSource() == numberButton[i]){
                num=num.concat(numberButton[i].getText());
                textField.setText(num);
                return;
            }
        }
        if(e.getSource() == clear){
            num="";
            textField.setText(num);
        }
        else if(e.getSource() == delete){
            try {
                num=num.substring(0,num.length()-1);
            }
            catch(Exception ignored){

            }
            textField.setText(num);
        }
        else {
            try {
                number=Integer.parseInt(num);
            }
            catch (Exception ignored){
            }
            num="";
            if(e.getSource() == hex){
                textField.setText(Integer.toHexString(number));
            }
            if(e.getSource() ==oct){
                textField.setText(Integer.toOctalString(number));
            }
            if(e.getSource() == bin){
                textField.setText(Integer.toBinaryString(number));
            }
            if(e.getSource() == goBack){
                try {
                    new MyCalculator();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                this.dispose();
            }
        }
    }
}


