package com.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "property")
public class Property extends BaseEntity {
	@Column(length = 255,nullable = false)
	private String title;
	
	private Address address;
	
	@Column(length = 50,nullable = false)
	private String propertyType;
	
	@Column(length = 10,precision = 2)
	private float price;
	
	private float propertyArea;
	
	private int bedrooms;
	
	private int bathrooms;
	
	@Lob
	private String description;
	
	@ManyToOne()
	private Users user;
	
//	@UpdateTimestamp
//	private LocalDateTime listingDate;
	
	@Column(length = 20,nullable = false)
	private String status;
	
	private Boolean isDeleted;
	
	
}
