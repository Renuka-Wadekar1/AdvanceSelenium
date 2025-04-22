package GenericUtilities;


import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * This Class consists of reusable methods related to java
 * @auther Renuka J
 */
public class JavaUtility {

	/*
	 * This method capture current system date and return to caller 
	 * @return
	 */
	public String getSystemDate() {
		Date d= new Date();
		SimpleDateFormat f=new SimpleDateFormat("dd-mm-yyyy_hh-mm-ss");
		String DateInFormat=f.format(d);
		return DateInFormat;
	
	}
	
}
