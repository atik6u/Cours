package fr.polytech.nancy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// ici, on definit la couche metier de notre application
public class Etudiants {
	
	public List<Etudiant> afficherTousLesEtudiants() {
		List<Etudiant> resultat = new ArrayList<Etudiant>();
		
		// Chargement du driver de MySQL 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	// exception surveillée
		} catch (ClassNotFoundException e) {
			System.out.println("Le driver n'est pas chargé");
		}
		
		//se connecter à la base de données
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cm13novembre?useSSL=false", "root", "root");
			statement = connection.createStatement();
			// Executer une requete
			resultSet = statement.executeQuery("SELECT * FROM `etudiants`;");
			
			//recuperation des donnees
			int identifiant;
			String nom, prenom;
			while (resultSet.next()) {
				identifiant = resultSet.getInt("identifiant");
				nom = resultSet.getString("nom");
				prenom = resultSet.getString("prenom");
				resultat.add(new Etudiant(identifiant, nom, prenom));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Problème de connexion à la base de données");
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				System.out.println("Problem dans la methode close()");
			}
		}
		
		return resultat;
	}
}
