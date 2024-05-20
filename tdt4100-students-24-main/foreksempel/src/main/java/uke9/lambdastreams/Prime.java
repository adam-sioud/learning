package uke9.lambdastreams;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

// Eksempel fra https://www.journaldev.com/2763/java-8-functional-interfaces

public class Prime {
	//Tradisjonell måte 
	private static boolean isPrime(int number) {		
		if(number < 2) return false;
		for(int i=2; i<number; i++){
			if(number % i == 0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {

		for (int i = 0; i < 100; i++) {
			if (isPrime(i)) {
				System.out.println(i +" er et primtall");
			}
		}

		// Finnes det andre måter, tro...
	}
}
