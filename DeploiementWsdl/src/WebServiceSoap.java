import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "http://www.monSite.com")
public class WebServiceSoap {
	
	public static ArrayList<Product> products = new ArrayList<>();
	static {
		products.add(new Product("Casque", 100, 110));
		products.add(new Product("Ordi", 500, 6000));
		products.add(new Product("Clavier", 60, 68));
		products.add(new Product("Souris", 80, 87));
		products.add(new Product("imprimante", 300, 315));
	}
	
	@WebMethod(operationName = "tous")
	public ArrayList<Product> AfficherTous() {
		return products;
	}
	
	@WebMethod(operationName = "Ajouter")
	public Product Ajouter(int code, String designation, double prix_achat, double prix_vente) {
		Product p = new Product(designation, prix_achat, prix_vente);
		products.add(p);
		return p;
	}
	
	@WebMethod(operationName = "plusCher")
	public ArrayList<Product> plusCher (@WebParam (name = "prix") double montant) {
		ArrayList<Product> productsPlus = new ArrayList<>();
		for (Product product : products) {
			if (product.getPrix_achat() >= montant) {
				productsPlus.add(product);
			}
		}
		return productsPlus;	
	}
	
	@WebMethod(operationName = "getProduct")
	public Product getProduct (@WebParam (name = "code") int code) {
		for (Product product : products) {
			if (product.getCode() == code) {
				return product;
			}
		}
		return null;	
	}
	
	@WebMethod(operationName = "changerNom")
	public String afficher() {
		return "appel fonction afficher...";
	}
	
	@WebMethod(operationName = "MaSomme")
	public double somme(@WebParam (name = "param1")double a, double b) {
		return a+b;
	}
	
	@WebMethod
	public double convertir(double a) {
		return a*1.16;
	}
}
