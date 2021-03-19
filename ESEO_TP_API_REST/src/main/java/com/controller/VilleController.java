package com.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.modele.Ville;
import com.blo.VilleBlo;
import com.blo.VilleBloImpl;

@RestController
public class VilleController {
	
	/**
	 * Méthode GET
	 * Listener : écoute sur le réseau les URL de la forme "/ville"
	 * Récupère l'ensemble des villes.
	 */	
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public List<Ville> appelGet(@RequestParam(required = false, value="codePostal") String codePostal) {
		
		VilleBlo villeBlo = new VilleBloImpl();
		List<Ville> villes = villeBlo.getInfoVille(codePostal);		
		return(villes);
	}	
}