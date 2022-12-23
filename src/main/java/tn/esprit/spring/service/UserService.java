package tn.esprit.spring.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.RoleName;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.RoleRepository;
import tn.esprit.spring.repository.UserRepository;
@Service
public class UserService {
@Autowired
private UserRepository userRepository;
@Autowired
private RoleRepository roleRepo;

BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
public User findUserByUserName(String userName) {
return userRepository.findByUserName(userName);
}
public User saveUser(User user) {

user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
user.setActive(true);
user.setRole("SUPERADMIN");
return userRepository.save(user); }}
