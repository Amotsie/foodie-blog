package com.foodie.repository;

import java.util.List;

import com.foodie.model.Model;

public interface IPosts {

	public List<Model> findAllPost();
	public List<Model> findByHashTag(String tag);
	public Model findBytitle(String title);
	public void deleteById(long id);
	public void createPost(Model model);
}
