package com.bike;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

import com.bike.dao.RutaRepo;
import com.bike.dto.ruta.Ruta;
import com.bike.dto.usuario.UsuarioCiudadano;
import com.bike.dto.usuario.UsuarioSocial;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RutaTests{
	
	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private RutaRepo rutaRepo;
    
    @Profile("socialbike")
    @Test
	public void nuevaRutaTest() {

    	UsuarioSocial usuario= new UsuarioSocial("avargas2", "Adriana Vargas", "a.vargas20@uniandes.edu.co", "12345678");
    	entityManager.persistAndFlush(usuario);

    	Ruta ruta = new Ruta();
    	
    	ruta.setRutaLatitudDestino(1);
    	ruta.setRutaLatitudOrigen(2);
    	ruta.setRutaLongitudDestino(3);
    	ruta.setRutaLongitudOrigen(2);
    	ruta.setRutaPuntaje(5);
    	ruta.setUsuario(usuario);
    	
    	entityManager.persistAndFlush(ruta);
    	
        List<Ruta> found = rutaRepo.findByUsuario(usuario);
     
        assertThat(found.size())
          .isEqualTo(1);

        assertThat(found.get(0).getUsuario().getUsuUsuario())
        .isEqualTo("avargas2");
	}

    @Profile("!socialbike")
    @Test
	public void nuevaRutaTest1() {

    	UsuarioCiudadano usuario= new UsuarioCiudadano("avargas20", "Adriana Vargas", "a.vargas20@uniandes.edu.co", "12345678", "CC", "1100950340", "3017330386", "San Gil", null);
    	entityManager.persistAndFlush(usuario);

    	Ruta ruta = new Ruta();
    	
    	ruta.setRutaLatitudDestino(1);
    	ruta.setRutaLatitudOrigen(2);
    	ruta.setRutaLongitudDestino(3);
    	ruta.setRutaLongitudOrigen(2);
    	ruta.setRutaPuntaje(5);
    	ruta.setUsuario(usuario);
    	
    	entityManager.persistAndFlush(ruta);
    	
        List<Ruta> found = rutaRepo.findByUsuario(usuario);
     
        assertThat(found.size())
          .isEqualTo(1);

        assertThat(found.get(0).getUsuario().getUsuUsuario())
        .isEqualTo("avargas20");
	}
}
