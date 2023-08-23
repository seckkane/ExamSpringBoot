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
import com.groupeisi.models.Declaration;
import com.groupeisi.services.DeclarantService;
import com.groupeisi.services.DeclarationService;


@Controller
public class declarationController {
	
	@Autowired
	private DeclarationService declarationService;
	@Autowired
	private DeclarantService declarantService;

	@GetMapping("/declaration")
	public String findAll(Model model){	
		
		List<Declaration> declarations = declarationService.getDeclarations();
		model.addAttribute("declarations", declarations);
		List<Declarant> declarants = declarantService.getDeclarants();
		model.addAttribute("declarants", declarants);
		
	    return "declaration";
    }
	
	//Post a new Declaration
	@PostMapping("/declaration/addnew")
	public String addNew(Declaration declaration){	
		declarationService.saveDeclaration(declaration);
		return "redirect:/declaration";
	}
	
	//Get a Declaration by id sous format json
	@RequestMapping("/declaration/findById")
	@ResponseBody
	public Optional<Declaration> findById(long id){	
		return declarationService.getDeclarationById(id);
	}
	
	//Deleting a Declaration -- methode qui marchera aussi en get
	@RequestMapping(value="/declaration/delete/{id}", method = { RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable("id") long id){	
		declarationService.deleteDeclarationById(id);
		return "redirect:/declaration";
	}
	
}
