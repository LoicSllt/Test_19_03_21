package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.modele.Ville;

//@Repository
public class VilleDaoImpl implements VilleDao {
	
	//Attribut
	
	private DaoFactory daoFactory;
	
	//Constructeur
	
    public VilleDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
	
    //Méthode
    
    public List<Ville> getVille() {
    	
    	List<Ville> villes = new ArrayList<Ville>();
    	
    	Connection connexion = null;
		PreparedStatement statement = null;		
		ResultSet resultat = null;		
		
		try {
			connexion = this.daoFactory.getConnection();
			statement = connexion.prepareStatement("SELECT * FROM ville_france ORDER BY Nom_commune ASC");
			resultat = statement.executeQuery();
			
			while(resultat.next()) {
				String code = resultat.getString("Code_commune_INSEE");
				String nom = resultat.getString("Nom_commune");
				String codePostal = resultat.getString("Code_postal");
				String libelle = resultat.getString("Libelle_acheminement");
				String ligne = resultat.getString("Ligne_5");
				String latitude = resultat.getString("Latitude");
				String longitude = resultat.getString("Longitude");
				
				System.out.println(nom);
				
				Ville ville = new Ville(code, nom, codePostal, libelle, ligne, latitude, longitude);
				villes.add(ville);
			}
		}
		catch(SQLException e) {
			
		}
		return(villes);
    }
    
    public Ville getVilleByCodePostal(String codePostal) {
    	
    	Ville ville = null;
    	
    	Connection connexion = null;
		PreparedStatement statement = null;		
		ResultSet resultat = null;	
		
		try {
			connexion = this.daoFactory.getConnection();
			statement = connexion.prepareStatement("SELECT * FROM ville_france WHERE Code_postal = ?");
			statement.setString(1, codePostal);
			resultat = statement.executeQuery();			
			
			while(resultat.next()) {
				String code = resultat.getString("Code_commune_INSEE");
				String nom = resultat.getString("Nom_commune");
				String codPostal = resultat.getString("Code_postal");
				String libelle = resultat.getString("Libelle_acheminement");
				String ligne = resultat.getString("Ligne_5");
				String latitude = resultat.getString("Latitude");
				String longitude = resultat.getString("Longitude");
				
				ville = new Ville(code, nom, codPostal, libelle, ligne, latitude, longitude);				
			}
		}
		catch(SQLException e) {
			
		}
		return(ville);
    }    
}