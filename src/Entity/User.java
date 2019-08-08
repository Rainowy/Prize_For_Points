package Entity;

public class User {

    private int id;
    private String name;
    private String password;
    private int age;
    private int user_points;
    private Usergroup usergroup;

    public User() {
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getUser_points() {
        return user_points;
    }

    public void setUser_points(int user_points) {
        this.user_points = user_points;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usergroup getUsergroup() {
        return usergroup;
    }

    public void setUsergroup(Usergroup usergroup) {
        this.usergroup = usergroup;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n" + "IMIĘ: " + name + "\n" + "HASŁO: " + password + " \n" + "WIEK: " + age + " \n" + "PUNKTY: " + user_points + "\n" + usergroup;
    }
}
