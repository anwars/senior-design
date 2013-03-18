import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.math.*;

import Jama.Matrix;



public class Bank2 {
	

	private ArrayList<Bank2> debtorBanks;
	private HashMap<Bank2, Double> debtToBank;
	private ArrayList<Bank2> creditorBanks;
	private HashMap<Bank2, Double> creditToBank;
	private double cash;
	private int shock;
	private int seniorObligations;
	
	public Bank2(double cash){
		this.cash = cash;
		creditorBanks = new ArrayList<Bank2>();
		debtorBanks = new ArrayList<Bank2>();
		debtToBank = new HashMap<Bank2, Double>();
	}
	
	public void setCash(double cash){
		this.cash = cash;
	}
	
	public double getCash(){
		return cash;
	}
	
	public void addDebtor(Bank2 bank, double debt){
		debtToBank.put(bank, debt);
		//debtorBanks.add(bank);
	}
	
	public void addCreditor(Bank2 bank, double debt){
		creditorBanks.add(bank);
		debtToBank.put(bank, debt); 
	}
	
	public void makeTrasaction(double cash){
		this.cash = this.cash + cash;
	}
	
	public ArrayList<Bank2> getCreditors(){
		return creditorBanks;
	}
	
	public ArrayList<Bank2> getDebtors(){
		return debtorBanks;
	}
	
	public boolean hasCreditors(){
		ArrayList<Bank2> arr = getCreditors();
		if (arr.size() > 0) return true;
		else return false;
	}
	
	public boolean hasDebtors(){
		ArrayList<Bank2> arr = getDebtors();
		if (arr.size() > 0) return true;
		else return false;
	}
	
	public boolean insufficientFunds(){
		
		double sumPayments = 0;
		ArrayList<Bank2> all = getCreditors();
		
		//System.out.println("Number of creditors: " + all.size());
		
		for (Bank2 x: all){
			sumPayments = sumPayments + debtToBank.get(x);
		}
		
		if (cash < sumPayments) return true;
		else return false;
		
	}
	
	public boolean makePayments(){ //if false, then insufficient funds
		
		boolean bankrupt = false;
		
			if (hasCreditors()){
				ArrayList<Bank2> creditors = getCreditors();
				
				if (!insufficientFunds()){
				
				for (Bank2 Cred : creditors){
					
					//if (!insufficientFunds()){//we have enough money
						
						double amount = debtToBank.get(Cred);
						cash = cash - amount;
						Cred.cash = Cred.cash + amount;
					}
				}
					else{
						
						System.out.println("Insufficient funds! Bankrupt!");
						bankrupt = true;
						double sumPayments = 0;
						for (Bank2 Cred: creditors){
							sumPayments = sumPayments + debtToBank.get(Cred);
						}
						
						System.out.println("Cash: " + cash);
						
						HashMap<Bank2, Double> bankDividends = new HashMap<Bank2, Double>();
						
						for (Bank2 Cred : creditors){
							//System.out.println("here!");
							double owedToBank = debtToBank.get(Cred);
							double dividend = (cash*owedToBank)/sumPayments;
							bankDividends.put(Cred, dividend);
							System.out.println("Dividend:" + dividend);
							
						}
						
						for (Bank2 Cred : creditors){
							double deduction = bankDividends.get(Cred);
							cash = cash - deduction;
							Cred.cash = Cred.cash + deduction;
						}
						
						
						//need to write an else clause
					}
							
					
				
			}
			
			else {
				System.out.println("No creditors for the Bank!");
			}
			
		return !bankrupt;
		
		
		
	}
	
	public void randomShock(int ran){
		Random generator = new Random();
		int r = generator.nextInt(ran);
		cash = cash - r;
	}
	
	public static void main(String [] args){
		
		double[][] arr1 = { {1, -1, 0}, {0, 1, -1}, {-1, 0 , 1}}; 
		Matrix A = new Matrix(arr1);
		
		double[][] arr2 = { {7}, {9}, {4}};
		Matrix B = new Matrix(arr2);
		
		
		System.out.println(B.getRowDimension());
		System.out.println(B.getColumnDimension());
		
		double det = A.det();
		System.out.println(det);
		
		
		//Printing out 3 X 3 matrix 
		/* 
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				System.out.println(A.get(i, j));
			}
		}
		*/
		
		//Printing out 3 X 1 matrix
		/*
		for (int i = 0; i < 3; i++){ //i = row
			for (int j = 0; j < 1; j++){ //j = col
				
				System.out.print(B.get(i, j));
				
			}
		}
		*/
		//System.out.println(B);
		
		
		
		//Solving matrix and then printint out result
		
		try {
		
			Matrix result = A.solve(B);
			
			System.out.println(result.getRowDimension());
			System.out.println(result.getColumnDimension());
			
			System.out.println();
			
			for (int i = 0; i < 3; i++){
				
				System.out.println(result.get(0, i));
				
			}
		}
		
		catch(Exception e){
			System.out.println("Matrix is singular!");
		}
		
		
		//System.out.println(result);
		
	
	}
	
	
	

}
