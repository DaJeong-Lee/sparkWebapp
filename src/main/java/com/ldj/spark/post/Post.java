package com.ldj.spark.post;

public class Post {
	String title;
	String content;
	String category;
	
	public Post(String title, String content, String category) {
		super();
		this.title = title;
		this.content = content;
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
