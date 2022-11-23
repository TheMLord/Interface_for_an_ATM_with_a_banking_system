package com.example.bank.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.bank.models.User;

/**
 *
 * @author npyatak
 * @since 17.10.2022
 */
public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}
