package rest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

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
	public static void saveFile(String input) throws IOException {
	    // input = input.replace("><", ">\n<");
	    Writer out = new BufferedWriter(
	    		new OutputStreamWriter(
	    				new FileOutputStream("src/rest/lastfm-album.xml"), "UTF-8"));
	    try {
	    	// Write into the file
			out.write(input);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			// Close the stream
			out.close();
		}
	}
}
