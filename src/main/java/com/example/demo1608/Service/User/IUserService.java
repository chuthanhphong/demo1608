package com.example.demo1608.Service.User;

import com.example.demo1608.Service.IGenaralService;
import com.example.demo1608.model.User;

public interface IUserService  extends IGenaralService<User> {
    Iterable<User> findbyRoleName(String name);
}
