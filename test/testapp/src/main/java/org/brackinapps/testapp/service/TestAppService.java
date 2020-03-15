package org.brackinapps.testapp.service;

import org.brackinapps.testapp.entity.Role;
import org.brackinapps.testapp.entity.User;
import org.brackinapps.testapp.repository.RoleRepository;
import org.brackinapps.testapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


@Service("testAppService")
public class TestAppService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public TestAppService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
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
