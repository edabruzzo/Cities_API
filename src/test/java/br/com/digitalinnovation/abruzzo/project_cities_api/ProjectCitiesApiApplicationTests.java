package br.com.digitalinnovation.abruzzo.project_cities_api;

import br.com.digitalinnovation.abruzzo.project_cities_api.controller.CountryController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ProjectCitiesApiApplicationTests {

	@Autowired
	private CountryController controller;

	@Test
	public void contextLoads() throws Exception {
		assert (this.controller) != null;

	}

}
