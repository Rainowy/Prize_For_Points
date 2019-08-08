package DAO;

import Entity.User;
import Entity.Usergroup;
import Services.DbServicePFP;

import java.util.List;

public class UserDao {

    public static void save (User user){

        if(user.getId() == 0){
            addToDb(user);
        }
        else {
           // updateInDb(user);
        }
    }

    public static void addToDb(User user){

        String query = "insert into user values(null,?,?,?,null,?);";

        String[] params = new String[4];

        params[0] = user.getName();
        params[1] = user.getPassword();
        params[2] = String.valueOf(user.getAge());
        //Usergroup UserGroupbyId = UsergroupDAO.getById(user.getUsergroup().getId());
        params[3] = String.valueOf(user.getUsergroup().getId());

        int newId = DbServicePFP.executeInsert(query, params);
        user.setId(newId);

    }

    public static void getByPassword(String password){

        String query = "select * from user where password =?;";
        String [] params = {password};

    }

    public static User getById(int id){

        String query = "select * from user where id = ?;";
        String[] params = {String.valueOf(id)};
        List<String[]> data = DbServicePFP.getData(query, params);

        return getSingleUser(data);

    }

    private static User getSingleUser(List<String[]> data){

        User currentUser = new User();

        String[] firstRow = data.get(0);

        currentUser.setId(Integer.valueOf(firstRow[0]));
        currentUser.setName(firstRow[1]);
        currentUser.setPassword(firstRow[2]);
        currentUser.setAge(Integer.valueOf(firstRow[3]));
        currentUser.setUser_points(Integer.valueOf(firstRow[4]));
        currentUser.setUsergroup(UsergroupDAO.getById(Integer.valueOf(firstRow[5])));

        return currentUser;

        }
    }

