package com.blo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.modele.Ville;

@Service
public interface VilleBlo {	
	List<Ville> getInfoVille(String parametre);
}