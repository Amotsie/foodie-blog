package com.foodie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodie.dao.BlogRepository;
import com.foodie.model.BlogModel;

@Service
public class FoodieService {
	
	@Autowired
	BlogRepository blogRepo;
	
	
	//Create
	public void createPost(BlogModel post) {
		blogRepo.save(post);
	}
	
	
	//Read
	public List<BlogModel> findAllPosts(){
		return blogRepo.findAll();
	}
	
	public BlogModel findPostByID(long id) {
		return blogRepo.getOne(id);
	}
	
	//Update
	public void updatePost(BlogModel post) {
		blogRepo.save(post);
	}
	
	//Delete
	public void deletePost(long id) {
		blogRepo.deleteById(id);
	}
	
}
