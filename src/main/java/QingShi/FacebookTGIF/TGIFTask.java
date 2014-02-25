package QingShi.FacebookTGIF;

import java.util.TimerTask;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;

/**
 * Task class to post TGIF on facebook
 * @author shiqing
 *
 */
public class TGIFTask extends TimerTask {

	@Override
	public void run() {
		// Need to figure out the automatic way to update the access token
		String accessToken = "YOUR_ACCESS_TOKEN";
		FacebookClient facebookClient = new DefaultFacebookClient(accessToken);

		FacebookType publishMessageResponse = facebookClient.publish("me/feed", FacebookType.class,
			    Parameter.with("message", "TGIF"));
		
		System.out.println("Published message ID: " + publishMessageResponse.getId());
	}
}
