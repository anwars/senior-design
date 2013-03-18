package SimultanousBanks;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;

import Jama.Matrix;


public class Model2 {
	
	static ArrayList<Bank> allBanks = new ArrayList<Bank>();
	static HashMap<Bank, Double> bankFailure = new HashMap<Bank, Double>();
	
	static double[][] globalMatrix1 = new double[3][3]; //the LHS of the eqn
	static double[][] globalMatrix2 = new double[3][1]; //RHS
	static double[] allPayments = new double[3]; //keeps track of all payments
	
	static final Integer numberOfBanks = 3;
	
	public static void BankSetup(){
		
		Bank A = new Bank("A", 7.);
		Bank B = new Bank("B", 9.);
		Bank C = new Bank("C", 4.);
		
		A.addDebtor(B, 12.); //debtor owes you money
		A.addCreditor(C, 10.);
		
		B.addDebtor(C, 7.);
		B.addCreditor(A, 12.);
		
		C.addDebtor(A, 10.);
		C.addCreditor(B, 7.);
	
	}
	
	//Takes a String array and an index and then returns the corresponding subMatrix
	
	//type: whether it belongs in the const or linear regime. const = true
	//row: what row of the global Matrix will this belong to?
	
	//NOTE: AT THIS POINT IN TIME, WE ARE STORING ALL THE VARIABLES IN A FIXED SIZE ARRAY. THERE CAN ONLY BE 
	//3 VARIABLES BECAUSE WE ARE DEALING WITH 3 BANKS. AS WE INCREASE THE NUMBER OF BANKS, THIS PART WILL HAVE
	// TO BE MODIFIED ACCORDINGLY
	
	public static void MatrixSetup(int bankNum, double [] arr, boolean type, int row){
		
		allPayments[row] = arr[0]; // this saves the payment value for later comparison
		
		double num = 0 ; //this will hold either the const value or base value
		
		double x1 = 0;
		double x2 = 0;
		double x3 = 0; 
		
		switch (bankNum){ //if we have a const value, then we want to igonre the linear part. Hence, we will set
		//all three vars to 0, and then initialize only the one that is the bank itself
			
		case 1 : 
			x1 = 1;
			break;
		
		case 2: 
			x2 = 1;
			break;
		
		case 3: 
			x3 = 1;
			break;
		}
		
		if (type){ //we want cosnt regime
			num = arr[0];
		}
		
		else if (!type){ //we want linear regime
			num = arr[1]; // this now holds base value
			
			x1 = arr[2];
			x2 = arr[3];
			x3 = arr[4];
		}
		
		globalMatrix1[row][0] = x1;
		globalMatrix1[row][1] = x2;
		globalMatrix1[row][2] = x3;
		
		globalMatrix2[row][0] = num;
		
	}
	
	
	
	public static void MatrixSolution(){ //what regimes are we in?
		
		/*
		 * A set of arrays that will hold both the solvent and insolvent values for each bank.
		 * arr[0] is always = const, arr[1] is always = linear eqn
		 * 
		 * Maybe this could be refactored into a getInput function?
		 */
		
		; 
		
		int count = 0;
		
		//double[][] arr1 = { {1, -1, 0}, {0, 1, -1}, {-1, 0, 1}}; 
		
		Matrix A = new Matrix(globalMatrix1);
		
		//double[][] arr2 = { {7}, {9}, {4}};
		
		Matrix B = new Matrix(globalMatrix2);
		
			try{
				
				double gamma = 1.0; //a scalar to force a solution to the singularity
				boolean solved = true; //we want to set to false if no solution
				
				if (A.det() == 0) { System.out.println("DET = 0"); gamma = 0.8;}
				
				A = A.times(gamma);
				
				Matrix result = A.solve(B);
				//System.out.println("PASSED!");
				
				double [][] resultArr = result.getArray();
				
				double orig1 = allPayments[0]; //orig amount of money that was owed
				double orig2 = allPayments[1];
				double orig3 = allPayments[2];
				
				//System.out.println(orig1 + "\t" + orig2 + "\t"  + orig3);
				
				if ((resultArr[0][0] > orig1) || (resultArr[1][0] > orig2 || (resultArr[2][0] > orig3))) {
					//System.out.println("NOT A SOLUTION!");
					solved = false;
					}
				

				//	if (resultArr[0][0] + globalMatrix2[0][0] < ) //if more money was paid that what a bank had
				
			
				//else System.out.println("SOLVED THE PROBLEM!"); //this is at the very end
				
				System.out.println(resultArr[0][0] + "\t" + resultArr[1][0] + "\t" + resultArr[2][0]);
				
			}
			
			catch (Exception e){
				//e.printStackTrace();
				System.out.println("Singularity!");
				count++;
				//System.out.println(count);
				
			}
		
		
	}
	
	
	public static void main(String [] args){
	    System.out.println("Mike's comment");
		
		
		BitSet bits = new BitSet();
		
		double [] bankArr1 = {118, 7, 1, -1, 0}; //[0] = constant, [1] = base cash, [2] = which bank owes x
		double [] bankArr2 = {12, 9, 0, 1, -1};
		double [] bankArr3 = {7, 4, -1, 0, 1}; 
		
		//changing 10 to: 118
		
		int bankNum1 = 1;
		int bankNum2 = 2;
		int bankNum3 = 3;
		int row0 = 0;
		int row1 = 1;
		int row2 = 2;
		
		MatrixSetup(bankNum1, bankArr1, false, row0); //false means that we are in linear regime
		MatrixSetup(bankNum2, bankArr2, false, row1);
		MatrixSetup(bankNum3, bankArr3, false, row2);
		
		// Now we need a practical and reliable way to "set" bank state (const vs linear regime)
		
		Integer count = new Integer(0);
		
		for (int i0 = 0; i0 < 8; i0++){
			
			String bitString = Integer.toBinaryString(count);
			
			int bitLength = bitString.length();
			
			//System.out.println(bitString);
			//System.out.println(bitLength);
			
			int extra = numberOfBanks - bitLength;
			
			for (int i = 0; i < extra; i++){
			
				bitString = "0".concat(bitString);
			}
				
			//System.out.println(bitString);
			char[] bitArr = bitString.toCharArray();
			//System.out.println(bitArr);
			
			//Now need to setup the true/false array
			boolean [] matrixArray = new boolean[3];
			
			
			boolean bankBool1;
			boolean bankBool2;
			boolean bankBool3;
			
			if (bitArr[0] == '0') bankBool1 = false;
			else bankBool1 = true;
			
			if (bitArr[1] == '0') bankBool2 = false;
			else bankBool2 = true;
			
			if (bitArr[2] == '0') bankBool3 = false;
			else bankBool3 = true;
			
			
			MatrixSetup(bankNum1, bankArr1, bankBool1, row0); //false means that we are in linear regime
			MatrixSetup(bankNum2, bankArr2, bankBool2, row1);
			MatrixSetup(bankNum3, bankArr3, bankBool3, row2);
			
			MatrixSolution();
			
		//	System.out.println(Integer.toBinaryString(count));
			count++;
		}
		//MatrixSolution();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		for (int i = 0; i < 3; i++){
			//System.out.println(globalMatrix1[1][i]);
		}

		for (int i = 0; i < 3; i++){
			//System.out.println(globalMatrix2[i][0]);
		}
		
		
		
		
		
		
		/*
		int test = 3;
		
		switch(test){
			
		case 1:
			System.out.println("It is 1!");
			break;
			
		case 2:
			System.out.println("It is 2!");
			break;
		
		}
		*/
		//MatrixSetup();
		
		
		
		
	}
	
	
	
	
	
	

}
