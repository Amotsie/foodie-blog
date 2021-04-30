package com.foodie.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodie.model.Model;
import com.foodie.repository.FoodRepository;

@Service
@Transactional
public class FoodieService {

	@Autowired
	FoodRepository fRepository;
	
	public List<Model> findAllPost() {
		return fRepository.findAllPost();
	}


	public List<Model> findByHashTag(String tag) {
		return fRepository.findByHashTag(tag);
	}

	
	public Model findBytitle(String title) {
		return fRepository.findBytitle(title);
	}

	
	public void deleteById(long id) {
		fRepository.deleteById(id);;
	}

	
	public void createPost(Model model) {
		fRepository.createPost(model);
		
	}

}
