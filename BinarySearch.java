/*Binary Search Recursive version*/
public class BinarySearch {
	public static int binarySearch(int[] arr,int key, int l, int h){
		//l->lower index   h->higher index
		if( l>h ){
			return -1;	//base condition (failure case)
		}else{
			int mid=(h+l)/2;	//or mid=l+(h-l)/2
			if( arr[mid]==key ){
				return mid;	//base condition (success case)
			}else if( key > arr[mid] ){
				return binarySearch(arr, key, mid+1, h);
			}else{
				return binarySearch(arr, key, l, mid-1);
			}			
		}		
	}

}
