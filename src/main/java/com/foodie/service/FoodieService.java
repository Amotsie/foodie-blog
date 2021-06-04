package com.foodie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodie.dao.BlogRepository;
import com.foodie.model.BlogItem;

@Service
public class FoodieService {
	
	@Autowired
	BlogRepository blogRepo;
	
	//Create
	public void createPost(BlogItem post) {
		blogRepo.save(post);
	}
	//Read
	public List<BlogItem> findAllPosts(){
		return blogRepo.findAll();
	}
	
	public BlogItem findPostByID(long id) {
		return blogRepo.getOne(id);
	}
	//Update
	public void updatePost(BlogItem post) {
		blogRepo.save(post);
	}
	//Delete
	public void deletePost(long id) {
		blogRepo.deleteById(id);
	}
	//Filter
	public List<BlogItem> filterByCategory(String name) {
		return blogRepo.findAllByCategory(name);
	}
	
}
