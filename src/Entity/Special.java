package Entity;

import java.sql.Date;

public class Special {

    private int id;
    private String description;
    private Date created;
    private Date updated;
    private int special_points;
    private  User user_id;

    public Special() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getSpecial_points() {
        return special_points;
    }

    public void setSpecial_points(int special_points) {
        this.special_points = special_points;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return " OPIS " +description + " UTWORZONO " + created + " ZMODYFIKOWANO " + updated + " WYKONANE PRZEZ: " + user_id;
    }
}
