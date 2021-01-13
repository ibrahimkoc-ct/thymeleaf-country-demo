package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Country;
import com.example.demo.repository.CountryRepository;

@Controller
public class CountryController {
	@Autowired
	private CountryRepository countryRepository;
	
	@GetMapping("/")
	public String showPage(@RequestParam(defaultValue="0") int page, Model model) {
		Pageable pageable=PageRequest.of(page, 4);
		model.addAttribute("data",countryRepository.findAll(pageable));
		model.addAttribute("currentPage", page);
		return "index";
	}
	
	@PostMapping("/save")
	public String save(Country country) {
		countryRepository.save(country);
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String deleteCountry(int id) {
		countryRepository.deleteById(id);
		return "redirect:/";
	}
	
	@GetMapping("/findOne")
	@ResponseBody
	public Country findOne(int id) {
		return countryRepository.findById(id).get();
	}
}
