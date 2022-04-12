package com.lld.problems.SnakeNLadders;

public class ValidatingCreditCardNumbers {
	
	public static void main(String[] args) {
		
		
		String in = "4123456789123456";
		
		
		
		if(in.length() > 19 ) {
			System.out.println("Invalid");;
		}
		
		
		if(in.charAt(0) != '4' || in.charAt(0) != '5' || in.charAt(0) != '6') {
			System.out.println("Invalid");;
		}
		
		
		for(int i =0;i < in.length();i++) {
			int g = Integer.parseInt(in.charAt(i)+"");
			if(g >= 0 && g<= 9) {
				continue;
			} else {
				System.out.println("Invalid");;
			}
		}
		
		
		for(int i =0;i < in.length();i++) {
			
			if(i % 4 == 0) {
				if(in.charAt(i) == '-' || in.charAt(i) == '0') {
					continue;
				} 
			}
			
			try {
			int g = Integer.parseInt(in.charAt(i)+"");
			if(g >= 0 && g<= 9) {
				continue;
			} else {
				System.out.println("Invalid");;
			}
			}catch(Exception e) {
				
			}
		}
		
	}

}
