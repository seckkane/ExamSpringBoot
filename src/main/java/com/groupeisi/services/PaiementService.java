package com.groupeisi.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.groupeisi.models.Paiement;
import com.groupeisi.repositories.PaiementRepository;

@Service
public class PaiementService {

	@Autowired
	private PaiementRepository paiementRepository;
	
	// Return list of Paiement
	public List<Paiement> getPaiements() {
		return paiementRepository.findAll();	
	}
		
	// Post a new Paiement
	public void savePaiement(Paiement paiement) {
		paiementRepository.save(paiement);	
	}
		
	// Get Paiement by id
	public Optional<Paiement> getPaiementById(Long id) {
		return paiementRepository.findById(id);
	}
		
	// Delete a Paiement by id
	public void deletePaiementById(Long id) {
		paiementRepository.deleteById(id);
	}	
}
