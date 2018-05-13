package de.java2enterprise.onlineshop.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
		customer.setSecretPassword("Taxi_123");
		
		String json = customerService.serialize(customer);
		assertNotNull(json);
		
		LOGGER.info("Json-Dokument: " + json);
	}
	
	@Test
	public void testSerializeCollection() {
		List<Customer> customers = new ArrayList<>();
		
		Customer customer1 = new Customer();
		customer1.setId(123L);
		customer1.setEmail("j@java2enterprise.de");
		customer1.setSecretPassword("Taxi_123");
		customer1.setBirthdate(LocalDate.of(2000, Month.JANUARY, 12));
		customer1.setCredit(new BigDecimal(300.0));
		customers.add(customer1);
		
		Customer customer2 = new Customer();
		customer2.setId(456L);
		customer2.setEmail("k@java2enterprise.de");
		customer2.setSecretPassword("Taxi_456");
		customer2.setBirthdate(LocalDate.of(2001, Month.MARCH, 15));
		customer2.setCredit(new BigDecimal(300.0));
		customers.add(customer2);
		
		String json = customerService.serializeCollection(customers);
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
	
	@Test
	public void testDeserializeCollection() {
		String json = "[{\"email\":\"j@java2enterprise.de\",\"id\":123,\"password\":\"Taxi_123\"},{\"email\":\"k@java2enterprise.de\",\"id\":456,\"password\":\"Taxi_456\"}]";
		
		Collection<Customer> customers = customerService.deserializeCollection(json);
		LOGGER.info("Customers: " + customers);
		
	}
}
