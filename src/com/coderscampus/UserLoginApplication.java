package com.coderscampus;

public class UserLoginApplication {

	public static void main(String[] args) {

		UserService userService = new UserService();
		User[] users = userService.createUserArray();
		userService.userInput(users);
	}

}
