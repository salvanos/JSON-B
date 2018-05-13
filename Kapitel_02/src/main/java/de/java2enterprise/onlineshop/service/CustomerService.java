package de.java2enterprise.onlineshop.service;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import de.java2enterprise.onlineshop.model.Customer;

public class CustomerService {
	public String serialize(Customer customer) {
		Jsonb jsonb = JsonbBuilder.create();
		return jsonb.toJson(customer);
	}
	
	public Customer deserialize(String json) {
		Jsonb jsonb = JsonbBuilder.create();
		return jsonb.fromJson(json, Customer.class);
	}
}
