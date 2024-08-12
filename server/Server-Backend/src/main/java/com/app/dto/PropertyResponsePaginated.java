package com.app.dto;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PropertyResponsePaginated {
	private List<PropertyResponse> properties;
    private int totalPages;
}
