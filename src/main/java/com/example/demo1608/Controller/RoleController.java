package com.example.demo1608.Controller;

import com.example.demo1608.Service.Role.IRoleService;
import com.example.demo1608.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("**")
@RequestMapping("roles")
public class RoleController {
    @Autowired
    IRoleService roleService;
    @GetMapping("/list")
    public ResponseEntity<Iterable<Role>> showList(){
        Iterable<Role> roleIterable = roleService.findAll();
        return new ResponseEntity<>(roleIterable, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        roleService.save(role);
        return new ResponseEntity(roleService.findById(role.getId()),HttpStatus.OK);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Role> edit(@PathVariable Long id , @RequestBody Role role){
        Optional<Role> role1 = roleService.findById(id);
        if(!role1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        role.setId(id);
        roleService.save(role);
        return new ResponseEntity<>(role,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Role> delete(@PathVariable Long id){
        roleService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/search/{name}")
    public ResponseEntity<Iterable<Role>> findByName(@PathVariable String name){
        Iterable<Role> roleIterable = roleService.findAllByName(name);
        return new ResponseEntity<>(roleIterable,HttpStatus.OK);
    }
}
