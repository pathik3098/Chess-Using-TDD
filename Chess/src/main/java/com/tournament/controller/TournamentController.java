package com.tournament.controller;
import com.tournament.dao.*;
import com.tournament.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TournamentController {

    @GetMapping("")
    public String viewFirstPage() {
        return "index";
    }

    @RequestMapping("/loginPageMapping")
    public String viewLoginPage(Model modelObject) {
        modelObject.addAttribute("user", new Users());
        return "Login";
    }

    @RequestMapping("/registerPageMapping")
    public String viewRegisterPage(Model modelObject) {
        modelObject.addAttribute("user", new Users());
        return "Register";
    }

    @PostMapping("/processLoginForm")
    public String processLoginPage(Users user) {
        String username = "Get from Login.html Page"; // To be figured out
        String password = "Get from Login.html Page";

        Users userObject = new Users();
        userObject.setUserId(username);
        userObject.setPassword(password);

        LoginDao daoObject = new LoginDao();
        daoObject.userAuthentication(userObject);

        return "Tournament";

    }

    @PostMapping("/processRegistrationForm")
    public String processRegisterPage(Users user) {

        String email = "Get from Login.html Page"; // To be figured out
        String username = "Get from Login.html Page";
        String password = "Get from Login.html Page";
        String conpassword = "Get from Login.html Page";

        Users userObject = new Users();
        userObject.setEmail(email);
        userObject.setUserId(username);
        userObject.setPassword(password);
        userObject.setConPassword(conpassword);

        RegisterDao daoObject = new RegisterDao();
        daoObject.userRegistration(userObject);

        return "Tournament";

    }
}