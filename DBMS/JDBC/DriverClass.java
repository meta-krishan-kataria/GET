package jdbc;
import java.util.*;


public class DriverClass {

	public static void main(String[] args) {
		DataHandler dh=new DataHandler();
		
		//task-1 books by author name
		String authorName="Bipul Jain";
		List<Book> books=dh.getBooksByAuthor(authorName);
		System.out.println(books);
		
		//task-2 number of available book to be issued 
		String title="Make It Happen";
		
		int availableCount=dh.getNumberOfTotalBooks(title);
		int totalbooks=dh.getNumberOfBooksCurrentyIssued(title);
		
		System.out.println("\n"+totalbooks+" Total books are there having title " + title);
		System.out.println("\n"+availableCount+" not issued");
		
		//task-3 deleting books not issued for one year 
		int numOfDeletedBooks=dh.deleteBooks();
		System.out.println( numOfDeletedBooks +" Books deleted" );
		
	}

}
