package App;

import DAO.UserDao;
import Entity.User;
import Entity.Usergroup;

import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner (System.in);

    public static void main(String[] args) {

      //  UserGroupManagement.addNewGroup();
//
//        Usergroup byId = UserGroupManagement.getById(5);
//        System.out.println(byId);
//
//        Usergroup byName = UserGroupManagement.getByName("USEr");
//        System.out.println(byName);

       // UserManagement.addToDb();

//feftchUser();

        User userId1 = UserDao.getById(2);
        System.out.println(userId1);
    }

    public static void feftchUser(){

        System.out.println("         XXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("         X        PODAJ HASŁO        X");
        System.out.println("         XXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        String password = scan.nextLine().trim();

        System.out.println(password);

       // User current


    }
}
