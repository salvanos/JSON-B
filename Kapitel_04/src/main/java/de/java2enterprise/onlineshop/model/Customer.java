package de.java2enterprise.onlineshop.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.json.bind.annotation.JsonbNumberFormat;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;

public class Customer {
	private Long id;
	
	private String email;
	
	@JsonbProperty("password")
	private String secretPassword;
	
	@JsonbTransient
	private LocalDate birthdate;
	
	@JsonbNumberFormat("#0.00")
	private BigDecimal credit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSecretPassword() {
		return secretPassword;
	}

	public void setSecretPassword(String secretPassword) {
		this.secretPassword = secretPassword;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public BigDecimal getCredit() {
		return credit;
	}

	public void setCredit(BigDecimal credit) {
		this.credit = credit;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", email=" + email + ", secretPassword=" + secretPassword + ", birthdate="
				+ birthdate + ", credit=" + credit + "]";
	}

}
