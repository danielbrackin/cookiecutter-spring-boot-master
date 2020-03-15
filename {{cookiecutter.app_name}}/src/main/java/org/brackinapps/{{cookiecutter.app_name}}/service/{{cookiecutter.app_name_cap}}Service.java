package org.brackinapps.{{cookiecutter.app_name}}.service;

import org.brackinapps.{{cookiecutter.app_name}}.entity.Role;
import org.brackinapps.{{cookiecutter.app_name}}.entity.User;
import org.brackinapps.{{cookiecutter.app_name}}.repository.RoleRepository;
import org.brackinapps.{{cookiecutter.app_name}}.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


@Service("{{cookiecutter.app_name_cam}}Service")
public class {{cookiecutter.app_name_cap}}Service {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public {{cookiecutter.app_name_cap}}Service(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    public User findUserByUsername(String username) { return userRepository.findByUsername(username); }
    public List<User> findAllUsers() { return userRepository.findAll(); }
    public List<Role> findAllRoles() { return roleRepository.findAll(); }


    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ROLE_USER");
        user.setRoles(new HashSet(Arrays.asList(new Role[] { userRole })));
        userRepository.save(user);
    }

}
