package DAO;

import Entity.Usergroup;
import Services.DbServicePFP;

import java.util.ArrayList;
import java.util.List;

public class UsergroupDAO {

    public static void save(Usergroup usergroup) {

        if (usergroup.getId() == 0) {
            addToDb(usergroup);

        } else {
            System.out.println("LOLO");
            // updateInDb(usergroup);
        }
    }

    public static void addToDb(Usergroup usergroup) {

        String query = "insert into user_group values (null,?);";
        String[] params = {usergroup.getName()};

        int newId = DbServicePFP.executeInsert(query, params);
        usergroup.setId(newId);

    }

    public static Usergroup getById(int id) {

        String query = "select * from user_group where id = ?;";

        String[] params = {String.valueOf(id)};

        List<String[]> data = DbServicePFP.getData(query, params);

        return getSingleUsergroup(data);
    }

    public static Usergroup getByName(String name) {

        String query = "select id from user_group where name = ?;";
        String[] params = {name};
        List<String[]> data = DbServicePFP.getData(query, params);
        String[] firstRow = data.get(0);

        return getById(Integer.valueOf(firstRow[0]));

    }

    public static Usergroup getSingleUsergroup(List<String[]> data) {

        int id = 0;
        String name = "";

        for (String[] s : data) {

            id = Integer.valueOf(s[0]);
            name = s[1];
        }

        Usergroup tmp = new Usergroup(name);

        try {
            if (id != 0) {
                tmp.setId(id);
            } else {
                throw new Exception("BRAK GRUPY O PODANYM ID W BAZIE");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tmp;
    }




}
