package com.app.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrdersDTOReponse {

	@NotBlank
	private Long id;

	@NotBlank
	private Long userId;

	@NotBlank
	private Long propertyId;

	private boolean orderCompleted;

	private float amount;
}
