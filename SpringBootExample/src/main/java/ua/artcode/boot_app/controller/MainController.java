package ua.artcode.boot_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.artcode.boot_app.config.AppConfigHolder;
import ua.artcode.boot_app.dto.GeneralResponse;
import ua.artcode.boot_app.model.User;
import ua.artcode.boot_app.repository.UserRepository;

import javax.transaction.Transactional;

/**
 * @author Serhii Bilobrov
 * @since 1.7
 */
@RestController
@Transactional
@RequestMapping("/app")
public class MainController {

    @Value("${app.private-key}")
    public String privateKey;

    private final UserRepository userRepository;
    private final AppConfigHolder appConfigHolder;

    @Autowired
    public MainController(UserRepository userRepository, AppConfigHolder appConfigHolder) {
        this.userRepository = userRepository;
        this.appConfigHolder = appConfigHolder;
    }

    @RequestMapping("/")
    public @ResponseBody String home() {
        return "Hello World!";
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public @ResponseBody User getUser(@PathVariable("id") Integer id) {
        return userRepository.findOne(id);
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public ResponseEntity<GeneralResponse> postUser(@RequestBody User user) {
        User saved = userRepository.save(user);
        return new ResponseEntity<GeneralResponse>(new GeneralResponse("success"), HttpStatus.OK);
    }


}
