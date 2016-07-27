
public class DriverClass {

	public static void main(String[] args) {
		ProfileAdder pfa=new ProfileAdder();
		PostsAdder pta=new PostsAdder();
		
		pfa.createProfile();
		pta.createPosts();
		
		SocialNetwork sn=new SocialNetwork();
		sn.start("krish");

	}

}
