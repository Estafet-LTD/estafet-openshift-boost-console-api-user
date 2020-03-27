package com.estafet.openshift.boost.console.api.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.estafet.openshift.boost.commons.lib.model.API;
import com.estafet.openshift.boost.console.api.user.model.User;
import com.estafet.openshift.boost.console.api.user.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Value("${app.version}")
	private String appVersion;

	@GetMapping("/api")
	public API getAPI() {
		return new API(appVersion);
	}

	@GetMapping("/users")
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@GetMapping("/user/name")
	public User getUserByName(@RequestBody User user) {
		return userService.getUserByName(user.getName());
	}
	
	@GetMapping("/user/uid/{uid}")
	public User getUserByUid(@PathVariable String uid) {
		return userService.getUserByUid(uid);
	}


}
