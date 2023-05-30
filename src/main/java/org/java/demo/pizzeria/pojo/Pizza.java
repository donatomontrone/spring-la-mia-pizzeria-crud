package org.java.demo.pizzeria.pojo;

import org.hibernate.validator.constraints.URL;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message="Inserisci il nome della pizza.")
	@Size(min=3,max=255,message="Il nome della pizza deve essere compreso tra 3 e 255 caratteri")
	private String name;
	
	@Column(columnDefinition = "text")
	@NotBlank(message="Inserisci la descrizione della pizza.")
	@Size(min=3,message="La descrizione della pizza deve essere almeno di 3 caratteri.")
	private String description;
	
	@URL(message = "Inserisci un url per l'immagine della pizza valido.")
	@NotBlank(message="Inserisci il link per l'immagine della pizza.")
	@Size(max=255,message="Il nome della pizza non può superare i 255 caratteri.")
	private String imgPath;
	
	@Min(value=3,message="Il prezzo della pizza deve essere almeno di 3,00€.")
	@NotNull(message="Inserisci il prezzo della pizza.")
	@Max(value=25,message="Il prezzo della pizza non può superare i 25,00€.")
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
