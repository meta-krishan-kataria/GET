
public class Pattern2 {
	
	//global variables
	static char[][] myGlobal2dArray;
	static int cursor=0;
	/*********************************************/
		//Version-1
	public static void printPattern(int n){
		for(int i=0; i<n ; i++){
			
			//spaces
			for(int space=0; space<i ; space++){
				System.out.print("-");
			}
			//number
			int num=1;
			for(int m=0 ; m<n-i ; m++){
				System.out.print(num);
				num++;
			}
			System.out.println();
			
		}
	}
	/**********************************************/
		//version-2
	//with well defined modularity
		static char[][] printPattern2(int n){
			myGlobal2dArray=new char[n][n];
			for(int i=0; i<n ; i++){
				//reseting cursor to left
				cursor=0;
				
				spaces(n,i);
				numbers(n,i);
				
			}
			for(int i=0; i<n ; i++){
				for(int j=0; j<n;  j++){
					System.out.print(myGlobal2dArray[i][j]);
				}
				System.out.println();
			}
			
			return myGlobal2dArray;	
		}
	/*********************************************/
	//func. to fill spaces
		public static  void spaces(int n,int row){
			for(int s=0; s<row; s++){
				myGlobal2dArray[row][cursor]='-';
				cursor++;
			}			
		}
	//func. to fill numbers
		public static void numbers(int n,int row){
			int num=1;
			for(int m=0 ; m<n-row ; m++){
				myGlobal2dArray[row][cursor]=Integer.toString(num).charAt(0);	//* casting
				cursor++;
				num++;
			}
		}	
	

	
	public static void main(String arg[]){
		Pattern2.printPattern(5);
		Pattern2.printPattern2(5);
		
	}
	
	
}
