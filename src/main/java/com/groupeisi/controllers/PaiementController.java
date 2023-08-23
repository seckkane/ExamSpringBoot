package com.groupeisi.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.groupeisi.models.Declaration;
import com.groupeisi.models.Paiement;
import com.groupeisi.services.DeclarationService;
import com.groupeisi.services.PaiementService;

@Controller
public class PaiementController {
	
	@Autowired
	private PaiementService paiementService;
	@Autowired
	private DeclarationService declarationService;

	@GetMapping("/paiement")
	public String findAll(Model model){	
		
		List<Paiement> paiements = paiementService.getPaiements();
		model.addAttribute("paiements", paiements);
		List<Declaration> declarations = declarationService.getDeclarations();
		model.addAttribute("declarations", declarations);
		
	    return "paiement";
    }
	
	//Post a new Paiement
	@PostMapping("/paiement/addnew")
	public String addNew(Paiement paiement){	
		paiementService.savePaiement(paiement);
		return "redirect:/paiement";
	}
	
	//Get a Paiement by id sous format json
	@RequestMapping("/paiement/findById")
	@ResponseBody
	public Optional<Paiement> findById(long id){	
		return paiementService.getPaiementById(id);
	}
	
	//Deleting a Paiement -- methode qui marchera aussi en get
	@RequestMapping(value="/paiement/delete/{id}", method = { RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable("id") long id){	
		paiementService.deletePaiementById(id);
		return "redirect:/paiement";
	}
}
