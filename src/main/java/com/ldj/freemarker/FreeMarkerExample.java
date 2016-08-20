package com.ldj.freemarker;

import static spark.Spark.*;

import java.util.*;

import spark.ModelAndView;

public class FreeMarkerExample {
  public static void main(String args[]) {
        get("/freemarker", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello FreeMarker World");

            // The hello.ftl file is located in directory:
            // src/test/resources/spark/examples/templateview/freemarker
            return modelAndView(attributes, "hello.ftl");
        }, new FreeMarkerTemplateEngine());
        
        get("/hello", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello FreeMarker World");
            ModelAndView mv = new ModelAndView(attributes, "hello.ftl");
            return mv;
        }, new FreeMarkerTemplateEngine());
    }
    
}
