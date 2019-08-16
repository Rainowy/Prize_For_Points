package Entity;

import java.util.Date;

public class Goals {

    private int id;
    private String name;
    private String description;
    private Date created;
    private Date updated;
    private int goals_points;
    private int user_points;
    private User user;

    public Goals() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getGoals_points() {
        return goals_points;
    }

    public int getUser_points() {
        return user_points;
    }

    public void setUser_points(int user_points) {
        this.user_points = user_points;
    }

    public void setGoals_points(int goals_points) {
        this.goals_points = goals_points;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" + "\n" + "  NUMER ID:" + id + "\n" + "  NAZWA CELU: " + name + "\n" + "  OPIS: " + description +  "\n" + "  UTWORZONO: " + created + "\n" + // "  ZMODYFIKOWANO " + updated;
        "  PUNKTÓW PRZYPISANYCH  " + goals_points + "\n" + "  PUNKTÓW POTRZEBNYCH " + user_points;
    }
}
