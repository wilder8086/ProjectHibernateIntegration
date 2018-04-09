package ar.edu.utn.frba.tadp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.edu.utn.frba.tadp.entity.Usuario;
import ar.edu.utn.frba.tadp.service.IUserManager;

@Controller
public class UsuarioController {

	@Autowired
	private IUserManager usuarioManager;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listUsers(ModelMap map){
		map.addAttribute("usuario", new Usuario());
		map.addAttribute("usuarioList", usuarioManager.getAllUsers());
		
		return "usuarioList";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute(value="usuario") Usuario user, BindingResult result){
		
		usuarioManager.addUser(user);
		return "redirect:/";
	}
	
	@RequestMapping(value="/delete/{userId}-user")
	public String deleteUser(@PathVariable("userId") Integer userId){
		
		usuarioManager.deleteUser(userId);
		
		return "redirect:/";
	}

	public void setUsuarioManager(IUserManager usuarioManager) {
		this.usuarioManager = usuarioManager;
	}
}
