package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@PostMapping("/registration")
public User createNewUser( @RequestBody User user) {
	User u;
User userExists = userService.findUserByUserName(user.getUserName());
if (userExists != null) {
u=userExists;
} else {
u=userService.saveUser(user);

}
return u; }
}