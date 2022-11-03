package com.example.ATMMachine.repositories;

import com.example.ATMMachine.userAtm.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{

}
