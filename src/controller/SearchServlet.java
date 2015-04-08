package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.ws.Service;

import org.xml.sax.SAXException;

import soap.JaxboxServiceInterface;
import bean.Album;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("search--->");
		System.out.println(request.getParameter("q"));
		String requestTerms = request.getParameter("q");
		
		
		// SENDING REQUEST
		// ---------------
		URL url = new URL("http://localhost:9999/ws/jaxbox?wsdl");
		QName qname = new QName("http://soap/", "JaxboxServiceService");
		
		Service service = Service.create(url, qname);
		JaxboxServiceInterface jaxbox = service.getPort(JaxboxServiceInterface.class);
		
		Album[] albums;
		
		try {
			System.out.println("in the try------------");
			albums = jaxbox.searchAlbumArtist(requestTerms);
			
			System.out.println("[client] size: " + albums.length);
			for (Album album : albums) {
				System.out.println(album);
			}
			
			HttpSession session = request.getSession(true);
			session.setAttribute("list", albums);
			
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		
	}

}
