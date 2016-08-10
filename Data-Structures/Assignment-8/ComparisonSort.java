
public class ComparisonSort {
	public static void sort(int[] input){
		
		if( input.length <= 10 ){
			System.out.println("Using Bubble sort");
			BubbleSort.sort(input);
		}else{
			System.out.println("Using Quick sort");
			QuickSort.sort(input);
		}
		
	}
}
