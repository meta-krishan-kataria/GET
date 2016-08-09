
public class CountSort {

	public static int[] sort( int[] input ){
		
		//creating frequency chart
		int max=getMaxValue(input);
		int[] freqchart=new int[max+1];
		
		//traversing array and counting occurrence for the every integer
		for(int i=0; i<input.length; i++){
			freqchart[ input[i] ]++;
		}
		
		//changing frequency chart array so that it contains the position of elements of the input array
		for(int i=1; i<freqchart.length; i++){
			freqchart[i]=freqchart[i]+freqchart[i-1];
		}
		
		//creating output array
		int[] output=new int[input.length];
		
		//filling elements into the output array after reading position of current element from updated freqchat
		for(int i=0; i<input.length; i++){
			output[ freqchart[ input[i] ] -1 ] = input[i];
			freqchart[ input[i] ]--;	
		}
		
		return output;


	}

	//finding max of array
	public static int getMaxValue(int[] array){  
		int maxValue = array[0];  
		for(int i=1;i < array.length;i++){  
			if(array[i] > maxValue){  
				maxValue = array[i];  
			}  
		}  
		return maxValue;  
	}

}


