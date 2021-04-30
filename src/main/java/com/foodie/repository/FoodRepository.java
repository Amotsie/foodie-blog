package com.foodie.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.foodie.model.Model;

@Repository
public class FoodRepository implements IPosts {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Model> findAllPost() {
		return entityManager.createQuery("from Model",Model.class).getResultList();
	}

	@Override
	public List<Model> findByHashTag(String tag) {
		//find the post by hashtags
		return entityManager.createQuery("from Model where Model.myTagList =:tag",Model.class).setParameter("tag", tag).getResultList();
	}

	@Override
	public Model findBytitle(String title) {
		//find post by title
		return entityManager.find(Model.class, title);
	}

	@Override
	public void deleteById(long id) {
		 entityManager.remove(entityManager.getReference(Model.class,id));
	}

	@Override
	public void createPost(Model model) {
		entityManager.persist(model);
		
	}

}
