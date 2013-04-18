package X_GUI_Compatible1;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class MyGraph extends JFrame {
	private static mxGraph graph;
	private static Object parent;
	private static ArrayList<Bank> banks;
	
	private static int windowSize = 500; 
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2707712944901661771L;

	public MyGraph() {

		super("My Graph");

		graph = new mxGraph();
		parent = graph.getDefaultParent();

		graph.getModel().beginUpdate();
		try {
			initBanks();
			drawNetwork();
		}
		finally {
			graph.getModel().endUpdate();
		}
		
		redraw();
		
		JButton button = new JButton("My button");
		JPanel toolbar = new JPanel();
		toolbar.add(button);
		
		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(graphComponent, BorderLayout.CENTER);
		getContentPane().add(toolbar, BorderLayout.NORTH);
	}
	
	private static void initBanks() {
		String[] initBankNames = {"AXP", "BAC", "BK", "C", "GS", "JPM", "MS", "PNC", "USB", "WFC", "AIG", "FNM", "FRE"};
		banks = new ArrayList<Bank>();
		for (int i = 0; i < initBankNames.length; i++) {
			banks.add(new Bank(initBankNames[i]));
		}					
	}
	
	public static void drawNetwork() {
		drawNodes();
		drawCompleteEdges();				
	}
	
	public static void drawNodes() {
		for (int i = 0; i < banks.size(); i++) {			
			Object v = graph.insertVertex(parent, null, banks.get(i).getName() , 0, 0, 30, 30, "shape=ellipse;perimeter=ellipsePerimeter");
			banks.get(i).setVertex(v);
		}
	}
	
	public static void drawCompleteEdges() {
		// connect all banks to each other
		for (int i = 0; i < banks.size(); i++) {
			for (int j = 0; j < banks.size(); j++) {
				if (i == j) continue;
				else
					graph.insertEdge(parent, null, "", banks.get(i).getVertex(), banks.get(j).getVertex());
			}
		}		
	}
	
	private static void redraw() {
		mxIGraphLayout layout = new mxCircleLayout(graph);
		layout.execute(parent);			
	}
	
	public static void addBank(String bankName) {			
		Object v = graph.insertVertex(parent, null, bankName , 0, 0, 30, 30, "shape=ellipse;perimeter=ellipsePerimeter");
		banks.add(new Bank(bankName, v));
		redraw();
				
	}	
	
	public static void removeBank(String bankName) {
		Object v = null;
		for(int i = 0; i < banks.size(); i++) {
			if (banks.get(i).getName().equals(bankName)) {
				v = banks.get(i).getVertex();
				banks.remove(i);				
			}
		}
		graph.getModel().beginUpdate();
		try {
			graph.getModel().remove(v);
			redraw();
		}
		finally {
			graph.getModel().endUpdate();
		}
		
	}	
	
	private static Object findBank(String b) {
		for (int i = 0; i < banks.size(); i++) {
			if (banks.get(i).getName().equals(b)) return banks.get(i).getVertex();
		}
		return null;
	}
	
	public static void removeEdge(String bank1, String bank2) {
		Object v1 = findBank(bank1);
		Object v2 = findBank(bank2);
		graph.getModel().beginUpdate();
		try {
			Object[] edges = graph.getEdgesBetween(v1, v2);
			for (Object edge : edges) graph.getModel().remove(edge);
		}
		finally {
			graph.getModel().endUpdate();
		}		
	}
	
	public static void addEdge(String bank1, String bank2) {
		Object v1 = findBank(bank1);
		Object v2 = findBank(bank2);
		graph.getModel().beginUpdate();
		try {
			graph.insertEdge(parent, null, "", v1, v2);
		}
		finally {
			graph.getModel().endUpdate();
		}
		
	}
	
	public static void clearGraph() {
		graph.removeCells(graph.getChildVertices(graph.getDefaultParent()));
	}
	
	public static void myWait(int n) {
		try {
			Thread.sleep(n);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static class Bank {
		
		private String name;
		private Object vertex;
		
		public Bank(String name, Object v) {
			this.name = name;
			this.vertex = v;
		}
		
		public Bank(String name) {
			this.name = name;
			this.vertex = null;
		}
		
		public String getName() { return this.name; }	
		public Object getVertex() { return this.vertex;}	
		public void setVertex(Object v) { this.vertex = v; }
	}

	public static void main(String[] args) {
		MyGraph frame = new MyGraph();		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(windowSize, windowSize);		
		frame.setVisible(true);
		
		myWait(2000);
		frame.setVisible(false);
		
		myWait(2000);		
		frame.setVisible(true);
	}

}
