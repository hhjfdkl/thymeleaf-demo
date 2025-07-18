package com.fileserve.document_creator.test_docs;

import de.svenjacobs.loremipsum.LoremIpsum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;

@Controller
public class PersonController {

    @GetMapping("/people")
    //the Model is passed in as a parameter so we can attach things within this method to the model
    public String getPeople(Model model)
    {
        //this sets the attribute name our template will look for. It's like a key:value pair
        model.addAttribute("something","This is coming from the controller");
        model.addAttribute("people", Arrays.asList(
                new Person("John", 20),
                new Person("Sarah", 22),
                new Person("Simon", 23)
        ));

        //with Thymeleaf, you want to return the name of your template in the methods
        //but we need to create an html file for thymeleaf to use as a template
        //we do this in resources/templates
        return "people";
    }

    @GetMapping("/{value}")
    public String getPage(Model model, @PathVariable String value)
    {
        model.addAttribute("pageName", value);
        model.addAttribute("valueTwice", value + " 1, " + value + " 2. We got it twice");
        model.addAttribute("lorem", new LoremIpsum().getWords(value.length()));
        return "info";
    }

    @GetMapping("/test")
    public String test(Model model)
    {
        model.addAttribute("content", "Getting here was successful! No conflicts with our value-mapped endpoint!");
        return "test";
    }
}
