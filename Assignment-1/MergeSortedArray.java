package first;

public class MergeSortedArray {
	int[] join(int a[], int asize, int b[], int bsize, int c[]){
		//using the algorithm as used in merge sort
		int i,j,k;
	    i = 0; // for index of first array
	    j = 0; // for index of second array
	    k = 0; // for index of merged array
	    
	    c=new int[asize+bsize];
	    
	    while (i < asize && j < bsize)
	    {
	        if (a[i] <= b[j])
	        {
	            c[k] =a[i];
	            i++;
	        }
	        else
	        {
	            c[k] = b[j];
	            j++;
	        }
	        k++;
	    }

	    /* Coping the remaining elements of a[], if there
	       are any */
	    while (i < asize)
	    {
	        c[k] = a[i];
	        i++;
	        k++;
	    }

	    /* Copy the remaining elements of b[], if there
	       are any */
	    while (j < bsize)
	    {
	        c[k] = b[j];
	        j++;
	        k++;
	    }
	    
	    for(int x : c){
	    	System.out.println(x+" ");
	    }
	    
	    return c;
	}
}
