package com.olaapp.imageuploader.repo;

import com.olaapp.imageuploader.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
