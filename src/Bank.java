import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class Bank {
	
	private ArrayList<Bank> debtorBanks;
	private HashMap<Bank, Integer> debtToBank;
	private ArrayList<Bank> creditorBanks;
	private HashMap<Integer, Bank> creditToBank;
	private int cash;
	private int shock;
	private int seniorObligations;
	
	public Bank(int cash){
		this.cash = cash;
		creditorBanks = new ArrayList<Bank>();
		debtorBanks = new ArrayList<Bank>();
		debtToBank = new HashMap<Bank, Integer>();
	}
	
	public void setCash(int cash){
		this.cash = cash;
	}
	
	public int getCash(){
		return cash;
	}
	
	public void addDebtor(Bank bank, int debt){
		debtToBank.put(bank, debt);
		//debtorBanks.add(bank);
	}
	
	public void addCreditor(Bank bank, int debt){
		creditorBanks.add(bank);
		debtToBank.put(bank, debt); 
	}
	
	public void makeTrasaction(int cash){
		this.cash = this.cash + cash;
	}
	
	public ArrayList<Bank> getCreditors(){
		return creditorBanks;
	}
	
	public ArrayList<Bank> getDebtors(){
		return debtorBanks;
	}
	
	public boolean hasCreditors(){
		ArrayList<Bank> arr = getCreditors();
		if (arr.size() > 0) return true;
		else return false;
	}
	
	public boolean hasDebtors(){
		ArrayList<Bank> arr = getDebtors();
		if (arr.size() > 0) return true;
		else return false;
	}
	
	public boolean insufficientFunds(){
		
		int sumPayments = 0;
		ArrayList<Bank> all = getCreditors();
		
		//System.out.println("Number of creditors: " + all.size());
		
		for (Bank x: all){
			sumPayments = sumPayments + debtToBank.get(x);
		}
		
		if (cash < sumPayments) return true;
		else return false;
		
	}
	
	public boolean makePayments(){ //if false, then insufficient funds
		
		boolean bankrupt = false;
		
			if (hasCreditors()){
				ArrayList<Bank> creditors = getCreditors();
				
				if (!insufficientFunds()){
				
				for (Bank Cred : creditors){
					
					//if (!insufficientFunds()){//we have enough money
						
						int amount = debtToBank.get(Cred);
						cash = cash - amount;
						Cred.cash = Cred.cash + amount;
					}
				}
					else{
						
						System.out.println("Insufficient funds! Bankrupt!");
						bankrupt = true;
						int sumPayments = 0;
						for (Bank Cred: creditors){
							sumPayments = sumPayments + debtToBank.get(Cred);
						}
						
						System.out.println("Cash: " + cash);
						
						HashMap<Bank, Integer> bankDividends = new HashMap<Bank, Integer>();
						
						for (Bank Cred : creditors){
							//System.out.println("here!");
							int owedToBank = debtToBank.get(Cred);
							int dividend = (cash*owedToBank)/sumPayments;
							bankDividends.put(Cred, dividend);
							System.out.println("Dividend:" + dividend);
							
						}
						
						for (Bank Cred : creditors){
							int deduction = bankDividends.get(Cred);
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
		
		Random gen = new Random();
		for (int i = 0 ; i < 1000; i++){ 
			int x = gen.nextInt(15);
			System.out.println(x);
		}
	}
	
	
	

}
