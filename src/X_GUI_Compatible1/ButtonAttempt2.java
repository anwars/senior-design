package X_GUI_Compatible1;
	
	/*
	*
	* FlowLayoutDemo.java
	*
	*/

	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	import java.util.*;
	

	public class ButtonAttempt2 extends JFrame{
	    JRadioButton RtoLbutton;
	    JRadioButton LtoRbutton;
	    FlowLayout experimentLayout = new FlowLayout();
	    final String RtoL = "Right to left";
	    final String LtoR = "Left to right";
	    JButton applyButton = new JButton("Apply component orientation");
	    
	    public ButtonAttempt2(String name) {
	        super(name);
	    }
	    
	    public void addComponentsToPane(final Container pane) {
	        final JPanel compsToExperiment = new JPanel();
	        compsToExperiment.setLayout(new BoxLayout(compsToExperiment, BoxLayout.LINE_AXIS));
	        experimentLayout.setAlignment(FlowLayout.CENTER); //TRAILING
	        JPanel controls = new JPanel();
	        controls.setLayout(new FlowLayout());
	        
	        final JPanel topLayer = new JPanel();
	        topLayer.setLayout(new BoxLayout(topLayer, BoxLayout.PAGE_AXIS));
	        
	        final JPanel firstLayer = new JPanel();
	        firstLayer.setLayout(new BoxLayout(firstLayer, BoxLayout.LINE_AXIS));
	        
	        final JPanel secondLayer = new JPanel();
	        secondLayer.setLayout(new BoxLayout(secondLayer, BoxLayout.LINE_AXIS));
	        
	        final JPanel bankPanel = new JPanel();
	        bankPanel.setLayout(new BoxLayout(bankPanel, BoxLayout.LINE_AXIS));
	        
	        final JPanel creditorPanel = new JPanel();
	        creditorPanel.setLayout(new BoxLayout(creditorPanel, BoxLayout.LINE_AXIS));
	        
	        final JPanel delBankPanel = new JPanel();
	        delBankPanel.setLayout(new BoxLayout(delBankPanel, BoxLayout.LINE_AXIS));
	        
	        final JPanel delCredPanel = new JPanel();
	        delCredPanel.setLayout(new BoxLayout(delCredPanel, BoxLayout.LINE_AXIS));
	        
	        LtoRbutton = new JRadioButton(LtoR);
	        LtoRbutton.setActionCommand(LtoR);
	        LtoRbutton.setSelected(true);
	        RtoLbutton = new JRadioButton(RtoL);
	        RtoLbutton.setActionCommand(RtoL);
	        
	        //Add buttons to the experiment layout
	        JButton simulate = new JButton("Simulate");
	      
	        final JTextField textField = new JTextField(1);
	        final JTextField anotherField = new JTextField(1);
	        
	        final JTextField delBnkField = new JTextField(1);
	        final JTextField delCredField = new JTextField(1);
	        
	        final JLabel addBank = new JLabel("Add Bank");
	        final JLabel addCreditor = new JLabel("Add Creditor");
	        
	        final JLabel delBank = new JLabel("Delete Bank");
	        final JLabel delCreditor = new JLabel("Delete Creditor");
	        
	        bankPanel.add(addBank);
	        bankPanel.add(Box.createRigidArea(new Dimension(15, 0)));
	        bankPanel.add(textField);
	        bankPanel.setMaximumSize(new Dimension(200, 25));
	        
	        creditorPanel.add(addCreditor);
	        creditorPanel.add(Box.createRigidArea(new Dimension(15, 0)));
	        creditorPanel.add(anotherField);
	        creditorPanel.setMaximumSize(new Dimension(200, 25));
	        
	        delBankPanel.add(delBank);
	        delBankPanel.add(Box.createRigidArea(new Dimension(15, 0)));
	        delBankPanel.add(delBnkField);
	        delBankPanel.setMaximumSize(new Dimension(200, 25));
	        
	        delCredPanel.add(delCreditor);
	        delCredPanel.add(Box.createRigidArea(new Dimension(15, 25)));
	        delCredPanel.add(delCredField);
	        delCredPanel.setMaximumSize(new Dimension(200, 25));
	        
	        compsToExperiment.add(Box.createRigidArea(new Dimension(10, 0)));
	        compsToExperiment.add(simulate);
	        compsToExperiment.add(Box.createRigidArea(new Dimension(30, 0)));
	        compsToExperiment.add(bankPanel);
	        compsToExperiment.add(Box.createRigidArea(new Dimension(30, 0)));
	        compsToExperiment.add(creditorPanel);
	        compsToExperiment.add(Box.createRigidArea(new Dimension(30, 0)));
	        compsToExperiment.add(delBankPanel);
	        compsToExperiment.add(Box.createRigidArea(new Dimension(30, 0)));
	        compsToExperiment.add(delCredPanel);
	        
	        //Left to right component orientation is selected by default
	        compsToExperiment.setComponentOrientation(
	                ComponentOrientation.LEFT_TO_RIGHT);
	        
	        compsToExperiment.setMaximumSize(new Dimension(10000,30));
	        
	        final JButton button1 = new JButton("Button 1");
	        final JButton button2 = new JButton("Button 2");
	        
	        final JButton button3 = new JButton("Button 3");
	        final JButton button4 = new JButton("Button 4");
	        
	        //Add controls to set up the component orientation in the experiment layout
	        final ButtonGroup group = new ButtonGroup();
	        group.add(LtoRbutton);
	        group.add(RtoLbutton);
	        controls.add(LtoRbutton);
	        controls.add(RtoLbutton);
	        controls.add(applyButton);
	        
	       // firstLayer.add(button1);
	        //firstLayer.add(button2);
	        
	       // secondLayer.add(button3);
	        //secondLayer.add(button4);
	        
	        topLayer.add(compsToExperiment);
	        topLayer.add(firstLayer);
	        topLayer.add(Box.createRigidArea(new Dimension(0, 5)));
	        topLayer.add(secondLayer);
	        
	        //Process the Apply component orientation button press
	        applyButton.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e){
	                String command = group.getSelection().getActionCommand();
	                //Check the selection
	                if (command.equals("Left to right")) {
	                    compsToExperiment.setComponentOrientation(
	                            ComponentOrientation.LEFT_TO_RIGHT);
	                } else {
	                    compsToExperiment.setComponentOrientation(
	                            ComponentOrientation.RIGHT_TO_LEFT);
	                }
	                //update the experiment layout
	                compsToExperiment.validate();
	                compsToExperiment.repaint();
	            }
	        });
	        
	        simulate.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		String[] temp = {};
	        		Model2.main(temp);
	        	}
	        });
	        
	        // for add creditor
	        anotherField.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
		        	try{
		        		
	        			final String line = anotherField.getText();
		        		String [] args = line.split(",");
		        		if (args.length!=3) throw new IllegalArgumentException();
		     	        int a1 = Integer.parseInt(args[0]);
		     	        int a2 = Integer.parseInt(args[1]);
		     	        double a3 = (double)Double.parseDouble(args[2]);
		     	        if (a1 < 0 || a2 < 0 || a3 < 0) throw new IllegalArgumentException();
		        		Model2.addCreditor(a1, a2, a3);
		        		
		        	}
		        	
		        	catch (NumberFormatException ex){
		        		ex.printStackTrace();
	        			JFrame fr = new JFrame("Invalid input!");
	        			fr.setSize(new Dimension(300, 0));
	        			fr.setVisible(true);
	        		}
	        		
	        		
	        		catch (IllegalArgumentException ie){
	        			
	        			// need to print out an error message
	        			JFrame fr = new JFrame("Bank does not exist!");
	        			//fr.setDefaultCloseOperation(EXIT_ON_CLOSE);
	        			fr.setSize(new Dimension(300, 0));
	        			fr.setVisible(true);
	        		}
	        		
		        	
	        	}
	        	
	        });
	        
	        // for add bank
	        textField.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		try{
		        		String str = textField.getText();
		        		double base = Double.parseDouble(str);
		        		Model2.addBank(base);
	        		}
	        		catch (NumberFormatException nfe){
	        			JFrame fr = new JFrame("Invalid input!");
	        			fr.setSize(new Dimension(300, 0));
	        			fr.setVisible(true);
	        		}
	        		
	        		catch (IllegalArgumentException ie){
	        			
	        			// need to print out an error message
	        			JFrame fr = new JFrame("Bank does not exist!");
	        			//fr.setDefaultCloseOperation(EXIT_ON_CLOSE);
	        			fr.setSize(new Dimension(300, 0));
	        			fr.setVisible(true);
	        		}
	        		
	        	}
	        	
	        });
	        
	        delBnkField.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		String str = delBnkField.getText();
	        		int i = Integer.parseInt(str);
	        		try{
	        			Model2.deleteBank(i);
	        		}
	        		
	        		
	        		catch (NumberFormatException ex){
	        			JFrame fr = new JFrame("Invalid input!");
	        			fr.setSize(new Dimension(300, 0));
	        			fr.setVisible(true);
	        		}
	        		
	        		
	        		catch (IllegalArgumentException ie){
	        			
	        			// need to print out an error message
	        			JFrame fr = new JFrame("Bank does not exist!");
	        			//fr.setDefaultCloseOperation(EXIT_ON_CLOSE);
	        			fr.setSize(new Dimension(300, 0));
	        			fr.setVisible(true);
	        		}
	        		
	        		
	        	}
	        });
	        
	        delCredField.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		String str = delCredField.getText();
	        		try{
	        			String [] args = str.split(",");
	        			if (args.length!=2) throw new IllegalArgumentException();
	        			int d1 = Integer.parseInt(args[0]);
	        			int d2 = Integer.parseInt(args[1]);
	        			if (d1 < 0 || d2 < 0 ) throw new IllegalArgumentException();
	        			Model2.deleteCreditor(d1, d2);
	        			
	        		}
	        		
	        		catch (NumberFormatException ex){
	        			ex.printStackTrace();
	        			JFrame fr = new JFrame("Invalid input!");
	        			fr.setSize(new Dimension(300, 0));
	        			fr.setVisible(true);
	        		}
	        		
	        		catch(IllegalArgumentException ie){
	        			JFrame fr = new JFrame("Invalid arguments!");
	        			fr.setSize(new Dimension(300, 0));
	        			fr.setVisible(true);
	        		}
	        		catch(Exception ex){
	        			ex.printStackTrace();
	        		}
	        	}
	        });
	        
	       // pane.add(compsToExperiment, BorderLayout.PAGE_START);
	        pane.add(topLayer);
	    }
	    
	    
	    /**
	     * Create the GUI and show it.  For thread safety,
	     * this method should be invoked from the
	     * event dispatch thread.
	     */
	    private static void createAndShowGUI() {
	        //Create and set up the window.
	        ButtonAttempt2 frame = new ButtonAttempt2("FlowLayoutDemo");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        //Set up the content pane.
	        frame.addComponentsToPane(frame.getContentPane());
	        
	        frame.setSize(900, 900);
	        
	        //Display the window.
	      //  frame.pack();
	        frame.setVisible(true);
	        
	        Model2.initializeBanks();
	    }
	    
	    public static void main(String[] args) {
	        /* Use an appropriate Look and Feel */
	        try {
	            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
	        } catch (UnsupportedLookAndFeelException ex) {
	            ex.printStackTrace();
	        } catch (IllegalAccessException ex) {
	            ex.printStackTrace();
	        } catch (InstantiationException ex) {
	            ex.printStackTrace();
	        } catch (ClassNotFoundException ex) {
	            ex.printStackTrace();
	        }
	        /* Turn off metal's use of bold fonts */
	        UIManager.put("swing.boldMetal", Boolean.FALSE);
	        //Schedule a job for the event dispatchi thread:
	        //creating and showing this application's GUI.
	        javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                createAndShowGUI();
	            }
	        });
	    }
	}
	
	
	


