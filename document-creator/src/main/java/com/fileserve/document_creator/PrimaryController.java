package com.fileserve.document_creator;

import de.svenjacobs.loremipsum.LoremIpsum;
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
        List<Fragment> fragments = List.of(
//              "navigation-bar"
//            , "hero"
//            ,
                new Fragment("card-front-page")
        );

        List<Card> cards = List.of(
                  new Card("greeting-card")
                , new Card("start-card")
                , new Card("contact-card")
                , new Card("custom-card", "Bill", "Bill")
                , new Card("custom-card", "Tom", "Bill")
                , new Card("custom-card")
                , new Card("greeting-card")
                , new Card("start-card")
                , new Card("contact-card")
                , new Card("custom-card", "Bill", "Bill")
                , new Card("custom-card", "Tom", "Bill")
                , new Card("custom-card")
                , new Card("greeting-card")
                , new Card("start-card")
                , new Card("contact-card")
                , new Card("custom-card", "Bill", "Bill")
                , new Card("custom-card", "Tom", "Bill")
                , new Card("custom-card")
                , new Card("greeting-card")
                , new Card("start-card")
                , new Card("contact-card")
                , new Card("custom-card", "Bill", "Bill")
                , new Card("custom-card", "Tom", "Bill")
                , new Card("custom-card")
        );

        //to protect against null, we should just filter the list here
        //I believe in an actual environment, we would handle null prior to the controller.
        // instead of letting it get to our fragments
        // but can we protect it at the fragment level?


        model.addAttribute("fragments", fragments);
        model.addAttribute("cards", cards);
        return "index";
    }



    
    @GetMapping("/test-env")
    public String testCall(Model model)
    {
        String[] titles = {"Jim","Potato","Regis","Garbage"};
        String s1 = new LoremIpsum().getWords(555);
        String s2 = new LoremIpsum().getWords(175);
        String s3 = new LoremIpsum().getWords(689);
        String s4 = new LoremIpsum().getWords(1000);

        String[] topics1 = {s1, s2, s3, s4};
        String[] topics2 = {s2};
        String[] topics3 = {s4, s2, s4};

        Subtopic st1 = new Subtopic(titles[0], topics1);
        Subtopic st2 = new Subtopic(titles[1], topics2);
        Subtopic st3 = new Subtopic(titles[2], topics3);

        Subtopic[] subtopics = {st1, st2, st3};

        List<Fragment> page = List.of(
                new Topic(
                        titles[3]
                        , subtopics
                )
        );
        model.addAttribute("fragments", page);
        return "index";


    }

}
