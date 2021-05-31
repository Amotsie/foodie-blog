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
import com.foodie.validator.PublishDateValidator;
import com.foodie.validator.TagsValidator;

@Controller
public class FoodieBlogController {
	
	@Autowired
	FoodieService service;
	
	@Autowired
	TagsValidator tv;
	
	@Autowired
	PublishDateValidator pdv;
	
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
	public ModelAndView	displayBlogPostDetails(@PathVariable("blogId") Long id) {
		ModelAndView mv = new ModelAndView("details-page");
		mv.addObject("blog", service.findPostByID(id));
		return mv;
	}
		
	/*
	 * Displays the Form for creating a new Post.
	 * The empty BlogItem object is passed to the view page.
	 */
	@GetMapping("/create")
	public ModelAndView	displayBlofPostForm() {
		ModelAndView mv = new ModelAndView("postform-page");
		mv.addObject("blog", new BlogItem());
		return mv;
	}
	
	/*
	 * Used to edit the blog-post selected from the welcome page
	 * Accepts the blog id as a path variable
	 * Passes the queried BlogItem Bean to the view page.
	 */
	@GetMapping("/edit/{blogId}")
	public ModelAndView	editBlogPost(@PathVariable("blogId") Long id) {
		ModelAndView mv = new ModelAndView("postform-page");
		mv.addObject("blog", service.findPostByID(id));
		return mv;
	}
	
	/*
	 * Used to Delete the blog-post selected from the welcome page
	 * Accepts the blog id as a path variable
	 * Passes the new queried BlogItem list to the welcome page.
	 */
	@GetMapping("/delete/{blogId}")
	public ModelAndView	deleteBlogPost(@PathVariable("blogId") Long id) {
		ModelAndView mv = new ModelAndView("welcome-page");
		service.deletePost(id);
		mv.addObject("blogs", service.findAllPosts());
		return mv;
	}
	
	/*
	 * Displays the results page of the new entry.
	 * if the there is no validation errors the Result page is loaded, else returned back to add blog post.
	 * if user confirms the results, the post is persisted, else redirected back to editing 
	 */
	@PostMapping("/results")
	public ModelAndView	displayFormResults(@Valid @ModelAttribute("blog") BlogItem post, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("blog", post);
		
		tv.validate(post, result);
		pdv.validate(post, result);
		
		
		if (result.hasErrors())
			mv.setViewName("postform-page");
		else
			mv.setViewName("results-page");
		
		return mv;
	}

	/*
	 * Displays the results page of the new entry.
	 * if the there is no validation errors the Result page is loaded, else returned back to add blog post.
	 * if user confirms the results, the post is persisted, else redirected back to editing 
	 */
	@PostMapping("/savepost")
	public ModelAndView	saveFormResults(@ModelAttribute("blog") BlogItem post) {
		service.createPost(post);
		ModelAndView mv = new ModelAndView("welcome-page");
		mv.addObject("blogs", service.findAllPosts());
		return mv;
	}
	
	@PostMapping("/backtoedit")
	public ModelAndView	viewEditPage(@ModelAttribute("blog") BlogItem post) {

		ModelAndView mv = new ModelAndView("postform-page");
		mv.addObject("blog", post);
		return mv;
	}
}
