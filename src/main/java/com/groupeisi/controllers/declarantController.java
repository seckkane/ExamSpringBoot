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
import com.groupeisi.models.Declarant;
import com.groupeisi.services.DeclarantService;
import com.groupeisi.services.DeclarationService;

@Controller
public class declarantController {

	@Autowired
	private DeclarantService declarantService;
	@Autowired
	private DeclarationService declarationService;

	/**
	 * Cette méthode recherche la liste des delarants enregistrés.
	 * Elle prend en compte les paramètres suivants : Pas de paramétre.
	 * 
	 * @param param1 Description du paramètre 1
	 * @param param2 Description du paramètre 2
	 * @return renvoie la liste de tous les declarants sous la variable declarants
	 * @throws UneException Description de l'exception éventuellement lancée : Non Capturée
	 */
	@GetMapping("/declarant")
	public String findAll(Model model){	
		
		List<Declarant> declarants = declarantService.getDeclarants();
		model.addAttribute("declarants", declarants);
		
	    return "declarant";
    }
	
	//Post a new Declarant
	@PostMapping("/declarant/addnew")
	public String addNew(Declarant declarant){	
		declarantService.saveDeclarant(declarant);
		return "redirect:/declarant";
	}
	
	//Get a Declarant by id sous format json
	@RequestMapping("/declarant/findById")
	@ResponseBody
	public Optional<Declarant> findById(long id){	
		return declarantService.getDeclarantById(id);
	}
	
	//Deleting a Declarant -- methode qui marchera aussi en get
	@RequestMapping(value="/declarant/delete/{id}", method = { RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable("id") long id){	
		declarantService.deleteDeclarantById(id);
		return "redirect:/declarant";
	}
}
