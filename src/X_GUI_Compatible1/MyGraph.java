package X_GUI_Compatible1;

import java.util.ArrayList;

import javax.swing.JFrame;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class MyGraph extends JFrame {
	private mxGraph graph;
	private Object parent;
	private ArrayList<Bank> banks;
	
	public int windowSize = 500; 
	

	/**
	 * 
	 */
	private final static long serialVersionUID = -2707712944901661771L;

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
		
		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		getContentPane().add(graphComponent);
	}
	
	public void initBanks() {
		String[] initBankNames = {"AXP", "BAC", "BK", "C", "GS", "JPM", "MS", "PNC", "USB", "WFC", "AIG", "FNM", "FRE"};
		banks = new ArrayList<Bank>();
		for (int i = 0; i < initBankNames.length; i++) {
			banks.add(new Bank(initBankNames[i]));
		}					
	}
	
	public void drawNetwork() {
		drawNodes();
		drawPrimaryLoansEdges();				
	}
	
	public void drawNodes() {
		for (int i = 0; i < banks.size(); i++) {			
			Object v = graph.insertVertex(parent, null, banks.get(i).getName() , 0, 0, 30, 30, "shape=ellipse;perimeter=ellipsePerimeter");
			banks.get(i).setVertex(v);
		}
	}
	
	public void drawPrimaryLoansEdges() {
		// full connectivity
		for (int i = 0; i < banks.size(); i++) {
			for (int j = 0; j < banks.size(); j++) {
				if (i == j) continue;
				else
					graph.insertEdge(parent, null, "", banks.get(i).getVertex(), banks.get(j).getVertex());
			}
		}		
	}
	
	public void drawCreditDefaultEdges() {
		//AXP
		graph.insertEdge(parent, null, "", findBank("AXP"), findBank("C"));
		graph.insertEdge(parent, null, "", findBank("AXP"), findBank("GS"));
		graph.insertEdge(parent, null, "", findBank("AXP"), findBank("JPM"));
		graph.insertEdge(parent, null, "", findBank("AXP"), findBank("MS"));
		graph.insertEdge(parent, null, "", findBank("AXP"), findBank("USB"));
		graph.insertEdge(parent, null, "", findBank("AXP"), findBank("AIG"));
		
		//BAC
		graph.insertEdge(parent, null, "", findBank("BAC"), findBank("AXP"));
		graph.insertEdge(parent, null, "", findBank("BAC"), findBank("BK"));
		graph.insertEdge(parent, null, "", findBank("BAC"), findBank("C"));
		graph.insertEdge(parent, null, "", findBank("BAC"), findBank("GS"));
		graph.insertEdge(parent, null, "", findBank("BAC"), findBank("JPM"));
		graph.insertEdge(parent, null, "", findBank("BAC"), findBank("MS"));
		graph.insertEdge(parent, null, "", findBank("BAC"), findBank("PNC"));
		graph.insertEdge(parent, null, "", findBank("BAC"), findBank("USB"));
		graph.insertEdge(parent, null, "", findBank("BAC"), findBank("WFC"));
		graph.insertEdge(parent, null, "", findBank("BAC"), findBank("AIG"));
		
		//BK		
		
		//C
		graph.insertEdge(parent, null, "", findBank("C"), findBank("AXP"));
		graph.insertEdge(parent, null, "", findBank("C"), findBank("BAC"));
		graph.insertEdge(parent, null, "", findBank("C"), findBank("BK"));
		graph.insertEdge(parent, null, "", findBank("C"), findBank("GS"));
		graph.insertEdge(parent, null, "", findBank("C"), findBank("JPM"));
		graph.insertEdge(parent, null, "", findBank("C"), findBank("MS"));
		graph.insertEdge(parent, null, "", findBank("C"), findBank("PNC"));
		graph.insertEdge(parent, null, "", findBank("C"), findBank("USB"));
		graph.insertEdge(parent, null, "", findBank("C"), findBank("WFC"));
		graph.insertEdge(parent, null, "", findBank("C"), findBank("AIG"));
		
		//GS
		graph.insertEdge(parent, null, "", findBank("GS"), findBank("AXP"));
		graph.insertEdge(parent, null, "", findBank("GS"), findBank("BAC"));
		graph.insertEdge(parent, null, "", findBank("GS"), findBank("BK"));
		graph.insertEdge(parent, null, "", findBank("GS"), findBank("C"));
		graph.insertEdge(parent, null, "", findBank("GS"), findBank("JPM"));
		graph.insertEdge(parent, null, "", findBank("GS"), findBank("MS"));
		graph.insertEdge(parent, null, "", findBank("GS"), findBank("PNC"));
		graph.insertEdge(parent, null, "", findBank("GS"), findBank("WFC"));
		graph.insertEdge(parent, null, "", findBank("GS"), findBank("AIG"));
		
		//JPM
		graph.insertEdge(parent, null, "", findBank("JPM"), findBank("AXP"));
		graph.insertEdge(parent, null, "", findBank("JPM"), findBank("BAC"));
		graph.insertEdge(parent, null, "", findBank("JPM"), findBank("BK"));
		graph.insertEdge(parent, null, "", findBank("JPM"), findBank("C"));
		graph.insertEdge(parent, null, "", findBank("JPM"), findBank("GS"));
		graph.insertEdge(parent, null, "", findBank("JPM"), findBank("AXP"));
		graph.insertEdge(parent, null, "", findBank("JPM"), findBank("MS"));
		graph.insertEdge(parent, null, "", findBank("JPM"), findBank("PNC"));
		graph.insertEdge(parent, null, "", findBank("JPM"), findBank("USB"));
		graph.insertEdge(parent, null, "", findBank("JPM"), findBank("WFC"));
		graph.insertEdge(parent, null, "", findBank("JPM"), findBank("AIG"));
		graph.insertEdge(parent, null, "", findBank("JPM"), findBank("FNM"));
		
		//MS
		graph.insertEdge(parent, null, "", findBank("MS"), findBank("AXP"));
		graph.insertEdge(parent, null, "", findBank("MS"), findBank("BAC"));
		graph.insertEdge(parent, null, "", findBank("MS"), findBank("BK"));
		graph.insertEdge(parent, null, "", findBank("MS"), findBank("C"));
		graph.insertEdge(parent, null, "", findBank("MS"), findBank("GS"));
		graph.insertEdge(parent, null, "", findBank("MS"), findBank("JPM"));
		graph.insertEdge(parent, null, "", findBank("MS"), findBank("PNC"));
		graph.insertEdge(parent, null, "", findBank("MS"), findBank("USB"));
		graph.insertEdge(parent, null, "", findBank("MS"), findBank("AIG"));
		
		//PNC
		
		//USB
		graph.insertEdge(parent, null, "", findBank("USB"), findBank("AXP"));
		graph.insertEdge(parent, null, "", findBank("USB"), findBank("C"));
		graph.insertEdge(parent, null, "", findBank("USB"), findBank("GS"));
		
		
		//WFC
		graph.insertEdge(parent, null, "", findBank("WFC"), findBank("AXP"));
		graph.insertEdge(parent, null, "", findBank("WFC"), findBank("BAC"));
		graph.insertEdge(parent, null, "", findBank("WFC"), findBank("BK"));
		graph.insertEdge(parent, null, "", findBank("WFC"), findBank("C"));
		graph.insertEdge(parent, null, "", findBank("WFC"), findBank("GS"));
		graph.insertEdge(parent, null, "", findBank("WFC"), findBank("MS"));
		graph.insertEdge(parent, null, "", findBank("WFC"), findBank("PNC"));
		graph.insertEdge(parent, null, "", findBank("WFC"), findBank("USB"));
		graph.insertEdge(parent, null, "", findBank("WFC"), findBank("AIG"));
		
		//AIG
		graph.insertEdge(parent, null, "", findBank("AIG"), findBank("AXP"));
		graph.insertEdge(parent, null, "", findBank("AIG"), findBank("BAC"));
		graph.insertEdge(parent, null, "", findBank("AIG"), findBank("BK"));
		graph.insertEdge(parent, null, "", findBank("AIG"), findBank("C"));
		graph.insertEdge(parent, null, "", findBank("AIG"), findBank("GS"));
		graph.insertEdge(parent, null, "", findBank("AIG"), findBank("JPM"));
		graph.insertEdge(parent, null, "", findBank("AIG"), findBank("MS"));
		graph.insertEdge(parent, null, "", findBank("AIG"), findBank("PNC"));
		graph.insertEdge(parent, null, "", findBank("AIG"), findBank("USB"));
		graph.insertEdge(parent, null, "", findBank("AIG"), findBank("WFC"));
		graph.insertEdge(parent, null, "", findBank("AIG"), findBank("FNM"));
		graph.insertEdge(parent, null, "", findBank("AIG"), findBank("FRE"));
		
		//FNM
		graph.insertEdge(parent, null, "", findBank("FNM"), findBank("BAC"));
		graph.insertEdge(parent, null, "", findBank("FNM"), findBank("PNC"));
		graph.insertEdge(parent, null, "", findBank("FNM"), findBank("USB"));
		graph.insertEdge(parent, null, "", findBank("FNM"), findBank("WFC"));
		graph.insertEdge(parent, null, "", findBank("FNM"), findBank("AIG"));
		graph.insertEdge(parent, null, "", findBank("FNM"), findBank("FRE"));
		
		//FRE
		graph.insertEdge(parent, null, "", findBank("FRE"), findBank("BAC"));
		graph.insertEdge(parent, null, "", findBank("FRE"), findBank("USB"));
		graph.insertEdge(parent, null, "", findBank("FRE"), findBank("AIG"));
		graph.insertEdge(parent, null, "", findBank("FRE"), findBank("FNM"));
		
		
	}
	
	public void redraw() {
		mxIGraphLayout layout = new mxCircleLayout(graph, windowSize / 2.5);
		layout.execute(parent);			
	}
	
	public void addBank(String bankName) {			
		Object v = graph.insertVertex(parent, null, bankName , 0, 0, 30, 30, "shape=ellipse;perimeter=ellipsePerimeter");
		banks.add(new Bank(bankName, v));
		redraw();				
	}
	
	public void removeBank(String bankName) {
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
	
	public Object findBank(String b) {
		for (int i = 0; i < banks.size(); i++) {
			if (banks.get(i).getName().equals(b)) return banks.get(i).getVertex();
		}
		return null;
	}
	
	public void removeEdge(String bank1, String bank2) {
		Object v1 = findBank(bank1);
		Object v2 = findBank(bank2);
		graph.getModel().beginUpdate();
		try {
			Object[] edges = graph.getEdgesBetween(v1, v2);
			graph.getModel().remove(edges[0]);			
		}
		finally {
			graph.getModel().endUpdate();
		}		
	}
	
	public void addEdge(String bank1, String bank2) {
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
	
	public void recolor(ArrayList<String> failedBanks) {
		for (int i = 0; i < failedBanks.size(); i++) {
			Object v = findBank(failedBanks.get(i));
			graph.getModel().setStyle(v, "shape=ellipse;perimeter=ellipsePerimeter;fillColor=red");			
		}
	}
	
	public void clearGraph() {
		graph.removeCells(graph.getChildVertices(graph.getDefaultParent()));
	}
	
	public void myWait(int n) {
		try {
			Thread.sleep(n);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private class Bank {
		
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

	/*public void main(String[] args) {
		MyGraph frame = new MyGraph();		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(windowSize, windowSize);		
		frame.setVisible(true);
		
		myWait(2000);
		clearGraph();
	}*/

}
