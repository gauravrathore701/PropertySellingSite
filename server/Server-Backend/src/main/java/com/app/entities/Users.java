package com.app.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name = "users")
@ToString(exclude = {"profilePicture"})
public class Users extends BaseEntity {
	@Column(length = 100)
	private String fname;
	
	@Column(length = 100)
	private String lname;
	
	@Column(length = 100)
	@Email
	private String email;
	
	@Column(length = 100)
	private String password;
	
	@Column(length = 20)
	private String phone;
	
	@Column(length = 20)
	private String city;
	
	@Column(length = 20)
	private String state;
	
	@Enumerated(EnumType.STRING)
	private UserRole role;
	
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] profilePicture;
	
	@Column(length = 100,unique = true)
	private String username;
	
	private LocalDate dob;
}
