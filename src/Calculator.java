import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Calculator extends JFrame {

	private JPanel contentPane;
	private JTextField adding;
	private double answer,number;
	char operation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void addInput(String str) {
		adding.setText(adding.getText()+str);
		
	}


public void calculate() {
	switch(operation) {
	case '+':
		answer=number+Double.parseDouble(adding.getText());
		adding.setText(Double.toString(answer));
		break;
		
	case '-':
		answer=number-Double.parseDouble(adding.getText());
		adding.setText(Double.toString(answer));
		break;
	case 'x':
		answer=number*Double.parseDouble(adding.getText());
		adding.setText(Double.toString(answer));
		break;
	case '/':
		answer=number/Double.parseDouble(adding.getText());
		adding.setText(Double.toString(answer));
		break;
	case '%':
		answer=number%Double.parseDouble(adding.getText());
		adding.setText(Double.toString(answer));
		break;
	case 'k':
		answer=number*number;
		adding.setText(Double.toString(answer));
		break;
	case '±':
		answer=-number;
		adding.setText(Double.toString(answer));
		break;
	
		
	}
}

	/**
	 * Create the frame.
	 */
	public Calculator() {
		setBackground(Color.BLACK);
		setTitle("Calculator");
		setResizable(false);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 299, 436);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 263, 63);
		contentPane.add(panel);
		panel.setLayout(null);
		
		adding = new JTextField();
		adding.setHorizontalAlignment(SwingConstants.RIGHT);
		adding.setFont(new Font("Microsoft Tai Le", Font.BOLD, 27));
		adding.setBounds(0, 21, 263, 41);
		panel.add(adding);
		adding.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setBackground(Color.BLACK);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Gadugi", Font.BOLD, 12));
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(0, 0, 263, 25);
		panel.add(label);
		
		JPanel control = new JPanel();
		control.setBounds(10, 69, 263, 317);
		contentPane.add(control);
		control.setLayout(new GridLayout(5, 4, 15, 15));
		
		JButton btnNewButton_4 = new JButton("%");
		btnNewButton_4.setBackground(Color.LIGHT_GRAY);
		btnNewButton_4.setForeground(Color.DARK_GRAY);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number=Double.parseDouble(adding.getText());
				operation='%';
				adding.setText("");
				label.setText(number +  e.getActionCommand());
				
			}
		});
		btnNewButton_4.setFont(new Font("Microsoft Tai Le", Font.BOLD, 18));
		control.add(btnNewButton_4);
		
		JButton btnx = new JButton("\u00B1");
		btnx.setForeground(Color.DARK_GRAY);
		btnx.setBackground(Color.LIGHT_GRAY);
		btnx.addActionListener(new ActionListener() {
			public void actionPerformed1(ActionEvent e) {
				number=Double.parseDouble(adding.getText());
				operation='±';
				adding.setText("");
				label.setText("-"+number );
				calculate();
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnx.setFont(new Font("Microsoft Tai Le", Font.BOLD, 18));
		control.add(btnx);
		
		JButton btnNewButton_6_2 = new JButton("x\u00B2");
		btnNewButton_6_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_6_2.setForeground(Color.DARK_GRAY);
		btnNewButton_6_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number=Double.parseDouble(adding.getText());
				operation='k';
				adding.setText("");
				label.setText("sqrt"+ "("+number+ ")");
				calculate();
			}
		});
		btnNewButton_6_2.setFont(new Font("Microsoft Tai Le", Font.BOLD, 17));
		control.add(btnNewButton_6_2);
		
		JButton btnNewButton_1 = new JButton("\u00F7");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(255, 165, 0));
		btnNewButton_1.setFont(new Font("Microsoft Tai Le", Font.BOLD, 28));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				number=Double.parseDouble(adding.getText());
				operation='/';
				adding.setText("");
				label.setText(number +  e.getActionCommand());
				try {
					answer=number/0;
					}catch(ArithmeticException e1) {
						
						//adding.setText("Error");
						System.out.println("Error");
					}
				
		
			}
		
			
		});
		control.add(btnNewButton_1);
		
		JButton btnNewButton_6_7 = new JButton("7");
		btnNewButton_6_7.setForeground(Color.WHITE);
		btnNewButton_6_7.setBackground(Color.DARK_GRAY);
		btnNewButton_6_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		btnNewButton_6_7.setFont(new Font("Microsoft Tai Le", Font.BOLD, 18));
		control.add(btnNewButton_6_7);
		
		JButton btnNewButton_2 = new JButton("8");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		btnNewButton_2.setFont(new Font("Microsoft Tai Le", Font.BOLD, 18));
		control.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("9");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(Color.DARK_GRAY);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		btnNewButton_3.setFont(new Font("Microsoft Tai Le", Font.BOLD, 18));
		control.add(btnNewButton_3);
		
		JButton btnX = new JButton("x");
		btnX.setForeground(Color.WHITE);
		btnX.setBackground(new Color(255, 165, 0));
		
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number=Double.parseDouble(adding.getText());
				operation='x';
				adding.setText("");
				label.setText(number +  e.getActionCommand());
				
			}
		});
		btnX.setFont(new Font("Microsoft Tai Le", Font.BOLD, 26));
		control.add(btnX);
		
		JButton btnNewButton_6_8 = new JButton("4");
		btnNewButton_6_8.setBackground(Color.DARK_GRAY);
		btnNewButton_6_8.setForeground(Color.WHITE);
		btnNewButton_6_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		btnNewButton_6_8.setFont(new Font("Microsoft Tai Le", Font.BOLD, 18));
		control.add(btnNewButton_6_8);
		
		JButton btnNewButton = new JButton("5");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		btnNewButton.setFont(new Font("Microsoft Tai Le", Font.BOLD, 18));
		control.add(btnNewButton);
		
		JButton btnNewButton_6_1 = new JButton("6");
		btnNewButton_6_1.setBackground(Color.DARK_GRAY);
		btnNewButton_6_1.setForeground(Color.WHITE);
		btnNewButton_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		btnNewButton_6_1.setFont(new Font("Microsoft Tai Le", Font.BOLD, 18));
		control.add(btnNewButton_6_1);
		
		JButton btnNewButton_6_6 = new JButton("-");
		btnNewButton_6_6.setForeground(Color.WHITE);
		btnNewButton_6_6.setBackground(new Color(255, 165, 0));
		btnNewButton_6_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number=Double.parseDouble(adding.getText());
				operation='-';
				adding.setText("");
				label.setText(number +  e.getActionCommand());
				
				
			}
		});
		btnNewButton_6_6.setFont(new Font("Microsoft Tai Le", Font.BOLD, 35));
		control.add(btnNewButton_6_6);
		
		JButton btnNewButton_6_4 = new JButton("1");
		btnNewButton_6_4.setForeground(Color.WHITE);
		btnNewButton_6_4.setBackground(Color.DARK_GRAY);
		btnNewButton_6_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		btnNewButton_6_4.setFont(new Font("Microsoft Tai Le", Font.BOLD, 18));
		control.add(btnNewButton_6_4);
		
		JButton btnNewButton_5 = new JButton("2");
		btnNewButton_5.setBackground(Color.DARK_GRAY);
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		btnNewButton_5.setFont(new Font("Microsoft Tai Le", Font.BOLD, 18));
		control.add(btnNewButton_5);
		
		JButton btnNewButton_7 = new JButton("3");
		btnNewButton_7.setForeground(Color.WHITE);
		btnNewButton_7.setBackground(Color.DARK_GRAY);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		btnNewButton_7.setFont(new Font("Microsoft Tai Le", Font.BOLD, 18));
		control.add(btnNewButton_7);
		
		JButton btnNewButton_6_3 = new JButton("+");
		btnNewButton_6_3.setForeground(Color.WHITE);
		btnNewButton_6_3.setBackground(new Color(255, 165, 0));
		btnNewButton_6_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number=Double.parseDouble(adding.getText());
				operation='+';
				adding.setText("");
				label.setText(number +  e.getActionCommand());
				adding.setText("");
			
			}
		});
		btnNewButton_6_3.setFont(new Font("Microsoft Tai Le", Font.BOLD, 28));
		control.add(btnNewButton_6_3);
		
		JButton btnNewButton_6_5 = new JButton("0");
		btnNewButton_6_5.setBackground(Color.DARK_GRAY);
		btnNewButton_6_5.setForeground(Color.WHITE);
		btnNewButton_6_5.setFont(new Font("Microsoft Tai Le", Font.BOLD, 18));
		btnNewButton_6_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			addInput(e.getActionCommand());
			}
		});
		control.add(btnNewButton_6_5);
		
		JButton btnNewButton_6_9 = new JButton(",");
		btnNewButton_6_9.setEnabled(false);
		btnNewButton_6_9.setForeground(Color.WHITE);
		btnNewButton_6_9.setBackground(Color.DARK_GRAY);
		btnNewButton_6_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
			}
		});
		btnNewButton_6_9.setFont(new Font("Microsoft Tai Le", Font.BOLD, 25));
		control.add(btnNewButton_6_9);
		
		JButton btnNewButton_6_10 = new JButton("c");
		btnNewButton_6_10.setForeground(Color.WHITE);
		btnNewButton_6_10.setBackground(Color.DARK_GRAY);
		btnNewButton_6_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adding.setText("");
			}
		});
		btnNewButton_6_10.setFont(new Font("Microsoft Tai Le", Font.BOLD, 25));
		control.add(btnNewButton_6_10);
		
		JButton btnNewButton_6_11 = new JButton("=");
		btnNewButton_6_11.setForeground(Color.WHITE);
		btnNewButton_6_11.setBackground(new Color(255, 165, 0));
		btnNewButton_6_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate();
				label.setText(" ");
			}
		});
		btnNewButton_6_11.setFont(new Font("Microsoft Tai Le", Font.BOLD, 28));
		control.add(btnNewButton_6_11);
		
	}

}
