package org.example.sangecom.repository;

import org.example.sangecom.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepositoty extends JpaRepository<User, String> {
    public User findByEmail(String email);

    public List<User> findByRole(String role);

    public User findByResetToken(String token);

    public Boolean existsByEmail(String email);
}
