import javax.xml.ws.Endpoint;

public class Deploiement {

	public static void main(String[] args) {
		String url = "http://localhost:8989/";
		Endpoint.publish(url, new WebServiceSoap()); //hndi...
		System.out.println("your web service is deployed");
		System.out.println("http://localhost:8989/?wsdl");
	}

}
