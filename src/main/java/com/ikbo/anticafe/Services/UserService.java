package com.ikbo.anticafe.Services;

import com.ikbo.anticafe.Models.User;
import com.ikbo.anticafe.Repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).stream().findFirst().get();
    }
}
