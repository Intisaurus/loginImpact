package com.elev8.login.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elev8.login.model.User;

@Repository
public interface UserDetailsRepo extends JpaRepository<User, Long>{

	User findByUserName(String userName);
}
