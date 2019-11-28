package com.bike.api.robo;

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
import com.bike.dao.RoboRepo;
import com.bike.dto.Bicicleta;
import com.bike.dto.Robo;

@RestController
public class RoboApi {
	
	@Autowired
	private RoboRepo roboRepository;
	@Autowired
	private BicicletaRepo biciRepository;
	
	@Profile("bicibogo")
	@RequestMapping(value = "/reporteRobo", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> postReporteRobo(@Valid @RequestBody RequestRobo request) throws Exception {
		if (request.getTipoAplicacion().equals("3")) {
			Bicicleta bicicleta = biciRepository.findByBiciId(request.getBicicletaId());
			if (bicicleta != null) {
				Robo robo = new Robo();
				robo.setRoboCoordLatitud(request.getCoordLatitud());
				robo.setRoboCoordLongitud(request.getCoordLongitud());
				robo.setRoboDescripcion(request.getDescripcion());
				robo.setRoboFecha(request.getFecha());
				robo.setBicicleta(bicicleta);
				return new ResponseEntity<>(roboRepository.save(robo), HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>("Data incorrecta", HttpStatus.BAD_REQUEST);
			}
			
		} else {
			return new ResponseEntity<>(new Exception("Tipo Aplicación no es correcta"), HttpStatus.BAD_REQUEST);
		}
		
    }

}
