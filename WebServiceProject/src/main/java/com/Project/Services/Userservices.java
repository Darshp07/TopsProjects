package com.Project.Services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.Project.Dio.Pagenation;

import com.Project.Repository.UserRepository;
import com.Project.model.User;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class Userservices {

	@Autowired
	private UserRepository repository;

	public User createuser(@Valid User user) {

		return repository.save(user);
	}

	public Pagenation<User> getallusers(int page, int size) {
		PageRequest pageRequest = PageRequest.of(page - 1, size);
		Page<User> page2 = repository.findAll(pageRequest);

		List<User> list = page2.getContent();
		Pagenation<User> pagenation = new Pagenation<User>(page2.getNumber() + 1, page2.getTotalPages(),
				page2.getTotalElements(), page2.getSize(), list);

		return pagenation;
	}

	public User findbyEmail(String email) {
		return repository.findByEmail(email);
	}

	public User UpdateUser(User user) {
		Optional<User> optionalUser = repository.findByUserid(user.getUserid());
		if (optionalUser.isPresent()) {
			User user2 = optionalUser.get();
			user2.setUsername(user.getUsername());
			user2.setEmail(user.getEmail());
			user2.setPassword(user.getPassword());
			user2.setRole(user.getRole());
			user2.setPhone(user.getPhone());
			return repository.save(user2);
		} else {
			throw new EntityNotFoundException("User not found with id: " + user.getUserid());
		}
	}

	public void deleteuser(Long userid) {
		repository.deleteByuserid(userid);
	}
}
