package first;

public class FindSequence {
	int[] longestSequence(int input[]){
		int f1=0, f2=0;	//flag variables
		int table[][]=new int[30][2];	//to store increasing sequences information found during traverse
		
		
		//creating table
		int j=0;
		for(int i=0;  i<input.length-1; i++){
			if(input[i+1]>=input[i]){
				f2=i+1;
				
			}else{
				//storing indexes for the found increasing sequence
				table[j][0]=f1;
				table[j][1]=f2;
				//updating flags
				f1=i+1;
				f2=i+1;		
				
				j++;
			}			
		}
		table[j][1]=f2;	//important
		table[j][0]=f1;	
			/*//printing table
			for(int i=0; i<30; i++){
				System.out.println(i+" "+table[i][0]+" "+table[i][1]);
			}*/
		//finding the longest sequence from the table 
		int maxLength=0;
		int indexOfMaxlength=-1;
		
		for(int i=0; i<30 ;  i++ ){
			int currentLength = table[i][1]-table[i][0];
			if( currentLength > maxLength ){
				maxLength=currentLength;
				indexOfMaxlength=i;
			}
		}
			//System.out.println("Max length is"+maxLength+" inddex at "+indexOfMaxlength);;
		
		//creating output array
		int output[]=new int[maxLength+1];
		System.out.println();
		for(int k=0,i=table[indexOfMaxlength][0]; i<=table[indexOfMaxlength][1] ; i++,k++){
			//System.out.println(input[i]+" ");
			output[k]=input[i];
			
		}
		System.out.println("final array");
		for(int x : output){
			System.out.println(x+" ");
		}
		return output;
		
	}

	
	
}
