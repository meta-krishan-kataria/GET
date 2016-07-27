
 class SurveyReport {
	
	 //function to generate survey report
	 void generateSurvryReport(QuestionInfo[] ques){
		//reading all questions
		for(int i=0; i<ques.length; i++){
			//if single select question
			if( ques[i].type.equals("Single Select") ){
				System.out.println("Question:  "+ques[i].id);
				//reading frequency for all selected options
				for(int j=0; j < ques[i].freqChart.length ; j++){
					System.out.print("Option"+j+" ");
					System.out.println( getPercentage( ques[i].freqChart[j], getTotalResponses(ques[i].freqChart) ) );
				}
				
			}
		}
	}
	
	int getTotalResponses(int[] freqChart){
		int total=0;
		for(int i=0; i<freqChart.length ;i++){
			total+=freqChart[i];
		}
		return total;
	}
	
	double getPercentage(double numerator, double denominator){
		return (numerator/denominator)*100;
	}
}
