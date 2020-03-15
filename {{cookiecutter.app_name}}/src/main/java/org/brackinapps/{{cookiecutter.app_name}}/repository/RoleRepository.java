package org.brackinapps.{{cookiecutter.app_name}}.repository;

import org.brackinapps.{{cookiecutter.app_name}}.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
}