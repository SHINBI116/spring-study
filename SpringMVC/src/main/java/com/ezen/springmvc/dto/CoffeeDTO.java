package com.ezen.springmvc.dto;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class CoffeeDTO {
	
	@Nonnull
	private String coffee_kor_name;
	@Nonnull
	private Integer coffee_price;
	private String coffee_eng_name;
	
}
