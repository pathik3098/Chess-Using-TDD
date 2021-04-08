package com.tournament.controller;

import com.tournament.authentication.*;
import com.tournament.authentication.interfaces.IAuthentication;
import com.tournament.authentication.interfaces.IRegister;
import com.tournament.model.IUsers;
import com.tournament.model.Users;
import com.tournament.persistence.AuthenticationPersistence;
import com.tournament.persistence.MatchPersistence;
import com.tournament.persistence.interfaces.IAuthenticationPersistence;
import com.tournament.persistence.interfaces.IMatchPersistence;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AuthenticationController
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

        IAuthenticationPersistence authenticationPersistence =new AuthenticationPersistence();
        List<Users> allUsers = new ArrayList<>();
        allUsers = authenticationPersistence.getAllUsers();
        model.addAttribute("allUsers", allUsers);

        if(message.equals("Login Successful"))
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
        String userId = request.getParameter("userId");
        String userName = request.getParameter("username");
        String inputPlayerLevel = request.getParameter("level");
        int playerLevel = Integer.parseInt(inputPlayerLevel);
        String password = request.getParameter("password");
        String conPassword = request.getParameter("conpassword");
        Users userobject = new Users();
        userobject.setEmail(email);
        userobject.setUserId(userId);
        userobject.setUsername(userName);
        userobject.setPassword(password);
        userobject.setConPassword(conPassword);
        userobject.setPlayerLevel(playerLevel);

        IRegister registerObj= new Register();
        String message = registerObj.userRegistration(userobject);

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

    @RequestMapping(value = "/logOut")
    public String processLogOutPage(HttpServletRequest request, Model model) throws SQLException {

        IAuthentication logoutObj= new Authentication();
        IUsers  userObj = new Users();
        String userId = userObj.getUserId();
        String message = logoutObj.userLogOut(userId);
        if(message.equals("LogoutSuccessful"))
        {
            return "Login";
        }
        else
        {
            model.addAttribute("LogOut Message","LogOut Message"+message);
            return "Error";
        }
    }
}

