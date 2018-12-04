package com.nelioalves.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.nelioalves.cursomc.services.DBService;
import com.nelioalves.cursomc.services.EmailService;
import com.nelioalves.cursomc.services.MockEmailService;
//informa qual o profile
@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService dbService;
	
	//rewsponsavel por instanciar o banco de dados no profile de test
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		//chama a classe service que tem a criação de instancia do banco
		dbService.instantiateTestDatabase();
		return true;
	}
	
	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}
}
