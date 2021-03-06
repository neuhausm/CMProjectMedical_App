package Medical_Interaction_Project;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<User> Users = new ArrayList<>();
        boolean loginSuccess = false;
        Doctor doctor = new Doctor("Green", "1234");
        Users.add(doctor); //adding doctor system

        while(true) {
            System.out.println("Welcome to Medi-Assist Portal");
            do {
                System.out.print("Sign Up (1) or Login (2)");
                int choice = input.nextInt();

                if (choice == 1) {
                    System.out.print("Enter User Name: ");
                    String userName = input.next();
                    System.out.print("Enter Password: ");
                    String userPassword = input.next();
                    User user = new User(userName, userPassword, doctor);
                    Users.add(user);
                    System.out.println("Welcome " + userName);
                }


                if (choice == 2) {
                    System.out.print("Enter User Name: ");
                    String userName = input.next();
                    System.out.print("Enter Password: ");
                    String userPassword = input.next();
                    loginSuccess = logIn(userName, userPassword, Users);
                }
            } while (!loginSuccess);
        }
    }
    public static boolean logIn(String userName, String userPassword, ArrayList<User> Users) {
        for (int i = 0; i < Users.size(); i++) {

            if (Users.get(i).getUserName().equals(userName) && Users.get(i).getUserPassword().equals( userPassword)) {
                System.out.println("Login Successful");
                User currentUser=Users.get(i);
                if(currentUser instanceof Doctor){
                    ((Doctor) currentUser).doctorMenu();
                }
                else{
                    currentUser.UserMenu();
                }
                return true;
            }
        }
        System.out.println("ERROR Login Unsuccessful");
        return false;
    }


}
