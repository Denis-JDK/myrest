package ru.spring.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.spring.rest.entity.User;
@Repository
public interface UserRepository extends JpaRepository<Long, User> {
}
