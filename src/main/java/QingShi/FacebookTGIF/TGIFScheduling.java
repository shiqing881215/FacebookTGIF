package QingShi.FacebookTGIF;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * Class use timer to run TGIFTask each Friday
 * @author shiqing
 *
 */
public class TGIFScheduling {
	// One week
	private static final long period = 7*24*60*60*1000;
	
	/**
	 * Use timer to run the TGIFTask each Friday 00:00:00AM
	 * @param args
	 */
	public static void main(String[] args) {
		Timer timer = new Timer();
		Calendar date = getFriday();
	    long delay = date.getTimeInMillis() - new Date().getTime();
	    
	    timer.schedule(new TGIFTask(), delay, period);
	}
	
	/**
	 * Return Friday calendar object
	 * @return
	 */
	private static Calendar getFriday() {
		Calendar date = Calendar.getInstance();
	    date.set(Calendar.HOUR_OF_DAY, 0);
	    date.set(Calendar.MINUTE, 0);
	    date.set(Calendar.SECOND, 0);
	    date.set(Calendar.MILLISECOND,0);
	    date.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		
	    //in case you run the batch before date
	    if (date.before(Calendar.getInstance())) {
	        date.add(Calendar.DAY_OF_YEAR, 7);
	    }
	    
	    return date;
	}
}
