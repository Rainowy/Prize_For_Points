package App;

import DAO.UsergroupDAO;
import Entity.Usergroup;

import javax.jws.soap.SOAPBinding;
import java.util.Scanner;

public class UserGroupManagement {

    private static Scanner scan = new Scanner(System.in);

    public static void addNewGroup() {

        System.out.println("Wprowadź nazwę grupy: ");
        String name = scan.nextLine().trim();
        String finalName = name.replaceAll("\\s", "_");

        Usergroup newUser = new Usergroup(finalName);
        UsergroupDAO.save(newUser);

    }

    public static Usergroup getById(int id) {

        return UsergroupDAO.getById(id);
    }

    public static Usergroup getByName(String name) {

        return UsergroupDAO.getByName(name);

    }
}

