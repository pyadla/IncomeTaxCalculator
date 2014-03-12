
/*CALCULATOR TO COMPUTE INCOME TAX */

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class IncomeTaxCalc extends Applet implements ActionListener,ItemListener {

    double dc,gross;
    Label title,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,lh1,lh2,lh3,lh4;
    Label netinc,taxpayable;
    TextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,net,tp;
    Button b1=new Button("Compute net income");
    CheckboxGroup cbg=new CheckboxGroup();
    Checkbox c1,c2,c3;


    @Override
    public void init() {

        Label ex1,ex2,ex3,ex4,ex5,ex6,ex7;
        setLayout(new GridLayout(24,2));
        setSize(500,600);

        t1=new TextField(10);
        t2=new TextField(10);
        t3=new TextField(10);
        t4=new TextField(10);
        t5=new TextField(10);
        t6=new TextField(10);
        t7=new TextField(10);
        t8=new TextField(10);
        t9=new TextField(10);
        t10=new TextField(10);
        t11=new TextField(10);
        t12=new TextField(10);
        t13=new TextField(10);
        net=new TextField(10);
        tp=new TextField(10);

        c1=new Checkbox("Male(min taxable income:160000)",cbg,false);
        c2=new Checkbox("Female(min taxable income:190000)",cbg,false);
        c3=new Checkbox("Sr citizen(>65 yrs)(min taxable income:240000)",cbg,false);

        title=new Label("INCOME TAX CALCULATOR");
        ex1=new Label("    ");
        ex2=new Label("    ");
        ex3=new Label("    ");
        ex4=new Label("    ");
        ex5=new Label("    ");
        ex6=new Label("    ");
        ex7=new Label("    ");
        l1=new Label("Gross salary");
        l2=new Label("Other Income");
        l3=new Label("Other perks");
        lh1=new Label("Deductions under 80C(min:100000)");
        l4=new Label("PF&VPF");
        l5=new Label("LIC premium");
        l6=new Label("Housing Loan Repayment");
        l7=new Label("Child1 Fee");
        l8=new Label("Child2 Fee");
        l9=new Label("Interest on securities");
        lh2=new Label("Deductions under 80D");
        l10=new Label("Medical premium(totally exempted)");
        lh3=new Label("Deductions under 80E");
        l11=new Label("Interest on Higher Education loan");
        lh4=new Label("Deductions under 80G");
        l12=new Label("Donations");
        l13=new Label("Loss on House property");
        netinc=new Label("Net Income");
        taxpayable=new Label("Tax Payable");

        add(title);
        add(ex6);
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(lh1);
        add(ex1);
        add(l4);
        add(t4);
        add(l5);
        add(t5);
        add(l6);
        add(t6);
        add(l7);
        add(t7);
        add(l8);
        add(t8);
        add(l9);
        add(t9);
        add(lh2);
        add(ex2);
        add(l10);
        add(t10);
        add(lh3);
        add(ex3);
        add(l11);
        add(t11);
        add(lh4);
        add(ex4);
        add(l12);
        add(t12);
        add(l13);
        add(t13);
        add(b1);
        add(ex5);
        add(netinc);
        add(net);
        add(c1);
        add(c2);
        add(c3);
        add(ex7);
        add(taxpayable);
        add(tp);

        b1.addActionListener(this);
        b1.addActionListener(this);
        c1.addItemListener(this);
        c2.addItemListener(this);
        c3.addItemListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        gross=Integer.parseInt(t1.getText());
        gross+=Integer.parseInt(t2.getText());
        gross+=Integer.parseInt(t3.getText());
        gross-=2400;

        dc=Integer.parseInt(t4.getText());
        dc+=Integer.parseInt(t5.getText());
        dc+=Integer.parseInt(t6.getText());
        dc+=Integer.parseInt(t7.getText());
        dc+=Integer.parseInt(t8.getText());
        dc+=Integer.parseInt(t9.getText());

        if(dc>100000)
            gross-=100000;
        else
            gross-=dc;

        gross-=Integer.parseInt(t10.getText());
        gross-=Integer.parseInt(t11.getText());
        gross-=Integer.parseInt(t12.getText());

        if((Integer.parseInt(t13.getText()))>160000)
            gross-=160000;
        else
            gross-=Integer.parseInt(t13.getText());

        net.setText(Double.toString(gross));

    }

    public void itemStateChanged(ItemEvent e) {

        //choice=MALE
        if(cbg.getSelectedCheckbox().getLabel().equals("Male")){
            if(gross<160000)
                tp.setText("0");
            else if(gross<300000){
                   gross-=160000;
                   gross*=0.1;
                   gross+=gross*0.03;
                   tp.setText(Double.toString(gross));
                 }
            else if(gross<500000){
                   gross-=300000;
                   gross*=0.2;
                   gross+=14000;
                   gross+=gross*0.03;
                   tp.setText(Double.toString(gross));
                 }
            else{
                   gross-=500000;
                   gross*=0.3;
                   gross+=54000;
                   gross+=gross*0.03;
                   tp.setText(Double.toString(gross));
            }

        }
        //choice=FEMALE
        else if(cbg.getSelectedCheckbox().getLabel().equals("Female")){
            if(gross<190000)
                tp.setText("0");
            else if(gross<300000){
                   gross-=190000;
                   gross*=0.1;
                   gross+=gross*0.03;
                   tp.setText(Double.toString(gross));
                 }
            else if(gross<500000){
                   gross-=300000;
                   gross*=0.2;
                   gross+=11000;
                   gross+=gross*0.03;
                   tp.setText(Double.toString(gross));
                 }
            else{
                   gross-=500000;
                   gross*=0.3;
                   gross+=51000;
                   gross+=gross*0.03;
                   tp.setText(Double.toString(gross));
            }
        }
        //Choice=Senior citizen
        else{
            if(gross<240000)
                tp.setText("0");
            else if(gross<300000){
                   gross-=240000;
                   gross*=0.2;
                   gross+=gross*0.03;
                   tp.setText(Double.toString(gross));
                 }
            else if(gross<500000){
                   gross-=300000;
                   gross*=0.2;
                   gross+=6000;
                   gross+=gross*0.03;
                   tp.setText(Double.toString(gross));
                 }
            else{
                   gross-=500000;
                   gross*=0.3;
                   gross+=46000;
                   gross+=gross*0.03;
                   tp.setText(Double.toString(gross));
            }
        }

    }

}
