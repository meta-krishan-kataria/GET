
public class LinearSort {
	public static int[] sort(int[] input){
		if( findMaxDigit(input) > 2 ){
			return RadixSort.sort(input);
		}else{
			return CountSort.sort(input);
		}
		
		
	}
	
	public static int findMaxDigit(int[] arr){
		int maxDigit=0;
		for(int i=0; i < arr.length; i++){
			int d;
			if( (d =getNumberOfDigit(arr[i]) ) > maxDigit ){
				maxDigit=d;
			}
		}
		return maxDigit;
	}
	
	public static int getNumberOfDigit(int num){
		int count=0;
		while( num > 0 ){
			count++;
			num=num/10;
		}
		return count;
	}
}
