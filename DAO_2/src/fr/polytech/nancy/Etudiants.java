package fr.polytech.nancy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// ici, on definit la couche metier de notre application
public class Etudiants {
	private Connection connection;
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void seConnecter() {
		
		// Chargement du driver de MySQL 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	// exception surveillée
		} catch (ClassNotFoundException e) {
			System.out.println("Le driver n'est pas chargé");
		}
		//se connecter à la base de données
		try {
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cm13novembre?useSSL=false", "root", "root");
		} catch (Exception e) {
			System.out.println("Erreur connexion à la base des donnees");
		}
	}
	
	public List<Etudiant> afficherTousLesEtudiants() {
		List<Etudiant> resultat = new ArrayList<Etudiant>();
		
		this.seConnecter();
		
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			
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
	
	public void ajouterEtudiant(Etudiant etudiant) {
		// Connxion àla base des données
		this.seConnecter();
		//faille d'injection SQL
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement("INSERT INTO `etudiants`(`identifiant`, `nom`, `prenom`) VALUES (?,?,?);");
			preparedStatement.setInt(1, etudiant.getId());
			preparedStatement.setString(2, etudiant.getNom());
			preparedStatement.setString(3, etudiant.getPrenom());
			
			//executer la requete
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("Erreur ajouterEtudiant");
		}
	}
	
	public void modifierEtudiant(int id, String nom, String prenom) {
		// Connxion àla base des données
		this.seConnecter();
		//faille d'injection SQL
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement("UPDATE `etudiants` SET `nom`=?,`prenom`=? WHERE `identifiant`=?;");
			preparedStatement.setString(1, nom);
			preparedStatement.setString(2, prenom);
			preparedStatement.setInt(3, id);
			
			//executer la requete
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("Erreur modifierEtudiant");
		}
	}
	
	public Etudiant supprimerEtudiant(int id) {
		// Connxion àla base des données
		this.seConnecter();
		ResultSet resultSet = null;
		Etudiant etudiantSupprime = null;
		
		try {
			// Recuperer les information de l'etudiant à supprimer
			PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM `etudiants` WHERE `identifiant`=?;"); 
			preparedStatement.setInt(1, id);
			
			//executer la requete
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			int identifiant;
			String nom, prenom;
			identifiant = resultSet.getInt("identifiant");
			nom = resultSet.getString("nom");
			prenom = resultSet.getString("prenom");
			etudiantSupprime = new Etudiant(identifiant, nom, prenom);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Etudiant n'existe pas");
			etudiantSupprime = new Etudiant(0, "", "");
		}
		
		//faille d'injection SQL
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement("DELETE FROM `etudiants` WHERE `identifiant`=?;"); 
			preparedStatement.setInt(1, id);
			
			//executer la requete
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("Erreur supprimerEtudiant");
		}
		return etudiantSupprime;
	}
}
