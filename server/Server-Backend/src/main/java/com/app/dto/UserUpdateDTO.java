package com.app.dto;


import java.time.LocalDate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserUpdateDTO {
	@NotBlank
	private String fname;
	
	@NotBlank
	private String lname;
	
	@NotBlank
	@Email(message = "Enter Valid Email Structure")
	private String email;
	
	@NotBlank
	@Length(min = 10,message = "Phone Number must be atleast 10 character Long")
	private String phone;
	
	@NotBlank
	private String username;
	private AddressDTO address;
	private LocalDate dob;
}
