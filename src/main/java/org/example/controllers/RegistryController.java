package org.example.controllers;

import org.example.entity.Role;
import org.example.entity.UserSecurity;
import org.example.repo.UserSecurityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistryController {

    @Autowired
    private UserSecurityRepo userSecurityRepo;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(UserSecurity userSecurity, Map<String, Object> model) {
        UserSecurity userFromDb = userSecurityRepo.findByUsername(userSecurity.getUsername());
        if (userFromDb != null) {
            model.put("message", "user exist");
            return "registration";
        }

        userSecurity.setActive(true);
        userSecurity.setRoles(Collections.singleton(Role.USER));
        userSecurityRepo.save(userSecurity);

        return "redirect:/login";
    }
}
