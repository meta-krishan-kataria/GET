
public class BubbleSort implements Sorting {
	
	public static void sort(int[] input){
		for(int i=0; i < input.length;  i++){
			for(int j=0; j < input.length; j++){
				if( input[j] > input[j+1] ){
					swap(input,j,j+1);
				}
			}
		}
	}
	
	public static void swap(int[] array, int x,int y){
		int temp=array[x];
		array[x]=array[y];
		array[y]=temp;
	}
}
