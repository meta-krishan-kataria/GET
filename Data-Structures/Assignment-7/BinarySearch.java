class BinarySearch{
	static int binarySearch( int a[], int lower, int upper,int key){
		int mid=(u-l)/2;
		int tempmp;
		
		if(a[mid]==key){
			return mid;
		}	
		else{
			if( key > a[mid] )
				 binarySearch(a,mid+1,upper,key);
			else	
				 binarySearch(a,lower,mid-1,key);
		}
		return -1;
	}
}

class Demo{
	public static void main(String arg[]){
		Scanner cin=new Scanner(System.in);
		int t=cin.nextInt();
		while(t>0){
			int size=cin.nextInt();
			int a=new int[size];
			for( int i=0; i<size; i++)	
				a[i]=cin.nextInt();
			//reading done	
			int key=cin.nextInt();
			int ans=BinarySearch.bins(a,0,size-1,key);
			System.out.println(ans);
			
			t--;
		}
	}
}	
