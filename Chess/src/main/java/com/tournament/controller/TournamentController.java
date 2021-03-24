package com.tournament.controller;

import com.tournament.authentication.LogOut;
import com.tournament.authentication.Login;
import com.tournament.authentication.Register;
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

    @RequestMapping("/loginPageMapping")
    public String viewLoginPage()
    {
        return "Login";
    }

    @RequestMapping("/registerPageMapping")
    public String viewRegisterPage()
    {
        return "Register";
    }

    @RequestMapping(value = "/processLoginForm",method = {RequestMethod.POST})
    public String processLoginPage(HttpServletRequest request, Model model) throws SQLException {

        String UserId = request.getParameter("userId");
        String password = request.getParameter("password");

        Login loginObj= new Login();
        String message = loginObj.userAuthentication(UserId,password);

        if(message.equals("LoginSuccessful"))
        {
            model.addAttribute("loginMessage","loginMessage"+message);
            return "WelcomePage";
        }
        else
        {
            model.addAttribute("loginMessage","loginMessage"+message);
            return "Login";
        }
    }

    @RequestMapping(value = "/registerPageMapping",method = {RequestMethod.POST})
    public String processRegisterPage(HttpServletRequest request, Model model) throws SQLException {

        String Email = request.getParameter("email");
        String UserName = request.getParameter("username");
        String UserId = request.getParameter("userId");
        String PlayerLevel = request.getParameter("level");
        String password = request.getParameter("password");
        String conpassword = request.getParameter("conpassword");

        Users userobj = new Users();
        userobj.setEmail(Email);
        userobj.setUserId(UserName);
        userobj.setUsername(UserId);
        userobj.setPlayerLevel(PlayerLevel);
        userobj.setPassword(password);
        userobj.setConPassword(conpassword);

        Register registerObj= new Register();
        String message = registerObj.userRegistration(userobj);

        if(message.equals("RegisterSuccess"))
        {
            model.addAttribute("Registeration Message", "Registeration Message"+message);
            return "Login";
        }
        else
        {
            model.addAttribute("Registeration Message","Registeration Message"+message);
            return "Register";
        }
    }

    @RequestMapping(value = "/logOutPageMapping",method = {RequestMethod.POST})
    public String processLogOutPage(HttpServletRequest request, Model model) throws SQLException {


        LogOut logoutObj= new LogOut();
        String message = logoutObj.userLogOut();

        if(message.equals("RegisterSuccess"))
        {
            model.addAttribute("Registeration Message", "Registeration Message"+message);
            return "Login";
        }
        else
        {
            model.addAttribute("Registeration Message","Registeration Message"+message);
            return "Register";
        }
    }
}

