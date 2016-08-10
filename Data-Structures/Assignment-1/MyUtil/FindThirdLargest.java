package MyUtil;

public class FindThirdLargest {
	
	public static int findThirdLargest(int[] a){
		//array for max three elements
		int[] top3=new int[3];
		
		for(int i=0; i<a.length; i++){
			//if current > max
			if(a[i]>top3[0]){
				top3[2]=top3[1];
				top3[1]=top3[0];
				top3[0]=a[i];
				
			}//if current greater than second max
			else if(a[i]>top3[1]){		
				top3[2]=top3[1];
				top3[1]=a[i];
				
			}//if current id greater than third max
			else if( a[i] > top3[2]){
				top3[2]=a[i];
			}
			else{
				continue;
			}
		}
		
		//returning third max
		return top3[2];
		
	}
	
	

}
