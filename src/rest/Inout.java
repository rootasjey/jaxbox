package rest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

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
	
	public static void postprocess(String input) throws IOException {
		saveFile(input);
	}
	
	// Save the input stream to a local file
	public static void saveFile(String input) throws IOException {
	     input = input.replace("><", ">\n<");
	    Writer out = new BufferedWriter(
	    		new OutputStreamWriter(
	    				new FileOutputStream("src/rest/album.xml"), "UTF-8"));
	    try {
			out.write(input); 	// write into the file
			out.close();		// close the file
			
			StyliserInterface styliser = new Styliser();
			register(styliser);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			out.close();
		}
	}
	
	public static void register(StyliserInterface styliser) {
		try {
			styliser.transform("src/rest/album.xml", "src/xml/album.xsl");
		} catch (TransformerException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
}
