package lu.atozdigital.multitenant.web;

import lu.atozdigital.multitenant.dao.entities.User;
import lu.atozdigital.multitenant.dao.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    private final UserRepository userRepository;

    MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    List<User> all() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    User newEmployee(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    @GetMapping("/users/{id}")
    User one(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }
}
