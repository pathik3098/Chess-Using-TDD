package com.tournament.controller;

import com.tournament.authentication.*;
import com.tournament.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Controller
public class TournamentController
{

    @GetMapping("")
    public String viewFirstPage()
    {
        return "index";
    }

    @RequestMapping("/loginPage")
    public String viewLoginPage()
    {
        return "Login";
    }

    @RequestMapping("/registerPage")
    public String viewRegisterPage()
    {
        return "Register";
    }

    @RequestMapping(value = "/loginForm",method = {RequestMethod.POST})
    public String processLoginPage(HttpServletRequest request, Model model) throws SQLException {

        String UserId = request.getParameter("userId");
        String password = request.getParameter("password");

        IAuthentication loginObj= new Authentication();
        String message = loginObj.userAuthentication(UserId,password);

        if(message.equals("LoginSuccessful"))
        {
            return "WelcomePage";
        }
        else
        {
            model.addAttribute("message", message);
            return "Login";
        }
    }

    @RequestMapping(value = "/registerForm",method = {RequestMethod.POST})
    public String processRegisterPage(HttpServletRequest request, Model model) throws SQLException {

        String email = request.getParameter("email");
        String userName = request.getParameter("username");
        String userId = request.getParameter("userId");
        String playerLevel = request.getParameter("level");
        String password = request.getParameter("password");
        String conPassword = request.getParameter("conpassword");

        Users userobj = new Users();
        userobj.setEmail(email);
        userobj.setUserId(userId);
        userobj.setUsername(userName);
        userobj.setPassword(password);
        userobj.setConPassword(conPassword);

        IRegister registerObj= new Register();
        String message = registerObj.userRegistration(userobj,playerLevel);

        if(message.equals("RegisterSuccess"))
        {
            model.addAttribute("Registeration_Message", message);
            return "Login";
        }
        else
        {
            model.addAttribute("Registeration_Message",message);
            return "Register";
        }
    }

    @RequestMapping(value = "/logOutPageMapping",method = {RequestMethod.POST})
    public String processLogOutPage(HttpServletRequest request, Model model) throws SQLException {

        IAuthentication logoutObj= new Authentication();
        String message = logoutObj.userLogOut();

        if(message.equals("LogOut Successful"))
        {
            return "Login";
        }
        else
        {
            model.addAttribute("LogOut Message","LogOut Message"+message);
            return "Register";
        }
    }
}

