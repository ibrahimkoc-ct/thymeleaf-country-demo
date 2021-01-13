package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Country;
import com.example.demo.repository.CountryRepository;

@SpringBootApplication
public class CountriesApplication implements CommandLineRunner {
	
	@Autowired
	private CountryRepository countryRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(CountriesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		countryRepository.save(new Country("Earth","World"));
		countryRepository.save(new Country("Germany","Berlin"));
		countryRepository.save(new Country("USA","Washington DC"));
		countryRepository.save(new Country("Russia","Moscow"));
		countryRepository.save(new Country("Turkey","Ankara"));
		countryRepository.save(new Country("Canada","Ottawa"));
		countryRepository.save(new Country("England","London"));
		countryRepository.save(new Country("France","Paris"));
		countryRepository.save(new Country("Ukraine","Kiew"));
		countryRepository.save(new Country("Japan","Tokio"));
		
	}

}
