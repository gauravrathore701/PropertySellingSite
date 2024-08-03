package com.app.entities;


import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	
	@Column(length = 255,nullable = false)
	private String address;
	
	@Column(length = 100,nullable = false)
	private String city;
	
	@Column(length = 100,nullable = false)
	private String state;
	
	@Column(length = 100,nullable = false)
	private String district;
	
	@Column(length = 10,nullable = false)
	private String pincode;
	
}