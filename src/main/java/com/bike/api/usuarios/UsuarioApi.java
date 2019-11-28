package com.bike.api.usuarios;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bike.dao.UsuarioRepo;
import com.bike.dto.usuario.FabricaUsuario;
import com.bike.dto.usuario.Usuario;

@RestController
public class UsuarioApi {
	@Autowired
	private UsuarioRepo repository;

	@RequestMapping(value = "/registro", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> postRegistroUsuario(@Valid @RequestBody UsuarioRequest request) throws Exception {
		
		Usuario usuario;
		usuario = FabricaUsuario.getUsuarioAplicacion(request);
		return new ResponseEntity<>(repository.save(usuario), HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> postLoginUsuario(@Valid @RequestBody Map<String, String> request) throws Exception {
		
		Usuario usuario = repository.findByUsuCorreoAndUsuPassword(request.get("correo"), request.get("password"));
		if (usuario != null) {
			return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>("Usuario No existe", HttpStatus.BAD_REQUEST);
		}
		
    }
	
	@GetMapping("/usuario/{id}")
    public ResponseEntity<?> getUsuarioById(@PathVariable long id) throws Exception {
		
		Usuario usuario = repository.findByUsuId(id);
		if (usuario != null) {
			return new ResponseEntity<>(usuario, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>("Usuario No existe", HttpStatus.BAD_REQUEST);
		}
		
    }
	
	

}
