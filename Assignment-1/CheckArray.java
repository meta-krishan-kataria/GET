package first;

public class CheckArray{
	//function to check array is sorted or not
		//and whether increasing or decreasing
	int checkArrayIsSorted(int input[]){
		int incrementCount=0;
		int decrementCount=0;
		
		for(int i=1; i<input.length; ++i){
			if(input[i]>=input[i-1]){
				incrementCount++;
			}else{
				decrementCount++;
			}	
		}
		//caution: if all elements are equal "increasing" is the result
		if(incrementCount == input.length-1){
			return 1;	//ascending
		}else if(decrementCount == input.length-1){
			return 2;	//descending
		}else{
			return 0; 	//unsorted
		}
	}
	
}	
		
		
