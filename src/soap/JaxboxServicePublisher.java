package soap;

import javax.xml.ws.Endpoint;

public class JaxboxServicePublisher {
	
	public static void main(String[] args) {
		   Endpoint.publish("http://localhost:9999/ws/hello", new JaxboxService());
		   
		   System.out.println("Service Started!");
	}

}
