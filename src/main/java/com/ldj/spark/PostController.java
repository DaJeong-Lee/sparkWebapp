package com.ldj.spark;

import java.util.List;

public class PostController {
	public List<Post> getPosts(){
		Post post1 = new Post("제목1","내용1","카테고리");
    	Post post2 = new Post("제목2","내용2","카테고리");
    	Post post3 = new Post("제목3","내용3","카테고리");
    	
    	Posts posts = new Posts();
    	List<Post> postList = posts.getPosts();
    	postList.add(post1);
    	postList.add(post2);
    	postList.add(post3);
    	
    	return postList;
	}
}
