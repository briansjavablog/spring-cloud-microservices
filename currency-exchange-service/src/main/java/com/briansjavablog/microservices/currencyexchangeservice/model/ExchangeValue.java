package com.briansjavablog.microservices.currencyexchangeservice.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExchangeValue {

	@Id
	private Long id;
	@Column(name="from_currency")
	private String fromCurrency;
	@Column(name="to_currency")
	private String toCurrency;
	@Column(name="conversion_rate")
	private BigDecimal conversionRate;
	private int port;

	public ExchangeValue() {
	}

	public ExchangeValue(Long id, String from, String to, BigDecimal conversionRate) {
		super();
		this.id = id;
		this.fromCurrency = from;
		this.toCurrency = to;
		this.conversionRate = conversionRate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFromCurrency() {
		return fromCurrency;
	}

	public void setFromCurrency(String from) {
		this.fromCurrency = from;
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(String to) {
		this.toCurrency = to;
	}

	public BigDecimal getConversionRate() {
		return conversionRate;
	}

	public void setConversionRate(BigDecimal conversionRate) {
		this.conversionRate = conversionRate;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
