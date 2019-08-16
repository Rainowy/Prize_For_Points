package Entity;

import DAO.ExerciseDAO;

import java.util.Date;

public class Exercise {

    private int id;
    private String description;
    private Date created;
    private Date updated;
    private int special;
    private int special_id;
    private int exe_points;
    private User user;
    private Goals goal;
    public User currentUser;

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Goals getGoal() {
        return goal;
    }

    public void setGoal(Goals goal) {
        this.goal = goal;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getCurrentUser() {
        return currentUser;
    }

//    public void setCurrentUser(Exercise exercise, User currentUser) {
//        this.currentUser = currentUser;
//        ExerciseDAO exDAO = new ExerciseDAO();
//        exDAO.save(exercise, this);
//
//
//    }

    public Exercise() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public int getSpecial() {
        return special;
    }

    public void setSpecial(int special) {
        this.special = special;
    }

    public int getSpecial_id() {
        return special_id;
    }

    public void setSpecial_id(int special_id) {
        this.special_id = special_id;
    }

    public int getExe_points() {
        return exe_points;
    }

    public void setExe_points(int exe_points) {
        this.exe_points = exe_points;
    }

//    public void setCurrentUser (User user){
//
//    }

    @Override
    public String toString() {
        return "ID " + id + " OPIS ZADANIA " + description + " UTWORZONO " + created + " ZMODYFIKOWANO " + updated + " ZADANIE SPECJALNE NR " + getSpecial();
    }
}
