package com.example.casedeneme.controller;

import com.example.casedeneme.entity.User;
import com.example.casedeneme.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
public class UsersController {

    private IUserService userService;
    @Autowired
    public UsersController(IUserService userService) {

        this.userService = userService;
    }

    @GetMapping("/index")
    public String showList(Model theModel){
        theModel.addAttribute("users",userService.findAll());
        return "index";
    }
    @GetMapping("/signup")
    public String showSignupPage(User user){
        return "adduser";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model theModel){
        if (result.hasErrors()){
            return "adduser";
        }
        userService.add(user);
        return "redirect:/index";
    }
    @GetMapping("edit/{id}")
    public String showUpdatePage(@PathVariable int id,Model theModel){
        User user=userService.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid user id:"+id));
        theModel.addAttribute("user",user);
        return "updateuser";
    }
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable int id,@Valid User user, BindingResult result,Model theModel){
        if(result.hasErrors()){
            return "updateuser";
        }
        userService.update(user);
        return "redirect:/index";
    }
    @GetMapping ("/delete/{id}")
    public String deleteUser(@PathVariable int id){
         User user=userService.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid user id:"+id));
         userService.delete(id);
         return "redirect:/index";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model){
        model.addAttribute("loginError", true);
        return "login";
    }


}
