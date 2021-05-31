package com.foodie.validator;

import java.time.LocalDate;
import java.util.Arrays;
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
		
		BlogItem blogItem = (BlogItem) target;
		String[] tagsArr = blogItem.getTags();
		
		if(tagsArr == null ||  tagsArr.length<1) return;
		
		List<String> list = Arrays.asList(tagsArr);
		
		int cals = blogItem.getCalories();
		
		if(list.contains("Snack") && cals > 300)
			errors.rejectValue("tags", "my.custom.err1");
		if(list.contains("lunch") && (cals<500 || cals > 700))
			errors.rejectValue("tags", "my.custom.err2");
		if(list.contains("lunch") && list.contains("Snack"))
			errors.rejectValue("tags", "my.custom.err3");
	}
	
}
