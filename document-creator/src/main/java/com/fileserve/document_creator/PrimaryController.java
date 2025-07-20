package com.fileserve.document_creator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
//                , "custom-card"
        );
//        List<String> cards = List.of("greeting-card", "start-card", "contact-card", "hero", "navigation-bar", "custom-card");

        List<Card> cards = List.of(
                  new Card("greeting-card")
                , new Card("start-card")
                , new Card("contact-card")
                , new Card("custom-card", "Bill", "Bill")
                , new Card("custom-card", "Tom", "Bill")
                , new Card("custom-card")
//                ,null
        );

        //to protect against null, we should just filter the list here
        //I believe in an actual environment, we would handle null prior to the controller..
        // instead of letting it get to our fragments
        // but can we protect it at the fragment level?


        model.addAttribute("fragments", fragments);
        model.addAttribute("cards", cards);
        return "index";
    }



    
    @GetMapping("/test-env")
    public String testCall(Model model)
    {


//        model.addAttribute("username", "Bill");

        //deprecated
//        List<String> fragments = List.of(
//                "navigation-bar"
//                , "hero"
//                , "card-front-page"
////                ,
////                "footer"
////                , "footer"
//        );
//        model.addAttribute("cards", fragments);
        return "test";


    }

}
