package com.example.demo1608.Controller;

import com.example.demo1608.Service.User.IUserService;
import com.example.demo1608.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("**")
@RequestMapping("/users")
public class UserController {
    @Autowired
    IUserService userService;
    @GetMapping("/list")
    public ResponseEntity<Iterable<User>> findAll(){
        List<User> userList = (List<User>) userService.findAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user){
        userService.save(user);
        return new ResponseEntity(userService.findById(user.getId()),HttpStatus.CREATED);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<User> edit(@PathVariable Long id,@RequestBody User user){
        Optional<User> userOptional = userService.findById(id);
        if(!userOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        user.setId(id);
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id){
        userService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/search/{name}")
    public ResponseEntity<Iterable<User>> findbyRoleName(@PathVariable String name){
       Iterable<User> list =  userService.findbyRoleName(name);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
