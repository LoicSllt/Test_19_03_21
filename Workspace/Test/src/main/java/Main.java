import java.util.ArrayList;
import java.util.List;

public class Main {	
	
	public static void main(String[] args) {		
		List<Ville> villes = new ArrayList<Ville>();
		UtilisateurDao utilisateurDao;
		DaoFactory daoFactory = DaoFactory.getInstance();
		utilisateurDao = daoFactory.getUtilisateurDao();
		villes = utilisateurDao.getVille();	
		System.out.println("Nombre de villes :");
		System.out.println(villes.size());
		for(int i=0; i<=villes.size()-1;i++) {
			System.out.println(villes.get(i).getNom());
		}
	}

}
