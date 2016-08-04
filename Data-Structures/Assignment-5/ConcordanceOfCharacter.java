import java.util.*;

public class ConcordanceOfCharacter {
	
	public Map<Character,List<Integer>> createConcordance(char[] str){
		Map<Character,List<Integer>> map=new HashMap< Character, List<Integer> >();
		
		
		//traversing string
		for(Integer i=0; i < str.length;  i++){
			
			Character c=new Character(str[i]);
			
			//if map already contains 'c' as key, then appending list with the new index of 'c'
			if( map.containsKey( c ) )
			{
				//getting old value
				List<Integer> list=map.get(c);
				//appending
				list.add( i );
				//updating in map
				map.put(c, list);
				
			}
			else
			{		//if 'c' is not there as key creating a new entry
				//creating new list and initializing with i
				List<Integer> tempList=new ArrayList<Integer>();
				tempList.add(i);
				map.put(c , tempList);
			}
			
		}
		
		return map;
	}
	
	
	public static void main(String arg[]){
		char[] str="Hello world".toCharArray(); 
		//printing array
		for(int i=0; i<str.length ; i++){
			System.out.print(str[i]+"  ");
		}
		System.out.println();
		for(int i=0; i<str.length ; i++){
			System.out.print(i+"  ");
		}
		
		
		ConcordanceOfCharacter concordance=new ConcordanceOfCharacter();
		
		Map<Character,List<Integer>> map=concordance.createConcordance(str);
		
		System.out.println("\n");
		for( Map.Entry< Character, List<Integer> > entry : map.entrySet() ){
			System.out.println( entry.getKey() + " = " + entry.getValue() );
		}
		
	}
	
}
