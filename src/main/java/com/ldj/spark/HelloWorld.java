package com.ldj.spark;

import static spark.Spark.*;

import java.util.*;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

public class HelloWorld {
	public static void main(String[] args) {
		port(8080);
		staticFileLocation("/public");
		
        get("/hello", (req, res) -> "Hello World");
        get("/posts", (req, res) -> {
        	Map<String, Object> attributes = new HashMap<>();
//        	PostController pc = new PostController();
        	//json으로 data 변경
//        	attributes.put("posts", new JsonTransformer().render(pc.getPosts()));
//        	System.out.println(attributes.get("posts"));
//        	return new ModelAndView(attributes, "views/post.ftl");
//        	return new ModelAndView(new HashMap().put("a", "a"), "views/post.ftl");
        	attributes.put("message", "Data Structures & Algorithms");
            return new ModelAndView(attributes, "/views/post.ftl");
        }, new FreeMarkerEngine());
    }

	
}
