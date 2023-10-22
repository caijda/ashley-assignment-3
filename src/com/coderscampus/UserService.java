package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
}
