package first;

public class Try {
	public static void main(String args[]){
		//i am trying to append something to stringbuffer
		
		//case1 :no exception
		StringBuffer b=new StringBuffer();
		b.append(new StringBuffer("check"));
	
		//SOLVED //case2 :null pointer exception	
		StringBuffer[] pattern=new StringBuffer[5];
		for(int i=0; i<5; i++){
			pattern[i]=new StringBuffer();
		}
		pattern[0].append(new StringBuffer("check") );
		
		
	}
}
