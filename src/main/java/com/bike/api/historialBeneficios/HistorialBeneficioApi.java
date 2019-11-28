package com.bike.api.historialBeneficios;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bike.dao.BeneficioRepo;
import com.bike.dao.UsuarioRepo;
import com.bike.dto.Beneficio;
import com.bike.dto.usuario.Usuario;
import com.bike.service.BeneficioService;

@RestController
public class HistorialBeneficioApi {
	
	@Autowired
	private BeneficioRepo beneficioRepo;
	
	@Autowired
	private UsuarioRepo usuarioRepo;

	@Autowired
	BeneficioService beneficioService;

	@Profile("bicibogo")
	@PostMapping("/redimirBeneficios")
	 public ResponseEntity<?> addHistorialBeneficio(@RequestParam(value = "beneId") Long beneId, @RequestParam(value = "usuId") Long usuId) {
		
		Beneficio beneficio = beneficioRepo.findByBeneId(beneId);
		Set<Usuario> usuario = new HashSet<Usuario>();
		
		usuario.add(usuarioRepo.findByUsuId(usuId));
	       
	    if (beneficio != null && usuario != null)
	    {
	    	beneficio.setUsuarios((Set<Usuario>) usuario);
	    	return new ResponseEntity<>(beneficioRepo.save(beneficio), HttpStatus.CREATED);
	    }
	    else 
	    {
	    	return new ResponseEntity<>(new Exception("Datos no corresponden"), HttpStatus.NOT_FOUND);
	    }
	    
	 }

}
