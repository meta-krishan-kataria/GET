import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class SortingDemo {

	public static void main(String[] args) {
		
		ArrayList<QuestionInfo> qset=new ArrayList<QuestionInfo>();
		QuestionInfo q1=new QuestionInfo();
		q1.setTitle("Feedback");
		QuestionInfo q2=new QuestionInfo();
		q2.setTitle("Rate performance");
		QuestionInfo q3=new QuestionInfo();
		q3.setTitle("Rate Accuracy");
		
		qset.add(q3);
		qset.add(q1);
		qset.add(q2);
		
		

		Collections.sort(qset);
		System.out.println("After Sorting");
	
		for(QuestionInfo q : qset){
			System.out.println(q);
		}
		
	}

}
