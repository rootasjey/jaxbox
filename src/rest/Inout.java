package rest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import xml.Sax;
import xml.Styliser;
import xml.StyliserInterface;

/*
 * This Class help to read and write files
 */
public class Inout {

	public Inout() {
		
	}
	
	/*
	 * Read a file from a path and return a string
	 */
	public static String readfile(String file) {
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append(System.lineSeparator());
	            line = br.readLine();
	        }
	        
	        return sb.toString();
	    } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	// Save the input stream to a local file
	public static void saveFile(String input, String source) throws IOException {
		String filePath = "src/rest/" + source + ".xml";
	     input = input.replace("><", ">\n<");
	     
	    Writer out = new BufferedWriter(
	    		new OutputStreamWriter(
	    				new FileOutputStream(filePath), "UTF-8"));
	    try {
			out.write(input); 	// write into the file
			out.close();		// close the file
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			out.close();
		}
	}
	
	// Launch these methods after a previous process
	public static void postprocess(String input, String source, String type) 
			throws IOException, ParserConfigurationException, SAXException {
		
		// Build the file path
		String filePath = "src/rest/" + source + ".xml";
		
		// Save the file locally
		saveFile(input, source);
		
		// Test the source
		if (source.equals("lastfm")) {
			// We want this source to be the main
			StyliserInterface styliser = new Styliser();
			register(styliser, filePath, source, type);
			
		} else {
			
			// For others sources
			// Parse with SAX the other XML's API (Musicbrainz)
			Sax.compare("src/rest/" + source + ".xml");
		}
	}
	
	// Callback method
	public static void register(StyliserInterface styliser, String file, String fileName, String type) 
			throws ParserConfigurationException {
		try {
			
			// Test the query's type
			if (type.equals("album")) {
				// Format the xml
				styliser.transform(file, "src/xml/album.xsl", fileName);
				Sax.mediaType = "album";
				
			} else if (type.equals("artist")) {
				// Format the xml
				styliser.transform(file, "src/xml/artist.xsl", fileName);
				Sax.mediaType = "artist";

			} else if (type.equals("track")) {
				// Format the xml
				styliser.transform(file, "src/xml/track.xsl", fileName);
				Sax.mediaType = "track";
				
			}
			

			Sax.parse("src/xml/" + fileName + ".xml");
			
		} catch (TransformerException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
}
