package eeub10.project2;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 * 
 * @author Josh Gardner 
 * parses xml files 
 *
 */
public class XMLParser extends DefaultHandler {
	private URL url;
	private boolean input = false;
	private String internalString;
	private String content;
	private String start;
	private String end;
	
	public XMLParser (String url, String start, String end) throws MalformedURLException {
		this.url = new URL(url);
		
		this.start = start;
		this.end = end;
		input = false;
		internalString = "";
	}
	
	public String parse() throws SAXException, IOException {
		URLConnection conn = url.openConnection();
		
		InputStream inp = conn.getInputStream();
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse(new InputSource(inp), this);
		} catch (SAXException se) {
			se.printStackTrace();
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		return content;
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		//System.out.println("Started Document");
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		//System.out.println("End Document");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		//System.out.println(qName);
		if (qName.equals(start)) {
			input = true;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (input && qName.equals(end)) {
			System.out.println(internalString);
			input = false;
			content = internalString;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		internalString = new String(ch, start, length);
	}
	
	public String getContents() {
		return content;
	}
	
}
