package com.foodie.validator;

import java.time.LocalDate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.foodie.model.BlogItem;

@Component
public class PublishDateValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {

		return BlogItem.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		BlogItem blogItem = (BlogItem) target;
		
		LocalDate date = blogItem.getPublishdate();
		if(date == null) return;
		if(date.isBefore(LocalDate.now().minusDays(5)))
			errors.rejectValue("publishdate", "my.custom.pdate");
	}

}
