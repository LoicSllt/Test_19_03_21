package com.blo;

import java.util.ArrayList;
import java.util.List;
import com.dao.DaoFactory;
import com.dao.VilleDao;
import com.modele.Ville;

public class VilleBloImpl implements VilleBlo {
	
	private DaoFactory daoFactory = DaoFactory.getInstance();
	private VilleDao villeDao = daoFactory.getUtilisateurDao();
	
	public List<Ville> getInfoVille(String parametre) {
		
		List<Ville> villes = new ArrayList<Ville>();
				
		if(parametre == null) {
			villes = villeDao.getVille();
		}
		else {
			Ville ville = villeDao.getVilleByCodePostal(parametre);
			villes.add(ville);
		}		
		return(villes);		
	}
}