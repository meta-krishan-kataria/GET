package jdbc;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

//Class to handle database interaction
public class DataHandler {
	Connection con;
	Statement st;
	ResultSet rs;
	
	//URL strings
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/lis";
	
	//constructor, initializing database connection
	public DataHandler(){
		try {
			//registering for db ,opening connection and creating statement
			Class.forName(JDBC_DRIVER);
			con=DriverManager.getConnection(DB_URL,"root","root");
			st=con.createStatement();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	//task 1	getting books by author name
	List<Book> getBooksByAuthor(String authorName)
	{
		ResultSet rs;
		List<Book> books=new LinkedList<Book>(); 
		String query="SELECT t.title_name "
					+"FROM titles t "
					+"INNER JOIN title_author ta ON t.title_id=ta.title_id "
					+"WHERE ta.author_id=(SELECT author_id FROM authors WHERE author_name LIKE '"+authorName+"' )";
		System.out.println(query);
		
		try 
		{
			rs=st.executeQuery(query);
			
			while(rs.next())
			{
				Book b=new Book();
				b.setName(  rs.getString(1) );
				books.add(b);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return books;
		
	}
	
	
	//task 2 getting number of available book to be issued 
	public int getNumberOfAvailableBooks(String title){
		
		return getNumberOfTimesBookIssued(title) - getNumberOfTimesBookReturned(title) ;
		
	}
	
	//
	public int getNumberOfTotalBooks(String title){
		ResultSet rs;
		
		String query="SELECT COUNT(accession_number) "
					+"FROM books " 
					+"WHERE accession_number IN (SELECT accession_number FROM books " 
                            +"WHERE title_id=(SELECT title_id FROM titles "
                            	+"WHERE title_name LIKE '"+title+"' )  )";
		System.out.println(query);
		
		try 
		{
			rs=st.executeQuery(query);
			
			if(rs.next()){
				return rs.getInt(1);
			}else{
				return 0;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return 0;
		}
		
		
	}
	
	//
	public int getNumberOfTimesBookIssued(String title){
		ResultSet rs;
		
		String query="SELECT COUNT(accession_number) "
					+"FROM book_issue " 
					+"WHERE accession_number IN (SELECT accession_number FROM books " 
                            +"WHERE title_id=(SELECT title_id FROM titles "
                            	+"WHERE title_name LIKE '"+title+"' )  )";
		System.out.println(query);
		
		try 
		{
			rs=st.executeQuery(query);
			
			if(rs.next()){
				return rs.getInt(1);
			}else{
				return 0;
			}
			
		} catch (SQLException e) {
			
			//e.printStackTrace();
			return 0;
		}
		
		
	}
	
	
	//
	public int getNumberOfTimesBookReturned(String title){
		ResultSet rs;
		
		String query="SELECT COUNT(accession_number) "
					+"FROM book_return " 
					+"WHERE accession_number IN (SELECT accession_number FROM books " 
                            +"WHERE title_id=(SELECT title_id FROM titles "
                            	+"WHERE title_name LIKE "+title+" )  )";
		try 
		{
			rs=st.executeQuery(query);
			
			
			if(rs.next()){
				return rs.getInt(1);
			}else{
				return 0;
			}
			
		} catch (SQLException e) {
			
			//e.printStackTrace();
			return 0;
		}
		
		
	}
	
	
	//task-3
	//deleting books not issued for one year
	public int deleteBooks(){
		ResultSet rs;
		
		String query="DELETE FROM books WHERE accession_number NOT IN "
					+" (SELECT accession_number FROM book_issue WHERE TIMESTAMPDIFF(MONTH,NOW(),issue_dt) < 12 )";
		try 
		{
			return st.executeUpdate(query);
			
		} catch (SQLException e) {
			
			//e.printStackTrace();
			return 0;
		}
	}
	
	
	
	
}
