package first;

import java.util.Scanner;

public class BaseConversion2 {
	
	
	//Binary to Octal conversion
	static int convertBinaryToOctal(int n){
		System.out.println( "Given Binary :"+n);
		int decimal=convertAnyBaseToDecimal(2, n);
		System.out.println("In Decimal :"+ decimal );
		int octal=convertDecimalToAnyBase(8, decimal);
		
		return octal;
		
	}
	
	//General function to convert any base to decimal
	static int convertAnyBaseToDecimal(int BASE,int n){
		
		int sum=0;
		String num=Integer.toString(n);
		for( int i=num.length()-1 ,power=0  ;    i>=0     ;    i--,power++ ){
			
			sum= sum + (int) ( Character.getNumericValue(num.charAt(i)) * Math.pow(BASE,power) );
			
		}
		return sum;
		
	}
	//General function to convert  decimal to any base 
	static int convertDecimalToAnyBase(int BASE, int n){
		int ans=0;
		for(int i=0; n>0; i++){
			
			int digit= n % BASE ;
			ans=(int) (ans + digit*Math.pow(10,i));
			n= (n-digit) / BASE;
			
		}
		return ans;	
	}

	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int octal=convertBinaryToOctal(num);
		System.out.println("In Octal :"+ octal);
	}
	
}