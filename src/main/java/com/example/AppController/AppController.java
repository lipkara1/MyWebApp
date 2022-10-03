package com.example.AppController;

import com.example.Repository.UsersRepository;
import com.example.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    @Autowired
    private UsersRepository repo;

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }


    @GetMapping("/register")
    public String showSignUp(Model model) {
        model.addAttribute("user", new Users());
        return "register";

    }

    @PostMapping("/process_register")
    public String processRegistration(Users user) {
        repo.save(user);
        return "register_success";
    }

}
