
import java.util.ArrayList;
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
	public void generateUserInterface(){
		//responses
		String rs="Responses\n";
		
		char fillmore;
		do{
		
		
		for( int i=0; i < questions.length; i++ ){
			
			rs=rs+"Participant: "+ i +" ";
			//printing question id and title
			System.out.print("Question "+ questions[i].id +"       " );
			System.out.println( questions[i].title );
			
			//based on question type generating apt. field
			if( questions[i].type.equals("Single Select") )
			{
				System.out.println(" (Sinlge Choice) ");
				Integer singlechoice=generateSingleSelectField( questions[i] );
				rs=rs+singlechoice;
				
			}else if( questions[i].type.equals("Multi Select") )
			{
				System.out.println(" (Multiple Choice) ");
				ArrayList<Integer> al=generateMultiSelectField( questions[i] );
				rs=rs.concat( al.toString() );
				
			}else if( questions[i].type.equals("Number") )
			{
				System.out.println(" (Enter the number) ");
				int num=generateNumberField( questions[i] );
				rs=rs+num;
				
			}else if( questions[i].type.equals("Text") )
			{
				System.out.println(" (Enter Text) ");
				String text=generateTextField( questions[i] );
				rs=rs+text;
			}else{
				System.out.println("INVALID TYPE");
			}
			
			
		}
		rs=rs+"\n";
		
		System.out.println("\nSubmit Survey ? (y/n) ");
		fillmore=sc.next().charAt(0);
		}while(fillmore=='n');
		
		System.out.println(rs);
		
	}
	
	
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
