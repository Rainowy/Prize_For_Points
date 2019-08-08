package Entity;

import java.util.Date;

public class Exercise {

    private int id;
    private String description;
    private Date created;
    private Date updated;
    private int special;
    private Special special_id;
    private int exe_points;

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

    public Special getSpecial_id() {
        return special_id;
    }

    public void setSpecial_id(Special special_id) {
        this.special_id = special_id;
    }

    public int getExe_points() {
        return exe_points;
    }

    public void setExe_points(int exe_points) {
        this.exe_points = exe_points;
    }

    @Override
    public String toString() {
        return "ID " + id + " OPIS ZADANIA " + description + " UTWORZONO " + created + " ZMODYFIKOWANO " + updated + " ZADANIE SPECJALNE NR " + getSpecial();
    }
}
