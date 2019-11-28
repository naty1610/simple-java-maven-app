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

import com.bike.dao.MonitoreoRepo;
import com.bike.dto.Monitoreo;
import com.bike.dto.usuario.UsuarioCiudadano;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MonitoreoTests{
	
	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private MonitoreoRepo monitoreoRepo;
    
    @Profile("bicibogo")
    @Test
	public void guardarMonitoreoTest() {

    	Monitoreo monitoreo = new Monitoreo();
    	
    	monitoreo.setMonitorDistanciaDia(10);
    	monitoreo.setMonitorDistanciaSemana(30);
    	monitoreo.setMonitorDistanciaMes(20);
    	monitoreo.setMonitorTiempoDia(5);
    	monitoreo.setMonitorTiempoSemana(10);
    	monitoreo.setMonitorTiempoMes(15);
  	   
    	UsuarioCiudadano usuario= new UsuarioCiudadano("avargas20", "Adriana Vargas", "a.vargas20@uniandes.edu.co", "12345678", "CC", "1100950340", "3017330386", "San Gil", null);
    	
    	entityManager.persistAndFlush(usuario);
    	monitoreo.setUsuario(usuario);
		
		entityManager.persistAndFlush(monitoreo);
     
        Monitoreo found = monitoreoRepo.findByUsuario(usuario);
     
        assertThat(found.getMonitorDistanciaDia())
          .isEqualTo(10);

	}

    @Profile("gobike")
    @Test
	public void guardarMonitoreoTest1() {

    	Monitoreo monitoreo = new Monitoreo();
    	
    	monitoreo.setMonitorDistanciaDia(10);
    	monitoreo.setMonitorDistanciaSemana(30);
    	monitoreo.setMonitorDistanciaMes(20);
    	monitoreo.setMonitorTiempoDia(5);
    	monitoreo.setMonitorTiempoSemana(10);
    	monitoreo.setMonitorTiempoMes(15);
  	   
    	UsuarioCiudadano usuario= new UsuarioCiudadano("avargas20", "Adriana Vargas", "a.vargas20@uniandes.edu.co", "12345678", "CC", "1100950340", "3017330386", "San Gil", null);
    	
    	entityManager.persistAndFlush(usuario);
		monitoreo.setUsuario(usuario);
		
		entityManager.persistAndFlush(monitoreo);
     
        Monitoreo found = monitoreoRepo.findByUsuario(usuario);
     
        assertThat(found.getMonitorDistanciaSemana())
          .isEqualTo(30);
        
        assertThat(found.getUsuario().getUsuUsuario())
        .isEqualTo("avargas20");

	}
    
    @Profile("!socialbike")
    @Test
	public void consultarMonitoreoTest() {

    	Monitoreo monitoreo = new Monitoreo();
    	
    	monitoreo.setMonitorDistanciaDia(10);
    	monitoreo.setMonitorDistanciaSemana(30);
    	monitoreo.setMonitorDistanciaMes(20);
    	monitoreo.setMonitorTiempoDia(5);
    	monitoreo.setMonitorTiempoSemana(10);
    	monitoreo.setMonitorTiempoMes(15);
  	   
    	UsuarioCiudadano usuario= new UsuarioCiudadano("avargas20", "Adriana Vargas", "a.vargas20@uniandes.edu.co", "12345678", "CC", "1100950340", "3017330386", "San Gil", null);
    	
    	entityManager.persistAndFlush(usuario);
		monitoreo.setUsuario(usuario);
		
		entityManager.persistAndFlush(monitoreo);
     
        List<Monitoreo> found = monitoreoRepo.findAll();
     
        assertThat(found.size())
          .isEqualTo(1);

	}

}
