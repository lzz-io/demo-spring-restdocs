package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/{id}")
	public String show(@PathVariable int id) {
		return "show id = " + id;
	}

	@PutMapping("/{id}")
	public String edit(@PathVariable int id) {
		return "edit id = " + id;

	}
}
