package src.main;

import java.util.ArrayList;
import java.util.List;
import src.dao.DaoFactory;
import src.dao.UtilisateurDao;
import src.modele.Ville;

public class Main {
	
		//Attribut
		
		private UtilisateurDao utilisateurDao;
		
		public void init() {
		}	

	public static void main(String[] args) {		
		List<Ville> villes = new ArrayList<Ville>();
		UtilisateurDao utilisateurDao;
		DaoFactory daoFactory = DaoFactory.getInstance();
		utilisateurDao = daoFactory.getUtilisateurDao();
		villes = utilisateurDao.getVille();		
		for(int i=0; i<=villes.size()-1;i++) {
			System.out.println(villes.get(i).getNom());
		}
	}

}
