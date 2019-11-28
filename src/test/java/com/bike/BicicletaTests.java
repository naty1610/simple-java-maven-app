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

import com.bike.dao.BicicletaRepo;
import com.bike.dto.Bicicleta;
import com.bike.dto.usuario.UsuarioCiudadano;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BicicletaTests{
	
	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private BicicletaRepo biciRepo;
    
    @Profile("!socialbike")
    @Test
	public void nuevaBiciTest() {

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
    	
        List<Bicicleta> found = biciRepo.findByUsuario(usuario);
     
        assertThat(found.get(0).getBiciCodigo())
          .isEqualTo("193827");

	}
    
}
