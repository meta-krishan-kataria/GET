
public class RadixSort {
	/**
	 * count sort for radix sort method
	 * */
	public static int[] countSort( int[] input, int position ){

		//creating frequency chart
		
		int[] freqchart=new int[10];

		//traversing array and counting occurrence for the every integer
		for(int i=0; i<input.length; i++){
			if( getNumberOfDigit( input[i] ) == position )
				freqchart[  getDigitAt(input[i], position)  ]++;
		}

		//changing frequency chart array so that it contains the position of elements of the input array
		for(int i=1; i<freqchart.length; i++){
			freqchart[i]=freqchart[i]+freqchart[i-1];
		}

		//creating output array
		int[] output=new int[input.length];

		//filling elements into the output array after reading position of current element from updated freqchat
		for(int i=0; i<input.length; i++){
			if( getNumberOfDigit( input[i] ) == position ){
				output[ freqchart[  getDigitAt(input[i], position)  ] -1 ] = input[i];
				freqchart[ getDigitAt(input[i], position) ]--;	
			}
		}
		
		//updating
		return output;


	}

	//finding max of array (for Radix sort)
	public static int getMaxValue(int[] array,int position){  
		int maxValue = 0;  
		int d;
		for(int i=1;i < array.length;i++){  
			if(  (  d=getDigitAt(array[i], position) )  > maxValue  ){  
				maxValue = d;  
			}  
		}  
		return maxValue;  
	}
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
	
	
	/**
	 * 
	 * radix sort
	 * */
	public static int[] radixSort(int[] input){
		int largest=findMaxDigit(input);
		
		for( int i=1;  i<=largest ; i++){
			
			input=countSort(input, i);
			
			System.out.println("*********After run "+i);
			for(int x : input){
				System.out.println(x);
			}
		}
		return input;
	}
	
	
	
}
