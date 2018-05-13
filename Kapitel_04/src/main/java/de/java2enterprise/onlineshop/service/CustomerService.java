package de.java2enterprise.onlineshop.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyNamingStrategy;

import de.java2enterprise.onlineshop.model.Customer;

public class CustomerService {
	public String serialize(Customer customer) {
		JsonbConfig jsonbConfig = new JsonbConfig();
		jsonbConfig.withAdapters(new CustomerAdapter());
		Jsonb jsonb = JsonbBuilder.create(jsonbConfig);
		return jsonb.toJson(customer);
	}
	
	public String serializeCollection(Collection<Customer> customers) {
		JsonbConfig jsonbConfig = new JsonbConfig();
		jsonbConfig
			.withFormatting(true)
			.withPropertyNamingStrategy(
					PropertyNamingStrategy.UPPER_CAMEL_CASE_WITH_SPACES)
			.withDateFormat("dd.MM.yyyy", Locale.GERMAN);
		Jsonb jsonb = JsonbBuilder.create(jsonbConfig);
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
