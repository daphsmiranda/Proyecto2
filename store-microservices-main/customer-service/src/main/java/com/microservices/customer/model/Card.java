package com.microservices.customer.model;

import java.util.Date;

import lombok.Data;

@Data
public class Card {

	private Long id;
	private String number;
	private String cvv;
	private Date exp_date;
	private Double balance;
	private Bank bank;
	private String customer;
}
