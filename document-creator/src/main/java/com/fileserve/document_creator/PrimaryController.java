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
        );
        List<String> cards = List.of("card1", "card2", "card3");
        model.addAttribute("fragments", fragments);
        model.addAttribute("cards", cards);
        return "index";
    }



    
    @GetMapping("/test-env")
    public String testCall(Model model)
    {


//        model.addAttribute("username", "Bill");

        List<String> fragments = List.of(
//                "navigation-bar"
//                , "hero"
//                , "card-front-page"
//                ,
                "footer"
                , "footer"
        );
        model.addAttribute("cards", fragments);
        return "test";


    }

}
