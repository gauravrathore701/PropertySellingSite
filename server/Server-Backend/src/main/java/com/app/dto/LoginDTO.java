package com.app.dto;


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
public class LoginDTO {
	@NotBlank
	@Email(message = "Enter Valid Email Structure")
	private String email;
	
	@NotBlank
	@Length(min = 6,message = "Password must be atleast 6 character Long")
	private String password;
}
