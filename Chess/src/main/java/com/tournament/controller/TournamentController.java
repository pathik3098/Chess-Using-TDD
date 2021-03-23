package com.tournament.controller;

import com.tournament.dao.*;
import com.tournament.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TournamentController
{

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

    @RequestMapping(value = "/processLoginForm",method = {RequestMethod.POST})
    public String processLoginPage(HttpServletRequest request,Model model) {

        String UserId = request.getParameter("username");
        String password = request.getParameter("password");

        Users userObject = new Users();
        userObject.setEmail(UserId);
        userObject.setUserId(password);
        userObject.setPassword(password);

        LoginDao loginDaoObj = new LoginDao();
        String message = loginDaoObj.userAuthentication(userObject);

        if(message.equals("SUCCESS"))
        {
            model.addAttribute("loginMessage","Login Successful!");
            return "Tournament";
        }
        else
        {
            model.addAttribute("loginMessage","Login Failed!");
            return "processLoginForm";
        }
    }

    @RequestMapping(value = "/processRegisterForm",method = {RequestMethod.POST})
    public String processRegisterPage(HttpServletRequest request,Model model) {

        String Email = request.getParameter("email");
        String UserId = request.getParameter("username");
        String password = request.getParameter("password");
        String conpassword = request.getParameter("conpassword");

        Users userObject = new Users();
        userObject.setEmail(Email);
        userObject.setUserId(UserId);
        userObject.setPassword(password);
        userObject.setConPassword(conpassword);

        RegisterDao registerDaoObj = new RegisterDao();
        String message = registerDaoObj.userRegistration(userObject);

        if(message.equals("RegisterSuccess"))
        {
            model.addAttribute("registerMessage","Registration Successful!");
            return "Login";
        }
        else
        {
            model.addAttribute("registerMessage","Registration Successful!");
            return "processRegisterForm";
        }
    }

    @RequestMapping(value = "/processLogoutForm",method = {RequestMethod.POST})
    public String processLogoutPage(HttpServletRequest request,Model model)
    {

        LogOutDao logoutObject = new LogOutDao();
        String message = logoutObject.userLoggingOut();

        if(message.equals("loggedOut"))
        {
            model.addAttribute("logoutMsg","you are logged out!");
            return "Login";
        }
        return "Login";
    }

}