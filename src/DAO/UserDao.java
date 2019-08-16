package DAO;

import Entity.User;
import Entity.Usergroup;
import Services.DbServicePFP;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public static void save(User user) {

        if (user.getId() == 0) {
            addToDb(user);
        } else {
            updateInDb(user);
        }
    }

    public static void addToDb(User user) {

        String query = "insert into user values(null,?,?,?,0,?);";

        String[] params = new String[4];

        setParams(user, params);
        params[3] = String.valueOf(user.getUsergroup().getId());

        int newId = DbServicePFP.executeInsert(query, params);
        user.setId(newId);

    }

    /**
     * wyciągnięte 3 powtarzające się w kilku metodach parametry
     **/
    private static void setParams(User user, String[] params) {

        params[0] = user.getName();
        params[1] = user.getPassword();
        params[2] = String.valueOf(user.getAge());
    }

    public static void updateInDb(User user) {

        String query = "update user set name=?, password=?, age=?, user_points =?, user_group_id =? where id =?;";

        String[] params = new String[6];
        setParams(user, params);
        params[3] = String.valueOf(user.getUser_points());
        params[4] = String.valueOf(user.getUsergroup().getId());
        params[5] = String.valueOf(user.getId());

        DbServicePFP.executeQuery(query, params);

    }

    public static User getByPassword(String password) {

        String query = "select * from user where password =?;";
        String[] params = {password};
        List<String[]> data = DbServicePFP.getData(query, params);
        String[] firstRow = data.get(0);

        return getUser(firstRow);
    }

    public static User getById(int id) {

        String query = "select * from user where id = ?;";
        String[] params = {String.valueOf(id)};
        List<String[]> data = DbServicePFP.getData(query, params);
        String[] firstRow = data.get(0);

        return getUser(firstRow);

    }

//    private static User getSingleUser(List<String[]> data){
//
//        String[] firstRow = data.get(0);
//
//        return getUser(firstRow);
//
//    }

    private static User getUser(String[] firstRow) {
        User currentUser = new User();
        currentUser.setId(Integer.valueOf(firstRow[0]));
        currentUser.setName(firstRow[1]);
        currentUser.setPassword(firstRow[2]);
        currentUser.setAge(Integer.valueOf(firstRow[3]));
        currentUser.setUser_points(Integer.valueOf(firstRow[4]));
        currentUser.setUsergroup(UsergroupDAO.getById(Integer.valueOf(firstRow[5])));

        return currentUser;
    }


    public static List<User> getAllUsers() {

        String query = "select * from user;";

        List<String[]> data = DbServicePFP.getData(query, null);
        System.out.println(data);

        List<User> userList = new ArrayList<>();

        System.out.println(data.size());

        for (String[] s : data) {
            User user = getUser(s);
            System.out.println(user);
            userList.add(user);
        }
        return userList;
    }
        public static void modifyUser(String columnName, String columnType){

            String query2 ="ALTER TABLE user MODIFY column " + columnName + " " + columnType;
            String[] params = {columnName,columnType};
            DbServicePFP.executeQuery(query2,params);
    }
}

