import java.util.ArrayList;
import java.util.HashMap;


public class Model1 {
	
	static ArrayList<Bank> allBanks = new ArrayList<Bank>();
	
	static HashMap<Bank, Double> bankFailure = new HashMap<Bank, Double>();
	
	public static void main(String[] args){
		
		Bank C = new Bank(15); //15
		Bank B = new Bank(7);
		Bank A = new Bank(1);
		
		//System.out.println(C.getCash());
		
		Bank X = new Bank(2);
		
		C.addDebtor(A, 9);
		C.addCreditor(B, 5); //money is owed to B
		C.addCreditor(X, 3);
		
		X.addDebtor(C, 3);
		X.addCreditor(A, 1);
		
		B.addDebtor(C, 5);
		B.addCreditor(A, 10);
		
		A.addDebtor(B, 10);
		A.addDebtor(X, 1);
		A.addCreditor(C, 9);
		
		allBanks.add(C);
		allBanks.add(B);
		allBanks.add(A);
		
		allBanks.add(X);
		
		bankFailure.put(A, 0.0);
		bankFailure.put(B, 0.0);
		bankFailure.put(C, 0.0);
		bankFailure.put(X, 0.0);

		
		for (int i = 0; i < 500000; i++){
		
	
		C.setCash(15);
		B.setCash(7);
		A.setCash(1);
		X.setCash(2);
			
		C.randomShock(15);
		System.out.println("After shock, C now has cash: " + C.getCash());
		
		
		
		
		for (Bank bk : allBanks){
			double count1 = 0.0;
			System.out.println(bk.getCash());
			if(!bk.makePayments()){
				
				count1 = bankFailure.get(bk);
				count1++;
				bankFailure.put(bk, count1);
				
			}
			System.out.println(bk.getCash());
			System.out.println();
		}
		/*
		System.out.println("C:");
		//System.out.println(C.getCash());
		C.makePayments();
		System.out.println(C.getCash());
		System.out.println();
		
		System.out.println("B:");
		System.out.println(B.getCash());
		if (!B.makePayments()) {
			count++;
		}
		System.out.println(B.getCash());
		System.out.println();
		
		System.out.println("X:");
		System.out.println(X.getCash());
		X.makePayments();
		System.out.println(X.getCash());
		System.out.println();
		
		System.out.println("A:");
		System.out.println(A.getCash());
		A.makePayments();
		System.out.println(A.getCash());
		System.out.println();
		
		System.out.println(C.getCash());
		
	*/
	}
	int c = 0;
	for (Bank q : allBanks){
		c++;
		double finalCount = bankFailure.get(q);
		double percentage = (finalCount/5000) * 100;
		
	System.out.print("Result:");
	System.out.println(percentage + "% chance of bank " + c +  " going bankrupt");
	System.out.println();
	}
	}
}
