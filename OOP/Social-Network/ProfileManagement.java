import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/*
interface ProfileManagementInterface{
	void addProfile(Profile p);
	Profile[] loadProfiles();
	Profile searchProfile();
	
}
*/
public class ProfileManagement  {

	String filename="D:/myfiles/profiledb.txt";
	/**
	 * 
	 */
	void addProfile (Profile p) throws IOException{
		
		FileOutputStream fout=new FileOutputStream( filename );
		ObjectOutputStream oout=new ObjectOutputStream( fout );
			
		oout.writeObject(p);
		oout.flush();
		
			
	}
	
	/**
	 * 
	 */
	
	List<Profile> loadProfiles() throws Exception{
		List<Profile> allProfiles=new ArrayList<Profile>();
		Profile temp;
		
		FileInputStream fin=new FileInputStream( filename );
		ObjectInputStream oin=new ObjectInputStream(fin);
		
		while( ( temp = (Profile)oin.readObject() ) != null ){
			allProfiles.add(temp);
		}
		
		oin.close();
		return allProfiles;	
	}
	
	/**
	 * 
	 */
	
	 Profile searchProfiles(String username) throws Exception{
		Profile desiredProfile;
		Profile temp;
		
		FileInputStream fin=new FileInputStream( filename );
		ObjectInputStream oin=new ObjectInputStream(fin);
		
		while( ( temp = (Profile)oin.readObject() ) != null ){
			if( temp.username.equals(username) == true ){
				desiredProfile=temp;
				return desiredProfile;
			}else{
				continue;
			}
		}
		
		oin.close();
		return null;
			
	}


}
