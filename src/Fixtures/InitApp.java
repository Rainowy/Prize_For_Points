package Fixtures;

import Services.DbService;
import Services.DbServicePFP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InitApp {


    //create tables

    private static String createTableUser =
            "create table user (" +
                    "id int auto_increment," +
                    "name varchar(255) unique," +
                    "password varchar(255)," +
                    "age int," +
                    "user_points int default 0," + //aktualna ilość punktów
                    "user_group_id int," +
                    "primary key (id)," +
                    "foreign key (user_group_id) references user_group (id)" +
                    ")";

    private static String createTableUser_Group =
            "create table user_group (" +
                    "id int auto_increment," +
                    "name varchar(255)," +
                    "primary key (id)" +
                    ")";

    private static String createTableExercise =
            "create table exercise (" +
                    "id int auto_increment," +
                    "description varchar(255)," +
                    "created datetime," +
                    "updated datetime default null," +
                    "special tinyint DEFAULT 0," +  //oznacza czy zadanie jest specjalne
                    "special_id int," + //id zadania specjalnego
                    "exe_points int," +
                    "user_id int," +
                    "primary key (id)," +
                    "foreign key (user_id) references user (id)" +
                    ")";

    private static String createTableSpecial =
            "create table special (" +
                    "id int auto_increment,"+
                    "description varchar(255)," +
                    "created datetime," +
                    "updated datetime default null," +
                    "special_points int," +
                    "user_id int," +    //tu będziemy podawać użytkownika który zrobił zad. specjalne
                    "primary key (id)" +
                    ")";


    public static void main(String[] args) {


       // DbServicePFP.createDB();
//        createTables(createTableUser);
//        createTables(createTableUser_Group);
        createTables(createTableExercise);
        createTables(createTableSpecial);
    }


    private static void createTables(String query) {

        DbServicePFP.executeQuery(query, null);
    }
}
