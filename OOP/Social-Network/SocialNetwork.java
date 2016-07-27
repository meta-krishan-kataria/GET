import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/*
 * 
 * 	GRAPH
 * 
 * 
 * */

public class SocialNetwork {
	
	private String username;	
	ProfileManagement profileManager;
	PostsManagement postManager;
	Scanner sc;
	
	public SocialNetwork(){
		profileManager=new ProfileManagement();
		postManager=new PostsManagement();
		sc=new Scanner(System.in);
	}
	
	
	public void start(String username) {
		this.username=username;
		
		System.out.println("Welcome  "+username );
		
		System.out.println("1: Show my profile");
		System.out.println("2: Show News Feed");
		System.out.println("3: Follow someone");
		System.out.println("4: Write a post");
		
		try{
		int choice=sc.nextInt();
		switch (choice){
		case 1: showProfile();
		break;
		case 2: showMyFeeds();
		break;
		case 3: follow();
		break;
		case 4: writePost();
		break;

		default:	;
		}	
		
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	
	
	void showProfile() throws Exception {
		Profile userProfile=profileManager.searchProfiles(username);
		System.out.println(userProfile);
	}
	
	void showMyFeeds() throws Exception{
		List<Post> allPosts;
		allPosts=postManager.getPostsOf(username);
		for(Post p : allPosts){
			System.out.println(p);
		}	
	}
	
	void follow() throws Exception{
		List<Profile> allProfiles=profileManager.loadProfiles();
		for(Profile p : allProfiles){
			System.out.println(p);
		}
	}
	
	void writePost() throws IOException{
		System.out.println("Wite here: ");
		String content=sc.nextLine();
		
		Post p=new Post(username,content);
		postManager.addPost(p);
	}
	

}
