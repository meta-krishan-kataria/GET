
public class LinearSearch {
	public static int linearSearch(int[] arr,int key, int low,int high){
		if(	arr[low]==key	){
			return low;	//base condition: success case
		}else if( low < high	){
			return linearSearch(arr, key, low+1, high);
		}else{
			return -1;	//base condition: failure case			
		}
	}
}
