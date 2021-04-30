package com.foodie.model;

import java.time.LocalDate;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="PostContent")
public class Model {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Size(min=3,max=50)
	private String title;
	@Size(min=2)
	private String description;
	@Size(min=2)
	private String category;
	private double calories;
	private LocalDate date;
	
	
	@OneToMany(mappedBy="Model")
	private List<Tags> myTagList=new ArrayList<>();


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public double getCalories() {
		return calories;
	}


	public void setCalories(double calories) {
		this.calories = calories;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public List<Tags> getMyTagList() {
		return myTagList;
	}


	public void setMyTagList(List<Tags> myTagList) {
		this.myTagList = myTagList;
	}

	
	
	
}
