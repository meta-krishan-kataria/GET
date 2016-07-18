
public class QuickSort {
	
	public static void qsort(int[] arr,int p, int r){
		if(p<r){
			int q=partition(arr,p,r);
			qsort(arr, p ,q-1);
			qsort(arr, q+1, r);			
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
	public static int partition(int[] arr, int p,int r){
		//taking arr[r] (last element as pivot)
		int j=p-1;
		int i;
		for(i=p; i<=r-1 ; i++){
			//ascending order
			if( arr[i] < arr[r] ){// current element < pivot	
				j++;
				swap(arr,i,j);
			}
		}
		j++;
		swap(arr,j,r);	//putting pivot element to its sorted place
		
		return j;	
	}

}
