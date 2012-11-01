package com.example.designpatterns.memento;


import org.apache.commons.lang3.StringUtils;

public class CustomerValidator implements Validator {

	@Override
    public boolean isValid(Customer customer) {

        return applyValidationRules(customer);
	}

    private boolean applyValidationRules(Customer customer) {
        return customer.getLastname() != null && // rule 1
               customer.getLastname().length() > 0 && // rule 2
               StringUtils.isNumeric(customer.getCreditCardNumber()) && // rule 3
               StringUtils.isNotBlank(customer.getLastname()); // rule 4
    }

}
