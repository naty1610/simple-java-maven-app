package com.bike;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

import com.bike.dao.RoboRepo;
import com.bike.dto.Bicicleta;
import com.bike.dto.Robo;
import com.bike.dto.usuario.UsuarioCiudadano;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RoboTests{
	
	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private RoboRepo roboRepo;
    
    @Profile("bicibogo")
    @Test
	public void roboTest() {

    	UsuarioCiudadano usuario= new UsuarioCiudadano("avargas20", "Adriana Vargas", "a.vargas20@uniandes.edu.co", "12345678", "CC", "1100950340", "3017330386", "San Gil", null);
    	entityManager.persistAndFlush(usuario);

    	Bicicleta bici = new Bicicleta();
    	
    	bici.setBiciCodigo("193827");
		bici.setBiciColor("Verde");
		bici.setBiciFechaCompra(new Date(15/01/2018));
		bici.setBicifoto(null);
		bici.setBiciMarca("Shimano");
		bici.setBiciModelo("FRD3022");
		bici.setBiciSerial("FE45S390FSSJK");
		bici.setBiciValorComercial(3000000);
		bici.setUsuario(usuario);
		
    	entityManager.persistAndFlush(bici);
    	
    	Robo robo = new Robo();
    	
		robo.setRoboCoordLatitud("123 12 1");
		robo.setRoboCoordLongitud("456 98 5");
		robo.setRoboDescripcion("Me drogaron y se la llevaron");
		robo.setRoboFecha("15/10/2019");
		robo.setBicicleta(bici);
        
		entityManager.persistAndFlush(robo);
		
		List<Robo> found = roboRepo.findAll();
		
        assertThat(found.get(0).getBicicleta().getBiciCodigo())
          .isEqualTo("193827");

	}
    
}
