package com.ikbo.anticafe.Controllers;

import com.ikbo.anticafe.Models.Enums.Role;
import com.ikbo.anticafe.Models.Enums.Status;
import com.ikbo.anticafe.Models.User;
import com.ikbo.anticafe.Repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

@RestController
public class RegistrationController {
    private final UserRepository userRepository;

    @Autowired
    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<?> postUser(@RequestBody User user){ /*спринг сам положит переданные поля в объект(стоит проверить)*/
        var ref = new Object() {
            boolean isUnique = true;
        };

        // Проверка email на оригинальность
        userRepository.findAll().forEach((User) -> {
            if (Objects.equals(User.getEmail(), user.getEmail())) {
                ref.isUnique = false;
            }
        });

        if (ref.isUnique) {
            User newUser = new User();

            // Шифруем пароль
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
            String encodePassword = passwordEncoder.encode(user.getPassword());

            // Инициализация(создание) нового пользователя
            newUser.setPassword(encodePassword);
            newUser.setEmail(user.getEmail());
            newUser.setStatus(Status.ACTIVE);
            newUser.setRole(Role.USER);

            // Сохраняем в БД
            userRepository.save(newUser);
        } else {
            return new ResponseEntity<>("Account with same email already registered.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
