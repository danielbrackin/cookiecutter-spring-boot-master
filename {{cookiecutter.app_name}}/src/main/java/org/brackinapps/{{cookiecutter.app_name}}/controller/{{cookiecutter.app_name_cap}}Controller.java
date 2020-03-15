package org.brackinapps.{{cookiecutter.app_name}}.controller;

import org.brackinapps.{{cookiecutter.app_name}}.service.{{cookiecutter.app_name_cap}}Service;
import org.brackinapps.{{cookiecutter.app_name}}.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Controller
public class {{cookiecutter.app_name_cap}}Controller {

    private Logger logger = LoggerFactory.getLogger({{cookiecutter.app_name_cap}}Controller.class);

    @Autowired
    public {{cookiecutter.app_name_cap}}Service {{cookiecutter.app_name_cam}}Service;

    @RequestMapping(value = {"/login"}, method = {RequestMethod.GET})
    public String login(Model m) {
        return "login";
    }

    @RequestMapping(value = {"/"}, method = {RequestMethod.GET})
    public String redirect(Model m) {
        return "redirect:home";
    }

    @RequestMapping(value = {"/home"}, method = {RequestMethod.GET})
    public String home(Model m) {
        return "home";
    }


    @RequestMapping(value = {"/registration"}, method = {RequestMethod.GET})
    public String registration(Model m) {
        User user = new User();
        m.addAttribute("user", user);
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String createNewUser(Model m, @Valid User user, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
        User userExists = {{cookiecutter.app_name_cam}}Service.findUserByUsername(user.getUsername());
        if (userExists != null) {
            bindingResult.rejectValue("username", "error.user", "There is already a user registered with the username provided.");
            logger.error("User {} already exists. Not saving...", user.getUsername());
        }
        if (bindingResult.hasErrors()) {
            return "registration";
        } else {
            {{cookiecutter.app_name_cam}}Service.saveUser(user);
            m.addAttribute("username",user.getUsername());
            logger.info("User saved successfully and logged in.");
            return "login";
        }
    }

    @RequestMapping(value = {"/error"}, method = {RequestMethod.GET})
    public String error() {
        return "error";
    }

    @RequestMapping(value = {"/help"}, method = {RequestMethod.GET})
    public String help() {
        return "help";
    }

    @RequestMapping(value = {"/access-denied"}, method = {RequestMethod.GET})
    public String access_denied() {
      return "access-denied";
    }

    private String generateDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss a");
        return now.format(formatter);
    }


}
