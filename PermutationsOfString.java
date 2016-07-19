
public class PermutationsOfString {
	
	//boolean array to know which symbols have been used or not
	boolean[] used;
	char[] input;	
	char[] output;
	
	//constructor
	PermutationsOfString(char[] a){
		input=a;
		output=new char[a.length];
		used=new boolean[a.length];	
		
	}
	
	//function to clean boolean array
	void cleanArray(){		
		//true->symbol used			false->not used
		for( int i=0; i < used.length ; i++ ){
			used[i]=false;
		}
	}
	
	//function to get unused symbol from input string 
	char getUnusedSymbol(){
			
		char symbol='#';
		int i;
		for( i=0; i< used.length ; i++){
			if( used[i]==false ){
				symbol=input[i];
				break;	//
			}
		}
		//updating 'used' array
		//at the bank
		if( i==used.length ){
			return '#';		// '#' implies null(when nothing removed)
		}else{
			used[i]=true;
			return symbol;
		}
	}	
	
	//function to generate permutations
	void permute(char[] a, int L,int H){
		if(L==H){
			System.out.println(output);
		}else{
			for(int i=L; i<=H; i++ ){
				output[i]=getUnusedSymbol();
				permute(a,L+1,H);
				cleanArray();
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char arr[]={'a','b','c'};
		PermutationsOfString ob=new PermutationsOfString(arr);
		ob.permute(arr, 0, 2);
	}

}
