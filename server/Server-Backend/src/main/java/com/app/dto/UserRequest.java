package com.app.dto;


import java.time.LocalDate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserRequest {
	@NotBlank
	private String name;
	
	@NotBlank
	@Email(message = "Enter Valid Email Structure")
	private String email;
	
	@NotBlank
	@Length(min = 6,message = "Password must be atleast 6 character Long")
	private String password;
	
	@NotBlank
	@Length(min = 10,message = "Phone Number must be atleast 10 character Long")
	private String phone;
	
	@NotBlank
	private String username;
	private AddressDTO address;
	private LocalDate dob;
}
