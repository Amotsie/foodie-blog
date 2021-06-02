package com.foodie.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodie.model.BlogItem;

@Repository
public interface BlogRepository extends JpaRepository<BlogItem,Long> {

	List<BlogItem> findAllByCategory(String name);
}
