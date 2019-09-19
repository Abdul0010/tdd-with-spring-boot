package com.abdul.weekendfun.wheretoeat;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import static org.hibernate.id.IdentifierGenerator.ENTITY_NAME;

/**
 * @Author by AbdulQader
 * on 16/9/2019.
 */
@RestController
public class userController {
    private UserService userService;

    public userController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{name}")
    public User getUser(@PathVariable String name){
        return userService.findUser(name);
    }
    @PostMapping("/user")
    public ResponseEntity createUser(@RequestBody User user){
         userService.save(user);
         return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity updateUser(@PathVariable long id,@RequestBody User user){

        return new ResponseEntity(userService.update(id,user),HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity deleteUser(@PathVariable long id){
        return null;
    }
    @GetMapping("/users")
    public ResponseEntity getAllUsers(){
        return new ResponseEntity(userService.findAll(),HttpStatus.OK);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void userNotFoundHandler(UserNotFoundException e){}


}
