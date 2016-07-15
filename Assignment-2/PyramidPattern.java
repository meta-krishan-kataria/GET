
public class PyramidPattern {
	
	/*********************************************/
	StringBuffer[] printPyramidPattern(int n){
		//n-> no. of rows
		StringBuffer[] pattern=new StringBuffer[2*n-1];	
		
		//initializing 'pattern' to avoid nullpointerexception
		for(int i=0; i<2*n-1 ; i++){
			pattern[i]=new StringBuffer();
		}
		
		
		//upper triangle
		int arrayindex=0;
		for(int i=1;   i<=n;  i++,arrayindex++){
			
			
			pattern[arrayindex].append(spaces(n,i));
			pattern[arrayindex].append(number(i));
			pattern[arrayindex].append(spaces(n,i));
			//
			System.out.println(pattern[i-1]);
		}
		
		//lower triangle
		for(int i=n-1;   i>0    ; i--,arrayindex++){
			pattern[arrayindex].append(spaces(n,i));
			pattern[arrayindex].append(number(i));
			pattern[arrayindex].append(spaces(n,i));
			//
			System.out.println(pattern[i-1]);
		}
		return pattern;
		
		
	}
	/*************************************************/
	
	//function to print spaces
	public static StringBuffer spaces(int n,int row_no){
		StringBuffer spacestr=new StringBuffer("");
		for(int i=1;  i<= n-row_no; i++ ){
			spacestr.append('-'); //space char
		}
		
		return spacestr;
	}
	//function to print numbers
	public static StringBuffer number(int row_no){
		//generating number
		// 
		int num=1;
		for(int i=1; i < row_no ; i++ ){
			num*=10;
			num+=1;
		}
		num=num*num;		
		return new StringBuffer(Integer.toString(num));	
	}
	
	
	//main function
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PyramidPattern ob=new PyramidPattern();
		StringBuffer pattern[]=ob.printPyramidPattern(5);
		
	}

}
