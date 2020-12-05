package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Usuario;
import com.example.demo.service.IUsuarioService;

@Controller
@RequestMapping("/private")
public class PrivateController {

	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/index")
	public String index (Authentication auth, HttpSession session) {
		String username = auth.getName();
		
		// Si la sesión no está creada
		if (session.getAttribute("usuario") == null) {
			Usuario usuario = usuarioService.findByUsername(username);
			usuario.setPassword(null); // por seguridad no se envia el password
			session.setAttribute("usuario", usuario);
		}
		
		return "index";
	}
	
	
}
