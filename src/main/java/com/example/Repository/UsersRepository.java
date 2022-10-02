package com.example.Repository;

import com.example.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;



public interface UsersRepository extends JpaRepository<Users,Long> {

}
