package com.Project.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Dio.Apiserviece;
import com.Project.Dio.Pagenation;

import com.Project.Services.Userservices;

import com.Project.model.Login;
import com.Project.model.User;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Api/webservice/User")
public class Usercontroller {

	@Autowired
	private Userservices userservices;

	// User registration API
	@PostMapping("/create")
	public ResponseEntity<Apiserviece<User>> CreateUser(@Valid @RequestBody User user) {

		User existingUser = userservices.findbyEmail(user.getEmail());

		if (existingUser != null && existingUser.getEmail().equals(user.getEmail())) {

			Apiserviece<User> apiserviece = new Apiserviece<>(false, "Email already exists!", null);
			return new ResponseEntity<>(apiserviece, HttpStatus.CONFLICT);
		}
		User user2 = userservices.createuser(user);
		Apiserviece<User> apiserviece = new Apiserviece<User>(true, "User is create succesfully..!", user2);
		return new ResponseEntity<>(apiserviece, HttpStatus.OK);

	}

	// Get all User with Pagination API
	@GetMapping("/getallUsers")
	public ResponseEntity<Apiserviece<Pagenation<User>>> getallUsers(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int size) {
		Pagenation<User> pagenation = userservices.getallusers(page, size);
		Apiserviece<Pagenation<User>> apiserviece = new Apiserviece<Pagenation<User>>(true, "get all Users succesfully",
				pagenation);
		return new ResponseEntity<>(apiserviece, HttpStatus.OK);
	}

	// update user API
	@PutMapping("/update")
	public ResponseEntity<Apiserviece<User>> UpdateUser(@RequestBody User user) {
		User user2 = userservices.UpdateUser(user);

		Apiserviece<User> apiserviece = new Apiserviece<User>(true, "User Updateted", user2);
		return new ResponseEntity<>(apiserviece, HttpStatus.OK);
	}

    // delete user AIP
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Apiserviece<Void>> DeleteUser(@PathVariable Long id) {
		userservices.deleteuser(id);

		Apiserviece<Void> apiserviece = new Apiserviece<Void>(true, "user delete succesfully", null);
		return new ResponseEntity<>(apiserviece, HttpStatus.NO_CONTENT);
	}

	// User login API
	@PostMapping("/login")
	public ResponseEntity<Apiserviece<User>> loginuser(@Valid @RequestBody Login login) {
		User existuser = userservices.findbyEmail(login.getEmail());

		if (existuser == null) {
			Apiserviece<User> apiserviece = new Apiserviece<User>(false, "Email id and password are not match ",
					existuser);
			return new ResponseEntity<>(apiserviece, HttpStatus.CONFLICT);
		}
		if (!existuser.getPassword().equals(login.getPassword()) && !existuser.getEmail().equals(login.getEmail())) {
			Apiserviece<User> apiserviece = new Apiserviece<User>(false, "Email id and password are not match ",
					existuser);
			return new ResponseEntity<>(apiserviece, HttpStatus.CONFLICT);
		} else {
			Apiserviece<User> apiserviece = new Apiserviece<User>(true, "user login succesfully", existuser);
			return new ResponseEntity<>(apiserviece, HttpStatus.OK);
		}

	}
}
