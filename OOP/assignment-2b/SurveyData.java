
//Class to store survey data for single select questions
public class SurveyData {
	
	String qid;	//question id
	int responsesChart[];
	SurveyData[] surveyDatabase;
	
	
	public SurveyData(String qid, int numberOfOptions) {
		super();
		this.qid = qid;
		this.responsesChart= new int[numberOfOptions];
	}
	
	public void storeResposeForOption(int option){
		responsesChart[option]++;
	}
	
	//survey data for single select questions
		void createSurveyDatabase(QuestionInfo[] questions){
			//preparing survey database objects
			int numberOfSingleSelectQuestions=0;
			for(int i=0; i<questions.length; i++){
				if( questions[i].type.equals("Single Select") ){
					numberOfSingleSelectQuestions++;
				}
			}
			//
			surveyDatabase=new SurveyData[ numberOfSingleSelectQuestions ];
			
			//initializing survey database
			for(int i=0; i<questions.length; i++){
				if( questions[i].type.equals("Single Select") ){
					surveyDatabase[i]=new SurveyData(questions[i].id, questions[i].numberOfOptions );
				}
			}
			
		}
	
}
