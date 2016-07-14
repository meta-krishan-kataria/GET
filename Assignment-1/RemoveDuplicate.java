package first;

public class RemoveDuplicate {
	int[] removeDuplicate(int input[]){
		//using the approach similar to count sort
		
		//creating frequency chart
		int max=getMaxValue(input);
		int[] freqchart=new int[max+1];
		
		for(int i=0; i<input.length; i++){
			freqchart[ input[i] ]++;
		}
		
		//output array: copying those elements only whose frequency is greater than 0
		int outarray[]=new int[ countNonZeroElements(freqchart) ];
		
		for(int i=0,j=0 ;  i<freqchart.length; i++){
			if( freqchart[i]>0 ){
				outarray[j]=i;
				j++;				
			}
		}
		return outarray;
		
	}
	//counting no. of non-zero elements
	public static int countNonZeroElements(int[] array){
		int count=0;
		for(int i=0; i<array.length ; i++){
			if(array[i] != 0){
				count++;
			}
		}
		return count;
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
	
	public static void main(String args[]){
		RemoveDuplicate ob=new RemoveDuplicate();
		
		int arr[]={1,2,3,2,3,4,5,3,4,2,2,3,4,5,6,7,8,1,2,4,5,6,7,8,9};
		System.out.println("Input Array");
		for(int x : arr){
			System.out.print(x+",");
		}
		int ans[]=ob.removeDuplicate(arr);
		System.out.println("\nResultant Array");
		for(int x : ans){
			System.out.print(x+",");
		}
	}
	
}
