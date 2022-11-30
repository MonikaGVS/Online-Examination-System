import java.awt.*;  
import java.awt.event.*;
import java.util.Scanner;

import javax.swing.*;

class Online_Test extends JFrame implements ActionListener {
	JButton btnNext, btnSkip,b1;
	JLabel label,passLable;
    Component userLabel;
    JPanel newPanel;
    JTextField  textField1, textField2; 
	ButtonGroup bg;
	int m[] = new int[15];
	JRadioButton radioButton[] = new JRadioButton[5];
	int current = 0,count = 0, x = 1, y = 1, now = 0;
    //Online Test Function1
	Online_Test(String s) {
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnNext = new JButton("Next Question");
		btnSkip = new JButton("Skip Question");
		btnNext.addActionListener(this);
		btnSkip.addActionListener(this);
		add(btnNext);
		add(btnSkip);
		set();
		label.setBounds(30, 40, 450, 20);
		radioButton[0].setBounds(50, 80, 200, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 200, 20);
		btnNext.setBounds(100, 240, 150, 30);
		btnSkip.setBounds(270, 240, 200, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(700,600); 
		Color c = new Color(102,255,255);
		getContentPane().setBackground(c); 
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			if (qcheck())
				count = count + 1;
			current++;
			set();
			if (current == 10) {
				btnNext.setEnabled(false);
				btnSkip.setText("Result");
			}
		}
		if (e.getActionCommand().equals("Skip Question")) {
			JButton bk = new JButton("Skip " + x);
			bk.setBounds(480, 20 + 30 * x, 150, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 14)
				btnSkip.setText("Score");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Skip" + y)) {
				if (qcheck())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}
		if (e.getActionCommand().equals("Result")) {
			if (qcheck())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this,"You have answered " + count + " Questions correctly" );
			System.exit(0);
		}
	}



   //questions
	void set() {
		radioButton[4].setSelected(true);
		if (current == 0) {
			label.setText("Que1: Who invented Java Programming?");
			radioButton[0].setText("Dennis Ritchie");
			radioButton[1].setText("Ken Thompson");
			radioButton[2].setText("Brian Kernighan");
			radioButton[3].setText("James Gosling");
		}
		if (current == 1) {
			label.setText("Que2:  Which concept allows you to reuse the written code?");
			radioButton[0].setText("Encapsulation");
			radioButton[1].setText("Abstraction");
			radioButton[2].setText("Inheritance");
			radioButton[3].setText(" Polymorphism");
		}
		if (current == 2) {
			label.setText("Que3: Which one of the following is not a Java feature?");
			radioButton[0].setText("Object-oriented");
			radioButton[1].setText("cpUse of pointers");
			radioButton[2].setText("Portable");
			radioButton[3].setText(" Dynamic and Extensible");
		}
		if (current == 3) {
			label.setText("Que4: Wrapping data and its related functionality into a single entity is known as _____________");
			radioButton[0].setText(" Abstraction");
			radioButton[1].setText("Encapsulation");
			radioButton[2].setText("Polymorphism");
			radioButton[3].setText("Modularity");
		}
		if (current == 4) {
			label.setText("Que5:  Which of the following correctly declares an array in java?");
			radioButton[0].setText(" array{10};");
			radioButton[1].setText("array array[10];");
			radioButton[2].setText("int array;");
			radioButton[3].setText("int array[10];");
		}
		if (current == 5) {
			label.setText("Que6: Which of the following is a correct identifier in java?");
			radioButton[0].setText("VAR_1234");
			radioButton[1].setText(" $var_name");
			radioButton[2].setText("7VARNAME");
			radioButton[3].setText("7var_name");
		}
		if (current == 6) {
			label.setText("Que7:  Which component is used to compile, debug and execute the java programs?");
			radioButton[0].setText("JRE");
			radioButton[1].setText("JIT");
			radioButton[2].setText("JDK");
			radioButton[3].setText("JVM");
		}
		if (current == 7) {
			label.setText("Que8:  Which one of the following is not a Java feature?");
			radioButton[0].setText("Object-oriented");
			radioButton[1].setText("Use of pointers");
			radioButton[2].setText("Portable");
			radioButton[3].setText("Dynamic and Extensible");
		}
		if (current == 8) {
			label.setText("Que9: Which of these cannot be used for a variable name in Java?");
			radioButton[0].setText("identifier & keyword");
			radioButton[1].setText("identifier");
			radioButton[2].setText("keyword");
			radioButton[3].setText("none of the mentioned");
		}
		if (current == 9) {
			label.setText("Que10: What is the extension of java code files?");
			radioButton[0].setText(".js");
			radioButton[1].setText(".txt");
			radioButton[2].setText(".class");
			radioButton[3].setText(".java");
		}
		
		
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}

	//answers
	boolean qcheck() {
		if (current == 0)
			return (radioButton[3].isSelected());
		if (current == 1)
			return (radioButton[2].isSelected());
		if (current == 2)
			return (radioButton[1].isSelected());
		if (current == 3)
			return (radioButton[1].isSelected());
		if (current == 4)
			return (radioButton[3].isSelected());
		if (current == 5)
			return (radioButton[0].isSelected());
		if (current == 6)
			return (radioButton[1].isSelected());
		if (current == 7)
			return (radioButton[1].isSelected());
		if (current == 8)
			return (radioButton[2].isSelected());
		if (current == 9)
			return (radioButton[3].isSelected());                  
		return false; 
	}
}
    public class Online_exam{
	public static void main(String s[]) {
        JOptionPane.showMessageDialog(null,"ONLINE EXAMINATION");
        boolean again=true;
        int ln=0;
        while(again==true)
        {
            JOptionPane.showMessageDialog(null," 1.Login\n 2.Update details\n 3.Start Exam\n 4.Logout\n 5.Exit");
            String option=JOptionPane.showInputDialog("Enter your option:");
            int opt=Integer.valueOf(option);
            Login l=new Login();
            Update u=new Update();
            switch(opt)
            {
                case 1:
                    l.CreateLoginForm(u);
                    ln=1;
                    break;
                case 2:
                    if(ln==1)
                    {
                        u.update(option, option);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"You Haven't logged in");
                    }
                    break;
                case 3:
                    if(ln==1)
                    {
                        Online_Test on =new Online_Test("Online test");
                        on.actionPerformed(null);
                        on.set();
                        on.qcheck();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"You Haven't logged in");
                    }
                    break;
                case 4:
                    if(ln==1)
                    {
                        Logout lo=new Logout();
                        lo.logout(lo, lo);
                        ln=0;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"You Haven't logged in");
                    }
                    break;
                case 5:
                    again=false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"You Haven't logged in");
                    break;
            }
        }
	}
    }