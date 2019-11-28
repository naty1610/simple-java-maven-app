package com.bike.api.monitoreo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bike.dao.MonitoreoRepo;
import com.bike.dao.UsuarioRepo;
import com.bike.dto.Monitoreo;
import com.bike.dto.usuario.Usuario;

@RestController
public class MonitoreoApi {
	
	@Autowired
	private MonitoreoRepo monitoreoRepo;
	
	@Autowired
	private UsuarioRepo usuarioRepo;
	
	private double nuevos_puntos, consolidado_puntos;

	@Profile("bicibogo")
	@PostMapping("/guardarMonitoreo/bicibogo/{usuId}")
	ResponseEntity<?> nuevoRegistro(@RequestBody Monitoreo nuevoRegistro, @PathVariable Long usuId) {
		
		Usuario usuario = usuarioRepo.findByUsuId(usuId);
		Monitoreo puntos = monitoreoRepo.findByUsuario(usuario);
		
		if (usuario != null)
		{
			//Por cada 30 kilometros recorridos al día se otorgan 100 puntos
			 
			nuevos_puntos = nuevoRegistro.getMonitorDistanciaDia() / 0.3;
			
			if (puntos == null)
				nuevoRegistro.setMonitorPuntos((int)nuevos_puntos);
			else 
			{
				consolidado_puntos = (puntos.getMonitorPuntos()) + nuevos_puntos;
				nuevoRegistro.setMonitorPuntos((int)consolidado_puntos);
			}
			
			nuevoRegistro.setUsuario(usuario);
			
	    	return new ResponseEntity<>(monitoreoRepo.save(nuevoRegistro), HttpStatus.CREATED);
	    } else
			return new ResponseEntity<>(new Exception("Datos no corresponden"), HttpStatus.NOT_FOUND);
	    
	  	}
	
	@Profile("gobike")
	@PostMapping("/guardarMonitoreo/goinbike/{usuId}")
	ResponseEntity<?> nuevoRegistroGo(@RequestBody Monitoreo nuevoRegistro, @PathVariable Long usuId) {
		
		Usuario usuario = usuarioRepo.findByUsuId(usuId);
		
		if (usuario != null)
		{
			nuevoRegistro.setUsuario(usuario);
			
	    	return new ResponseEntity<>(monitoreoRepo.save(nuevoRegistro), HttpStatus.CREATED);
	    } else
			return new ResponseEntity<>(new Exception("Datos no corresponden"), HttpStatus.NOT_FOUND);
	    
	  	}

	@Profile("!socialbike")
	@GetMapping("/monitoreo/{usuId}")
	ResponseEntity<?> one(@PathVariable Long usuId) {

		Usuario usuario = usuarioRepo.findByUsuId(usuId);
		
		if (usuario != null)
	    {
	    	return new ResponseEntity<>(monitoreoRepo.findByUsuario(usuario), HttpStatus.CREATED);
	    } else
			return new ResponseEntity<>(new Exception("Datos no corresponden"), HttpStatus.NOT_FOUND);
	    
	  }

}
