public interface CalculationInterface {

	public int getFirstNumber();
	public int getSecondNumber();	
}



public abstract class Calculation implements CalculationInterface {

	public int firstNumber;
	public int secondNumber;
	
	 
	
	public Calculatition(){
		this.firstNumber =  0;
		this.secondNumber = 0;
	}
	
	public Calculation(int firstNumber, int secondNumber) {
	
		this.firstNumber =  firstNumber;
		this.secondNumber = secondNumber;
	}
	
}
public abstract class Operands{	
	Number firstNumber;
	Number secondNumber;
	
	public setFirstNumber(Number num1){
		this.firstNumber=num1;
	}
	
	public setSecondNumber(Number num2){
		this.secondNumber=num2;
	}
	
	
	public Number getFirstNumber() {

		return firstNumber;
	}

	
	public Number getSecondNumber() {

		return secondNumber;
	}
}


	
public abstract class Operations{
		char operationSymbol;
		Operands operands;
		Number num1;
		Number num2;
		
		void setOperationSymbol();
		
		num1=operands.getFirstNumber();
		num2=operands.getSecondNumber();
		
		Number doOperation(char symbol);
		
		Number addition(Number a,Number b);
		Number subtraction(Number a,Number b);
		Number multiplication(Number a,Number b);
		Number division(Number a,Number b);
}		
		
	
public abstract class ExpressionBuffer{
	public String expression;
	Operands operands;
	
	Number num1;
	Number num2;
		
	Number parseOperand(String expression);
	
	void clearExpression(String expression);
	
	
}	
	
public abstract class	Button{
	char symbol;
	char value;
	
	void setButton(char symbol,char value);
	char getButtonValue(Button b);
}
	
public abstract class Layout{
	public enum Layouts {"GRID","SPARSE","COMPACT"};
	String layoutType;
	
	void setLayout(String);
	String getLayout();

}

public abstract class Display{
	void clearDisplay();
	void printResult();
	void storeDisplayContent();
}

public abstract class Calculator extends Calculation{
	Number num1;
	Number num2;
	Number result;
	
	char symbol;
	
	String expression;
	ExpressionBuffer expBuffer;
	
	
	Button button;
	Layout layout;
	Display display;
	
	Operands operands;
	Operations operations;
	
	void intialise(Layout layout,Button buttonset[][],Display display);

	
}

public class DriverClass{
	Calculator calc=new Calculator();
	Button button;
	Layout layout;
	Display display;
	
	calc.initialise(layout,buttonset[][],display)
	clac.operands.setFirstNumber(num1);
	clac.operands.setSecondNumber(num2);
	
	clac.operations.setOperationSymbol(symbol);
	
	clac.result=Operations.doOperation(num1,num2,symbol);
	clac.display.printResult();

}




