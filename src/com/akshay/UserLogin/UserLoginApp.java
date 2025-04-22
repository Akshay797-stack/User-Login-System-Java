package com.akshay.UserLogin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserLoginApp {
        private static List<UserProfile> userProfiles = new ArrayList<>();
        private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the User Login System!");
        while (true){
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    resetPassword();
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        }
    }
    private static void displayMenu(){
        System.out.println("\n--- Menu ---");
        System.out.println("1. Register");
        System.out.println("2. login");
        System.out.println("3. ResetPassword");
        System.out.println("4. Exit");
        System.out.println("Enter your choice: ");
    }
    private static void registerUser(){
        System.out.println("Enter Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Password: ");
        String password = scanner.nextLine();
        System.out.println("Enter Mobile Number: ");
        String number = scanner.nextLine();

        if(isValidPassword(password)){
            UserProfile newuser = new UserProfile(name,password,number);
            userProfiles.add(newuser);
            System.out.println("User registered Successfully!");
        }
        else{
            System.out.println("Password must be atleast 8 characters long and contain a special character.");
        }
    }
    private static boolean isValidPassword(String password){
        return password.length() >= 8 && password.matches(".*[!@#$%^&*()].*");
    }
    private static void loginUser(){
        System.out.println("Enter Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Password: ");
        String password = scanner.nextLine();
        boolean isValidUser = false;
        for (UserProfile user:userProfiles){
            if(user.getName().equals(name) && user.getPassword().equals(password)){
                isValidUser = true;
                break;
            }
        }
        if(isValidUser){
            System.out.println("Login Successful!");
        }
        else {
            System.out.println("Invalid Username or Password.");
        }
    }
    private static void resetPassword(){
        System.out.println("Enter Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Old Password: ");
        String oldpassword = scanner.nextLine();
        System.out.println("Enter New Password: ");
        String newpassword = scanner.nextLine();
        boolean isReset = false;
        for (UserProfile user:userProfiles){
            if (user.getName().equals(name) && user.getPassword().equals(oldpassword))
            {
                user.setPassword(newpassword);
                System.out.println("Password reset Successfully!");
                isReset=true;
                break;
            }
        }
        if(!isReset){
            System.out.println("Username or Password is incorrect.");
        }
    }
}
