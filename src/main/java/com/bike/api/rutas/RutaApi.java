package com.bike.api.rutas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bike.dao.RutaRepo;
import com.bike.dao.UsuarioRepo;
import com.bike.dto.ruta.Ruta;
import com.bike.dto.ruta.RutaPuntosIntermedios;
import com.bike.dto.usuario.Usuario;
import com.bike.service.RutaService;


@RestController
public class RutaApi {
	
	@Autowired
	private RutaRepo rutaRepo;
	
	@Autowired
	private UsuarioRepo usuarioRepo;

	@Autowired
	RutaService rutaService;
	
	@GetMapping("/rutas")
	  List<Ruta> all() {
	    return rutaRepo.findAll();
	  }

	  @Profile("socialbike")
	  @PostMapping("/nuevaRuta/socialbike/{usuId}")
	  ResponseEntity<?> nuevaRuta(@RequestBody RutaRequest nuevaRuta, @PathVariable Long usuId) {
			
			Usuario usuario = usuarioRepo.findByUsuId(usuId);
			Ruta ruta = new Ruta();
			ArrayList<RutaPuntosIntermedios> puntos = new ArrayList<RutaPuntosIntermedios>();
			
			if (usuario != null)
		    {
				ruta.setRutaLatitudDestino(nuevaRuta.getRutaLatitudDestino());
				ruta.setRutaLatitudOrigen(nuevaRuta.getRutaLatitudOrigen());
				ruta.setRutaLongitudDestino(nuevaRuta.getRutaLongitudDestino());
				ruta.setRutaLongitudOrigen(nuevaRuta.getRutaLongitudOrigen());
				ruta.setRutaDescripcion(nuevaRuta.getRutaDescripcion());
				ruta.setUsuario(usuario);
				
				for(int i=0; i<nuevaRuta.getRutaPuntosIntermedios().size(); i++ )
				{
					RutaPuntosIntermedios rutaPuntosIntermedios = new RutaPuntosIntermedios();
					rutaPuntosIntermedios.setPuntIntCoordLatitud(nuevaRuta.getRutaPuntosIntermedios().get(i).getPuntIntCoordLatitud());
					rutaPuntosIntermedios.setPuntIntCoordLongitud(nuevaRuta.getRutaPuntosIntermedios().get(i).getPuntIntCoordLongitud());
					
					puntos.add(rutaPuntosIntermedios);
				}
				
				ruta.setRutaPuntosIntermedios(puntos);
				
		    	return new ResponseEntity<>(rutaRepo.save(ruta), HttpStatus.CREATED);
		    } else
				return new ResponseEntity<>(new Exception("Datos no corresponden"), HttpStatus.NOT_FOUND);
		    
		  	}
	  
	  @Profile("socialbike")
	  @PostMapping("/calificarRuta/{rutaId}")
	  ResponseEntity<?> calificarRuta(@PathVariable Long rutaId) {
			
			Ruta ruta = rutaRepo.findByRutaId(rutaId);
					
			if (ruta != null)
		    {
				int puntaje = ruta.getRutaPuntaje();
				
				ruta.setRutaPuntaje(puntaje+1);
		    	return new ResponseEntity<>(rutaRepo.save(ruta), HttpStatus.CREATED);
		    } else
				return new ResponseEntity<>(new Exception("Datos no corresponden"), HttpStatus.NOT_FOUND);
		    
		  	}
	  
	  @Profile("!socialbike")
	  @PostMapping("/nuevaRuta/{usuId}")
	  ResponseEntity<?> nuevaRutaO(@RequestBody RutaRequest nuevaRuta, @PathVariable Long usuId) {
			
		    Usuario usuario = usuarioRepo.findByUsuId(usuId);
			Ruta ruta = new Ruta();
			ArrayList<RutaPuntosIntermedios> puntos = new ArrayList<RutaPuntosIntermedios>();
			
			if (usuario != null)
		    {
				ruta.setRutaLatitudDestino(nuevaRuta.getRutaLatitudDestino());
				ruta.setRutaLatitudOrigen(nuevaRuta.getRutaLatitudOrigen());
				ruta.setRutaLongitudDestino(nuevaRuta.getRutaLongitudDestino());
				ruta.setRutaLongitudOrigen(nuevaRuta.getRutaLongitudOrigen());
				ruta.setRutaDescripcion(nuevaRuta.getRutaDescripcion());
				ruta.setUsuario(usuario);
				
				for(int i=0; i<nuevaRuta.getRutaPuntosIntermedios().size(); i++ )
				{
					RutaPuntosIntermedios rutaPuntosIntermedios = new RutaPuntosIntermedios();
					rutaPuntosIntermedios.setPuntIntCoordLatitud(nuevaRuta.getRutaPuntosIntermedios().get(i).getPuntIntCoordLatitud());
					rutaPuntosIntermedios.setPuntIntCoordLongitud(nuevaRuta.getRutaPuntosIntermedios().get(i).getPuntIntCoordLongitud());
					
					puntos.add(rutaPuntosIntermedios);
				}
				
				ruta.setRutaPuntosIntermedios(puntos);
				
		    	return new ResponseEntity<>(rutaRepo.save(ruta), HttpStatus.CREATED);
		    } else
				return new ResponseEntity<>(new Exception("Datos no corresponden"), HttpStatus.NOT_FOUND);
		    
		  	}

	  @GetMapping("/ruta/{usuId}")
	  ResponseEntity<?> one(@PathVariable Long usuId) {

			Usuario usuario = usuarioRepo.findByUsuId(usuId);
			
			if (usuario != null)
		    {
		    	return new ResponseEntity<>(rutaRepo.findByUsuario(usuario), HttpStatus.CREATED);
		    } else
				return new ResponseEntity<>(new Exception("Datos no corresponden"), HttpStatus.NOT_FOUND);
		    
		  }

}
