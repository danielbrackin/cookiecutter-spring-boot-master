package org.brackinapps.{{cookiecutter.app_name}}.repository;

import org.brackinapps.{{cookiecutter.app_name}}.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
