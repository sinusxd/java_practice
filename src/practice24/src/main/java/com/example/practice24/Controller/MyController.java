package com.example.practice24.Controller;

import com.example.practice24.DTO.UserRegistartionDTO;
import com.example.practice24.Entity.User;
import com.example.practice24.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/home")
    public String getInfoForAll(){
        return "home";
    }
    @GetMapping("/hello")
    public String getHello(){
        return "hello";
    }
    @GetMapping("/")
    public String getHome(){
        return "home";
    }
    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }
    @GetMapping("/register")
    public String getReg(){
        return "register";
    }
    @PostMapping("/register")
    public ModelAndView registerUser(UserRegistartionDTO registrationDto){
        if (!registrationDto.getPassword().equals(registrationDto.getConfirmPassword())) {
            return new ModelAndView("register", "error", "Passwords do not match");
        }
        User newUser = new User();
        System.out.println(registrationDto);
        newUser.setUsername(registrationDto.getUsername());
        newUser.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        userRepo.save(newUser);
        return new ModelAndView("login", "success", "Registration successful");
    }

    @PostMapping("/login")
    public ModelAndView login(String username, String password) {
        // Проверяем, существует ли пользователь с заданным именем пользователя
        if (userRepo.findByUsername(username) != null) {
            System.out.println("я тут");
            // Если пользователь существует, передаем управление Spring Security для аутентификации
            return new ModelAndView("redirect:/authenticate");
        } else {
            // Если пользователь не существует, возвращаем сообщение об ошибке
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("error", "User not found");
            return modelAndView;
        }
    }
}
