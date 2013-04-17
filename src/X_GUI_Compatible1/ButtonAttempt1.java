package X_GUI_Compatible1;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ButtonAttempt1 extends JPanel implements ActionListener {
	
	protected JButton b1, b2; 
	protected JTextField textField;
	protected JTextArea textArea;
	protected JRadioButton r1, r2;
	
	static JPanel example = new JPanel();
	
	public ButtonAttempt1(){
		
		b1 = new JButton("Test");
		b1.setActionCommand("add");
		
		b1.addActionListener(this);
		add(b1, BorderLayout.CENTER);
		example.add(b1);
		
		b2 = new JButton("Another");
		b2.setAlignmentX(LEFT_ALIGNMENT);
		add(b2, BorderLayout.LINE_START);
		
		textField = new JTextField(20);
		textField.addActionListener(this);
		textField.setActionCommand("Enter1");
		add(textField);
		
		textArea = new JTextArea(20,30);
		add(textArea);
		
		r1 = new JRadioButton();
		r2 = new JRadioButton();
		add(r1);
		add(r2);
		
	}
	
	public void addComponentsToPane(){
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("add".equals(e.getActionCommand())){
			String[] args = {};
			Model2.main(args);
			double [][] resultArr = Model2.finalResult;
		}
		
		if ("Enter1".equals(e.getActionCommand())){
			String line = textField.getText();
			textArea.append(line + "\n");
			textField.selectAll();
			
			String [] args = line.split(",");
			int destination = Integer.parseInt(args[0]);
			int source = Integer.parseInt(args[1]);
			double amount = Double.parseDouble(args[2]);
			
			String fake = "I am fake";
			
			Model2.addBank(fake, destination);
			//Model2.addCreditor(destination, source, amount);
		
		}
	}
	
	public static void createAndShowGUI(){
		
		JFrame frame = new JFrame();
		frame.setSize(100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLayout(new FlowLayout()); //what does this do?
		frame.setVisible(true);
		
		ButtonAttempt1 newContentPane = new ButtonAttempt1();
		newContentPane.setOpaque(true);
		
		frame.add(newContentPane);
		frame.add(example);
		//frame.add(frame.getContentPane());
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args){
		
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				createAndShowGUI();
			}
		});
		
	}
	
	

}
