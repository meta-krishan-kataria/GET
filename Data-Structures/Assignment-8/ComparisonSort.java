
public class ComparisonSort {
	public static void sort(int[] input){
		
		if( input.length <= 10 ){
			BubbleSort.sort(input);
		}else{
			QuickSort.sort(input);
		}
		
	}
}
