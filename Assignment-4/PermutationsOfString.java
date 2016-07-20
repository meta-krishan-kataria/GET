
public class PermutationsOfString {
	//utility func. to swap two elements of an array
	public static void swap(char[] arr, int i, int j){
			char temp;
			temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
		}
		
	//function to print permutation	
	void permute(char[] a, int L,int H){
		if(L==H){
			System.out.println(a);
		}else{
			for(int i=L ; i<=H ; i++){
				swap( a, L, i);
				permute(a, L+1, H);
				swap( a, L, i);
			}
		}
	}
	//driver function
	public static void main(String arg[]){
		char[] arr="ABCD".toCharArray();
		PermutationsOfString ob=new PermutationsOfString();
		ob.permute(arr, 0, arr.length-1);
	}
	
}
