import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class InputFileParser {
	
	/* Function to read file line by line and return lines as String[] */
	public ArrayList<String> readInputFile(File fin) throws IOException {
		ArrayList<String> allLines=new ArrayList<String>();
		FileInputStream fis = new FileInputStream(fin);
	 
		//Construct BufferedReader from InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
	 
		String line = null;
		System.out.println("**************Printing file content*****************");
		while ((line = br.readLine()) != null) {
			allLines.add(line);
			System.out.println(line);
		}
		System.out.println("****************************************************");
		br.close();
		return allLines;
	}
	
	
	/* Function to parse line and store question description in QuestionInfo Object */
	public QuestionInfo parseQuestionDescription(String line){
		
		QuestionInfo question=new QuestionInfo();
		
		StringTokenizer stk=new StringTokenizer(line,".,");
		//first token is question id
		question.id=stk.nextToken().trim();
		
		//second token is question title
		question.title=stk.nextToken().trim();
		
		//third token is question type
		question.type=stk.nextToken().trim();
		
		//reading next token based on question type
		if(question.type.equals("Single Select"))
		{
			String optionsToken=stk.nextToken().trim();
			question.options=readOptions(optionsToken,question);
			
		}else if(question.type.equals("Multi Select") )
		{
			String optionsToken=stk.nextToken().trim();
			question.options=readOptions(optionsToken,question);
		}else if(question.type.equals("Number") )
		{
			question.number=true;
		}else if(question.type.equals("Text") )
		{
			question.text=true;
		}
		
		return question;
		
	}
	

	
	//function to parse options from options token
	public String[] readOptions(String optionsToken, QuestionInfo ques){
		String[] tempOptions=new String[10];
		int optionsCount=0;
		
		//parsing tokens
		StringTokenizer stk=new StringTokenizer(optionsToken, "()/");
		while(stk.hasMoreElements()){
			optionsCount++;
			tempOptions[optionsCount-1]=stk.nextToken();
			
		}
		//filling number_of_options
		ques.numberOfOptions=optionsCount;
		
		//returning tokens
		String[] outStringArray=new String[optionsCount];
		
		for(int i=0; tempOptions[i]!=null; i++){
			outStringArray[i]=tempOptions[i];
		}
		return outStringArray;
		
	}
	
}
