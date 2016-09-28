package dao;

import java.util.HashMap;
import java.util.Map;

public class MyUtil {
	public static boolean getBoolean(int binary){
		if(binary==0){
			return false;
		}else{
			return true;
		}
	}

	public static Map<String, String> getQueryMap(String query)  
     {  
         String[] params = query.split("&");  
         Map<String, String> map = new HashMap<String, String>();  
         for (String param : params)  
         {  
             String name = param.split("=")[0];  
             String value = param.split("=")[1];  
             map.put(name, value);  
         }  
         
         return map;  
    }
}
