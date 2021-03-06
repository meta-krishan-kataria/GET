
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class UserInterface {
	//QuestionInfo[] questionSet;
	
	//SurveyData[] surveyDatabase;
	Scanner sc;
	QuestionInfo[] questions;
	
	//Constructor to initialize object with Questions Info
	public UserInterface(QuestionInfo[] ques) {
		questions=ques;
		sc=new Scanner(System.in);
	}
	
	//main function to generate user Interface
	public QuestionInfo[] generateUserInterface(){
		//responses (arraylist of String Buffer)
		List<String> output=new ArrayList<String>();
		List<StringBuffer> output2=new ArrayList<StringBuffer>();
		
		
		char fillmore;
		int p=0;	//participant number
		
		//Loop for new participants
		do{
		p++;
		
		String rs="Participant: "+ p +" ";
		
		StringBuffer rs2=new StringBuffer();
		rs2.append("Participant:");
		rs2.append(p);
		rs2.append("  ");
		
		//expanding questions
		for( int i=0; i < questions.length; i++ ){
			
			
			//printing question id and title
			System.out.print("Question "+ questions[i].id +"       " );
			System.out.println( questions[i].title );
			
			//based on question type generating apt. field
			if( questions[i].type.equals("Single Select") )
			{
				System.out.println(" (Sinlge Choice) ");
				Integer singlechoice=generateSingleSelectField( questions[i] );
				rs=rs+singlechoice;
				rs2.append(singlechoice);
				rs2.append("  ");
				
				//recording response for survey report
				questions[i].recordResponseData(singlechoice);
				
			}else if( questions[i].type.equals("Multi Select") )
			{
				System.out.println(" (Multiple Choice) ");
				ArrayList<Integer> al=generateMultiSelectField( questions[i] );
				rs=rs + al.toString() ;
				rs2.append(al);
				rs2.append("  ");
				
			}else if( questions[i].type.equals("Number") )
			{
				System.out.println(" (Enter the number) ");
				int num=generateNumberField( questions[i] );
				rs=rs+num;
				rs2.append(num);
				rs2.append("  ");
				
			}else if( questions[i].type.equals("Text") )
			{
				System.out.println(" (Enter Text) ");
				String text=generateTextField( questions[i] );
				rs=rs+text;
				rs2.append(text);
				rs2.append("  ");
				
			}else{
				System.out.println("INVALID TYPE");
			}
			
			
		}
		
		output.add(rs);
		output2.add(rs2);
		//System.out.println(rs);
		
		System.out.println("\nFill another form ? (y/n) ");
		fillmore=sc.next().charAt(0);
		}while(fillmore=='y');
		
		//printing responses at the end of survey
		for(StringBuffer s:output2){
			System.out.println(s);
		}
		
		//writing response to file
		FileWrite.writeToFile(output2);
		
		
		//returning questions for survey report generation		
		return questions;
		
	}
	
	
	
	/*
	 * FunctionS to generate specific field for different type of questions
	 * 
	 * */
	
	public int generateSingleSelectField( QuestionInfo q ){
		int singleChoice;
		int serial_no=1;
		for(int i=0; i < q.numberOfOptions; i++){
			System.out.println(" ("+serial_no+")"+  q.options[i]);
			serial_no++;
		}
		System.out.println("Enter your choice ");
		singleChoice=sc.nextInt();
		return singleChoice;
		
	}
	
	public ArrayList<Integer> generateMultiSelectField( QuestionInfo q ){
		ArrayList<Integer> choices=new ArrayList<Integer>();
		Integer temp;
		
		int serial_no=1;
		//printing options
		for(int i=0; i<q.numberOfOptions; i++)
		{
			System.out.println(" ("+serial_no+")"+  q.options[i]);
			serial_no++;
		}
		
		System.out.println("Enter your choice ");
		//reading response
		System.out.println("<type -1 to terminate choices>");
		while(  ( temp=new Integer( sc.nextInt() ) ) != -1 )
		{
			choices.add(temp );
		}
		return choices;
	}
	
	public int generateNumberField( QuestionInfo q  ){
		int responseNumber=sc.nextInt();
		return responseNumber;
	}
	
	public String generateTextField( QuestionInfo q  ){
		String temp=sc.nextLine();
		String responseText=sc.nextLine();
		return responseText;
	}
	
	
}
