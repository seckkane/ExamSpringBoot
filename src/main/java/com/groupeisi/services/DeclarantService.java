package com.groupeisi.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.groupeisi.models.Declarant;
import com.groupeisi.repositories.DeclarantRepository;


@Service
public class DeclarantService {

	@Autowired
	private DeclarantRepository declarantRepository;
	
	// Return list of Declarant
	public List<Declarant> getDeclarants() {
		return declarantRepository.findAll();	
	}
			
	// Post a new Declarant
	public void saveDeclarant(Declarant declarant) {
		declarantRepository.save(declarant);	
	}
			
	// Get Declarant by id
	public Optional<Declarant> getDeclarantById(Long id) {
		return declarantRepository.findById(id);
	}
			
	// Delete a Declarant by id
	public void deleteDeclarantById(Long id) {
		declarantRepository.deleteById(id);
	}	
}
