import java.io.*;
import java.util.List;
class FileWrite 
{
   public static void writeToFile(List<StringBuffer> content)
  {
      try{
	    // Create file 
	    FileWriter fstream = new FileWriter("D:/myfiles/out.txt");
	    BufferedWriter out = new BufferedWriter(fstream);
	    
	    //writing to file
	    for( StringBuffer line :content ){
	    	out.write( line.toString() + "\n");
	    }
	    

	    //Close the output stream
	    out.close();
	    
    }catch (Exception e){//Catch exception if any
    	System.err.println("Error: " + e.getMessage());
    }
  }
}