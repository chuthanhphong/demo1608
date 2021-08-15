package com.example.demo1608.Repository;

import com.example.demo1608.model.Role;
import com.example.demo1608.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends PagingAndSortingRepository<User,Long> {

    Iterable<User> findAllByNameContaining(String name);
}
