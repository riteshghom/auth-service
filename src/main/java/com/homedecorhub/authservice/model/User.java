package com.homedecorhub.authservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users") // ✅ <--- Add this line
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}
	public Object getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	
	
}
