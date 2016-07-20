
 class AssignmentQ1 {
	//maximum
	 public int max=-35000;	//initializing with a small number
	 public int maxDigit=-1;
	 
	 //func. to find Greatest Common Divisor of two number
	public static int gcd(int a,int b){
		if(a==b){
			return a;
		}
		return (a>b) ? gcd(a-b,b) : gcd(a,b-a);
	}
	
	// func. to find Greatest Common Divisor of two number	VERSION:2
	int gcd(int a, int b)
	{
	    if (a == 0)
	        return b;
	    return gcd(b%a, a);
	}
	
	//func. to find remainder of two numbers //**Non recursive***
	public static int rem2(int a,int b){	
		//a>b
		/*	From a=bq+r
		 * 	we have r=a-bq		  
		 */
		int q=a/b;	//truncation of decimal digits
		return a-(b*q);
	}
	//func. to find remainder of two numbers	//RECURSIVE
	//DOMAIN:  x>y , x,y > 0
	public static int rem(int x,int y){
			if( x-y >= y ){
				return rem(x-y, y);
			}else{
				return x-y;
			}
	}
	
	//function to find largest digit from a number
		public int largestDigit(int num){
			if(num>0){
				int digit=num%10;	//getting last digit
				if(digit>maxDigit){
					maxDigit=digit;
				}
				num=num/10;	//removing last digit
				return largestDigit(num);
			}else{
				return maxDigit;
			}
		}
	
	//func. to find maximum from an array	
		public int findMaxOfArray(int[] arr,int l,int h){
			if(l <= h){
				if( arr[l] > max){
					 max=arr[l];
				 }
				
				findMaxOfArray(arr, l+1, h);  
			}
			return max;	//base condition
		}
	
	
}
