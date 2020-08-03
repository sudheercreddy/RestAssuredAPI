package com.api.test.decks;

public class reverse {
	
	public static void main (String[]args) {
		String name = "sudheer";
		int Lengthof=name.length();

		for (int i=Lengthof-1 ;i>=0;i--){

		System.out.print(name.charAt(i));
		
		//Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 7
		}
	}

}
