
/* Class to store information of a question*/
public class QuestionInfo {
	String id;
	String title;
	String type;
	String[] options;
	int numberOfOptions;
	boolean number;
	boolean text;
	
	
	
	public QuestionInfo() {
		
		this.id = "-1";
		this.title = null;
		this.type = null;
		this.options = null;
		this.numberOfOptions=0;
		this.number = false;
		this.text = false;
	}



	public void setQuestionInfo(String id, String title, String type, String[] options,
			int num_options,boolean number, boolean text) {
		
		this.id = id;
		this.title = title;
		this.type = type;
		this.options = options;
		this.numberOfOptions=num_options;
		this.number = number;
		this.text = text;
	}
	
	//function to show content
		//Note: For debugging purpose
	void show(){
		System.out.println("\nQid="+id+  "\ntitle="+title+    "\ntype="+type+
				"\nnumberofoptions="+numberOfOptions+   "\nnumeber?="+number+   "\ntext?="+text);
		
		System.out.println("\nOptions are");
		if(options != null){
			for(String s : options){
				System.out.println(s);
			}
		}	
	}
	
}
