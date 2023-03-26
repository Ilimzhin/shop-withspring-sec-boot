package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.User;
import org.example.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;


    public User findById(Long id) {
        return userRepo.getOne(id);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public User saveUser(User user) {
        return userRepo.save(user);
    }

    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }


}
