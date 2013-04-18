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
	    
	    static JComboBox bankList;
	    static JComboBox bankList1;
	    static JComboBox bankList2;
	    
	    
	    static int MarketChoice;
	    static ArrayList<String> banks = new ArrayList<String>();  
	    static String[] bks = {"AXP", "BAC", "BK", "C", "GS", "JPM", "MS", "PNC", "USB", "WFC", "AIG", "FNM", "FRE"}; 
	    
	    public static void initBankList(){
	    	for (String s: bks){
	    		banks.add(s);
	    	}
	    }
	    
	    public static String[] convertToStrings(){
	    	String [] result = new String[banks.size()];
	    	int i = 0;
	    	for (String s: banks){
	    		result[i] = s;
	    		i++;		
	    	}
	    	return result;
	    }
	    
	    public static void updateLists(){
	    	
	    	
	    	
	    	String [] b = convertToStrings();
	    	bankList = new JComboBox(b);
	    	bankList1 = new JComboBox(b);
	    	bankList2 = new JComboBox(b);
	    	
	    	bankList.repaint();
	    	bankList1.repaint();
	    	bankList2.repaint();
	    	
	    	
	    	
	    }
	    
	    public ButtonAttempt2(String name) {
	        super(name);
	    }
	    
	    
	    public void addComponentsToPane(final Container pane) {
	    	
	    	initBankList();
	    	
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
	        
	        final JButton addCreditor = new JButton("Add Creditor");
	        final JButton delCreditor = new JButton("Delete Creditor");
	        
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
	        
	        final JButton addBank = new JButton("Add Bank");
	        
	        final JButton delBank = new JButton("Delete Bank");
	        
	        final JLabel choose = new JLabel("Choose Network Structure");
	        
	        //final JLabel delBank = new JLabel("Delete Bank");
	        
	        String [] temp = convertToStrings();
	        
	        bankList = new JComboBox(temp);
	        bankList.setMaximumSize(new Dimension(60, 50));
	        
	        bankList1 = new JComboBox(temp);
	        bankList.setMinimumSize(new Dimension(60, 50));
	        
	        bankList2 = new JComboBox(temp);
	        bankList.setMinimumSize(new Dimension(60, 50));
	        
	        final JTextField field1 = new JTextField(1);
	        
	        bankPanel.add(addBank);
	        bankPanel.add(Box.createRigidArea(new Dimension(15, 0)));
	        bankPanel.add(textField);
	        bankPanel.setMaximumSize(new Dimension(200, 25));
	        	        
	        creditorPanel.add(delBank);
	        creditorPanel.add(Box.createRigidArea(new Dimension(15,0)));	        
	        creditorPanel.add(bankList);
	       
	        creditorPanel.add(Box.createRigidArea(new Dimension(15,0)));
	       
	        delCredPanel.add(addCreditor);
	        delCredPanel.add(Box.createRigidArea(new Dimension(15, 0)));
	        delCredPanel.add(delCreditor);
	        delCredPanel.add(Box.createRigidArea(new Dimension(15,0)));
	        delCredPanel.add(bankList1);
	        delCredPanel.add(Box.createRigidArea(new Dimension(15,0)));
	        delCredPanel.add(bankList2);
	        delCredPanel.add(Box.createRigidArea(new Dimension(20,0)));
	        delCredPanel.add(field1);
	        
	        delCredPanel.add(Box.createRigidArea(new Dimension(20,0)));	
	        
	       
	        
	       
	      
	       
	       // delBankPanel.add(bankList);
	       // delBankPanel.add(Box.createRigidArea(new Dimension(15, 0)));
	       // delBankPanel.add(delBank);
	        
	        //delBankPanel.add(delBnkField);
	      //  delBankPanel.setMaximumSize(new Dimension(200, 25));
	        	        
	      
	        delCredPanel.add(Box.createRigidArea(new Dimension(15, 25)));
	        	        
	        delCredPanel.setMaximumSize(new Dimension(480, 25));
	        
	        	        
	        compsToExperiment.add(Box.createRigidArea(new Dimension(10, 0)));
	        compsToExperiment.add(simulate);
	        compsToExperiment.add(Box.createRigidArea(new Dimension(30, 0)));
	        compsToExperiment.add(bankPanel);
	         compsToExperiment.add(Box.createRigidArea(new Dimension(30, 0)));
	       
	       // compsToExperiment.add(Box.createRigidArea(new Dimension(30, 0)));
	        compsToExperiment.add(creditorPanel);
	       // compsToExperiment.add(Box.createHorizontalGlue());
	       // compsToExperiment.add(Box.createRigidArea(new Dimension(30, 0)));
	        compsToExperiment.add(delCredPanel);
	        
	        
	      //  compsToExperiment.setBackground(Color.RED);
	        
	        //Left to right component orientation is selected by default
	        compsToExperiment.setComponentOrientation(
	                ComponentOrientation.LEFT_TO_RIGHT);
	        
	        compsToExperiment.setMaximumSize(new Dimension(10000,30));
	        
	        final JButton market1 = new JButton("Primary Loans");
	        final JButton market2 = new JButton("Credit Default Swaps");
	        final JButton market3 = new JButton("Money Market");
	        
	        final JButton button4 = new JButton("Button 4");
	      
	        
	        
	        //Add controls to set up the component orientation in the experiment layout
	        final ButtonGroup group = new ButtonGroup();
	        group.add(LtoRbutton);
	        group.add(RtoLbutton);
	        controls.add(LtoRbutton);
	        controls.add(RtoLbutton);
	        controls.add(applyButton);
	        
	        firstLayer.add(Box.createRigidArea(new Dimension(10,0)));
	        firstLayer.add(market1);
	        firstLayer.add(Box.createRigidArea(new Dimension(20, 0)));
	        firstLayer.add(market2);
	        firstLayer.add(Box.createRigidArea(new Dimension(20, 0)));
	        firstLayer.add(market3);
	        firstLayer.add(Box.createRigidArea(new Dimension(180, 0)));
	        firstLayer.add(Box.createHorizontalGlue());
	       // firstLayer.setAlignmentX(RIGHT_ALIGNMENT);
	        
	        secondLayer.add(Box.createRigidArea(new Dimension(10,0)));
	        //secondLayer.add(bankList);
	        //secondLayer.add(Box.createHorizontalGlue());
	       //secondLayer.setAlignmentX(RIGHT_ALIGNMENT);
	        //secondLayer.add(button4);
	        
	        topLayer.add(Box.createRigidArea(new Dimension(0,10)));
	        topLayer.add(firstLayer);
	        topLayer.add(Box.createRigidArea(new Dimension(0, 10)));
	        topLayer.add(compsToExperiment);
	        topLayer.add(Box.createRigidArea(new Dimension(0, 10)));
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
	                
	                topLayer.validate();
	                topLayer.repaint();
	            }
	        });
	        
	        simulate.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		String[] temp = {};
	        		try{
	        			Model2.main(temp);
	        			
	        			double [][] result = Model2.finalResult;
	        			
	        			for (int i = 0; i < 12; i++){
	        				System.out.println(result[i][0]);
	        			}
	        			
	        			
	        		}
	        		
	        		catch (Exception ex){
	        			ex.printStackTrace();
	        		}
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
	        addBank.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		try{
	        			//TODO    
		        		String str = textField.getText();
		        		String [] args = str.split(",");
		        		if (args.length!=2) throw new IllegalArgumentException();
		        		String name = args[0];		        		
		        		double base = Double.parseDouble(args[1]);
		        		Model2.addBank(name, base);
		        		banks.add(str);
		        		updateLists();
		        		
		        		pane.repaint();
		        		
	        		}
	        		catch (NumberFormatException nfe){
	        			JFrame fr = new JFrame("Invalid input!");
	        			fr.setSize(new Dimension(300, 0));
	        			fr.setVisible(true);
	        		}
	        		
	        		catch (IllegalArgumentException ie){
	        			
	        			// need to print out an error message
	        			JFrame fr = new JFrame("Not a valid argument!");
	        			//fr.setDefaultCloseOperation(EXIT_ON_CLOSE);
	        			fr.setSize(new Dimension(300, 0));
	        			fr.setVisible(true);
	        		}
	        		
	        		catch (NullPointerException npe){
	        			JFrame fr = new JFrame("Maximum number of banks exist!");
	        			fr.setSize(new Dimension(300, 0));
	        			fr.setVisible(true);
	        		}
	        		
	        	}
	        	
	        });
	        
	        //Delete Bank
	        delBank.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		String str = (String)bankList.getSelectedItem();
	        		try{
	        			Model2.deleteBank(str);
	        			banks.remove(str);
	        			System.out.println(str);
	        			
	        			updateLists();
	        			
	        			
	        			creditorPanel.removeAll();
	        			delCredPanel.removeAll();
	        			
	        			String [] b = convertToStrings();
	        	    	bankList = new JComboBox(b);
	        	    	bankList1 = new JComboBox(b);
	        	    	bankList2 = new JComboBox(b);
	        	    	
	        	    	 creditorPanel.add(delBank);
	        		     creditorPanel.add(Box.createRigidArea(new Dimension(15,0)));	        
	        		     creditorPanel.add(bankList);
	        		       
	        		     creditorPanel.add(Box.createRigidArea(new Dimension(15,0)));
	        	    		        	    	
	        	   			creditorPanel.validate();
	        	   			creditorPanel.repaint();
	        	   			delCredPanel.add(addCreditor);
	        		        delCredPanel.add(Box.createRigidArea(new Dimension(15, 0)));
	        		        delCredPanel.add(delCreditor);
	        		        delCredPanel.add(Box.createRigidArea(new Dimension(15,0)));
	        		        delCredPanel.add(bankList1);
	        		        delCredPanel.add(Box.createRigidArea(new Dimension(15,0)));
	        		        delCredPanel.add(bankList2);
	        		        delCredPanel.add(Box.createRigidArea(new Dimension(20,0)));
	        		        delCredPanel.add(field1);
	        		        
	        		        delCredPanel.add(Box.createRigidArea(new Dimension(20,0)));	
	        		        

	        		        delCredPanel.add(Box.createRigidArea(new Dimension(15, 25)));
	        		        	        
	        		        delCredPanel.setMaximumSize(new Dimension(480, 25));
	        		        
	        		        delCredPanel.validate();
	        		        delCredPanel.repaint();
	        			
	        		}
	        		
	        		
	        		
	        		catch (NumberFormatException ex){
	        			JFrame fr = new JFrame("Invalid input!");
	        			fr.setSize(new Dimension(300, 0));
	        			fr.setVisible(true);
	        		}
	        		
	        		
	        		catch (IllegalArgumentException ie){
	        			ie.printStackTrace();
	        			// need to print out an error message
	        			JFrame fr = new JFrame("Bank does not exist!");
	        			//fr.setDefaultCloseOperation(EXIT_ON_CLOSE);
	        			fr.setSize(new Dimension(300, 0));
	        			fr.setVisible(true);
	        		}
	        		
	        		catch (NullPointerException npe){
	        			npe.printStackTrace();
	        			JFrame fr = new JFrame("Bank does not exist!");
	        			fr.setSize(new Dimension(300, 0));
	        			fr.setVisible(true);
	        		}
	        		
	        		
	        	}
	        });
	        
	        // Add Creditor
	        addCreditor.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		
	        		int d1 = bankList1.getSelectedIndex();
	        		int d2 = bankList2.getSelectedIndex();        		
	        		
	        		try{
	        			if (d1 == d2) throw new IllegalArgumentException();	  
	        			String str = field1.getText();
		        		double amount = Double.parseDouble(str);
		        			        		
	        			if (d1 < 0 || d2 < 0 ) throw new IllegalArgumentException();
	        			Model2.addCreditor(d1, d2, amount);
	        			
	        		}
	        		
	        		catch (NumberFormatException ex){
	        			
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
	        			JFrame fr = new JFrame("Oops! Something went wrong!");
	        			fr.setSize(new Dimension(300, 0));
	        			fr.setVisible(true);
	        		}
	        	}
	        });
	        
	        //Delete Creditor
	        delCreditor.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		
	        		int d1 = bankList1.getSelectedIndex();
	        		int d2 = bankList2.getSelectedIndex(); 
	        		
	        		d1++;
	        		d2++;
	        		        		
	        		try{
	        			if (d1 == d2) throw new IllegalArgumentException();
	        			
	        			if (d1 < 0 || d2 < 0 ) throw new IllegalArgumentException();
	        			Model2.deleteCreditor(d1, d2, true);
	        			
	        		}
	        		
	        		catch (NumberFormatException ex){
	        			ex.printStackTrace();
	        			JFrame fr = new JFrame("Invalid input!");
	        			fr.setSize(new Dimension(300, 0));
	        			fr.setVisible(true);
	        		}
	        		
	        		catch(IllegalArgumentException ie){
	        			ie.printStackTrace();
	        			JFrame fr = new JFrame("Invalid arguments!");
	        			fr.setSize(new Dimension(300, 0));
	        			fr.setVisible(true);
	        		}
	        		catch(Exception ex){
	        			ex.printStackTrace();
	        			JFrame fr = new JFrame("Oops! Something went wrong!");
	        			fr.setSize(new Dimension(300, 0));
	        			fr.setVisible(true);
	        		}
	        	}
	        });
	        
	        market1.setEnabled(false);
	        market2.setEnabled(true);
	        market3.setEnabled(true);
	        
	        market1.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		market1.setEnabled(false);
	        		market2.setEnabled(true);
	        		market3.setEnabled(true);
	        		MarketChoice = 1;
	        		Model2.initializeBanks(MarketChoice);
	        	}
	        });
	        
	        market2.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		market2.setEnabled(false);
	        		market1.setEnabled(true);
	        		market3.setEnabled(true);
	        		MarketChoice = 2;
	        		Model2.initializeBanks(MarketChoice);
	        	}
	        });
	        
	        market3.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		market3.setEnabled(false);
	        		market1.setEnabled(true);
	        		market2.setEnabled(true);
	        		MarketChoice = 3;
	        		Model2.initializeBanks(MarketChoice);
	        	}
	        });
	        
	        
	        
	        
	        /*
	        bankList.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		String bank = (String) bankList.getSelectedItem();
	        		System.out.println(bank);
	        	}
	        });
	        */
	        
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
	        ButtonAttempt2 frame = new ButtonAttempt2("Network Resiliency in a Financial System");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        //Set up the content pane.
	        frame.addComponentsToPane(frame.getContentPane());
	        
	        frame.setSize(1250, 900);
	        
	        //Display the window.
	      //  frame.pack();
	        frame.setVisible(true);
	        
	        
	        MarketChoice = 1;
	        Model2.initializeBanks(MarketChoice);
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
	
	
	


