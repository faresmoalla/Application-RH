package tn.esprit.spring.controller;

import java.security.Principal;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.UserService;
@CrossOrigin(origins = "http://localhost:4200/",exposedHeaders="Access-Control-Allow-Origin" )
@RestController
public class HomeController {
@Autowired
UserService userService;
@Autowired
JavaMailSender javaMailSender;
@PostMapping("/registration")
public User createNewUser( @RequestBody User user) {
	User u;
User userExists = userService.findUserByUserName(user.getUserName());
if (userExists != null) {
u=userExists;
} else {
u=userService.saveUser(user);
SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
simpleMailMessage.setFrom("ikram88781@gmail.com");
simpleMailMessage.setTo(user.getEmail());
simpleMailMessage.setSubject(user.getUserName() + " " + "Welcome");
simpleMailMessage.setText("Welcome"+user.getUserName());
System.out.println("sendig mail//////////");
javaMailSender.send(simpleMailMessage);


}

return u; }
@GetMapping("/login")
public Principal login(Principal principal) {
     
     
    return principal;
}
}