package com.ldj.freemarker;

import java.io.IOException;
import java.io.StringWriter;

import freemarker.template.*;
import spark.*;
import spark.TemplateEngine;

public class FreeMarkerTemplateEngine extends TemplateEngine {

    private Configuration configuration;

    protected FreeMarkerTemplateEngine() {
        this.configuration = createFreemarkerConfiguration();
    }

    @Override
    public String render(ModelAndView modelAndView) {
        try {
            StringWriter stringWriter = new StringWriter();

            Template template = configuration.getTemplate(modelAndView.getViewName());
            template.process(modelAndView.getModel(), stringWriter);
            System.out.println(stringWriter.toString());
            
            return stringWriter.toString();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        } catch (TemplateException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private Configuration createFreemarkerConfiguration() {
        Configuration retVal = new Configuration();
//        retVal.setClassForTemplateLoading(FreeMarkerTemplateEngine.class, "freemarker");
        //커스터마이징
        retVal.setClassForTemplateLoading(this.getClass(), "/freemarker/");
        
        return retVal;
    }
}
