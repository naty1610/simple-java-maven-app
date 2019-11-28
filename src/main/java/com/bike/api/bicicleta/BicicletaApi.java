package com.bike.api.bicicleta;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bike.dao.BicicletaRepo;
import com.bike.dao.UsuarioRepo;
import com.bike.dto.Bicicleta;
import com.bike.dto.usuario.Usuario;

@RestController
public class BicicletaApi {
	

	@Autowired
	private BicicletaRepo biciRepository;
	
	@Autowired
	private UsuarioRepo usuarioRepo;
	
	
	@Profile("!socialbike")
	@RequestMapping(value = "/registroBicicleta", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> postRegistroBicicleta(@Valid @RequestBody RequestBicicleta request) throws Exception {
		if (!request.getTipoAplicacion().equals("1")) {
			Usuario usuario = usuarioRepo.findByUsuId(request.getIdUsuario());
			if (usuario != null) {
				Bicicleta bici = new Bicicleta();
				bici.setBiciCodigo(request.getCodigo());
				bici.setBiciColor(request.getColor());
				bici.setBiciFechaCompra(request.getFechaCompra());
				bici.setBicifoto(request.getFoto());
				bici.setBiciMarca(request.getMarca());
				bici.setBiciModelo(request.getModelo());
				bici.setBiciSerial(request.getSerial());
				bici.setBiciValorComercial(request.getValorComercial());
				bici.setUsuario(usuario);
				return new ResponseEntity<>(biciRepository.save(bici), HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>("Data incorrecta", HttpStatus.BAD_REQUEST);
			}
			
		} else {
			return new ResponseEntity<>(new Exception("Tipo Aplicación no es correcta"), HttpStatus.BAD_REQUEST);
		}
		
    }
	
	@Profile("!socialbike")
	@GetMapping("/bicicleta/{usuId}")
	public  List<Bicicleta> getBicicletasByIdUsuario(@PathVariable long usuId) {
		Usuario usuario = usuarioRepo.findByUsuId(usuId);
		if (usuario != null) {
			return biciRepository.findByUsuario(usuario);
		} else {
			return null;
		}
	    
	  }

}
