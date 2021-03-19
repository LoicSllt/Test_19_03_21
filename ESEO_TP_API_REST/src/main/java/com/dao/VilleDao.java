package com.dao;

import java.util.List;
import com.modele.Ville;

public interface VilleDao {
	List<Ville> getVille();
	Ville getVilleByCodePostal(String codePostal);
}