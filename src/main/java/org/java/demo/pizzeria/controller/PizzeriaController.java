package org.java.demo.pizzeria.controller;

import java.util.List;
import java.util.Optional;

import org.java.demo.pizzeria.pojo.Pizza;
import org.java.demo.pizzeria.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PizzeriaController {
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping("/")
	public String index(Model model) {
		
		List<Pizza> pizzas = pizzaService.findAll();
		
		model.addAttribute("pizzas", pizzas);
		
		return "index";
	}
	@PostMapping("/pizzas")
	public String getIndexByName(Model model, @RequestParam(required = false ) String name) {
		List<Pizza> pizzas = pizzaService.findBySearch(name);
		model.addAttribute("pizzas", pizzas);
		model.addAttribute("name", name);
		
		return "index";
	}
	
	@GetMapping("/pizzas/{id}")
	public String show(Model model, 
			@PathVariable("id") Integer id) {
		
		Optional<Pizza> oPizza = pizzaService.findById(id);
		Pizza pizza = oPizza.get();
		
		model.addAttribute("pizza", pizza);
		return "pizza";
	}
	
	@GetMapping("/pizzas/create")
	public String create() {
		return "create";
	}
	
	@PostMapping("/pizzas/create")
	public String store(@ModelAttribute Pizza pizza) {

		pizzaService.save(pizza);
		Integer id = pizza.getId();
		return "redirect:/pizzas/" + id;
	}
	
	@GetMapping("/pizzas/edit/{id}")
	public String edit(Model model, 
			@PathVariable("id") Integer id) {
		
		Optional<Pizza> oPizza = pizzaService.findById(id);
		Pizza pizza = oPizza.get();
		System.out.println(pizza);
		model.addAttribute("pizza", pizza);
		
		return "edit";
	}
	
	@PostMapping("/pizzas/edit/{id}")
	public String update(@PathVariable("id") Integer id, @ModelAttribute Pizza pizza) {
		
		pizzaService.save(pizza);
		return "redirect:/pizzas/{id}";
	}
	
	@GetMapping("/pizzas/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		Optional<Pizza> oPizza = pizzaService.findById(id);
		Pizza pizza = oPizza.get();
		pizzaService.delete(pizza);
		return "redirect:/";
	}
	
	
}
