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

import com.bike.dto.Beneficio;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BeneficioTest{
	
	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private com.bike.dao.BeneficioRepo beneficioRepo;
    
	@Profile("bicibogo")
    @Test
	public void beneficioTest() {

    	Beneficio beneficio = new Beneficio();
    	
    	beneficio.setBeneCosto(150);
    	beneficio.setBeneDescripcion("-50% en adidas");
		
		entityManager.persistAndFlush(beneficio);
     
        List<Beneficio> found = beneficioRepo.findAll();
     
        assertThat(found.get(0).getBeneCosto())
          .isEqualTo(150);

	}

}
