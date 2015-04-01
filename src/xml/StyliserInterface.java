package xml;

import java.io.IOException;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public interface StyliserInterface {
	public void transform(String xml, String xslt) 
			throws TransformerException, TransformerConfigurationException, 
			SAXException, IOException;
}
