package com.ldj.spark;

import java.util.List;

public class PostController {
	public List<Post> getPosts(){
		Post post1 = new Post("����1","����1","ī�װ�");
    	Post post2 = new Post("����2","����2","ī�װ�");
    	Post post3 = new Post("����3","����3","ī�װ�");
    	
    	Posts posts = new Posts();
    	List<Post> postList = posts.getPosts();
    	postList.add(post1);
    	postList.add(post2);
    	postList.add(post3);
    	
    	return postList;
	}
}
