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
        	
        	//json���� data ����(StringŸ��)
//	        	attributes.put("posts", new JsonTransformer().render(pc.getPosts()));
        	
        	attributes.put("postList", pc.getPosts());
        	attributes.put("message","�޼�¡");
        	
        	System.out.println(new JsonTransformer().render(pc.getPosts()));
        	
        	return new ModelAndView(attributes, "post.ftl");
        }, new FreeMarkerTemplateEngine());
		 
		 //json���� return 
		 get("/postsJsonData", (req, res) -> {
			 PostController pc = new PostController();
			 res.status(200);
			 res.type("application/json");
			 
			// �ѱ۱��� ������ ���� ���ڵ��ϱ�
			String result = URLEncoder.encode(new JsonTransformer().render(pc.getPosts()) , "UTF-8");

			 return new JsonTransformer().render(pc.getPosts()); 
		 });
		 
	}
	
	public Posts getPosts(){
		Post post1 = new Post("����1","����1","ī�װ�");
    	Post post2 = new Post("����2","����2","ī�װ�");
    	Post post3 = new Post("����3","����3","ī�װ�");
    	
    	Posts posts = new Posts();
    	List<Post> postList = posts.getPosts();
    	postList.add(post1);
    	postList.add(post2);
    	postList.add(post3);
    	
    	posts.setPosts(postList);
    	
    	return posts;
	}
}
