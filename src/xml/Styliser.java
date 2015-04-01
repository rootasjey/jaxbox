package xml;

import java.io.IOException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.xml.sax.SAXException;

public class Styliser implements StyliserInterface {

	public Styliser() {
	}

	@Override
	public void transform(String xml, String xslt) throws TransformerException, TransformerConfigurationException,
	SAXException, IOException    
	{
		System.out.println("Transforming...");
		TransformerFactory tFactory = TransformerFactory.newInstance();
		Transformer transformer = tFactory.newTransformer(new StreamSource(xslt));
		 
		transformer.transform(new StreamSource(xml), new StreamResult("src/xml/xml-beautify.xml"));
		
		System.out.println("Transormation is done!");
	}
}
