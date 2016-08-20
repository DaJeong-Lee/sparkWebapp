package com.ldj.spark.post;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ldj.freemarker.FreeMarkerTemplateEngine;
import com.ldj.spark.JsonTransformer;

import spark.ModelAndView;

import static spark.Spark.*;

public class PostController {
	
	
	public static void postUrl(){
		 get("/posts", (req, res) -> {
			PostController pc = new PostController();
        	Map<String, Object> attributes = new HashMap<>();
        	
        	//json으로 data 변경(String타입)
//	        	attributes.put("posts", new JsonTransformer().render(pc.getPosts()));
        	
        	attributes.put("postList", pc.getPosts());
        	attributes.put("message","메세징");
        	
        	System.out.println(new JsonTransformer().render(pc.getPosts()));
        	
        	return new ModelAndView(attributes, "post.ftl");
        }, new FreeMarkerTemplateEngine());
		 
		 //json으로 return 
		 get("/postsJsonData", (req, res) -> {
			 PostController pc = new PostController();
			 res.status(200);
			 res.type("application/json");
			 
			// 한글깨짐 방지를 위해 인코딩하기
			String result = URLEncoder.encode(new JsonTransformer().render(pc.getPosts()) , "UTF-8");

			 return new JsonTransformer().render(pc.getPosts()); 
		 });
		 
	}
	
	public Posts getPosts(){
		Post post1 = new Post("제목1","내용1","카테고리");
    	Post post2 = new Post("제목2","내용2","카테고리");
    	Post post3 = new Post("제목3","내용3","카테고리");
    	
    	Posts posts = new Posts();
    	List<Post> postList = posts.getPosts();
    	postList.add(post1);
    	postList.add(post2);
    	postList.add(post3);
    	
    	posts.setPosts(postList);
    	
    	return posts;
	}
}
