package org.brackinapps.{{cookiecutter.app_name}}.controller;

import org.brackinapps.{{cookiecutter.app_name}}.service.{{cookiecutter.app_name_cap}}Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class {{cookiecutter.app_name_cap}}RestController  {
    private Logger logger = LoggerFactory.getLogger({{cookiecutter.app_name_cap}}RestController.class);

    private final JdbcTemplate jdbcTemplate;

    public {{cookiecutter.app_name_cap}}RestController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @RequestMapping("/")
    @ResponseBody
    public String up() {
        return "up";
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public List<Map<String, Object>> users(){
        return jdbcTemplate.queryForList("SELECT * FROM users");
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/api/roles", method = RequestMethod.GET)
    public List<Map<String, Object>> roles(){
        return jdbcTemplate.queryForList("SELECT * FROM role");
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = {"/api/userRoles", "/api/user-roles", "/api/ur"}, method = RequestMethod.GET)
    public List<Map<String, Object>> userRoles(){
        return jdbcTemplate.queryForList("SELECT * FROM user_role");
    }

}
