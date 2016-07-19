
public class TowerOfHanoi {
	
		
	public String[] solve(int discs, String start, String aux, String end,String[] result){
		int i=0;
		if(discs == 1){// Base case (termination condition)
			
			result[i++]=new String( start+"->"+end);
		}
		else{
			solve(discs-1, start, end, aux, result);
			result[i++]= new String(start+"->"+end);
			solve(discs-1, aux, start, end, result);
		}
		return result;
	}
	


}
