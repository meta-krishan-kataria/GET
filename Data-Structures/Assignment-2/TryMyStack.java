
public class TryMyStack {

	public static void main(String[] args) {
		
		MyStack<String> stack=new MyStack<String>();
		
		stack.push("A");
		stack.push("B");
		stack.push("C");
		
		System.out.println( stack.pop() );
		
		stack.push("D");;
		
		try{
			String s;
			while( ( s=stack.pop() ) != null ){		//parenthesis important because '!=' has higher precedence than '='
				System.out.println(s);
			}
			
		}catch(MyStackUnderFlowException ex){
			System.out.println( "Stack under flow" );
			ex.printStackTrace();
		}
		
		

	}

}
