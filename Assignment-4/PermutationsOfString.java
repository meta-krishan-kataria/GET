
public class PermutationsOfString {
	String result[];
	int i=0;
	//constructor
	public PermutationsOfString(int n) {
		result=new String[factorial(n)];
	}
	
	public static int factorial(int n) {
    	int fact = 1; // this  will be the result
	 for (int i = 1; i <= n; i++) {
	     fact *= i;
	 }
	 return fact;
	}
	
	//utility func. to swap two elements of an array
	public static void swap(char[] arr, int i, int j){
			char temp;
			temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
		}
		
	//function to print permutation	
	//a=input char array, L=lower inded, H=higher index
	void permute(char[] a, int L,int H){
		if(L==H){
			System.out.println(a);
			result[i]=new String(a);
			i++;
		}else{
			for(int i=L ; i<=H ; i++){
				swap( a, L, i);
				permute(a, L+1, H);
				swap( a, L, i);
			}
		}
	}
	//driver function
	String[] printPermutationOfString(char[] array){
		permute(array,0,array.length-1);
		return result;
	}
	
	public static void main(String arg[]){
		char[] arr="ABC".toCharArray();
		PermutationsOfString ob=new PermutationsOfString(3);
		ob.permute(arr, 0, arr.length-1);
	}
	
	
}
