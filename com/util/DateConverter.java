/**
 * 
 */
package com.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Krishan Kataria
 *
 */
public class DateConverter {

	/**
	 * converts the the string containing date to java.sql.Timestamp
	 * @param String having date in 'dd-MM-yyyy' format
	 * @return Timestamp
	 * */
	public static Timestamp convertToTimestamp(String dateInString){
		
		Timestamp dateInTimestamp = null;
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		try {

			Date date = formatter.parse(dateInString);
			dateInTimestamp= new Timestamp( date.getTime() );

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return dateInTimestamp;

	}

	
	public static String covertToString( Timestamp dateInTimeStamp  ){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date =  new Date( dateInTimeStamp.getTime() );
		return formatter.format(date);
	}

}
