package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyCalculator extends JFrame implements ActionListener {
    JButton[] numberButton=new JButton[10];
    JButton[] funcButton =new JButton[9];

    JPanel panel1=new JPanel();
    JPanel panel2=new JPanel();
    JPanel panel3=new JPanel();

    JButton[] ScientificButtons =new JButton[8];
    JButton ln,exp,sqrt, cubeRoot,log;
    JButton sin,cos,tan;

    JButton radixConversion;
    JTextField textField=new JTextField();
    String specialOperator=null;

    double result;
    String num="";
    char operator='0';  //'0' will denote that no operation has been selected yet
    double num1=0,num2=0;

    double  reserved1=0,reserved2=0;


    boolean flag_num=false;
    boolean isSpecialOpNegative =false;

    public MyCalculator() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        this.setPreferredSize(new Dimension(470,480));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setTitle("Calculator");
        //this.setResizable(false);
        getRootPane().setBorder(BorderFactory.createLineBorder(Color.blue));

        this.setPanel1();
        this.setPanel2();
        this.setPanel3();

        for (int i=0;i<numberButton.length;i++) {
            numberButton[i].addActionListener(this);
        }
        for (int i=0;i< funcButton.length;i++) {
            funcButton[i].addActionListener(this);

        }
        panel1.setBackground(new Color(201,180,222));
        panel2.setBackground(new Color(188, 180, 204));
        panel3.setBackground(new Color(201, 189, 222));
        panel2.setPreferredSize(new Dimension(336,300));


        this.add(panel2,BorderLayout.CENTER);
        this.pack();

        this.setVisible(true);
    }


    public void setPanel1(){
        textField.setPreferredSize(new Dimension(340,75));
        textField.setFont(new Font("Consolas",Font.BOLD,20));
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setEditable(false);
        //textField.setBackground(Color.LIGHT_GRAY);
        panel1.add(textField);
        panel1.setPreferredSize(new Dimension(350,80));
        panel1.setBackground(Color.WHITE);
        this.add(panel1,BorderLayout.NORTH);
    }

    public void setPanel2(){
        panel2.setPreferredSize(new Dimension(350,300));
        this.add(panel2,BorderLayout.CENTER);

        panel2.setLayout(new GridLayout(5,5,5,5));

        //this.add(panel1,BorderLayout.SOUTH);
        for(int i=0;i<10;i++){
            numberButton[i]=new JButton(Integer.toString(i));
            numberButton[i].setFont(new Font("Consolas",Font.BOLD,20));
            numberButton[i].setBackground(Color.DARK_GRAY);
            numberButton[i].setFocusable(false);
            //panel2.add(numberButton[i]);
        }
        funcButton[0]=new JButton("=");
        funcButton[1]=new JButton("+");
        funcButton[2]=new JButton("-");
        funcButton[3]=new JButton("×");
        funcButton[4]=new JButton("/");
        funcButton[5]=new JButton(".");

        //funcButton[3].setFont(new Font("Consolas",Font.BOLD,10));
        funcButton[8]=new JButton("(-)");
        funcButton[8].setBackground(Color.LIGHT_GRAY);
        funcButton[8].setFont(new Font("Consolas",Font.BOLD,20));
        funcButton[8].setPreferredSize(new Dimension(80,60));



        for(int i=0;i<6;i++){
            funcButton[i].setFont(new Font("Consolas",Font.BOLD,20));
            funcButton[i].setBackground(Color.LIGHT_GRAY);
        }
        funcButton[5].setBackground(Color.WHITE);
        funcButton[5].setForeground(Color.BLACK);
        funcButton[0].setBackground(Color.WHITE);

        sin=new JButton("sin");
        sin.setBackground(Color.LIGHT_GRAY);
        sin.setFont(new Font("Consolas",Font.BOLD,20));

        cos=new JButton("cos");
        cos.setBackground(Color.LIGHT_GRAY);
        cos.setFont(new Font("Consolas",Font.BOLD,20));

        tan=new JButton("tan");
        tan.setBackground(Color.LIGHT_GRAY);
        tan.setFont(new Font("Consolas",Font.BOLD,20));

        ln =new JButton("ln");
        ln.setBackground(Color.LIGHT_GRAY);
        ln.setFont(new Font("Consolas",Font.BOLD,20));

        log =new JButton("log");
        log.setBackground(Color.LIGHT_GRAY);
        log.setFont(new Font("Consolas",Font.BOLD,20));

        exp=new JButton("e^");
        exp.setBackground(Color.LIGHT_GRAY);
        exp.setFont(new Font("Consolas",Font.BOLD,20));

        sqrt=new JButton("√");
        sqrt.setBackground(Color.LIGHT_GRAY);
        sqrt.setFont(new Font("Consolas",Font.BOLD,20));

        cubeRoot=new JButton("x²");
        cubeRoot.setBackground(Color.LIGHT_GRAY);
        cubeRoot.setFont(new Font("Consolas",Font.BOLD,20));

        sin.addActionListener(this);
        cos.addActionListener(this);
        tan.addActionListener(this);
        ln.addActionListener(this);
        log.addActionListener(this);
        exp.addActionListener(this);
        sqrt.addActionListener(this);
        cubeRoot.addActionListener(this);

        ScientificButtons[0]=ln;
        ScientificButtons[1]=exp;
        ScientificButtons[2]=sqrt;
        ScientificButtons[3]=cubeRoot;
        ScientificButtons[4]=sin;
        ScientificButtons[5]=cos;
        ScientificButtons[6]=tan;
        ScientificButtons[7]=log;


        panel2.add(sin);
        panel2.add(cos);
        panel2.add(tan);
        panel2.add(funcButton[8]);
        panel2.add(exp);
        panel2.add(numberButton[7]);
        panel2.add(numberButton[8]);
        panel2.add(numberButton[9]);
        panel2.add(ln);
        panel2.add(log);
        panel2.add(numberButton[4]);
        panel2.add(numberButton[5]);
        panel2.add(numberButton[6]);
        panel2.add(sqrt);
        panel2.add(cubeRoot);
        panel2.add(numberButton[1]);
        panel2.add(numberButton[2]);
        panel2.add(numberButton[3]);
        panel2.add(funcButton[1]);
        panel2.add(funcButton[2]);
        panel2.add(funcButton[5]);
        panel2.add(numberButton[0]);
        panel2.add(funcButton[0]);
        panel2.add(funcButton[4]);
        panel2.add(funcButton[3]);


        this.add(panel2);
    }

    public void setPanel3(){
        panel3.setPreferredSize(new Dimension(350,80));
        this.add(panel3,BorderLayout.SOUTH);
        panel3.setLayout(new FlowLayout());
        panel3.setBackground(Color.WHITE);

        funcButton[6]=new JButton("Delete");
        funcButton[6].setPreferredSize(new Dimension(110,60));
        funcButton[6].setBackground(Color.RED);
        funcButton[6].setFont(new Font(null,Font.BOLD,15));

        funcButton[7]=new JButton("Clear");
        funcButton[7].setPreferredSize(new Dimension(110,60));
        funcButton[7].setFont(new Font("Consolas",Font.BOLD,15));
        funcButton[7].setBackground(Color.BLUE);

        radixConversion =new JButton("BaseConv.");
        radixConversion.setFont(new Font(null,Font.BOLD,15));
        radixConversion.setPreferredSize(new Dimension(110,60));
        radixConversion.setBackground(Color.GREEN);
        radixConversion.addActionListener(this);

        panel3.add(funcButton[6]);
        panel3.add(funcButton[7]);
        panel3.add(radixConversion);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == radixConversion){
            try {
                new RadixConverter();
            } catch (Exception ex) {
                System.out.println(ex);
            }
            this.dispose();
        }
        if(e.getSource() == funcButton[0]){
            //'=' button has been pressed
            if(specialOperator != null && num1 == 0 ){
                num1=getActualValue(num);
                if(reserved1 != 0){
                    num1=num1*reserved1;
                }
            }
            num2=getActualValue(num);

            if(reserved2 != 0){
                num2=num2*reserved2;
            }
            switch(operator){
                case '0' -> result=num1;
                case '+' ->result=num1+num2;
                case '-' ->result=num1-num2;
                case '×' ->result=num1*num2;
                case '/' ->result=num1/num2;
            }
            textField.setText(Double.toString(result));
            flag_num=false;
            num="";
        }

        else if(e.getSource() == funcButton[5]){
            // '.' button has been pressed
            if(flag_num){
                num=num.concat(".");
            }
            textField.setText(textField.getText().concat("."));

        }
        else if(e.getSource() == funcButton[6]){
            //'delete button has been pressed'
            char ch=textField.getText().charAt(textField.getText().length()-1);
            String s=textField.getText().substring(0,textField.getText().length()-1);
            if(ch == '+' ||ch =='-' || ch=='/' ||ch=='×' ){
                textField.setText(s);
                flag_num=false;
                operator ='0';
            }
            else if(!flag_num){
                textField.setText(s);
            } else if ( num.length() != 0) {
                num=num.substring(0,num.length()-1);
                textField.setText(s);
            }else {
                int len=specialOperator.length();
                s=textField.getText().substring(0,textField.getText().length()-len);
                specialOperator=null;
                textField.setText(s);
            }
        }
        else if(e.getSource() == funcButton[7]){
            //'clear' button has been pressed
            result=num1=num2=0;
            num="";
            specialOperator=null;
            operator='0';
            textField.setText("");
            flag_num=false;
            reserved1=0;
            reserved2=0;
        }
        else if(e.getSource() == funcButton[8]){
            //'(-)'  button has been pressed
            if(!flag_num){
                textField.setText("-" +textField.getText());
            }else if(num.length() != 0){
                int len =num.length();
                num="-" +num;
                String s=textField.getText().substring(0,textField.getText().length()-len);
                textField.setText(s+"("+num+")");
            }else {
                int len =specialOperator.length();
                String s=textField.getText().substring(0,textField.getText().length()-len);
                textField.setText(s+"("+"-"+specialOperator);
                isSpecialOpNegative =true;
            }
        }
        for(int i=1;i<=4;i++){
            if(e.getSource() ==funcButton[i]){
                operator=funcButton[i].getText().charAt(0);
                if(flag_num){
                    num1=getActualValue(num);
                    if(reserved1 != 0){
                        num1=num1*reserved1;
                        reserved1=0;
                    }
                }
                else {
                    num1=Double.parseDouble(textField.getText());
                }
                textField.setText(textField.getText().concat(operator+""));
                flag_num =true;
            }
        }
        for(int i=0;i<numberButton.length;i++){
            if(e.getSource() == numberButton[i]){
                if(flag_num){
                    num=num.concat(numberButton[i].getText());
                }
                textField.setText(textField.getText().concat(numberButton[i].getText()));
            }
        }
        if(e.getSource() == ScientificButtons[3]){
            if(flag_num){
                int len=num.length();
                String s=textField.getText().substring(0,textField.getText().length()-len);
                num2=Double.parseDouble(num);
                if(num2 <0){
                    s=s.substring(0,s.length()-1);
                }
                num2=num2*num2;
                textField.setText(s+num2+"");
                num=Double.toString(num2);
                //flag_num=false;
            }else {
                num1=Double.parseDouble(textField.getText());
                num1=num1*num1;
                textField.setText(num1+"");
            }
        }
        for(int i=0;i<8;i++){
            if(e.getSource() == ScientificButtons[i]){
                if(i== 3){continue;}
                if(num.length() != 0 && flag_num){
                    reserved2 = Double.parseDouble(num);
                    num="";
                }
                if(!flag_num && operator=='0' && textField.getText().length() !=0){
                    reserved1=Double.parseDouble(textField.getText());
                }
                flag_num=true;
                specialOperator=ScientificButtons[i].getText();
                textField.setText(textField.getText() +specialOperator);
            }
        }

    }
    public double getActualValue(String s){
        double number =0;
        double pi=Math.PI;
        try {
            number=Double.parseDouble(s);
        }
        catch(Exception e){
            textField.setText("Invalid Input");
        }

        if(specialOperator != null) {
            switch (specialOperator) {
                case "sin" -> number = Math.sin(number * pi / 180);
                case "cos" -> number = Math.cos(number * pi / 180);
                case "tan" -> number = Math.tan(number * pi / 180);
                case "ln" -> number = Math.log(number);
                case "log" -> number = Math.log(number) / (Math.log(10));
                case "e^" -> number = Math.exp(number);
                case "√" -> number = Math.sqrt(number);
                case "x²" -> number = Math.pow(number, 2);
            }
        }
        specialOperator=null;
        String st=textField.getText().substring(0,textField.getText().length());
        if(isSpecialOpNegative){
            number =(-1)*number;
            textField.setText(st+")");
            isSpecialOpNegative =false;
        }
        num="";
        return number;
    }
}


