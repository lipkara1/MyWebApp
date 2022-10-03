package com.example.Repository;

import com.example.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;




public interface UsersRepository extends JpaRepository<Users,Long> {

}
