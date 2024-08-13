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
@Table(name = "orders")
@ToString(exclude = {"property","buyer"})
public class Orders extends BaseEntity{

	@OneToOne
	private Property property;
	
	@ManyToOne
	private Users buyer;
	
	private boolean orderComplete;
	
	private float amount;

}