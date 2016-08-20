package com.ldj.spark;

import java.util.*;

public class Posts {
	
	List<Post> posts = new ArrayList<>();
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<Post> getAllPosts(){
		return this.posts;
	}
}
