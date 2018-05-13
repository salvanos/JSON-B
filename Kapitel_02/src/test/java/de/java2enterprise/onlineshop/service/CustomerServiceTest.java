package de.java2enterprise.onlineshop.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import de.java2enterprise.onlineshop.model.Customer;

public class CustomerServiceTest {
	private final static Logger LOGGER =
			Logger.getLogger(CustomerServiceTest.class.getName());
	
	CustomerService customerService = new CustomerService();
	
	@Test
	public void testSerialize() {
		Customer customer = new Customer();
		customer.setId(123L);
		customer.setEmail("j@java2enterprise.de");
		customer.setPassword("Taxi_123");
		
		String json = customerService.serialize(customer);
		assertNotNull(json);
		
		LOGGER.info("Json-Dokument: " + json);
	}

	@Test
	public void testDeserialize() {
		String json = "{\"email\":\"j@java2enterprise.de\",\"id\":123,\"password\":\"Taxi_123\"}";
		Customer customer = customerService.deserialize(json);
		
		assertNotNull(customer);
		LOGGER.info("Customer: " + customer);
	}
}
