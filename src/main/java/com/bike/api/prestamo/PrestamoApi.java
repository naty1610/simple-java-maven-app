package com.bike.api.prestamo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bike.dao.BicicletaRepo;
import com.bike.dao.PrestamoRepo;
import com.bike.dao.UsuarioRepo;
import com.bike.dto.Bicicleta;
import com.bike.dto.Prestamo;
import com.bike.dto.usuario.Usuario;

@RestController
public class PrestamoApi {
	

	@Autowired
	private PrestamoRepo prestamoRepository;
	@Autowired
	private BicicletaRepo biciRepository;
	@Autowired
	private UsuarioRepo usuarioRepository;
	
	
	@Profile("gobike")
	@RequestMapping(value = "/registroPrestamo", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> postRegistroPrestamo(@Valid @RequestBody RequestPrestamo request) throws Exception {
		if (request.getTipoAplicacion().equals("2")) {
			Bicicleta bicicleta = biciRepository.findByBiciId(request.getIdBicicleta());
			Usuario usuario = usuarioRepository.findByUsuId(request.getIdUsuario());
			if (bicicleta != null && usuario != null) {
				Prestamo prestamo = new Prestamo();
				prestamo.setPrestCosto(request.getCosto());
				prestamo.setPrestFechaFin(request.getFechaFin());
				prestamo.setPrestFechaInicio(request.getFechaInicio());
				prestamo.setUsuario(usuario);
				prestamo.setBicicleta(bicicleta);
							
				return new ResponseEntity<>(prestamoRepository.save(prestamo), HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>("Data incorrecta", HttpStatus.BAD_REQUEST);
			}
			
		} else {
			return new ResponseEntity<>(new Exception("Tipo Aplicación no es correcta"), HttpStatus.BAD_REQUEST);
		}
    }

}
