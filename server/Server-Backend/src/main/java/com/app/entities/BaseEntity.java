package com.app.entities;


import java.time.LocalDateTime;

import jakarta.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@MappedSuperclass // to tell hib , not to create any tables n other entities will extend from it
@Getter
@Setter
@ToString
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@CreationTimestamp
	private LocalDateTime createdDateTime;
	
	@UpdateTimestamp
	private LocalDateTime UpdatedDateTime;
	
}