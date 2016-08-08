import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Class to create concordance of characters
 * */
 class ConcordanceOfCharacter {
	
	 /**
	  * creates concordance, store result in a map and returns the resultant map
	  * */
	public static Map<Character,List<Integer>> createConcordance(char[] str){
		
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
	
	/**
	 * @return list of unique characters of string from the map
	 * */
	public static List getUniqueCharacters(Map<Character,List<Integer>> map){
		List<Character> charList=new ArrayList<Character>();
		//getting all the keys
		for( Map.Entry< Character, List<Integer> > entry : map.entrySet() ){
			charList.add( entry.getKey() );
		}
		
		return charList;
	}
	
	/**
	 * utlity method to print the list
	 * */
	public static void printResult(List<Character> list){
		System.out.println();
		for( Character c : list ){
			System.out.println(c);
		}
	}
	
	
}

public class Assignment2 {
	public static void main(String arg[]){
		
		/*Map for recent input strings*/
		Map< String, List<Character> > map=new LinkedHashMap<String, List<Character>>(5);
		
		Scanner sc;
		do{
			//reading input string
			sc=new Scanner(System.in);
			System.out.println("Please Enter String (Enter -1 to terminate program)");
			String input=sc.nextLine();
			
			//checking for termination condition
			if(input.equals("-1")){
				break;
			}
			
			//checking if the input is there in recent list of strings
			if( map.containsKey(input) ){
				//if present, getting result from the map
				System.out.println("Duplicate");
				ConcordanceOfCharacter.printResult( map.get(input) );
				
			}else{
				
				//calculating result
				List<Character> result=ConcordanceOfCharacter.getUniqueCharacters( ConcordanceOfCharacter.createConcordance( input.toCharArray() ) );
				
				//printing
				ConcordanceOfCharacter.printResult( result );
				
				//storing in recent results
				map.put(input, result);
			}
			
	
			
		}while(true);
		
	}
}
