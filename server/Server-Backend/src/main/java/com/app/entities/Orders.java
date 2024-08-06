package com.app.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Orders extends BaseEntity{

	@OneToOne
	private Property property;
	
	@OneToOne
	private Users user;
	
	private boolean orderStatus;
	
	private float amount;

}