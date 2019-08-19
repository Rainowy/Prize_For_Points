package DAO;

import Entity.Exercise;
import Entity.User;
import Services.DbServicePFP;

import java.util.List;

public class ExerciseDAO {

    private User currentUser;

    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * Zapisuje Zadanie do bazy i ustawia currentUser i dodaje punkty użytkownikowi
     **/
    public void setCurrentUser(Exercise exercise, User currentUser) {

        this.currentUser = currentUser;                   //ustawia usera
        this.save(exercise);                              //zapisuje zadanie

        int currentPoints = currentUser.getUser_points(); //pobiera aktualne punkty użytkownika
        int exercisePoints = exercise.getExe_points();    //pobiera punkty za zadanie
        currentPoints += exercisePoints;                  //sumuje powyższe

        User updateUserPoints = currentUser;
        updateUserPoints.setUser_points(currentPoints);   //modyfikuje punkty użytkownika
        UserDao.updateInDb(updateUserPoints);
    }

    public void save(Exercise exercise) {

        if (exercise.getId() == 0) {
            addToDb(exercise);
        } else {
            //updateInDb(exercise);
        }
    }
    /** Dodaje nowe zadanie **/
    public void addToDb(Exercise exercise) {

        String query = "insert into exercise values (null,?,?,null,0,0,?,?,?);";        // TODO: 09.08.19 special id zrobić

        String[] params = new String[5];
        params[0] = exercise.getDescription();
        params[1] = String.valueOf(exercise.getCreated());
       // params[2] = String.valueOf(exercise.getSpecial());
        //params[3] = String.valueOf(exercise.getSpecial_id());
        params[2] = String.valueOf(exercise.getExe_points());
        params[3] = String.valueOf(getCurrentUser().getId());
        params[4] = String.valueOf(exercise.getGoal().getId());

        int newId = DbServicePFP.executeInsert(query, params);

        exercise.setId(newId);
    }
    /** Pobiera listę ze wszystkimi zadaniami **/
    public static List<String[]> getData (){

        String query = "select * from exercise;";

        List<String[]> data = DbServicePFP.getData(query, null);

        return data;
    }
    /**Poboera podstawowe dane na temat zadania na podstawia id **/
    public static List<String[]> getBasicExerciseBasedOnUserId (int id){

        String query= "select id, description, exe_points, created from exercise where user_id =?;";
        String [] params = {String.valueOf(id)};
        List<String[]> data = DbServicePFP.getData(query, params);

        return data;

    }


}

