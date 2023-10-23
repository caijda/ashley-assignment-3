package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserService {

	public User[] createUserArray() {
		User[] userArray = new User[4];
		BufferedReader fileReader = null;
		String line;
		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));
			int i = 0;
			while ((line = fileReader.readLine()) != null) {
				String[] userInfoArray = line.split(",");
				userArray[i++] = writeUser(userInfoArray);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found exception");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("I/O Exception");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("I/O Exception");
				e.printStackTrace();
			}
		}
		return userArray;
	}
	
	public User writeUser(String[] userInfo) {
		User user = new User();
		user.setUsername(userInfo[0]);
		user.setPassword(userInfo[1]);
		user.setName(userInfo[2]);
		return user;
	}
	
	public Integer validatingInput(String[] input, User[] users) {
		int i;
		for (i = 0; i < 4; i++) {
			if (input[0].equalsIgnoreCase(users[i].getUsername()) && input[1].equals(users[i].getPassword())){
				break;
			}
		}		
		return i;
	}
	
	public void userInput (User[] users) {
		String[] userInput = new String[2];
		int attempts = 0;
		int userIndex;
		Scanner scanner = new Scanner(System.in);

		while (attempts < 5) {
			System.out.println("Enter your email:");
			userInput[0] = scanner.nextLine();
			System.out.println("Enter your password:");
			userInput[1] = scanner.nextLine();
			userIndex = validatingInput(userInput, users);
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
