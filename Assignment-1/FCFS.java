package first;

public class FCFS {
	 int [][]FCFS( int arrival_time [], int job_size[] ){
		 //assuming given inputs are sorted according to arrival time
		 
		 int n=arrival_time.length;	//no. of jobs
		 int time;
		 int[][] table=new int[n][5];
		 //[job no., arrival time, waiting time, started at, finished at]
		 
		 for(int i=0; i<n; i++){
			 			 
		 }
		 
		 for(int i=0; i<n ; i++){
			 time=1;
			 table[i][0]=i+1; 						//job no.
			 table[i][1]=arrival_time[i]; 			//arrival time
			 
			 for(int j=0; j<i ;j++){
				 time=time+job_size[j]; //adding job times for previous processes
			 }
			 
			 if(i>1 && arrival_time[i]>table[i-1][4] ){//when processor can be idle
				 table[i][2]=0;							//waiting time
				 table[i][3]=arrival_time[i];			//started at
				 table[i][4]=table[i][3]+job_size[i]-1;//finished time
			 }else{
				 table[i][3]=time;						//started at
				 table[i][4]=table[i][3]+job_size[i]-1;	//finished at
				 table[i][2] =time-arrival_time[i];		//waiting time
			 }
		 }
		 //printing array
		 for(int i=0; i<n; i++){
			 for(int j=0; j<5; j++){
				 System.out.print(table[i][j]+" ");
			 }
			 System.out.println();
		 }
		 	
		 
		 return table;
		 
		 
	 }
}
