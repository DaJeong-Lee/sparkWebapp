package com.ldj.spark;

import static spark.Spark.*;

import com.ldj.spark.post.PostController;

public class Main {
	public static void main(String[] args) {
		port(8080);
//		staticFileLocation("/public");
		
        get("/hello", (req, res) -> "Hello World");
        
        PostController.postUrl();
    }
}
