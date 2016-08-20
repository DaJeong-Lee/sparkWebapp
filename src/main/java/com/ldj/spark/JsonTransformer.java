package com.ldj.spark;

import com.google.gson.Gson;

import spark.ResponseTransformer;

public class JsonTransformer implements ResponseTransformer {

    public Gson gson = new Gson();

    @Override
    public String render(Object model) {
        return gson.toJson(model);
    }

}