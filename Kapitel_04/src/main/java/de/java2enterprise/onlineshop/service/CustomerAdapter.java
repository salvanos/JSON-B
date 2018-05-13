package de.java2enterprise.onlineshop.service;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.bind.adapter.JsonbAdapter;

import de.java2enterprise.onlineshop.model.Customer;

public class CustomerAdapter implements JsonbAdapter<Customer, JsonObject>{

	@Override
	public Customer adaptFromJson(JsonObject jsonObject) throws Exception {
		Customer customer = new Customer();
		customer.setEmail(jsonObject.getString("email"));
		return customer;
	}

	@Override
	public JsonObject adaptToJson(Customer customer) throws Exception {
		return Json.createObjectBuilder()
			.add("email", customer.getEmail())
			.build();
	}

}
