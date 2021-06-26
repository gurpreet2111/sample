package masterSelenium1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class GetLinkStatus {
	
	
	static int invalidLink;
	
	
	
	public static void verifyLink(String linkString)
	{
		
		
		try {
			URL url = new URL(linkString);
			
			//Open HTTP connection
			HttpsURLConnection urlConnect = (HttpsURLConnection) url.openConnection();
			
			//Define timeout
			urlConnect.setConnectTimeout(50000);
			
			//Hit URL
			urlConnect.connect();
			
			if(urlConnect.getResponseCode()==200)
			{
				
			}else{
				System.out.println(linkString + " : "+ urlConnect.getResponseMessage()+" : "+urlConnect.HTTP_NOT_FOUND);
				invalidLink++;
			}
			
			
		} catch (  Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void getinvalidLinkCount()
	{
		System.out.println("Total invalid links "+invalidLink);
	}

}
