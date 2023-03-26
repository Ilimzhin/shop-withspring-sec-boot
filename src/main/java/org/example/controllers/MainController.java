package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.entity.User;
import org.example.entity.UserSecurity;
import org.example.repo.UserSecurityRepo;
import org.example.service.UserSecurityService;
import org.example.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final UserSecurityService userSecurityService;

    private final UserService userService;
    private final UserSecurityRepo userSecurityRepo;

    @GetMapping("/userList")
    public String userList(Model model) {
        List<UserSecurity> userSecurities = userSecurityService.findAll();
        model.addAttribute("userSecurity", userSecurities);
        return "userList";
    }

    @PostMapping("/user-create")
    public String createUsers(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/user/create")
    public String createUsersForm(User user) {
        return "/user-create";
    }

    @GetMapping("/users")
    public String findAllUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/user-info/{id}")
    public String getProductInfo(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user-info";
    }

}
