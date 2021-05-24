package com.foodie.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.foodie.model.BlogItem;
import com.foodie.service.FoodieService;
import com.foodie.validator.TagsValidator;

@Controller
public class FoodieBlogController {
	
	@Autowired
	FoodieService service;
	
//	@Autowired
	TagsValidator tv;
	
	/*
	 * Displays the home or welcome page 
	 * The List of all the blog posts available is passed to the view page.
	 * Pagination can be implemented in case the blog posts become too many.
	 */
	@GetMapping(value = {"/home", "/"})
	public ModelAndView	Welcome() {
		ModelAndView mv = new ModelAndView("welcome-page");
		mv.addObject("blogs", service.findAllPosts());
		return mv;
	}
	
	/**
	 * Displays the details page
	 * From the Home/Welcome page when the "Read More" button of the blog post is clicked,
	 * The Id of the clicked blog post is passed as a path variable
	 */
	@GetMapping("/details/{blogId}")
	public ModelAndView	displayDetails(@PathVariable("blogId") Long id) {
		ModelAndView mv = new ModelAndView("details-page");
		mv.addObject("blog", service.findPostByID(id));
		return mv;
	}
		
	/*
	 * Displays the Form for creating a new Post.
	 * The empty BlogItem object is passed to the view page.
	 */
	@GetMapping("/create")
	public ModelAndView	displayAddPostForm() {
		ModelAndView mv = new ModelAndView("postform-page");
		mv.addObject("blog", new BlogItem());
		return mv;
	}
	
	
	/*
	 * Displays the results page of the new entry.
	 * if the there is no validation errors the Result page is loaded, else returned back to add blog post.
	 * if user confirms the results, the post is persisted, else redirected back to editing 
	 */
	@PostMapping("/results")
	public ModelAndView	displayResults(@Valid @ModelAttribute BlogItem post, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("blog", post);

		tv.validate(post, result);

		if (result.hasErrors())
			mv.setViewName("postform-page");
		else
			mv.setViewName("results-page");

		return mv;
	}
}
