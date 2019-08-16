package DAO;

import Entity.Goals;
import Services.DbService;
import Services.DbServicePFP;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class GoalsDAO {

    public static int newGoalId;

    public static int getNewGoalId() {
        return newGoalId;
    }

    public static void save(Goals goal) {
        if (goal.getId() == 0) {
            addToDb(goal);
        } else {
            //updateInDb(goal);
        }
       // return addToDb(goal);
    }

    public static void addToDb(Goals goal) {

        String query = "insert into goals values (null,?,?,?,null,0,0);";
        String[] params = new String[3];
        params[0] = goal.getName();
        params[1] = goal.getDescription();
        params[2] = String.valueOf(goal.getCreated());


        newGoalId = DbServicePFP.executeInsert(query, params);
        goal.setId(newGoalId);
        System.out.println("GOAL ID NEW TOL " + newGoalId);

        //return newId;   // zwraca ID nowego celu
    }

    public static void updateUser_Points_InDb(int points, int id) { // TODO: 09.08.19 przerobić na pełny update a nie tylko punkty

        String query = "update goals set user_points = ? where id =?;";
        String [] params = new String[2];
        params[0] = String.valueOf(points);
        params[1] = String.valueOf(id);
        DbServicePFP.executeQuery(query,params);
    }


    /**
     * Pobiera listę ze wszystkimi celami (Zwraca listę)**/
    public static List<String[]> getData() {

        String query = "select * from goals;";

        List<String[]> data = DbServicePFP.getData(query, null);

        return data;
    }

    /** Pobiera pojedynczy cel na podstawie ID**/
    public static Goals getById(int id) {

        String query = "select * from goals where id = ?;";
        String[] params = {String.valueOf(id)};

        List<String[]> data = DbServicePFP.getData(query, params);

        String[] firstRow = data.get(0);


        return getGoal(firstRow);

    }
    /**Pobiera goal_id na podstawie user_id z exercise**/
    public static List<String[]> getFromGoalsBasedOnUserId(int id){
        String query = "select goals_id from exercise join goals g on exercise.goals_id = g.id where user_id =?";
        String params[] = {String.valueOf(id)};
        List<String[]> data = DbServicePFP.getData(query, params);

        return data;
    }
    public static List<String[]> getAllFromGoalsBasedOnUserId(int id) {
        String query = "select * from exercise join goals g on exercise.goals_id = g.id where user_id =?";
        String params[] = {String.valueOf(id)};
        List<String[]> data = DbServicePFP.getData(query, params);

        return data;
    }

    private static Goals getGoal(String[] firstRow) {

        Timestamp created = Timestamp.valueOf(firstRow[3]); //pobiera Stringa i zamienia na Timestamp do wstawienia do bazy

        Goals newGoal = new Goals();
        newGoal.setId(Integer.valueOf(firstRow[0]));
        newGoal.setName(firstRow[1]);
        newGoal.setDescription(firstRow[2]);
        newGoal.setCreated(created);

        if (!String.valueOf(firstRow[4]).equals("null")) {          //sprawdza czy data pod updated jest null, jeśli nie to zamienia na Timestamp i wstawia
            Timestamp updated = Timestamp.valueOf(firstRow[4]);
            newGoal.setUpdated(updated);
        }
        newGoal.setGoals_points(Integer.valueOf(firstRow[5]));
        newGoal.setUser_points(Integer.valueOf(firstRow[6]));

        return newGoal;
    }

    /** Pobiera wszystie obiekty Goal (Zwraca obiekty) **/
    public static List<Goals> getAllGoals (){

        List<Goals> goalsList = new ArrayList<>();

        for(String[] s: getData()){
            Goals goal = getGoal(s);    // odwołuje się do metody getGoal która zwraca pojedynczy obiekt Goal
            goalsList.add(goal);
        }
        return goalsList;
    }

    public static List<String[]> getBasicGoalsBasedOnUserId (int id){

       // String query = "select goals.id, name, user_points, e.created from goals join exercise e on goals.id = e.goals_id where user_id =?;";
        String query = "select goals.id, name, user_points, e.created from goals join exercise e on goals.id = e.goals_id;";
        String[] params = {String.valueOf(id)};
        List<String[]> data = DbServicePFP.getData(query, null);

        return data;
    }





    /** METODY MODYFIKUJĄCE TABELĘ */

    /**
     * Dodaje kolumnę
     */
    public static void addColumn(String columnName, String columnType) {

        String query2 = "ALTER TABLE goals ADD " + columnName + " " + columnType;
        DbServicePFP.executeQuery(query2, null);
    }
}
