package com.example;

import com.example.Repository.UsersRepository;
import com.example.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
@ComponentScan("basepackage")
public class UsersRepositoryTests {

    @Autowired
    private UsersRepository repo;
    @Autowired
    private TestEntityManager entityManager;


    @Test
    public void testCreateUsers() {
        Users user = new Users();
        user.setEmail("bachas.fanis@gmail.com");
        user.setFirstName("Theofanis");
        user.setLastName("Bachas");
        user.setAge(21);
        user.setPassword("1234");


        Users savedUser = repo.save(user);
        Users existUser = entityManager.find(Users.class,savedUser.getId());


        assertEquals(user.getEmail(), existUser.getEmail());


    }
}
