package com.fileserve.document_creator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.standard.expression.FragmentExpression;

import java.util.List;

@Controller
public class PrimaryController
{

    @GetMapping("/")
    public String mainPage(Model model)
    {
        List<String> fragments = List.of(
              "navigation-bar"
            , "hero"
            , "card-front-page"
            , "footer"
        );
        model.addAttribute("fragments", fragments);
        return "index";
    }



    
    @GetMapping("/test-env")
    public String testCall(Model model)
    {


        model.addAttribute("username", "Bill");

        return "test";


    }

}
