package App;

import DAO.GoalsDAO;
import DAO.UserDao;
import DAO.UsergroupDAO;
import Entity.User;
import Entity.Usergroup;

import java.util.Scanner;

public class UserManagement {

    private static Scanner scan = new Scanner(System.in);


    public static void addToDb(int userId, int userPoints) {

        System.out.println("Wprowadź nazwę użytkownika");
        String userName = scan.nextLine().trim();

        System.out.println("Wprowadź hasło użytkownika");
        String userPassword = scan.nextLine().trim();

        System.out.println("Wprowadź wiek użytkownika");
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.println("Wpisz wiek!");
        }
        int age = scan.nextInt();

        System.out.println("Wprowadź [n]azwę lub [i]d grupy do której należy użytkownik");
        String idName = scan.next().toLowerCase();

        Usergroup tmp = new Usergroup("");

        switch (idName) {

            case "n":
                System.out.println("Wprowadź nazwę grupy");
                String name = scan.next().trim();
                Usergroup groupName = UsergroupDAO.getByName(name);
                tmp = groupName;
                break;

            case "i":
                System.out.println("Wprowadź id grupy");
                while (!scan.hasNextInt()) {
                    scan.next();
                    System.out.println("Wpisz ID");
                }
                int groupID = scan.nextInt();
                Usergroup byId = UsergroupDAO.getById(groupID);
                tmp = byId;
        }
        User newUser = new User();
        newUser.setName(userName);
        newUser.setPassword(userPassword);
        newUser.setAge(age);
        newUser.setUsergroup(tmp);
        if (userId != 0) {
            newUser.setId(userId);
            newUser.setUser_points(userPoints);
        }

        UserDao.save(newUser);
    }

    public static void updateInDb() {
        System.out.println("Podaj Id użytkownika, którego chcesz zmodyfikować");
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.println("Wpisz ID");
        }
        int userId = scan.nextInt();

        System.out.println("Podaj aktualną ilość punktów");
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.println("Wpisz ilość punktów");
        }
        int userPoints = scan.nextInt();
        scan.nextLine();

        addToDb(userId, userPoints);
    }

    /** METODY MODYFIKUJĄCE BAZĘ */

    public static void modifyColumn(){  //modyfikuje kolumnę

        System.out.println("Wpisz nazwę kolumny do modyfikacji");

        String columnName = scan.nextLine();

        System.out.println("Wpisz typ tabeli(int, varchar itp.) i ew. dodatkowe parametry");

        String columnType = scan.nextLine();

        GoalsDAO.addColumn(columnName,columnType);

    }
}
