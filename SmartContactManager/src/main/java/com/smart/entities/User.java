package com.smart.entities;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotBlank(message = "User Name cannot be blank")
	private String name;
	private String email;
	private boolean enable;
	private String password;

	@Column(length = 500)
	private String description;
	private String role;
	private String image;

	@OneToMany(cascade = CascadeType.ALL ,fetch = FetchType.EAGER ,mappedBy = "user" )
	private List<Contact> contacts = new ArrayList<>();

	public User() {
	}

	public User(int id, String name, String email, boolean enable, String password, String description, String role,
			String image, List<Contact> contacts) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.enable = enable;
		this.password = password;
		this.description = description;
		this.role = role;
		this.image = image;
		this.contacts = contacts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", enable=" + enable + ", password="
				+ password + ", description=" + description + ", role=" + role + ", image=" + image + ", contacts="
				+ contacts + "]";
	}

}
