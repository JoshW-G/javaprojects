package eeub10.project2;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

import org.xml.sax.SAXException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SAXException, IOException
    {
        String url = "https://weather-broker-cdn.api.bbci.co.uk/en/observation/rss/3042091";
        try {
			XMLParser p = new XMLParser(url, "item", "title");
			p.parse();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
