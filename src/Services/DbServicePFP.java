package Services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbServicePFP  {

    public static String dbName = "prize_for_points";

    private static String createDB = "Create database `" + dbName + "` Character set utf8 collate utf8_unicode_ci";


    public static void createDB(){

        try {
            DbService.executeQuery(createDB,null,"");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void executeQuery(String query, String[] params) {

        try {
            DbService.executeQuery(query, params, dbName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int executeInsert(String query, String[] params) {

        int newID = 0;
        try {
            newID = DbService.executeInsert(query, params, dbName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newID;
    }

    public static List<String[]> getData(String query, String[] params) {

        List<String[]> data = new ArrayList<>();

        try {
            data = DbService.getData(query, params, dbName);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }

}
