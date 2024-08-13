package com.app.entities;


import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
@ToString(exclude = "property")
public class Address extends BaseEntity{
	
	@Column(length = 100,nullable = false)
	private String addLine1;
	
	@Column(length = 100,nullable = false)
	private String addLine2;
	
	@Column(length = 100,nullable = false)
	private String city;
	
	@Column(length = 100,nullable = false)
	private String state;
	
	@Column(length = 100,nullable = false)
	private String district;
	
	@Column(length = 10,nullable = false)
	private String pincode;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "property")
	private Property property;
	
}