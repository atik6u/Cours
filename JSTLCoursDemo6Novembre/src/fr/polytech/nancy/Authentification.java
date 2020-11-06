package fr.polytech.nancy;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

public class Authentification implements Serializable{
	private boolean connexion;
	public Authentification() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void acces(HttpServletRequest request) {
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");
		
		if (pass.equals(login+"1234")) {
			this.connexion = true;
		} else {
			this.connexion = false;
		}
	}

	public boolean isConnexion() {
		return connexion;
	}

	public void setConnexion(boolean connexion) {
		this.connexion = connexion;
	}
	
	
}
