import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

//Component class
class  Component {
    private String componentName;
    private List<Component> childComponents = new ArrayList<Component>();
    
    Scanner sc=new Scanner(System.in);
    Component(){}
    
    Component(String name){
        componentName=name;
    }
    
    public void add(Component component) {
        childComponents.add(component);
    }
 
    public void remove(Component component) {
        childComponents.remove(component);
    }
 
    public void showName(){
        System.out.println(">"+componentName);
    }
    
    
    /*
     * Function to expand component
     * 
     * */
    public void expand(){
        //step-1 printing current component name
    	showName();
        //step-2 printing child components name
    	int i=0;
        for(Component c :childComponents){
            System.out.print(i+" ");
            c.showName();
            i++;
        }
        
        //step-3 asking for choice
        System.out.println("Enter your choice (Press -1 to move back)");
        int choice=sc.nextInt();
	        //if user wants to return
        	if(choice==-1){
	        	return;
	        }
        	//validating choice
        	while(  isChoiceValid(i, choice)==false  ){
        		System.out.println("Invalid choice");
        		choice=sc.nextInt();	//if not valid take input again
        	}
	    //step-4 expanding child element    
        Component child=childComponents.get(choice);
        child.expand();
        //step-5 recurring
        this.expand();
        
    }
    
    /*	Function to validate input choice
     * for void choice -> true
     * */
    boolean isChoiceValid(int i,int choice){
    	if(choice < i && choice >=0){
    		return true;
    	}else{
    		return false;
    	}
    }
    
}
 
/*
 * 
 * 	Leaf class
 */
class Leaf extends Component {
    String name;
    
    public Leaf(String s){
        super();
        name = s;
    }
    
    //over riding expand method
    public void expand() {
        System.out.println(name);
        int temp2=sc.nextInt();
        if(temp2==-1)
            return ;
    }
    
    public void showName() {
        System.out.println(name);
    }
}
 
 /*
  * Driver class to generate  menu
  * Example: Shopping portal
  * */
public class CompositePattern {
 
    public static void main(String[] args) {
        //Root element "Shop"
        Component componentRoot=new Component("Shop");
        
        //Making "Clothing" branch
        Component c1 = new Component("Clothing");
        Component  c1_1= new Component("Men's fashion");
        Component  c1_2= new Component("Women's fashion");
        
        Leaf c1_1_a=new Leaf("Shirts");
        Leaf c1_1_b=new Leaf("Trousers");
        
        Leaf c1_2_a=new Leaf("Tops");
        Leaf c1_2_b=new Leaf("Skirts");
        
        c1.add(c1_1);
        c1.add(c1_2);
        c1_1.add(c1_1_a);
        c1_1.add(c1_1_b);
        c1_2.add(c1_2_a);
        c1_2.add(c1_2_b);
        componentRoot.add(c1);
        
        //making "electronics" branch
        Component c2 = new Component("Electronics");        
        Leaf leaf3 = new Leaf("Computers");
        Leaf leaf4 = new Leaf("Mobiles");
        Leaf leaf5 = new Leaf("Home appliances");
        c2.add(leaf3);
        c2.add(leaf4);
        c2.add(leaf5);
        componentRoot.add(c2);
        
        //initializing menu
        componentRoot.expand();
    }
}
