package tn.esprit.spring.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.FileDB;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.RoleName;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.FileDBRepository;
import tn.esprit.spring.repository.UserRepository;
@Service
public class UserServiceImpl implements IUserservice {
	@Autowired
	UserRepository userRepo;
	@Autowired
	FileDBRepository fileRepo;

	@Override
	public User inscription(User user) {
		 return userRepo.save(user);
	}

	@Override
	public User updateUser(User user, Long idUser) {
		User u = userRepo.findById(idUser).orElse(null);
		u.setUserName(user.getUserName());
		u.setTel(user.getTel());
		u.setRole(user.getRole());
		u.setEmail(user.getEmail());
		

		
		
		return userRepo.save(u);
		
	}

	@Override
	public void deleteUser(Long idUser) {

		userRepo.deleteById(idUser);;
		
	}

	@Override
	public User affichDetailUser(Long idUser) {
		// TODO Auto-generated method stub
		return userRepo.findById(idUser).orElse(null);
	}

	@Override
	public List<User> affichUser() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}
	@Override
	public User findbyusername(String username) {
		return userRepo.findByUserName(username);
	}

	@Override
	public User affcterfileauuser(Long iduser,Long idfile) {
		// TODO Auto-generated method stub
		User u = userRepo.findById(iduser).orElse(null);
		FileDB f = fileRepo.findById(idfile).orElse(null);
		f.getUser().add(u);
		fileRepo.save(f);
		return u;
	}

}
