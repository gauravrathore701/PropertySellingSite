package com.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class Users extends BaseEntity {
	@Column(length = 100)
	private String name;
	
	@Column(length = 100)
	@Email
	private String email;
	
	@Column(length = 100)
	private String password;
	
	@Column(length = 20)
	private String phone;
	
	@Column(length = 255)
	private Address address=null;
	
	@Lob
	private Byte[] profilePicture;
	
	@Column(length = 100,unique = true)
	private String username;
}
