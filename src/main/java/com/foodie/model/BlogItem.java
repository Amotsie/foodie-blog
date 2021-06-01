package com.foodie.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "blog")
public class BlogItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Size(min = 5, max = 100)
	private String title;
	
	@Length(min = 20)
	private String body;
	
	@NotBlank
	private String category;
	
	@NotNull
	@Min(value = 50)
	private Integer calories;
	
	@PastOrPresent
	@NotNull
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate publishdate;
	
	@Column(name = "tags")
	@NotEmpty
	private String[] tags;

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

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getCalories() {
		return calories;
	}

	public void setCalories(Integer calories) {
		this.calories = calories;
	}

	public LocalDate getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(LocalDate publishdate) {
		this.publishdate = publishdate;
	}
	
	public String[] getTags() {
		return tags;
	}

	
//	public List<String> getTags() {
//		if(tags.length<1 || tags == null) {
//			List<String> list = new ArrayList<>();
//			return list;
//		}
//			
//		return Arrays.asList(tags);
//	}

//	public void setTags(List<String> tags) {
//		String[] arr = new String[tags.size()];
//        arr = tags.toArray(arr);
//		this.tags = arr;
//	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "BlogItem [id=" + id + ", title=" + title + ", body=" + body + ", category=" + category + ", calories="
				+ calories + ", publishdate=" + publishdate + ", tags=" + Arrays.toString(tags) + "]";
	}	
	

}
