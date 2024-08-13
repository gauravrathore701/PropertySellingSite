package com.app.entities;

import java.util.Set;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name = "property")
@ToString(exclude = {"address","tags"})
public class Property extends BaseEntity{
	
	@Column(length = 255,nullable = false)
	private String title;
	
	@Lob
	private String description;
	
	@Column(length = 10,precision = 2)
	private float price;

	private float propertyArea;
	
	@Enumerated(EnumType.STRING)
	private PropertyType propertyType;
	
	private int bedrooms;
	
	private int washrooms;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Address")
	private Address address;
	
	@ManyToOne()
	private Users user;
	
	private Boolean isSold;
	
	private Boolean isDeleted;
	
	@ManyToMany(mappedBy = "property",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<Tags> tags ;
	
}
