import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/*
interface PostsManagementInterface{
	void addPost(Post p);
	Post[] loadPosts();
	Post[] getPostsOf(String username);
	
}
*/


class PostsManagement  {
	
	String filename="D:/myfiles/postsdb.txt";
	/**
	 * 
	 */
	void addPost (Post p) throws IOException{
		
		FileOutputStream fout=new FileOutputStream( filename );
		ObjectOutputStream oout=new ObjectOutputStream( fout );
			
		oout.writeObject(p);
		oout.flush();
		
			
	}
	
	/**
	 * 
	 */
	
	List<Post> loadPosts() throws Exception{
		List<Post> allPosts=new ArrayList<Post>();
		Post temp;
		
		FileInputStream fin=new FileInputStream( filename );
		ObjectInputStream oin=new ObjectInputStream(fin);
		
		while( ( temp = (Post)oin.readObject() ) != null ){
			allPosts.add(temp);
		}
		
		oin.close();
		return allPosts;	
	}
	
	/**
	 * 
	 */
	
	 List<Post> getPostsOf(String username) throws Exception{
		List<Post> desiredPosts=new ArrayList<Post>();
		Post temp;
		
		FileInputStream fin=new FileInputStream( filename );
		ObjectInputStream oin=new ObjectInputStream(fin);
		
		while( ( temp = (Post)oin.readObject() ) != null ){
			if( temp.username.equals(username) == true ){
				desiredPosts.add(temp);
			}else{
				continue;
			}
		}
		
		oin.close();
		
		return desiredPosts;	
	}

	
}
