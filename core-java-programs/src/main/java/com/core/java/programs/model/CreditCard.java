package com.core.java.programs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard {
	
	private Integer id;
	private String creditCardNumber;

	public static List<CreditCard> getCreditCard() {
		// TODO Auto-generated method stub
		return Arrays.asList(new CreditCard(2, "223"), new CreditCard(1, "124"), new CreditCard(3, "334"));
	}
}
