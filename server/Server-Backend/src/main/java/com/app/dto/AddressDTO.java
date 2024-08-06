package com.app.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AddressDTO {
	@NotBlank
	private String addLine1;
	@NotBlank
	private String addLine2;
	@NotBlank
	private String city;
	@NotBlank
	private String state;
	@NotBlank
	private String district;
	@NotBlank
	private String pincode;
}
