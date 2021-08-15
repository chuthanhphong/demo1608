package com.example.demo1608.Repository;

import com.example.demo1608.model.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends PagingAndSortingRepository<Role, Long> {

    Iterable<Role> findAllByNameContaining(String name);
}
