package my;



class util{
	/**
	 * @return the number of digits of the largest number in the array 
	 * */
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
	/**
	 * @return number of digits in a number
	 * */
	public static int getNumberOfDigit(int num){
		int count=0;
		while( num > 0 ){
			count++;
			num=num/10;
		}
		return count;
	}
	
	/**
	 * @return the digit from the number at particular position(1,2,3..   starting from left side)
	 * returns 0 if position exceed the length  of number num
	 * */
	public static int getDigitAt(int num,int position){
		int length=getNumberOfDigit(num);
		if(position > length){
			return 0;
		}else{
			//getting digit
			for( int i=1; i<position; i++ ){
				num=num/10;
			}
			return num%10;
			
		}
		
	}
}

public class RadixSort2 {
	/**
	 * 
	 * radix sort
	 * */
	public static int[] radixSort(int[] input){
		int largest=util.findMaxDigit(input);
		
		for( int i=1;  i<=largest ; i++){
			
			QuickSortR.sort(input, i);
			
			System.out.println("*********After run "+i);
			for(int x : input){
				System.out.println(x);
			}
		}
		return input;
	}
}

 class QuickSortR {
	
	//begins the qsort method
	public static void sort(int[] input,int position){
		qsort(input, 0, input.length-1,position);
	}
	
	//Quicksort algorithm implementation 
	public static void qsort(int[] arr,int p, int r,int position){
		if(p<r){
			int q=partition(arr,p,r,position);
			qsort(arr, p ,q-1,position);
			qsort(arr, q+1, r,position);			
		}
	}
	
	//utility func. to swap two elements of an array
	public static void swap(int[] arr, int i, int j){
		int temp;
		temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	//partition func. for quicksort algorithm
	public static int partition(int[] arr, int p,int r,int position){
		//taking arr[r] (last element as pivot)
		int j=p-1;
		int i;
		for(i=p; i<=r-1 ; i++){
			//ascending order
			if(  util.getDigitAt(arr[i], position)  < util.getDigitAt(arr[r], position) ){// current element < pivot	
				j++;
				swap(arr,i,j);
			}
		}
		j++;
		swap(arr,j,r);	//putting pivot element to its sorted place
		
		return j;	
	}

}