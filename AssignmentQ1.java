
 class AssignmentQ1 {
	//func. to fing Greatest Common Divisor of two number
	public static int gcd(int a,int b){
		if(a==b){
			return a;
		}
		return (a>b) ? gcd(a-b,b) : gcd(a,b-a);
	}
	
	//func. to find remainder of two numbers
	public static int rem(int a,int b){	//**Non recursive***
		//a>b
		/*	From a=bq+r
		 * 	we have r=a-bq		  
		 */
		int q=a/b;	//truncation of decimal digits
		return a-(b*q);
	}
	
	//func. to find maximim from an array
	public static int findMaxOfArray(int[] arr, int low,int high){
		
		return 0;
	}
	
	
	
	
}
