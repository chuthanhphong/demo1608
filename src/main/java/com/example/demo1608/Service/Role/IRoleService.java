package com.example.demo1608.Service.Role;

import com.example.demo1608.Service.IGenaralService;
import com.example.demo1608.model.Role;

import java.util.Optional;

public interface IRoleService extends IGenaralService<Role> {
    Iterable<Role> findAllByName(String name);
}
