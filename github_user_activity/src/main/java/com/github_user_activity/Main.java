package com.github_user_activity;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        boolean flag = true; 
        Scanner sc = new Scanner(System.in); // Create Scanner once and reuse
        GithubUserActivity gitActivity = new GithubUserActivity();        
        while (flag) {
            System.out.println("ENTER A VALID GITHUB USERNAME (or type 'exit' to quit):");
            String command = sc.nextLine();

            if (command.equals("exit")) { 
                flag = false;
            } else {
                try{
                    gitActivity.getActivity(command);
                }catch(Exception e){
                    System.err.println("REQUESTS ERROR " + e.getMessage());
                }
            }
        }
        sc.close(); 
        }
}