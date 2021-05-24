package com.foodie.validator;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.foodie.model.BlogItem;

@Component
public class TagsValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return BlogItem.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		BlogItem bi = (BlogItem) target;
		List<String> list = bi.getTags();
		int cals = bi.getCalories();
		
		if(list.contains("Snack") && cals > 300)
			errors.rejectValue("tags", "my.custom.err1");
		if(list.contains("lunch") && list.contains("Snack"))
			errors.rejectValue("tags", "my.custom.err3");
	}
	
	
}
