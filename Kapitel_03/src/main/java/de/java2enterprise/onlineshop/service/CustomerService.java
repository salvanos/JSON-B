package de.java2enterprise.onlineshop.service;

import java.util.ArrayList;
import java.util.Collection;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import de.java2enterprise.onlineshop.model.Customer;

public class CustomerService {
	public String serialize(Customer customer) {
		Jsonb jsonb = JsonbBuilder.create();
		return jsonb.toJson(customer);
	}
	
	public String serializeCollection(Collection<Customer> customers) {
		Jsonb jsonb = JsonbBuilder.create();
		return jsonb.toJson(customers);
	}
	
	public Customer deserialize(String json) {
		Jsonb jsonb = JsonbBuilder.create();
		return jsonb.fromJson(json, Customer.class);
	}

	public Collection<Customer> deserializeCollection(String json) {
		Jsonb jsonb = JsonbBuilder.create();
		return jsonb.fromJson(
				json, 
				new ArrayList<Customer>() {}.getClass().getGenericSuperclass());
	}
}
