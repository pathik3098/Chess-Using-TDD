package com.tournament.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {

    @RequestMapping("/matchChess")
    public String viewLoginPage()
    {
        return "MatchChess";
    }

}
