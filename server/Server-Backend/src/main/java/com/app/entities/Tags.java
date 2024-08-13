package com.app.entities;


import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = false,of = "tagName")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tags")
@ToString()
public class Tags extends BaseEntity{

	@Column(length = 100,nullable = false)
	private String tagName;

	@Column(length = 100,nullable = false)
	private String tagDesc;

	@JsonIgnore(value = true)
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name="Property_Tags",
	joinColumns = {
			@JoinColumn(name="tag_id",referencedColumnName = "id")
	},
	inverseJoinColumns = {
			@JoinColumn(name="property_id",referencedColumnName = "id")
	})
	private Set<Property> property=new HashSet<Property>();

}