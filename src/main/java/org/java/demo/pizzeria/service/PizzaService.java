package org.java.demo.pizzeria.service;

import java.util.List;
import java.util.Optional;

import org.java.demo.pizzeria.pojo.Pizza;
import org.java.demo.pizzeria.repo.PizzaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {

	@Autowired
	private PizzaRepo pizzaRepository;
	
	public List<Pizza> findAll() {
		
		return pizzaRepository.findAll();
	}
	public Pizza save(Pizza pizza) {
		
		return pizzaRepository.save(pizza);
	}
	public Optional<Pizza> findById(Integer id) {
		
		return pizzaRepository.findById(id);
	}
	public List<Pizza> findBySearch(String name ){
		return pizzaRepository.findByNameContaining(name);
	}
	
	public void delete(Pizza pizza) {
		pizzaRepository.delete(pizza);
	}
}