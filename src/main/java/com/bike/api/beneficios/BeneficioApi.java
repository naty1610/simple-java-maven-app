package com.bike.api.beneficios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bike.dao.BeneficioRepo;
import com.bike.dto.Beneficio;
import com.bike.service.BeneficioService;

@RestController
public class BeneficioApi {
	
	@Autowired
	private BeneficioRepo repository;

	@Autowired
	BeneficioService beneficioService;
	
	@Profile("bicibogo")
	@GetMapping("/beneficios")
	  List<Beneficio> all() {
	    return repository.findAll();
	  }

	@Profile("bicibogo")
	@PostMapping("/nuevoBeneficio")
	  Beneficio nuevoBeneficio(@RequestBody Beneficio nuevoBeneficio) {
	    return repository.save(nuevoBeneficio);
	  }

	@Profile("bicibogo")
	@GetMapping("/beneficio/{beneId}")
	  Beneficio one(@PathVariable Long beneId) {

	    return repository.findByBeneId(beneId);
	  }

}
