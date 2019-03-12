package io.github.tintinrevient.oauthserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import io.github.tintinrevient.oauthserver.model.User;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    public List<User> findAll();
    public List<User> findById(int id);
    public User findByUsername(String username);
}
