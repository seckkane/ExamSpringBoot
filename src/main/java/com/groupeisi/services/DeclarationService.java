package com.groupeisi.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.groupeisi.models.Declaration;
import com.groupeisi.repositories.DeclarationRepository;

@Service
public class DeclarationService {

	@Autowired
	private DeclarationRepository declarationRepository;
	
	// Return list of Declaration
	public List<Declaration> getDeclarations() {
		return declarationRepository.findAll();	
	}
			
	// Post a new Declaration
	public void saveDeclaration(Declaration declaration) {
		declarationRepository.save(declaration);	
	}
			
	// Get Declaration by id
	public Optional<Declaration> getDeclarationById(Long id) {
		return declarationRepository.findById(id);
	}
			
	// Delete a Declaration by id
	public void deleteDeclarationById(Long id) {
		declarationRepository.deleteById(id);
	}	
}
