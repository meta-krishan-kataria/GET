
public class TowerOfHanoi {
	
	public String[] result;
	public int i;	
	public TowerOfHanoi(int N) {
		
		result=new String[(int) (Math.pow(2, N) - 1)];
		i=0;
	}

	//Using the algorithm
	/* 
	 
	 *1. Move first n-1 disks from source pole
	    to auxiliary pole using destination as
	    temporary pole
	 *2.  Move the remaining disk from source
	    pole to destination pole
	 *3. Move the n-1 disks from auxiliary (now source)
	    pole to destination pole using source pole as
	    temporary (auxiliary) pole

	 */
	void tower(int n, char sourcePole, char destinationPole, char auxiliaryPole)
	{
	   // Base case (termination condition)
	   if(n == 1){
		   System.out.println(sourcePole + "->" + destinationPole);
		   result[i]=new String(sourcePole + "->" + destinationPole);
		   i++;
		   return;
	   }
	     
	 
	   //step-1
	   tower(n-1, sourcePole, auxiliaryPole,
	      destinationPole);
	    
	   //step-2
	   System.out.println(sourcePole + "->" + destinationPole);
	   result[i]=new String(sourcePole + "->" + destinationPole);
	   i++;
	   
	   // step-3
	   tower(n-1, auxiliaryPole, destinationPole,
	     sourcePole);
	}

}
