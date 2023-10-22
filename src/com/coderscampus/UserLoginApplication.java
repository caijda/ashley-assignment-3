package com.coderscampus;

import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) {

		UserService userService = new UserService();
		User[] users = userService.createUserArray();
		String[] userInput = new String[2];
		int attempts = 0;
		int userIndex;
		Scanner scanner = new Scanner(System.in);

		while (attempts < 5) {
			System.out.println("Enter your email:");
			userInput[0] = scanner.nextLine();
			System.out.println("Enter your password:");
			userInput[1] = scanner.nextLine();
			userIndex = userService.validatingInput(userInput, users);
			if (userIndex != 4) {
				System.out.println("Welcome: " + users[userIndex].getName());
				break;
			} else if (attempts < 4) {
				System.out.println("Invalid login, please try again");
				attempts++;
			} else {
				System.out.println("Too many failed login attempts, you are now locked out.");
				attempts++;
			}
		}
		scanner.close();
	}

}
