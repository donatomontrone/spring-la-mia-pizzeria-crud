package org.java.demo.pizzeria.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	@Column(columnDefinition = "text")
	private String description;
	private String imgPath;
	private Integer price;
	
	public Pizza() {}

	public Pizza(String name, String description, String imgPath, Integer price) {
		setName(name);
		setDescription(description);
		setImgPath(imgPath);
		setPrice(price);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "[" + getId() + "] - " + getName() + " | " + getPrice() + "€"
			+ "\nDescrizione: " + getDescription();
	}
	
	
}
