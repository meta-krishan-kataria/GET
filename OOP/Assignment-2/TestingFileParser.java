import java.io.*;
import java.util.ArrayList;


public class TestingFileParser {

	public static void main(String[] args) throws Exception{
		File inputFile=new File("D:/myfiles/input1.txt");
		
		//reading file for question descriptions
		InputFileParser parser=new InputFileParser();
		ArrayList<String> questionDescription=parser.readInputFile( inputFile );
		
		//creating QuestionInfo objects
		QuestionInfo questionSet[]=new QuestionInfo[ questionDescription.size() ];
		
		for(int i=0; i<questionSet.length;  i++)
		{
			questionSet[i]=parser.parseQuestionDescription( questionDescription.get(i) );
		}
		
		//printing objects
		System.out.println("*****************Printing Question Info***********************");
		for(QuestionInfo q : questionSet){
			q.show();
		}
		System.out.println("***************************************************************");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("                       FORM");
		UserInterface UI=new UserInterface(questionSet);
		UI.generateUserInterface();
		
		
	}

}
