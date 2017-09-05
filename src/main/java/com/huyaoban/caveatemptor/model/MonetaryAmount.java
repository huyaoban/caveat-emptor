package com.huyaoban.caveatemptor.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;

public class MonetaryAmount implements Serializable {
	private final BigDecimal value;
	private final Currency currency;
	
	public MonetaryAmount(BigDecimal value, Currency currency) {
		this.value = value;
		this.currency = currency;
	}

	public BigDecimal getValue() {
		return value;
	}
	
	public Currency getCurrency() {
		return currency;
	}
	
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof MonetaryAmount)) return false;

		final MonetaryAmount monetaryAmount = (MonetaryAmount) o;

		if (!currency.equals(monetaryAmount.currency)) return false;
		if (!value.equals(monetaryAmount.value)) return false;

		return true;
	}
	
	public int hashCode() {
		int result;
		result = value.hashCode();
		result = 29 * result + currency.hashCode();
		return result;
	}
	
	public String toString() {
		return "Value: '" + getValue() + "', " +
		        "Currency: '" + getCurrency() + "'";
	}
	
	public int compareTo(Object o) {
		if (o instanceof MonetaryAmount) {
            // TODO: This requires some conversion magic and is therefore not implemented
			return this.getValue().compareTo(((MonetaryAmount) o).getValue());
		}
		return 0;
	}
	
	public static MonetaryAmount fromString(String amount, String currencyCode) {
		return new MonetaryAmount(new BigDecimal(amount),
								  Currency.getInstance(currencyCode));
	}
	
	public static MonetaryAmount convert(MonetaryAmount amount,
			 Currency toConcurrency) {
		// TODO: This requires some conversion magic and is therefore not implemented
		return new MonetaryAmount(amount.getValue(), toConcurrency);
	}

}
