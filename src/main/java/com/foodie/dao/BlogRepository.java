package com.foodie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodie.model.BlogModel;

@Repository
public interface BlogRepository extends JpaRepository<BlogModel,Long> {

}
